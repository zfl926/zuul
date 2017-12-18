package org.egateway.core.server;

import org.egateway.core.configure.ForwardConfig;

public class ServerBuilder {
	
	private String                host;
	private String                name;
	private int                   port;
	
	private ForwardConfig       config;
	
	public ServerBuilder host(String host){
		this.host = host;
		return this;
	}
	
	public ServerBuilder port(int port){
		this.port = port;
		return this;
	}
	
	public ServerBuilder name(String name){
		this.name = name;
		return this;
	}

	public ServerBuilder config(ForwardConfig config){
		this.config = config;
		return this;
	}
	
	public Server build(){
		return new UndertowServer();
	}
}
