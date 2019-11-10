package org.wcci.apimastery;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/experiments")
public class ExperimentController {

	@Autowired
	private ExperimentStorage experimentStorage;
	
	@GetMapping("")
	public Iterable<Experiment> getAllExperiments(){
		return experimentStorage.getAllExperiments();
	}
	
	@GetMapping("/{id}")
	public Experiment getSingleExperiment(@PathVariable Long id) {
		return experimentStorage.findExperimentById(id);
	}
	
	@PostMapping("/add")
	public void addSingleExperiment(@PathVariable String name, String description) {
		Experiment experiment = new Experiment(name, description);
		experimentStorage.addExperiment(experiment);
	}
	
	@DeleteMapping("/{id}/remove")
	public void removeExperiment(@PathVariable Long id) {
		Experiment experiment = experimentStorage.findExperimentById(id);
		experimentStorage.removeExperiment(experiment);
	}

}
