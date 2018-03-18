package com.nachopowerrankings.reviews;

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
	@Resource
	private CommentRepository commentRepo;
	@Resource
	private ContentTagRepository contentTagRepo;

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

	@RequestMapping("/add-comment")
	public String addComment(String author, String reviewId, String content) {
		Long longReviewId = Long.parseLong(reviewId);
		Review appendedReview = reviewRepo.findOne(longReviewId);
		Comment newComment = new Comment(author, appendedReview, content);
		commentRepo.save(newComment);

		return "redirect:/review?id=" + reviewId;
	}

	@RequestMapping("/add-content-tag")
	public String addContentTag(String name, Long reviewId) {
		// Long longReviewId = Long.parseLong(reviewId);
		Review appendedReview = reviewRepo.findOne(reviewId);
		ContentTag newContentTag = new ContentTag(name, appendedReview);
		contentTagRepo.save(newContentTag);
		return "redirect:/review?id=" + reviewId;
	}

}
