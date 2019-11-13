package org.wcci.apimastery;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.wcci.apimastery.experiments.ExperimentStorage;


@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaWiringTest {
	
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private ExperimentStorage experimentStorage;
	
}
