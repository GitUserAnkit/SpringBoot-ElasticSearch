package com.ankit.spring.elastic.api.model;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName="users",type="users",shards=1)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	private Long userId;
	private String userName;
	private Double salary;

}
