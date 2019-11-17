package org.wcci.apimastery.inventors;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.wcci.apimastery.experiments.Experiment;
import org.wcci.apimastery.tags.Tag;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Inventor {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String country;
	@OneToMany(mappedBy="inventor")
	private List<Experiment> experiments;
	@ManyToMany
	private List<Tag> tags;
	
	public Inventor() {}
	public Inventor(String name, String country) {
		this.name = name;
		this.country = country;
	}
	
	public void giveInventorATag(Tag tag) {
		if (tags == null) {
			tags = new ArrayList<>();
		}
		tags.add(tag);
	}
	
	public void removeInventorTag(Tag tag) {
		tags.remove(tag);
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

	public List<Experiment> getExperiments() {
		return experiments;
	}
	public List<Tag> getTags() {
		return tags;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((experiments == null) ? 0 : experiments.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventor other = (Inventor) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (experiments == null) {
			if (other.experiments != null)
				return false;
		} else if (!experiments.equals(other.experiments))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}
	
	
}
