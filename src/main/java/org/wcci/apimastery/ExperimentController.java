package org.wcci.apimastery;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
}
