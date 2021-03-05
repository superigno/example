package com.gino.example.model;

import java.util.Collections;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Text {
	
	@JsonIgnore
	private String name;
	
	@JsonIgnore
    private int count;

    public String getName() {
		return name;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {		
		return count;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonAnyGetter
    public Map<String, Integer> any() {
        return Collections.singletonMap(name, getCount());
    }

}
