package org.wcci.apimastery;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Experiment {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	@ManyToMany
	private List<Inventor> inventors;
	
	public Experiment() {}
	public Experiment(String name, String description) {
		this.name = name;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public List<Inventor> getInventors() {
		return inventors;
	}
	
}
