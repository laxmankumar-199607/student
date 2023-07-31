package com.csv.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tutorial")
public class Tutorial {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "published")
	private String published;

	public Tutorial() {
		super();
	}

	public Tutorial(Long id, String title, String description, String published) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.published = published;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String isPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

}
