package org.egateway.core.handler;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

/**
 * 
 * handle all the requests and dispatch to proper handler by configure
 *
 */
public class RootHandler implements HttpHandler{

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		String requestPath = exchange.getRequestPath();
		
	}

}
