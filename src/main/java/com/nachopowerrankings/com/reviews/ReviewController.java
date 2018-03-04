package com.nachopowerrankings.com.reviews;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {
	@Resource
	private CategoryRepository categoryRepo;
	@Resource
	private ReviewRepository reviewRepo;

	@RequestMapping("/category")
	public String showCategory(@RequestParam("id") Long categoryId, Model model) {
		Category selected = categoryRepo.findOne(categoryId);
		model.addAttribute("selectedCategory", selected);
		return "single-category-view";
	}

	@RequestMapping("/categories")
	public String showAllCategories(Model model) {
		Iterable<Category> allCategories = categoryRepo.findAll();
		model.addAttribute("categories", allCategories);

		return "all-categories-view";
	}

	@RequestMapping("/review")
	public String showReview(@RequestParam("id") Long reviewId, Model model) {
		Review selected = reviewRepo.findOne(reviewId);
		model.addAttribute("selectedReview", selected);
		return "single-review-view";
	}

}
