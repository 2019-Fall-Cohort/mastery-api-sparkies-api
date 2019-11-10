package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagController {
	
	@Autowired
	private TagRepository tagRepo;
	
	@GetMapping("")
	public Iterable<Tag> getAllTags() {
		return tagRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Tag getSingleTag(@PathVariable Long id) {
		return tagRepo.findById(id).get();
	}

}
