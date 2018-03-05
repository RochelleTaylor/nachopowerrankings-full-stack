package com.nachopowerrankings.reviews;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private long id;

	private String name;
	private String summary;

	@OneToMany(mappedBy = "category")
	private Collection<Review> reviews;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Review> getReviews() {
		return reviews;
	}

	public String getSummary() {
		return summary;
	}

	@SuppressWarnings("unused")
	private Category() {
	}

	public Category(String name, String summary) {
		this.name = name;
		this.summary = summary;
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

		return id == ((Category) obj).id;
	}

}
