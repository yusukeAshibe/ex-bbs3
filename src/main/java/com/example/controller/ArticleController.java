package com.example.controller;

import java.util.List;

import org.apache.catalina.startup.CopyParentClassLoaderRule;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.form.ArticleForm;
import com.example.repository.ArticleRepository;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@ModelAttribute
	public ArticleForm aetUpArticleForm() {
		return new ArticleForm();
	}

	@Autowired
	private ArticleRepository articleReposotory;

	@RequestMapping("")
	public String index(Model model) {
		List<Article> articleList = articleReposotory.findAll();
		model.addAttribute("articleList", articleList);

		return "ex-bbs3";
	}

	@RequestMapping("/articleInsert")
	public String ArticleInsert(ArticleForm form) {
		Article article = new Article();
		BeanUtils.copyProperties(form, article);
		articleReposotory.insert(article);
		System.out.println(article);
		return "redirect:/article";
	}

}
