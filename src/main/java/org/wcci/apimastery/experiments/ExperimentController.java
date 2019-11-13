package org.wcci.apimastery.experiments;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.inventors.InventorStorage;
import org.wcci.apimastery.inventors.Inventor;



@RestController
@RequestMapping("/experiments")
public class ExperimentController {

	@Autowired
	private ExperimentStorage experimentStorage;
	
	@Autowired
	private InventorStorage inventorStorage; 
	
	@GetMapping("")
	public Iterable<Experiment> getAllExperiments(){
		return experimentStorage.getAllExperiments();
	}
	
	@GetMapping("/{id}")
	public Experiment getSingleExperiment(@PathVariable Long id) {
		return experimentStorage.findExperimentById(id);
	}
	
	@PostMapping("/add")
	public void addSingleExperiment(@PathVariable String name, String description, Inventor inventor) {
		Experiment experiment = new Experiment(name, description, inventor);
		experimentStorage.addExperiment(experiment);
	}
	
	@DeleteMapping("/{id}/remove")
	public void removeExperiment(@PathVariable Long id) {
		Experiment experiment = experimentStorage.findExperimentById(id);
		experimentStorage.removeExperiment(experiment);
	}

}
