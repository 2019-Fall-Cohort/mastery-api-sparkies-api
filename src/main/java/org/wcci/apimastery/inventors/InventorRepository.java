package org.wcci.apimastery.inventors;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventorRepository extends CrudRepository<Inventor, Long> {

}
