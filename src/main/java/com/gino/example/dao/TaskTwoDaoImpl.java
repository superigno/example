package com.gino.example.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class TaskTwoDaoImpl implements TaskTwoDao {

	@Override
	public String getTopText(String[] texts, int num) {
		
		Map<String, Integer> map = new HashMap<>();

		for (String text : texts) {
			if (map.containsKey(text)) {
				map.put(text, map.get(text) + 1);
			} else {
				map.put(text, 1);
			}
		}

		// Add to list
		List<String> list = new ArrayList<String>(map.keySet());

		// Sort list by count of words and name
		Collections.sort(list,
				(w1, w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));

		// Return the result up the the 'num' only
		List<String> sublist = list.subList(0, num);

		// Construct
		StringBuilder sb = new StringBuilder();
		for (String s : sublist) {
			sb.append(s).append("|").append(map.get(s)).append(",");
		}

		// Remove comma at end
		if (sb.length() > 0) {
			sb.setLength(sb.length() - 1);
		}

		return sb.toString();
	}

}
