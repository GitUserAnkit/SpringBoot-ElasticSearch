package com.ankit.spring.elastic.api.config;

import java.io.File;
import java.io.IOException;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages="{com.ankit.spring.elastic.api.repository}")
public class ElasticSearchConfig {
	
	@Bean
	NodeBuilder nodeBuilder(){
		return new NodeBuilder();
	}
	@Bean
	ElasticsearchOperations selasticsearchOperations(){
		File tempDir=null;
		try{
			tempDir=File.createTempFile("elastic-temp",Long.toString(System.nanoTime()));
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		Settings.Builder elasticsearchSettings=
		Settings.settingsBuilder()
		.put("http.enabled","true")
		.put("index.number_of_shards","1")
		.put("path.data",new File(tempDir,"data").getAbsolutePath())
		.put("path.logs",new File(tempDir,"logs").getAbsolutePath())
		.put("path.work",new File(tempDir,"work").getAbsolutePath())
		.put("path.home",tempDir);
		
		return new ElasticsearchTemplate(nodeBuilder()
				.local(true)
				.settings(elasticsearchSettings.build())
				.node()
				.client());
	}

}
