package com.nachopowerrankings.com.reviews;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ReviewControllerTest {
	@InjectMocks
	private ReviewController underTest;
	@Resource
	private TestEntityManager entityManager;
	@Mock
	@Resource
	private CategoryRepository categoryRepo;
	@Mock
	@Resource
	private ReviewRepo reviewRepo;
	private static final String TLDR = "tldr";
	private static final String IMAGE_URL = "picture";
	private static final String CONTENT = "Foo Bar Etc";
	private static final String TITLE = "TestReview";
	private static final String SUMMARY = "A new way to test";
	private static final String NAME = "Testing";
	@Mock
	private Category category1 = new Category(NAME, SUMMARY);
	@Mock
	private Review review1 = new Review(TITLE, CONTENT, category1, IMAGE_URL, TLDR);
	Long category1Id;
	Long review1Id;
	@Mock
	private Model model;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		category1 = categoryRepo.save(category1);
		category1Id = category1.getId();
		review1 = reviewRepo.save(review1);
		review1Id = review1.getId();
	}

	@Test
	public void shouldAddASingleCategoryToModel() {
		when(categoryRepo.findOne(category1Id)).thenReturn(category1);
		underTest.showCategory(category1Id, model);
		verify(model).addAttribute(NAME, category1);
	}
}
