package com.gaintcat.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gaintcat.mapper.CategoryMapper;
import com.gaintcat.model.category.Brand;
import com.gaintcat.model.category.Category;
import com.gaintcat.model.category.ChildCategory;

@Repository
public class CategoryDao {
	@Autowired
	private CategoryMapper categoryMapper;
	
	public ArrayList<Category> getParentCategory() {
		return categoryMapper.getParengCategory();
	}
	
	public ArrayList<ChildCategory> getChildCategory(Integer parentCategoryId) {
		return categoryMapper.getChildCategory(parentCategoryId);
	}
	
	public ArrayList<Brand> getBrands() {
		return categoryMapper.getBrandList();
	}
}
