package com.nachopowerrankings.com.reviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	@Lob
	private String content;
	private String tldr;
	private String imageUrl;
	@ManyToOne
	private Category category;

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Category getCategory() {
		return category;
	}

	public String getImageUrl() {

		return imageUrl;
	}

	public String getTldr() {
		return tldr;
	}

	@SuppressWarnings("unused")
	private Review() {
	}

	public Review(String title, String content, Category category, String imageUrl, String tldr) {
		this.title = title;
		this.content = content;
		this.category = category;
		this.imageUrl = imageUrl;
		this.tldr = tldr;
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

		return id == ((Review) obj).id;
	}

}
