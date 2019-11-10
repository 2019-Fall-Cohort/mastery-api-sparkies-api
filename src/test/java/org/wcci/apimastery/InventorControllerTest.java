package org.wcci.apimastery;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class InventorControllerTest {

	@InjectMocks
	private InventorController underTest;
	
	@Mock
	private InventorStorage inventorStorage;
	@Mock
	private Inventor testInventor;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
		testInventor = new Inventor("Test Inventor", "Test Provenance");
	}
	
	@Test
	public void fetchAllReturnListOfInventors() throws Exception {
		when(inventorStorage.getAllInventors()).thenReturn(Collections.singletonList(testInventor));
		List<Inventor> retrievedInventor = underTest.getInventors();
		assertThat(retrievedInventor, contains(testInventor));
	}
	
	@Test
	public void shouldReturnAllInventors() throws Exception {
		when(inventorStorage.getAllInventors()).thenReturn((Collections.singletonList(testInventor)));
		mockMvc.perform(get("/inventors")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(jsonPath("$", hasSize(1)))
			.andExpect(jsonPath("$[0].name", is(equalTo("Test Inventor"))));
	}
	
	@Test
	public void getByIdReturnsSingleInventor() throws InventorNotFoundException {
		when(inventorStorage.findInventorById(1L)).thenReturn(testInventor);
		Inventor retrievedInventor = underTest.getSingleInventor(1L);
		assertThat(retrievedInventor, is(testInventor));
	}
	
	
	@Test
	public void getAllIsMappedCorrectlyAndReturnsAJsonList() throws Exception {
		when(inventorStorage.getAllInventors()).thenReturn(Collections.singletonList(testInventor));
		mockMvc.perform(get("/inventors")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[0].name", is(equalTo("Test Inventor"))));
	}   
	
}
