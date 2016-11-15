package com.bit2016.jblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2016.dto.JSONResult;
import com.bit2016.jblog.service.MembersService;

@Controller("membersAPIController")
@RequestMapping("/members/api")
public class MembersController {

	@Autowired
	private MembersService membersService;
	
	@ResponseBody
	@RequestMapping("/checkid")
	public JSONResult checkId(@RequestParam(value = "id", required = true, defaultValue = "") String id) {

		// SingletonClass sc = SingletonClass.getInstance();
		boolean result = membersService.idExists(id);
		return JSONResult.success(result ? "exist" : "not exist");
	}
}
