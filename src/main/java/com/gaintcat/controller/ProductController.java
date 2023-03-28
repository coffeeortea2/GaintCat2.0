package com.gaintcat.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.gaintcat.model.category.Category;
import com.gaintcat.model.product.Product;
import com.gaintcat.model.product.ProductDetail;
import com.gaintcat.service.CategoryService;
import com.gaintcat.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/product/{id}")
	public String getProductDetail(
			@PathVariable("id") Integer productId,
			Model model) {
		
		// 取得產品詳細資料
		ProductDetail productDetail = productService.getProductDetail(productId);
		Integer parentCategoryId = productDetail.getParent_id();
		Integer childCategoryId = productDetail.getCategory_id();
		
		// 取得產品類別清單
		ArrayList<Category> categories = categoryService.getCategories();
		
		// 取得選取的商品分類清單
		Map<String, Object> selectCategory = categoryService.getCategoriesName(categories, parentCategoryId, childCategoryId);
		
		// 取得相同 parentCategoryId 下的隨機商品
		ArrayList<Product> randProducts = productService.getProductsByRand(productId, parentCategoryId);
		
		model.addAttribute("product", productDetail);
		model.addAttribute("categories", categories);
		model.addAttribute("selectCategory", selectCategory);
		model.addAttribute("randProducts", randProducts);
		
		return "product/product";
	}
}
