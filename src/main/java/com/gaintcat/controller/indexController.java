package com.gaintcat.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gaintcat.model.category.Category;
import com.gaintcat.model.index.IndexTopBanner;
import com.gaintcat.service.CategoryService;
import com.gaintcat.service.IndexService;

@Controller
public class indexController {
	@Autowired
	private IndexService indexService;
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 首頁處理
	 * @return
	 */
	@GetMapping("/")
	public ModelAndView index() {
		ArrayList<IndexTopBanner> indexTopBanners = indexService.getTopBanners();
		ArrayList<Category> categories = categoryService.getCategories();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("topBanners", indexTopBanners);
		modelAndView.addObject("categories", categories);
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
