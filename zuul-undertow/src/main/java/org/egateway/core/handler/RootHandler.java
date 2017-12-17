package org.egateway.core.handler;

import org.egateway.core.configure.ForwardConfig;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

/**
 * 
 * handle all the requests and dispatch to proper handler by configure
 *
 */
public class RootHandler implements HttpHandler{
	
	private ForwardConfig config;
	
	
	public ForwardConfig getConfig() {
		return config;
	}

	public void setConfig(ForwardConfig config) {
		this.config = config;
	}

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		String requestPath = exchange.getRequestPath();
		
	}

}
