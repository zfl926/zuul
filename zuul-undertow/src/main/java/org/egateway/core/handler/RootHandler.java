package org.egateway.core.handler;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.egateway.core.configure.ForwardConfig.UpstreamConfig;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.proxy.LoadBalancingProxyClient;

/**
 * 
 * handle all the requests and dispatch to proper handler by configure
 *
 */
public class RootHandler implements HttpHandler{
	
	private Map<Pattern, ProxyHandler>         proxyMapping;
	
	public RootHandler(Map<String, String> urlMapping, List<UpstreamConfig> upstreamConfig){
		Map<Pattern, List<String>> forwordUrls = new HashMap<>();
		proxyMapping = new HashMap<>();
		if ( urlMapping != null && upstreamConfig != null ){
			urlMapping.forEach((path, name) -> {
				upstreamConfig.forEach(upstream -> {
					if ( name.equals(upstream.getName()) ){
						Pattern pattern = Pattern.compile(path);
						forwordUrls.put(pattern, upstream.getUrls());
					}
				});
			});
			if ( !forwordUrls.isEmpty() ){
				forwordUrls.forEach((pattern, urls)->{
					LoadBalancingProxyClient loadBalancer = new LoadBalancingProxyClient();
					urls.forEach(url -> {
						try {
							loadBalancer.addHost(new URI(url));
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
					loadBalancer.setConnectionsPerThread(20);
					ProxyHandler myProxy = new ProxyHandler(loadBalancer, 3000, new HttpHandler(){
						@Override
						public void handleRequest(HttpServerExchange paramHttpServerExchange) throws Exception {
							
						}
						
					});
					proxyMapping.put(pattern, myProxy);
				});
			}
		}
	}


	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		System.out.println("Thread id = " + Thread.currentThread().getName());
		String requestPath = exchange.getRequestPath();
		boolean isFound = false;
		for (  Pattern pattern : proxyMapping.keySet() ){
			if ( pattern.matcher(requestPath).matches() ){
				proxyMapping.get(pattern).handleRequest(exchange);
				isFound = true;
				break;
			}
		}
		if ( !isFound ){
			exchange.setStatusCode(404);
			exchange.getResponseSender().send("Not Found");
		}
	}

}
