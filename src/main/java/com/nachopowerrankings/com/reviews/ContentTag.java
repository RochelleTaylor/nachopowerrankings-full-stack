package com.nachopowerrankings.com.reviews;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ContentTag {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	@ManyToMany(mappedBy = "contentTags")
	private List<Review> reviews;

	public ContentTag(String title, List<Review>... reviews) {
		this.title = title;
		this.reviews = reviews;
	}

	public String getTitle() {

		return title;
	}

	public Long getId() {
		return id;
	}

}
