package com.gaintcat.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String getProduct(
			@RequestParam(name = "p", required = false, defaultValue = "0") Integer parentCategoryId,
			@RequestParam(name = "c", required = false, defaultValue = "0") Integer childCategoryId,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
			@RequestParam(name = "page", required = false, defaultValue = "1") String page,
			@RequestParam(name = "k", required = false) String keyword,
			Model model) {
		
		SearchFilter searchFilter = new SearchFilter();
		searchFilter.setBrands(new Integer[] {});
		searchFilter.setKeyword(keyword);
		searchFilter.setPage(Integer.valueOf(page));
		searchFilter.setSort(sort);
		
		// 取得當前頁面要顯示的產品
		ArrayList<Product> products = searchService.getProducts(parentCategoryId, childCategoryId, searchFilter);
		
		// 取得分頁資訊
		Map<String, Integer> pageInfo = searchService.getPageInformation(parentCategoryId, childCategoryId, searchFilter);
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
		
		model.addAttribute("products", products);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("numberForShow", numberForShow);
		model.addAttribute("percentage", percentage);
		model.addAttribute("categories", categories);
		model.addAttribute("selectCategory", selectCategory);
		model.addAttribute("brands", brands);
		model.addAttribute("keyword", keyword);
		
		return "product/category";
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
		ArrayList<Product> products = searchService.getProducts(parentCategoryId, childCategoryId, searchFilter);
		
		// 取得分頁資訊
		Map<String, Integer> pageInfo = searchService.getPageInformation(parentCategoryId, childCategoryId, searchFilter);
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
