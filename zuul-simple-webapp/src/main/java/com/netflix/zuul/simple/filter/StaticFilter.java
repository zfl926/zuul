package com.netflix.zuul.simple.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class StaticFilter extends ZuulFilter {

	private String responseBody(){
		return "Static Filter";
	}
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        // Set the default response code for static filters to be 200
        ctx.setResponseStatusCode(HttpServletResponse.SC_OK);
        try {
			ctx.getResponse().getWriter().write(responseBody());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // first StaticResponseFilter instance to match wins, others do not set body and/or status
        //if (ctx.getResponseBody() == null) {
        //ctx.setSendZuulResponse(bSend);
        //ctx.setResponseBody(responseBody());
        ctx.setSendZuulResponse(false);
        //}		
		return null;
	}

	@Override
	public String filterType() {
		return "route";
	}

	@Override
	public int filterOrder() {
		return 100;
	}

}
