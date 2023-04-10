package com.gaintcat.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaintcat.dao.CategoryDao;
import com.gaintcat.model.category.Brand;
import com.gaintcat.model.category.Category;
import com.gaintcat.model.category.ChildCategory;

@Service
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	
	/**
	 * 取得產品分類清單
	 * @return
	 */
	public ArrayList<Category> getCategories() {
		// 取得上層分類的集合
		ArrayList<Category> categories = categoryDao.getParentCategory();
		for (Category category : categories) {
			ArrayList<ChildCategory> childCategories = categoryDao.getChildCategory(category.getId());
			category.setChildCategories(childCategories);
		}
		return categories;
	}
	
	/**
	 * 取得廠商清單
	 * @return
	 */
	public ArrayList<Brand> getBrands() {
		return categoryDao.getBrands();
	}
	
	/**
	 * 取得目前選擇的主產品分類、子產品分類名稱
	 * @param categories
	 * @param pid
	 * @param cid
	 * @return
	 */
	public Map<String, Object> getCategoriesName(ArrayList<Category> categories, Integer pid, Integer cid) {
		
		Category category = categories.stream()
				  .filter(c -> c.getId() == pid)
				  .findAny()
				  .orElse(null);
		
		Map<String, Object> categoryMap = new HashMap<>();
		
		System.out.println("???????" + cid);
		
		if (category != null) {
			categoryMap.put("parent", category.getName());
			categoryMap.put("parentId", category.getId());
			
			if (cid != 0) {
				ChildCategory childCategory = category.getChildCategories().stream()
						.filter(c -> c.getId() == cid)
						.findAny()
						.orElse(null);
				
				categoryMap.put("child", childCategory.getName());
			}
		}
		
		return categoryMap;
	}
}
