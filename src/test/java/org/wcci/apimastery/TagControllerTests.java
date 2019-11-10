package org.wcci.apimastery;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;


public class TagControllerTests {
	
	@InjectMocks
	private TagController underTest;
	@Mock
	private TagStorage tagStorage;
	@Mock
	private Tag testTag;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
		testTag = new Tag("Test Tag");
	}
	
	@Test
	public void getAllTagsReturnsListOfTags() throws Exception {
		when(tagStorage.getAllTags()).thenReturn(Collections.singletonList(testTag));
		List<Tag> retrievedTag = underTest.getAllTags();
		assertThat(retrievedTag, contains(testTag));
	}
	
	

}
