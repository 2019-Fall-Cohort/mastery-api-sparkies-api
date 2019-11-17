package org.wcci.apimastery.inventors;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.tags.Tag;
import org.wcci.apimastery.tags.TagRepository;

import antlr.collections.List;

@Service
public class InventorStorage {

	@Autowired
	private InventorRepository inventorRepo;
	
	@Autowired
	private TagRepository tagRepo;
	
	public Iterable<Inventor> getAllInventors(){
		return inventorRepo.findAll();
	}
	
	public Inventor findInventorById(Long id) {
		return inventorRepo.findById(id).get();
	}
	
	public void addInventor(Inventor inventor) {
		inventorRepo.save(inventor);
	}

	public void removeInventor(Inventor inventor) {
		inventorRepo.delete(inventor);
	}

	public void addTagToInventor(Tag addedTag, Long id) {
		Inventor inventor = inventorRepo.findById(id).get();
		inventor.giveInventorATag(addedTag);
		inventorRepo.save(inventor);
	}
	
	public void removeTagFromInventor(Inventor inventor, Tag tag) {
		inventor.removeInventorTag(tag);
		inventorRepo.save(inventor);
	}

//	public Inventor getInventor(long id) throws InventorNotFoundException {
//		Optional<Inventor> retrievedInventorOptional = inventorRepo.findById(id);
//		if (!retrievedInventorOptional.isPresent()) {
//			throw new InventorNotFoundException("Inventor not found.");
//		}
//		return retrievedInventorOptional.get();
//	}
}
