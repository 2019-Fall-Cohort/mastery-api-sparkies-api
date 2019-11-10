package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagStorage {
	
	@Autowired
	TagRepository tagRepo;
	
	public Tag saveTag(Tag tag) {
		return tagRepo.save(tag);
	}
	
	public Tag getAllTags() {
		// TODO Auto-generated method stub
		return null;
	}

}
