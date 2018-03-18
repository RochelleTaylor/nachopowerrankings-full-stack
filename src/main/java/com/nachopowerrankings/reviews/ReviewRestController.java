package com.nachopowerrankings.reviews;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewRestController {
	@Resource
	private ReviewRepository reviewRepo;
	@Resource
	private ContentTagRepository contentTagRepo;

	@RequestMapping("/contentTags/{id}")
	public String findOneContentTag(@PathVariable long id) {
		return contentTagRepo.findOne(id).getName();
	}

	@RequestMapping("/contentTags")
	public String findAllContentTagNames() {
		String contentTagNames = "";
		Iterable<ContentTag> contentTags = contentTagRepo.findAll();
		for (ContentTag tag : contentTags) {
			contentTagNames += tag.getName();
			contentTagNames += "\n";
		}
		return contentTagNames;
	}

	// @RequestMapping("/tagNames")
	// public List<ContentTag> findAllContentTagNamesByRest() {
	// return contentTagRepo.findByName();
	// }

}
