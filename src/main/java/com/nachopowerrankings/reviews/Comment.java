package com.nachopowerrankings.reviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	@ManyToOne
	private Review review;

	public Comment(String title, Review review) {
		this.title = title;
		this.review = review;

	}

	@SuppressWarnings("unused")
	private Comment() {
	};

	public long getId() {

		return id;
	}

	public String getTitle() {
		return title;
	}

}
