package org.wcci.apimastery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/inventors")
public class InventorController {

	@Autowired
	private InventorStorage inventorStorage;
	
	@GetMapping("")
	public List<Inventor> getInventors(){
		return (List<Inventor>) inventorStorage.getAllInventors();
	}
	
	@GetMapping("/{id}")
	public Inventor getSingleInventor(@PathVariable Long id) {
		return inventorStorage.findInventorById(id);
	}
	
	@PostMapping("/{country}/{name}")
	public void addSingleInventor(@PathVariable String name, @PathVariable String country) {
		Inventor inventor = new Inventor(name, country);
		inventorStorage.addInventor(inventor);
	}
	
	@DeleteMapping("/{id}/remove")
	public void removeSingleInventor(@PathVariable Long id) {
		Inventor inventor = inventorStorage.findInventorById(id);
		inventorStorage.removeInventor(inventor);
	}
}
