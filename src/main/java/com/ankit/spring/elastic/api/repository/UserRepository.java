package com.ankit.spring.elastic.api.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.ankit.spring.elastic.api.model.Users;

public interface UserRepository extends ElasticsearchRepository<Users,Long> {

}
