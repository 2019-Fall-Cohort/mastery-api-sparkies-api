package org.wcci.apimastery;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class InventorControllerTest {

	@InjectMocks
	private InventorController underTest;
	
	@Mock
	private InventorStorage inventorStorage;
	
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
}
