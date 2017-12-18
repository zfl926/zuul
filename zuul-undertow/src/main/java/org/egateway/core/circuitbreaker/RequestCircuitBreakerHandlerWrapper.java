package org.egateway.core.circuitbreaker;

import java.util.Date;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

public class RequestCircuitBreakerHandlerWrapper implements HttpHandler {

	private HttpHandler handler;
	
	public RequestCircuitBreakerHandlerWrapper(HttpHandler handler){
		this.handler = handler;
	}
	
	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		RequestCircuitBreakerCommand command = new RequestCircuitBreakerCommand(new Date().toString());
		command.setHandler(handler);
		command.handleRequest(exchange);
	}
}
