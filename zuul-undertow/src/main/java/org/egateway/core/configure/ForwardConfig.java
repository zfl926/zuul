package org.egateway.core.configure;

import java.util.Map;

public class ForwardConfig {
	private String      name;
	private String      host;
	private int         port;
	
	
	public static class UpstreamConfig {
		private String                   name;
		private Map<String, String>      urls;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Map<String, String> getUrls() {
			return urls;
		}
		public void setUrls(Map<String, String> urls) {
			this.urls = urls;
		}
	}
	
	
	
}
