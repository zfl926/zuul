package org.egateway.core.http;

import java.util.Map;

import org.egateway.core.RequestWrapper;

import io.undertow.server.HttpServerExchange;

public class UndertowHttpRequestWrapper implements RequestWrapper {

	public UndertowHttpRequestWrapper(HttpServerExchange request){
		
	}
	
	@Override
	public Object getRequest() {
		return null;
	}

	@Override
	public Map<String, String> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHeaders(Map<String, String> header) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBody(byte[] data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] getBody() {
		// TODO Auto-generated method stub
		return null;
	}

}
