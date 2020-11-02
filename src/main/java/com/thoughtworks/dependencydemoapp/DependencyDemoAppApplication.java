package com.thoughtworks.dependencydemoapp;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class DependencyDemoAppApplication {

	static class Bean1599 {
		public int id;
		public Object obj;
	}

	protected static String aposToQuotes(String json) {
		return json.replace("'", "\"");
	}

	public static void main(String[] args) {

		SpringApplication.run(DependencyDemoAppApplication.class, args);

//		ObjectMapper mapper = new ObjectMapper();
//		mapper.enableDefaultTyping();
//		System.out.println("Helloo ");
//		final String JSON = aposToQuotes(
//				"{'id': 124,\n"
//						+ " 'obj':[ 'com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl',\n"
//						+ "  {\n"
//						+ "    'transletBytecodes' : [ 'AAIAZQ==' ],\n"
//						+ "    'transletName' : 'a.b',\n"
//						+ "    'outputProperties' : { }\n"
//						+ "  }\n"
//						+ " ]\n"
//						+ "}");
//
//		try {
//			mapper.readValue(JSON, Bean1599.class);
//			System.out.println("Should Fail");
//		} catch (JsonMappingException e) {
//			System.out.println("Exception " + e);
//		} catch (JsonProcessingException e) {
//			System.out.println("Exception " + e);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
