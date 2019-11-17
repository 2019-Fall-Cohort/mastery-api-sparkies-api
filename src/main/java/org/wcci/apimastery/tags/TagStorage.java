package org.wcci.apimastery.tags;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.experiments.ExperimentRepository;
import org.wcci.apimastery.inventors.Inventor;

@Service
public class TagStorage {

	@Autowired
	private TagRepository tagRepo;

	public Tag addTag(Tag tag) {
		return tagRepo.save(tag);
	}
	
	public Tag findTagById(Long id) {
		return tagRepo.findById(id).get();
	}
	
	public void removeTag(Tag tag) {
		tagRepo.delete(tag);
	}
	
}
