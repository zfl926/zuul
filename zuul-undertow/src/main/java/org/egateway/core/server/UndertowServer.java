package org.egateway.core.server;

import java.util.List;
import java.util.Map;

import org.egateway.core.configure.ForwardConfig.UpstreamConfig;

import io.undertow.Undertow;

/**
 *  the forward server implements by undertow
 */
public class UndertowServer implements Server {
	
	private String                          name;
	private String                          host;
	private int                             port;
	
	private Map<String, String>       urlMapping;
	private List<UpstreamConfig>  upstreamConfig;
	
	private Undertow                      server;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Map<String, String> getUrlMapping() {
		return urlMapping;
	}

	public void setUrlMapping(Map<String, String> urlMapping) {
		this.urlMapping = urlMapping;
	}

	public List<UpstreamConfig> getUpstreamConfig() {
		return upstreamConfig;
	}

	public void setUpstreamConfig(List<UpstreamConfig> upstreamConfig) {
		this.upstreamConfig = upstreamConfig;
	}

	@Override
	public void start() {
		Undertow.Builder builder = Undertow.builder();
		builder.addHttpListener(port, host);
		server = builder.build();
		try {
			server.start();
		} catch (Exception e){
			// stop the server
			server.stop();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void stop() {
		if ( server != null )
			server.stop();
	}

}
