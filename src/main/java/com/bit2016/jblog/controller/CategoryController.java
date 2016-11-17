package com.bit2016.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2016.jblog.service.CategoryService;

@Controller
@RequestMapping("/blog")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
/*
	@RequestMapping("/{id}")
	public String viewBlog(@PathVariable("id") String id, Model model) {
		List<CategoryVo> list = categoryService.getCategoryList(id);
		model.addAttribute("list", list);
		return "blog/blog-main";
	}*/
}
