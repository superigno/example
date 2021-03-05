package com.gino.example.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gino.example.dao.TaskOneDao;
import com.gino.example.dao.TaskTwoDao;
import com.gino.example.model.Response;
import com.gino.example.util.ExampleUtils;

@Service
public class ExampleServiceImpl implements ExampleService {

	@Autowired
	private TaskOneDao taskOneDao;

	@Autowired
	private TaskTwoDao taskTwoDao;
	
	@Autowired
	private ExampleUtils utils;

	@Override
	public Response getCount(List<String> list) {
		// Add other business related logic
		return taskOneDao.getCount(list);
	}

	@Override
	public String getTopText(int num) throws IOException {
		// Add other business related logic
		String texts = utils.extractTextFromFile("paragraph.txt");
		String[] tokenizedString = utils.extractWordsFromText(texts);
		return taskTwoDao.getTopText(tokenizedString, num);
	}	

}
