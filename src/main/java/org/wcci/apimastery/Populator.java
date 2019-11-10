package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner{

	@Autowired
	ExperimentStorage experimentStorage;
	
	@Autowired
	InventorStorage inventorStorage;

	@Override
	public void run(String... args) throws Exception {
		
		Inventor faraday = new Inventor("Michael Faraday", "England");
		Inventor volta = new Inventor("Alessandro Volta", "Italy");
		
		Experiment faradayCage = new Experiment("Faraday Cage", "In 1836, Michael Faraday built a room coated with metal foil and allowed high-voltage discharges from an electrostatic generator to strike the outside of the room.");
		Experiment gobletOfBrine = new Experiment("Goblet of Brine", "Initially he experimented with individual cells in series, each cell being a wine goblet filled with brine into which the two dissimilar electrodes were dipped. The voltaic pile replaced the goblets with cardboard soaked in brine.");
		
		inventorStorage.addInventor(faraday);
		inventorStorage.addInventor(volta);
		
		experimentStorage.addExperiment(faradayCage);
		experimentStorage.addExperiment(gobletOfBrine);
	}
}
