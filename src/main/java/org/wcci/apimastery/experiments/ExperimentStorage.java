package org.wcci.apimastery.experiments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.inventors.Inventor;
import org.wcci.apimastery.tags.Tag;

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

	public void addTagToExperiment(Tag addedTag, Long id) {
		Experiment experiment = experimentRepo.findById(id).get();
		experiment.giveExperimentATag(addedTag);
		experimentRepo.save(experiment);
	}

	public void removeTagFromExperiment(Experiment experiment, Tag tag) {
		experiment.removeExperimentTag(tag);
		experimentRepo.save(experiment);
	}

	
	
}