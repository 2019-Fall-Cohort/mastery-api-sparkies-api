package org.wcci.apimastery.experiments;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.wcci.apimastery.inventors.Inventor;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Experiment {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@Lob
	private String description;
	@JsonIgnore
	@ManyToOne
	private Inventor inventor;
	
	public Experiment() {}
	public Experiment(String name, String description, Inventor inventor) {
		this.name = name;
		this.description = description;
		this.inventor = inventor;
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
	public Inventor getInventor() {
		return inventor;
	}
	
}
