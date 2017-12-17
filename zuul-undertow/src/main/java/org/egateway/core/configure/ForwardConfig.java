package org.egateway.core.configure;

import java.util.List;
import java.util.Map;

public class ForwardConfig {
	// server configure
	private String                 name;
	private String                 host;
	private int                    port;
	
	public ForwardConfig() {
		
	}
	// constructure
	public ForwardConfig(String name, String host, int port, Map<String, String> proxy,
			List<UpstreamConfig> upstreams) {
		this.name = name;
		this.host = host;
		this.port = port;
		this.proxy = proxy;
		this.upstreams = upstreams;
	}
	
	// upstream configure class
	public static class UpstreamConfig {
		private String                                name;
		private List<String>                          urls;     // upstream urls
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<String> getUrls() {
			return urls;
		}
		public void setUrls(List<String> urls) {
			this.urls = urls;
		}
		@Override
		public String toString() {
			return "UpstreamConfig [name=" + name + ", urls=" + urls + "]";
		}
	}
	// upstream mapping
	private Map<String, String> proxy;
	private List<UpstreamConfig> upstreams;
	
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
	public Map<String, String> getProxy() {
		return proxy;
	}
	public void setProxy(Map<String, String> proxy) {
		this.proxy = proxy;
	}
	public List<UpstreamConfig> getUpstreams() {
		return upstreams;
	}
	public void setUpstreams(List<UpstreamConfig> upstreams) {
		this.upstreams = upstreams;
	}
	@Override
	public String toString() {
		return "ForwardConfig [name=" + name + ", host=" + host + ", port=" + port + ", proxy=" + proxy + ", upstreams="
				+ upstreams + "]";
	}
}
