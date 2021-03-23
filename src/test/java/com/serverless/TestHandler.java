package com.serverless;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@DisplayName("Handler Test Class")
public class TestHandler {

	private RequestHandler<Map<String, Object>, ApiGatewayResponse> handler;

	@BeforeEach
	public void setUp() {
		handler = new Handler();
	}

	@Test
	@DisplayName("Test ResponseBody")
	public void testResponseBody() throws JsonProcessingException {
		Map<String, Object> input = new HashMap<>();
		Response responseBody = new Response("Hello DevOps! Test CI/CD", input);
		Assertions.assertEquals(new ObjectMapper().writeValueAsString(responseBody),
				handler.handleRequest(input, new TestContext()).getBody(), "\"Hello DevOps! Test CI/CD\" works");
	}
}
