package com.bit2016.jblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit2016.jblog.service.BlogService;
import com.bit2016.jblog.service.MembersService;
import com.bit2016.jblog.vo.MembersVo;

@Controller
@RequestMapping("")
public class MembersController {

	@Autowired
	private MembersService membersService;

	@Autowired
	private BlogService blogService;

	@RequestMapping("/join")
	public String join(@ModelAttribute MembersVo membersVo ) {
		return "user/join";
	}

	@RequestMapping(value = "/joinsuccess", method = RequestMethod.POST)
	public String join(@ModelAttribute @Valid MembersVo membersVo, BindingResult result, Model model) {

		if (result.hasErrors()) {
			//model.addAllAttributes(result.getModel());
			return "/user/join";
		}

		blogService.createBlog(membersService.join(membersVo));
		return "redirect:user/joinsuccess";
	}
}
