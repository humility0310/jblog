package com.bit2016.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("")
	public String index(){
		return "main/index";
	}
	
	@ResponseBody
	@RequestMapping( "/hello" )
	public String hello(){
		return "가나다라마바사아자차카타파22@@가";
	}
}
