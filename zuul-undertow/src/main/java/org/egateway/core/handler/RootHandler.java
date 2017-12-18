package org.egateway.core.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egateway.core.configure.ForwardConfig.UpstreamConfig;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

/**
 * 
 * handle all the requests and dispatch to proper handler by configure
 *
 */
public class RootHandler implements HttpHandler{
	
	private Map<String, String>                 urlMapping;
	private List<UpstreamConfig>            upstreamConfig;
	private Map<String, List<String>>          forwordUrls;
	
	public RootHandler(Map<String, String> urlMapping, List<UpstreamConfig> upstreamConfig){
		this.urlMapping = urlMapping;
		this.upstreamConfig = upstreamConfig;
		if ( urlMapping != null && upstreamConfig != null ){
			forwordUrls = new HashMap<>();
			urlMapping.forEach((path, name) -> {
				upstreamConfig.forEach(upstream -> {
					if ( name.equals(upstream.getName()) ){
						forwordUrls.put(path, upstream.getUrls());
					}
				});
			});
			if ( !forwordUrls.isEmpty() ){
				
			}
		}
	}


	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		String requestPath = exchange.getRequestPath();
		
	}

}
