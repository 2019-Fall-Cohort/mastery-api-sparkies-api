package org.wcci.apimastery.experiments;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperimentRepository extends CrudRepository<Experiment, Long> {

}
