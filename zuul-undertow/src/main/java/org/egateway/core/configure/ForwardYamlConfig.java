package org.egateway.core.configure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egateway.core.configure.ForwardConfig.UpstreamConfig;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

/**
 *  YAML configure
 */
public class ForwardYamlConfig implements Configure<ForwardConfig>{

	private Yaml yaml = new Yaml();
	private ForwardConfig configData = null;
	
	@Override
	public void load(String file) {
		configData = yaml.loadAs(file, ForwardConfig.class);
	}

	@Override
	public <C> C getProperty(String name, Class<C> clazz) {
		return null;
	}

	@Override
	public ForwardConfig getProperties() {
		return configData;
	}

	
	public static void main(String args[]){
		//ForwardYamlConfig config = new ForwardYamlConfig();
		//config.load("");
		ForwardConfig forwardConfig = new ForwardConfig();
		forwardConfig.setHost("/host");
		forwardConfig.setName("tn");
		forwardConfig.setPort(8080);
		UpstreamConfig upstreamConfig = new UpstreamConfig();
		upstreamConfig.setName("upstream");
		List<String> urls = new ArrayList<>();
		urls.add("http://test1");
		urls.add("http://test2");
		upstreamConfig.setUrls(urls);
		Map<String, String> nameMappings = new HashMap<>();
		nameMappings.put("/test", "upstream");
		forwardConfig.setProxy(nameMappings);
		List<UpstreamConfig> ups = new ArrayList<>();
		ups.add(upstreamConfig);
		forwardConfig.setUpstreams(ups);
		DumperOptions options = new DumperOptions();
		options.setDefaultFlowStyle(DumperOptions.FlowStyle.AUTO);
		Yaml y = new Yaml(options);
		String dump = y.dump(forwardConfig);
		System.out.println(dump);
	}
}
