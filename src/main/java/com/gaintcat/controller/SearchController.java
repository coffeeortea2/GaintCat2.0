package com.gaintcat.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gaintcat.model.category.Brand;
import com.gaintcat.model.category.Category;
import com.gaintcat.model.category.SearchFilter;
import com.gaintcat.model.product.Product;
import com.gaintcat.service.CategoryService;
import com.gaintcat.service.SearchService;

@Controller
public class SearchController {
	@Autowired
	private SearchService searchService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/category")
	public ModelAndView getProduct(
			@RequestParam(name = "p", required = false) Integer parentCategoryId,
			@RequestParam(name = "c", required = false) Integer childCategoryId,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
			@RequestParam(name = "page", required = false, defaultValue = "1") String page) {
		
		// 取得當前頁面要顯示的產品
		ArrayList<Product> products = searchService.getSearchProducts(parentCategoryId, childCategoryId, sort, Integer.valueOf(page));
		
		// 取得分頁資訊
		Map<String, Integer> pageInfo = searchService.getSearchTotalRow(parentCategoryId, childCategoryId, Integer.valueOf(page));
		Integer totalRow = pageInfo.get("totalRow");
		Integer totalPage = pageInfo.get("totalPage");
		
		// 取得產品類別清單
		ArrayList<Category> categories = categoryService.getCategories();
		
		// 取得選取的商品分類清單
		Map<String, Object> selectCategory = categoryService.getCategoriesName(categories, parentCategoryId, childCategoryId);
		
		// 取得廠商清單
		ArrayList<Brand> brands = categoryService.getBrands();
		
		// 計算目前顯示的總筆數
		Integer numberForShow;
		if (!page.equals("1")) {
			Integer previousPage = Integer.valueOf(page) - 1;
			numberForShow = (previousPage * 12) + products.size();
		} else {
			numberForShow = products.size();
		}
		
		// 載入進度條顯示的顏色寬度
		DecimalFormat df = new DecimalFormat("###.##");
		String percentage = df.format((double) Integer.valueOf(page) / totalPage * 100);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("products", products);
		modelAndView.addObject("totalRow", totalRow);
		modelAndView.addObject("numberForShow", numberForShow);
		modelAndView.addObject("percentage", percentage);
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("selectCategory", selectCategory);
		modelAndView.addObject("brands", brands);
		modelAndView.setViewName("product/category");
		return modelAndView;
	}
	
	/**
	 * for category ajax
	 * @param parentCategoryId
	 * @param childCategoryId
	 * @param test
	 * @return
	 */
	@PostMapping("/category/{p}/{c}")
	@ResponseBody
	public Map<String, Object> getProductRest(
			@PathVariable("p") Integer parentCategoryId,
			@PathVariable("c") Integer childCategoryId,
			@RequestBody SearchFilter searchFilter) {
		
		// 取得當前頁面要顯示的產品
		ArrayList<Product> products = searchService.getFilterPorducts(parentCategoryId, childCategoryId, searchFilter);
		
		// 取得分頁資訊
		Map<String, Integer> pageInfo = searchService.getFilterTotalRow(parentCategoryId, childCategoryId, searchFilter);
		Integer totalRow = pageInfo.get("totalRow");
		Integer totalPage = pageInfo.get("totalPage");
		
		// 計算目前顯示的總筆數
		Integer page = searchFilter.getPage();
		Integer numberForShow;
		if (page != 1) {
			Integer previousPage = page - 1;
			numberForShow = (previousPage * 12) + products.size();
		} else {
			numberForShow = products.size();
		}
		
		// 載入進度條顯示的顏色寬度
		DecimalFormat df = new DecimalFormat("###.##");
		String percentage = df.format((double) searchFilter.getPage() / totalPage * 100);
		
		Map<String, Object> filterResult = new HashMap<>();
		filterResult.put("products", products);
		filterResult.put("totalRow", totalRow);
		filterResult.put("numberForShow", numberForShow);
		filterResult.put("percentage", percentage);
		
		return filterResult;
	}
}
