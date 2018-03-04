package com.nachopowerrankings.com.reviews;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ContentTagTest {
	String TITLE = "Title";

	@Test
	public void shouldHaveTitle() {
		ContentTag underTest = new ContentTag(TITLE, null);
		String result = underTest.getTitle();
		assertThat(result, is(TITLE));

	}
}
