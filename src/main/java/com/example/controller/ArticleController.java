package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("article")
public class ArticleController {
	
	@RequestMapping("")
	public String index() {
		return "ex-bbs3";
	}

}
