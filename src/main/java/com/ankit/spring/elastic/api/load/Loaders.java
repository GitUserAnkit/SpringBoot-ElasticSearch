package com.ankit.spring.elastic.api.load;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ankit.spring.elastic.api.model.Users;
import com.ankit.spring.elastic.api.repository.UserRepository;

@Component
public class Loaders {
	@Autowired
	private UserRepository repository;
	@Autowired
	private ElasticsearchOperations operations;

	@PostConstruct
	@Transactional
	public void loadAll
	{
		operations.putMapping(Users.class);
		System.out.println("Loading Data");
		repository.save(getData());
		System.out.println("Loading Complete");
	}

	private List<Users> getData() {
		List<Users> listUsers = new ArrayList<>();
		listUsers.add(new Users(101L, "ankit", 1000.00));
		listUsers.add(new Users(102L, "ankush", 2000.00));
		return listUsers;
	}
}
