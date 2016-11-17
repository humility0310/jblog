package com.bit2016.jblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit2016.jblog.service.MembersService;
import com.bit2016.jblog.vo.MembersVo;

@Controller
@RequestMapping("")
public class MembersController {

	@Autowired
	private MembersService membersService;

	@RequestMapping("/join")
	public String join(@ModelAttribute MembersVo membersVo) {
		return "user/join";
	}

	@RequestMapping(value = "/joinresult", method = RequestMethod.POST)
	public String join(@ModelAttribute @Valid MembersVo membersVo, BindingResult result, Model model) {

		if (result.hasErrors()) {
			// model.addAllAttributes(result.getModel());
			return "/user/join";
		}
		membersService.join(membersVo);
		return "redirect:/joinsuccess";
	}
	
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "user/joinsuccess";
	}

	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}

}
