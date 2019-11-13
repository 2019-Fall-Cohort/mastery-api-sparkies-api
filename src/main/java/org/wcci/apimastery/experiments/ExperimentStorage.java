package org.wcci.apimastery.experiments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperimentStorage {

	@Autowired
	private ExperimentRepository experimentRepo;
	
	public Iterable<Experiment> getAllExperiments() {
		return experimentRepo.findAll();
	}
	
	public Experiment findExperimentById(Long id) {
		return experimentRepo.findById(id).get();
	}
	
	public void addExperiment(Experiment experiment) {
		experimentRepo.save(experiment);
	}

	public void removeExperiment(Experiment experiment) {
		experimentRepo.delete(experiment);
	}

	
	
}