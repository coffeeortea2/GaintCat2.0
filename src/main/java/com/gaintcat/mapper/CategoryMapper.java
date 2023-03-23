package com.gaintcat.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gaintcat.model.category.Brand;
import com.gaintcat.model.category.Category;
import com.gaintcat.model.category.ChildCategory;

@Mapper
public interface CategoryMapper {
	/**
	 * 取得上層產品分類
	 * @return
	 */
	@Select("SELECT id, name, image FROM category WHERE isParent = 1 AND isUsed = 1")
	public ArrayList<Category> getParengCategory();
	
	/**
	 * 取得子產品分類
	 * @param parent_id
	 * @return
	 */
	@Select("SELECT id, parent_id, name FROM category WHERE isParent = 2 AND isUsed = 1 AND parent_id = #{parent_id}")
	public ArrayList<ChildCategory> getChildCategory(Integer parent_id);
	
	/**
	 * 取得廠商資料
	 * @return
	 */
	@Select("SELECT brand.brand_id, brand.brand_name, COUNT(brand.brand_id) AS product_num FROM brand"
			+ " LEFT JOIN product ON product.brand_id = brand.brand_id"
			+ " WHERE brand.isUsed = 1 AND product.isUsed = 1"
			+ " GROUP BY brand.brand_id")
	public ArrayList<Brand> getBrandList();
}
