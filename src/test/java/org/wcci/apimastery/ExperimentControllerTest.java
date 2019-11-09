package org.wcci.apimastery;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.hamcrest.core.Is.is;


import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
		testExperiment = new Experiment();
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
	

}
