package com.gino.example.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gino.example.model.Response;
import com.gino.example.model.Text;

@Repository
public class TaskOneDaoImpl implements TaskOneDao {
	
	private static Map<String, Integer> countMap = new HashMap<>();
	
	static {
		countMap.put("Duis", 11);
		countMap.put("Sed", 16);
		countMap.put("Donec", 8);
		countMap.put("Augue", 7);
		countMap.put("Pellentesque", 6);
		countMap.put("123", 0);		
	}

	@Override
	public Response getCount(List<String> list) {
		List<Text> outputList = new ArrayList<>();
		for (String s : list) {
			Text t = new Text();
			t.setName(s);
			t.setCount(this.getCount(s));
			outputList.add(t);
		}
		
		Response resp = new Response();
		resp.setCounts(outputList);
		
		return resp;
	}
	
	private int getCount(String s) {
		int count = countMap.getOrDefault(s, 0);
		return count;
	}

}
