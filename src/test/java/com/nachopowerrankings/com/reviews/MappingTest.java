package com.nachopowerrankings.com.reviews;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class MappingTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private CategoryRepository categoryRepo;
	@Resource
	private ReviewRepo reviewRepo;

	@Test
	public void shouldSaveAndLoadCategory() {
		Category category = new Category("Testing", "A new way to test");
		category = categoryRepo.save(category);
		long categoryId = category.getId();
		entityManager.flush(); // forces pending stuff to happen
		entityManager.clear();
		category = categoryRepo.findOne(categoryId);
		assertThat(category.getName(), is("Testing"));
	}

	@Test
	public void shouldSaveAndLoadReview() {
		Category category = new Category("Testing", "A new way to test");
		category = categoryRepo.save(category);
		Review review = new Review("Test Review", "Stuff About Nachos", category, "image", "TLDR");
		review = reviewRepo.save(review);
		long reviewId = review.getId();
		entityManager.flush();
		entityManager.clear();

		review = reviewRepo.findOne(reviewId);
		assertThat(review.getTitle(), is("Test Review"));

	}

	@Test
	public void shouldShouldHaveTwoReviewsAndOneCategory() {
		Category category = new Category("Testing", "A new way to test");
		category = categoryRepo.save(category);
		Review review1 = new Review("Test Review", "Stuff About Nachos", category, "image", "TLDR");
		review1 = reviewRepo.save(review1);
		long review1Id = review1.getId();
		Review review2 = new Review("Test Review2", "Stuff About more Nachos", category, "image", "TLDRTT");
		review2 = reviewRepo.save(review2);
		long review2Id = review2.getId();
		entityManager.flush();
		entityManager.clear();

		Iterable<Review> reviews = reviewRepo.findAll();
		assertThat(reviews, containsInAnyOrder(review1, review2));

		review1 = reviewRepo.findOne(review1Id);
		review2 = reviewRepo.findOne(review2Id);
		assertThat(review1.getTitle(), is("Test Review"));
		assertThat(review2.getTitle(), is("Test Review2"));
		assertThat(review1.getCategory(), is(category));
		assertThat(review2.getCategory(), is(category));

	}

	@Test
	public void shouldReturnAListOfReviews() {
		Category category = new Category("Testing", "A new way to test");
		category = categoryRepo.save(category);
		Review review1 = new Review("Test Review", "Stuff About Nachos", category, "image", "TLDR");
		review1 = reviewRepo.save(review1);
		Review review2 = new Review("Test Review2", "Stuff About more Nachos", category, "image", "TLDRTT");
		review2 = reviewRepo.save(review2);
		entityManager.flush();
		entityManager.clear();

		Iterable<Review> reviews = reviewRepo.findAll();
		assertThat(reviews, containsInAnyOrder(review1, review2));
	}

	@Test
	public void shouldReturnAListOfCategories() {
		Category category = new Category("Testing", "A new way to test");
		categoryRepo.save(category);
		Category category2 = new Category("Testing1", "A new way to test1");
		categoryRepo.save(category2);

		entityManager.flush();
		entityManager.clear();
		Iterable<Category> categories = categoryRepo.findAll();
		assertThat(categories, containsInAnyOrder(category, category2));
	}

	@Test
	public void shouldReturnAListOfReviewsWithACommonCategory() {
		Category category1 = new Category("Testing", "A new way to test");
		categoryRepo.save(category1);
		Long category1Id = category1.getId();
		Category category2 = new Category("Testing1", "A new way to test1");
		categoryRepo.save(category2);
		Review review1 = new Review("Test Review", "Stuff About Nachos", category1, "image", "TLDR");
		review1 = reviewRepo.save(review1);
		Review review2 = new Review("Test Review2", "Stuff About more Nachos", category1, "image", "TLDRTT");
		review2 = reviewRepo.save(review2);
		Review review3 = new Review("Test Review3", "Stuff About Tacos", category2, "image", "TLDRTT");
		review3 = reviewRepo.save(review3);
		entityManager.flush();
		entityManager.clear();
		Iterable<Review> reviewsFromCategory1 = categoryRepo.findOne(category1Id).getReviews();
		assertThat(reviewsFromCategory1, containsInAnyOrder(review1, review2));
		assertThat(reviewsFromCategory1, not(hasItem(review3)));
	}

}
