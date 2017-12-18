package org.egateway.core.circuitbreaker;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

public class RequestCircuitBreakerCommand extends HystrixCommand<Void> implements HttpHandler {

	private HttpHandler handler;
	private HttpServerExchange exchange;
	
	public RequestCircuitBreakerCommand(String name) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("CircuitBreakerTestGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("CircuitBreakerTestKey"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("CircuitBreakerTest"))
                .andCommandPropertiesDefaults(    // 配置熔断器
                        HystrixCommandProperties.Setter()
                                .withCircuitBreakerEnabled(true) //默认true
                                .withCircuitBreakerErrorThresholdPercentage(20)     //（出错百分比阈值，当达到此阈值后，开始短路。默认50%）
                                .withCircuitBreakerRequestVolumeThreshold(3)        //// 在统计数据之前，必须在10秒内发出3个请求。  默认是20.withCircuitBreakerSleepWindowInMilliseconds(8000)  //（断路多久以后开始尝试是否恢复，默认5s）);
                                ));
		
	}
	
	
	public void setHandler(HttpHandler handler){
		this.handler = handler;
	}

	@Override
	protected Void run() throws Exception {
		handler.handleRequest(exchange);
		return null;
	}


	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		this.exchange = exchange;
		this.execute();
	}

}
