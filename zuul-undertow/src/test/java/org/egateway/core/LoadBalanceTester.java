package org.egateway.core;

import java.net.URI;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.proxy.LoadBalancingProxyClient;
import io.undertow.server.handlers.proxy.ProxyHandler;
import io.undertow.util.Headers;
import static io.undertow.Handlers.path;

public class LoadBalanceTester {
	public static void main(String []args) throws Exception {
		
		final Undertow server1 = Undertow.builder()
                .addHttpListener(8081, "localhost")
                .setHandler(new HttpHandler() {
                    @Override
                    public void handleRequest(HttpServerExchange exchange) throws Exception {
                        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                        exchange.getResponseSender().send("Server1");
                    }
                })
                .build();

        server1.start();

        final Undertow server2 = Undertow.builder()
                .addHttpListener(8082, "localhost")
                .setHandler(new HttpHandler() {
                    @Override
                    public void handleRequest(HttpServerExchange exchange) throws Exception {
                        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                        exchange.getResponseSender().send("Server2");
                    }
                })
                .build();
        server2.start();

//        final Undertow server3 = Undertow.builder()
//                .addHttpListener(8083, "localhost")
//                .setHandler(new HttpHandler() {
//                    @Override
//                    public void handleRequest(HttpServerExchange exchange) throws Exception {
//                        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
//                        exchange.getResponseSender().send("Server3");
//                    }
//                })
//                .build();
//
//        server3.start();
//		
//		
//		LoadBalancingProxyClient loadBalancer = new LoadBalancingProxyClient()
//                .addHost(new URI("http://localhost:8081"))
//                .addHost(new URI("http://localhost:8082"))
//                .addHost(new URI("http://localhost:8083"))
//                .setConnectionsPerThread(20);
//		
//		
//		Undertow reverseServer = Undertow.builder()
//				.addHttpListener(8084, "localhost")
//				.setIoThreads(4)
//				.setWorkerThreads(4)
//				.setHandler(new MyProxHandler(loadBalancer, 3000, new HttpHandler() {
//					@Override
//					public void handleRequest(HttpServerExchange exchange) throws Exception {
//						exchange.getResponseSender().send("no");
//					}
//				}))
//				.build();
//		
//		reverseServer.start();
		
	}
}
