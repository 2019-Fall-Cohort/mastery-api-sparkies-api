package org.wcci.apimastery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag {

	public Tag(String tagName) {
		this.tagName = tagName;
	}
	@Id
	@GeneratedValue
	private Long id;
	private String tagName;
	
}
