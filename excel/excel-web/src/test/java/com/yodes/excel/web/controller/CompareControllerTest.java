package com.yodes.excel.web.controller;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.yodes.excel.web.Setup;

public class CompareControllerTest extends Setup {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getAccount() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/compare"));
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
		MvcResult result = resultActions.andReturn();
		TestCase.assertEquals("compare", result.getModelAndView().getViewName());
	}
}
