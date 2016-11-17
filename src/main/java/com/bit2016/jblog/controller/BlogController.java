package com.bit2016.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2016.jblog.service.BlogService;
import com.bit2016.jblog.service.BoardService;
import com.bit2016.jblog.service.CategoryService;
import com.bit2016.jblog.vo.BoardVo;
import com.bit2016.jblog.vo.CategoryVo;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BoardService boardService;

	@RequestMapping("/main")
	public String main() {
		return "blog/blog-main";
	}

	// @RequestMapping({"","/{no}"})

	@RequestMapping("/{id}")
	public String viewBlog(@PathVariable("id") String id, Model model) {

		model.addAttribute("id", id);
		model.addAttribute("blogVo", blogService.getBlogInfo(id));

		List<CategoryVo> list = categoryService.getCategoryList(id);
		model.addAttribute("categorylist", list);

		return "blog/blog-main";
	}

	@RequestMapping("/{id}/{cateno}")
	public String viewBlogAndCategory(@PathVariable("id") String id, @PathVariable("cateno") Long cateno, Model model) {

		model.addAttribute("id", id);

		model.addAttribute("blogVo", blogService.getBlogInfo(id));

		List<CategoryVo> list = categoryService.getCategoryList(id);
		model.addAttribute("categorylist", list);

		List<BoardVo> list2 = boardService.viewBoard(cateno);
		model.addAttribute("boardlist", list2);
		// return "redirect:/blog/{id}/{cateno}";
		return "blog/blog-main";
	}

	@RequestMapping("/{id}/{cateno}/{titleno}")
	public String viewBlogAndCategoryAndContent(@PathVariable("id") String id, @PathVariable("cateno") Long cateno,
			@PathVariable("titleno") Long titleno, Model model) {

		model.addAttribute("id", id);
		model.addAttribute("cateno", cateno);
		model.addAttribute("titleno", titleno);

		model.addAttribute("blogVo", blogService.getBlogInfo(id));

		List<CategoryVo> list = categoryService.getCategoryList(id);
		model.addAttribute("categorylist", list);

		List<BoardVo> list2 = boardService.viewBoard(cateno);
		model.addAttribute("boardlist", list2);
		
		model.addAttribute("boardVo", boardService.viewContent(titleno));
		
		
		return "blog/blog-main";
	}

}
