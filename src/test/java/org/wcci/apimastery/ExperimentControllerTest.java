package org.wcci.apimastery;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.core.Is.is;


import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



public class ExperimentControllerTest {
	
	@InjectMocks
	private ExperimentController underTest;
	@Mock
	private ExperimentStorage experimentStorage;
	
	private MockMvc mockMvc;
	private Experiment testExperiment;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
		testExperiment = new Experiment("test experiment", "description");

		}
	
	@Test
	public void getAllExperimentsReturnsListOfExperiments() throws Exception {
		when(experimentStorage.getAllExperiments()).thenReturn(Collections.singletonList(testExperiment));
		Iterable<Experiment> retrievedExperiments = underTest.getAllExperiments();
		assertThat(retrievedExperiments, contains(testExperiment));
	}
	
	@Test
	public void getByIdReturnsSingleExperiment() {
		when(experimentStorage.findExperimentById(1L)).thenReturn(testExperiment);
		Experiment retrievedExperiment = underTest.getSingleExperiment(1L);
		assertThat(retrievedExperiment, is(testExperiment));
	}
	
	@Test
	public void fetchAllIsMappedCorrectlyAndReturnsAJsonList() throws Exception {
		when(experimentStorage.getAllExperiments()).thenReturn(Collections.singletonList(testExperiment));
		mockMvc.perform(get("/experiments")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].name", is(equalTo("test experiment"))));
	}
	
	@Test
	public void getByIdIsMappedCorrectlyAndReturnsAJsonExperiment() throws Exception {
		when(experimentStorage.findExperimentById(1L)).thenReturn(testExperiment);
		mockMvc.perform(get("/experiments/1"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$.name", is(equalTo("test experiment"))));
	}
	
	
	

}
