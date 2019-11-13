package org.wcci.apimastery.tags;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.wcci.apimastery.inventors.Inventor;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;
	private String tagName;
	@ManyToMany(mappedBy = "tags")
	private List<Inventor> inventors;
	
	
	public Tag() {}
	public Tag(String tagName) {
		this.tagName = tagName;
	}
	
	public Long getId() {
		return id;
	}
	public String getTagName() {
		return tagName;
	}
	public List<Inventor> getInventors() {
		return inventors;
	}
	
}
