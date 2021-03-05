package com.gino.example.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;

@Component
public class ExampleUtils {
	
	//Get words only and disregard special characters in between them
	public String[] extractWordsFromText (String s) {
		return s.split("\\W+");
	}
	
	public String extractTextFromFile(String filename) throws IOException  {
		try(InputStream inputStream = getClass().getResourceAsStream("/"+filename);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    
		    return sb.toString();
		    
		} catch (IOException e) {
			throw e;
		}		
	}

}
