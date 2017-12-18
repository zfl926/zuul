package org.egateway.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egateway.core.configure.ForwardConfig;
import org.egateway.core.configure.ForwardConfig.UpstreamConfig;
import org.egateway.core.server.Server;
import org.egateway.core.server.ServerBuilder;

public class UndertowServerTest {
	
	public static void main(String args[]){
		ForwardConfig config = new ForwardConfig();
		config.setHost("localhost");
		config.setPort(8080);
		config.setName("Undertow Server");
		Map<String, String> urls = new HashMap<>();
		urls.put("/test", "test");
		config.setProxy(urls);
		
		UpstreamConfig upConfig = new UpstreamConfig();
		upConfig.setName("test");
		List<String> urlList = new ArrayList<>();
		urlList.add("http://localhost:8081");
		urlList.add("http://localhost:8082");
		upConfig.setUrls(urlList);
		List<UpstreamConfig> upConfigs = new ArrayList<>();
		upConfigs.add(upConfig);
		config.setUpstreams(upConfigs);
		
		
		ServerBuilder serverBuilder = new ServerBuilder();
		serverBuilder.config(config);
		Server server = serverBuilder.build();
		server.start();
	}
}
