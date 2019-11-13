package org.wcci.apimastery.tags;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.experiments.ExperimentRepository;

@Service
public class TagStorage {

	@Autowired
	private TagRepository tagRepo;

	public Tag addTag(Tag tag) {
		return tagRepo.save(tag);
	}
	
	
}
