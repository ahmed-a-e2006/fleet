package com.fleet.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleet.services.TestService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestService testService;

	@RequestMapping("/static")
	public String staticData() {
		return testService.getStaticData();
	}
	
	@RequestMapping("/db")
	public String dbData() {
		return testService.getDataFromDB();
	}
}