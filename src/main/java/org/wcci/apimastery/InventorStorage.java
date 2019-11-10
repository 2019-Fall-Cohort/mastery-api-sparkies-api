package org.wcci.apimastery;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class InventorStorage {

	@Autowired
	private InventorRepository inventorRepo;
	
	public Iterable<Inventor> getAllInventors(){
		return inventorRepo.findAll();
	}
	
	public Inventor findInventorById(Long id) {
		return inventorRepo.findById(id).get();
	}
	
	public void addInventor(Inventor inventor) {
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
