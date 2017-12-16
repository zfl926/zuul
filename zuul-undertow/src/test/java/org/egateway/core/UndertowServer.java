package org.egateway.core;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

public class UndertowServer {
	public static void main(String[] args) {
		Undertow server = Undertow.builder()
				//.setServerOption(UndertowOptions., value)
				.addHttpListener(8081, "localhost")
				.setHandler(new HttpHandler(){
					@Override
					public void handleRequest(HttpServerExchange exchange) throws Exception {
						System.out.println(exchange.getConnection().toString());
						exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
						exchange.getResponseSender().send("Hello world!");
					}
				})
				.build();
		//server.getListenerInfo().toString();
		server.start();
	}
}
