package com.nachopowerrankings.com.reviews;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.ui.Model;

//@RunWith(SpringJUnit4ClassRunner.class)
//@DataJpaTest
public class ReviewControllerTest {
	@InjectMocks
	private ReviewController underTest;
	// @Resource
	private TestEntityManager entityManager;
	@Mock
	// @Resource
	private CategoryRepository categoryRepo;
	@Mock
	// @Resource
	private ReviewRepository reviewRepo;
	// private static final String TLDR = "tldr";
	// private static final String IMAGE_URL = "picture";
	// private static final String CONTENT = "Foo Bar Etc";
	// private static final String TITLE = "TestReview";
	private static final String SUMMARY = "A new way to test";
	private static final String NAME = "Testing";
	@Mock
	private Category category1; // = new Category(NAME, SUMMARY);
	@Mock
	private Category category2;
	@Mock
	private Review review1; // = new Review(TITLE, CONTENT, category1, IMAGE_URL,
	// TLDR);
	// Long category1Id;
	// Long review1Id;
	@Mock
	private Model model;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		// category1 = categoryRepo.save(category1);
		// category1Id = category1.getId();
		// review1 = reviewRepo.save(review1);
		// review1Id = review1.getId();
	}

	@Test
	public void shouldAddASingleCategoryToModel() {
		Long arbritaryCategoryId = 42L;
		when(categoryRepo.findOne(arbritaryCategoryId)).thenReturn(category1);
		underTest.showCategory(arbritaryCategoryId, model);
		verify(model).addAttribute("selectedCategory", category1);
	}

	@Test
	public void shouldReturnSingleCategoryView() {
		String templateName = underTest.showCategory(42L, model);
		assertThat(templateName, is("single-category-view"));
	}

	@Test
	public void shouldAddAllCategoriesToModel() {
		Collection<Category> allCategories = Arrays.asList(category1, category2);
		when(categoryRepo.findAll()).thenReturn(allCategories);
		underTest.showAllCategories(model);
		verify(model).addAttribute("categories", allCategories);
	}

	@Test
	public void shouldReturnAllCategoriesView() {
		String templateName = underTest.showAllCategories(model);
		assertThat(templateName, is("all-categories-view"));
	}

	@Test
	public void shouldAddASingleReviewToModel() {
		Long arbritaryReviewId = 42L;
		when(reviewRepo.findOne(arbritaryReviewId)).thenReturn(review1);
		underTest.showReview(arbritaryReviewId, model);
		verify(model).addAttribute("selectedReview", review1);
	}

	@Test
	public void shouldReturnSingleReviewView() {
		String templateName = underTest.showReview(42L, model);
		assertThat(templateName, is("single-review-view"));

	}
}
