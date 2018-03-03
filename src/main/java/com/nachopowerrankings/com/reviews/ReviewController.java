package com.nachopowerrankings.com.reviews;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {
	@Resource
	private CategoryRepository categoryRepo;

	@RequestMapping("/course")
	public String showCategory(Long category1Id, Model model) {
		Category selected = categoryRepo.findOne(category1Id);
		model.addAttribute("selectedCategory", selected);
		return "single-category-view";
	}

}
