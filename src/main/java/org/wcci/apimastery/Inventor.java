package org.wcci.apimastery;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Inventor {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String country;
	@OneToMany
	private List<String> pictures;
	@ManyToMany
	private List<Experiment> experiments;
	@ManyToMany
	private List<Tag> tags;
	
	public Inventor() {}
	public Inventor(String name, String country) {
		this.name = name;
		this.country = country;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCountry() {
		return country;
	}
	public List<String> getPictures() {
		return pictures;
	}
	public List<Experiment> getExperiments() {
		return experiments;
	}
	public List<Tag> getTags() {
		return tags;
	}
	
}
