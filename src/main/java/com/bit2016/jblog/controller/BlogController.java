package com.bit2016.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2016.jblog.service.BlogService;
import com.bit2016.jblog.service.BoardService;
import com.bit2016.jblog.service.CategoryService;
import com.bit2016.jblog.service.LogoService;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.BoardVo;
import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.MembersVo;
import com.bit2016.security.Auth;
import com.bit2016.security.AuthUser;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BoardService boardService;

	@Autowired
	private LogoService logoService;

	@RequestMapping("/main")
	public String main() {
		return "blog/blog-main";
	}

	// @RequestMapping({"","/{no}"})

	@Auth
	@RequestMapping("/{authUser.id}/setbasic")
	public String setMain(@AuthUser MembersVo authUser, Model model) {

		model.addAttribute("id", authUser.getId());
		model.addAttribute("blogVo", blogService.getBlogInfo(authUser.getId()));
		model.addAttribute("baseURL", LogoService.BASE_URL);

		return "blog/blog-admin-basic";
	}

	@Auth
	@RequestMapping("/{authUser.id}/setbasicsuccess")
	public String settMainSuccess(@AuthUser MembersVo authUser, @ModelAttribute BlogVo vo) {

		vo.setBlogId(authUser.getNo());
		System.out.println("authUser.getNo()=" + authUser.getNo());
		System.out.println("vo.getBlogId()=" + vo.getBlogId());
		System.out.println("vo.getTitle()=" + vo.getTitle());
		System.out.println("vo.getLogo()=" + vo.getLogo());
		blogService.updateBlog(vo);

		return "redirect:/blog/{authUser.id}";
	}

	@RequestMapping("/{id}")
	public String viewBlog(@PathVariable("id") String id, Model model) {

		model.addAttribute("id", id);
		model.addAttribute("blogVo", blogService.getBlogInfo(id));

		List<CategoryVo> list = categoryService.getCategoryList(id);
		model.addAttribute("categorylist", list);

		model.addAttribute("baseURL", LogoService.BASE_URL);

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

		model.addAttribute("baseURL", LogoService.BASE_URL);

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

		model.addAttribute("baseURL", LogoService.BASE_URL);

		return "blog/blog-main";
	}

}
