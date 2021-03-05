package com.gino.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gino.example.model.Request;
import com.gino.example.model.Response;
import com.gino.example.service.ExampleService;

@RestController
@RequestMapping("/counter-api")
public class ExampleController {
	
	@Autowired
	private ExampleService service;

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Response search(@RequestBody Request payload) throws Exception {
		List<String> textList = payload.getSearchText();
		return service.getCount(textList);
	}
	
	@RequestMapping(value = "/top/{count}", produces = "text/csv")
	public String countText(@PathVariable int count) throws Exception {
		return service.getTopText(count);
	}

}
