package com.fleet.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.daos.HibernateTestDao;

@Service
public class TestService {
	
	@Autowired
	private HibernateTestDao testDao;
	
	public String getStaticData() {
		return testDao.findStaticData().stream()
				.map(test -> test.getName())
				.collect(Collectors.joining(","));
	}
	
	public String getDataFromDB() {
		return testDao.findDataFromDB().stream()
				.map(test -> test.getName())
				.collect(Collectors.joining(","));
	}
}