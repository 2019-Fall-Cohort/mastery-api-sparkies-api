package org.wcci.apimastery;

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
}
