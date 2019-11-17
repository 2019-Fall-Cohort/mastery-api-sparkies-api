package org.wcci.apimastery.inventors;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.experiments.Experiment;
import org.wcci.apimastery.experiments.ExperimentStorage;
import org.wcci.apimastery.tags.Tag;
import org.wcci.apimastery.tags.TagStorage;



@RestController
@RequestMapping("/inventors")
public class InventorController {

	@Autowired
	private InventorStorage inventorStorage;
	
	@Autowired
	private TagStorage tagStorage;
	
	@Autowired ExperimentStorage experimentStorage;
	
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
	
	@PatchMapping("/{id}/addTag/{tagName}")
	public void addTag(@PathVariable String tagName, @PathVariable("id") Long id){
		Inventor inventor = inventorStorage.findInventorById(id);
		Tag addedTag = new Tag(tagName);
		addedTag = tagStorage.addTag(addedTag);
		inventorStorage.addTagToInventor(addedTag, id);
	}
	
	@PatchMapping("/{inventorId}/removeTag/{tagId}")
	public void removeTag(@PathVariable("inventorId") Long inventorId, 
						  @PathVariable("tagId") Long tagId) {
		Inventor inventor = inventorStorage.findInventorById(inventorId);
		Tag tagToBeRemoved = tagStorage.findTagById(tagId);
		inventorStorage.removeTagFromInventor(inventor, tagToBeRemoved);
	}
	
	@DeleteMapping("/{id}/remove")
	public void removeSingleInventor(@PathVariable Long id) {
		Inventor inventor = inventorStorage.findInventorById(id);
		List<Experiment> theExperiments = inventor.getExperiments();
		List<Tag> inventorTags = inventor.getTags();
		
		for (Experiment experiment : theExperiments) {
			List<Tag> experimentTags = experiment.getTags() ;
			for (Tag tag : experimentTags) {
				tagStorage.removeTag(tag);
			}
			experimentStorage.removeExperiment(experiment);
		}
		for (Tag tag : inventorTags) {
			tagStorage.removeTag(tag);
		}
		inventor.getExperiments().clear();
		inventor.getTags().clear();
		inventorStorage.removeInventor(inventor);
	}
}
