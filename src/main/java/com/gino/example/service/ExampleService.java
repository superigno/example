package com.gino.example.service;

import java.io.IOException;
import java.util.List;

import com.gino.example.model.Response;

public interface ExampleService {
	
	public Response getCount(List<String> list);
	public String getTopText(int num) throws IOException;
	
}
