package org.egateway.server.undertow;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.proxy.ProxyHandler;
import io.undertow.util.SameThreadExecutor;

/**
 * Hello world!
 *
 */
public class UndertowServer {
	public static void main(String[] args) {
		Undertow
			.builder()
			.addHttpListener(8088, "localhost")
			.setHandler(new HttpHandler(){
				@Override
				public void handleRequest(HttpServerExchange exchange) throws Exception {
					System.out.println("this is I/O handler" + Thread.currentThread().getName());
					// check if is first in IO thread
					if ( exchange.isInIoThread() ){
						// we need to use it in another worker pool
						exchange.dispatch(new HttpHandler(){
							@Override
							public void handleRequest(HttpServerExchange paramHttpServerExchange) throws Exception {
								System.out.println("this is task handler" + Thread.currentThread().getName());
								paramHttpServerExchange.getResponseSender().send("Great!");
								
							}
						});
					}
					
				}}
			)
			.build()
			.start();
	}
}
