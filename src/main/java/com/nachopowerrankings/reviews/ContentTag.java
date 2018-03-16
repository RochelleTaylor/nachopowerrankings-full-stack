package com.nachopowerrankings.reviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ContentTag {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@ManyToOne
	private Review review;

	public ContentTag(String name, Review... review) {
		this.name = name;
		// this.review = review;

	}

	private ContentTag() {
	};

	public Review getReview() {
		return review;
	}

	public long getId() {

		return id;
	}

	public String getName() {

		return name;
	}

}
