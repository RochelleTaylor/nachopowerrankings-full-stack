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

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		return id == ((Comment) obj).id;
	}

	public Review getReview() {
		// TODO Auto-generated method stub
		return review;
	}
}
