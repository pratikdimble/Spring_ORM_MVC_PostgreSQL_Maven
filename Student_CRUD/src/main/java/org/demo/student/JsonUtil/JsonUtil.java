package org.demo.student.JsonUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static ObjectMapper mapper;
	String jsonString="";
		static {
			mapper=new ObjectMapper();
		}
		public String convertJavaToJson(Object ob) {
			
			try {
				jsonString=mapper.writeValueAsString(ob);
			} catch (JsonProcessingException e) {
				System.out.println(e.getMessage());
			}
		return jsonString;
		}

}
