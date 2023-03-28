package com.gaintcat.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gaintcat.model.product.Product;
import com.gaintcat.model.product.ProductDetail;

@Mapper
public interface ProductMapper {
	/**
	 * 查詢商品詳細資料
	 * @param id
	 * @return
	 */
	@Select("SELECT product.id, product.brand_id, product.category_id, product.pet_id, product.title, product.detail, product.cost, product.price, product.special, "
			+ "product.inventory, product.length, product.width, product.height, product.weight, product.small_img, product.big_img1, product.big_img2, product.big_img3, product.big_img4, product.big_img5, "
			+ "category.parent_id, "
			+ "brand.brand_name "
			+ "FROM product "
			+ "LEFT JOIN category ON product.category_id = category.id "
			+ "LEFT JOIN brand ON product.brand_id = brand.brand_id "
			+ "WHERE product.isUsed = 1 AND product.id = #{id}")
	public ProductDetail getProductDetail(Integer id);
	
	/**
	 * 隨機抓取相同大分類下的五筆商品資料
	 * @param id
	 * @param parent_id
	 * @return
	 */
	@Select("SELECT id, brand_id, category_id, pet_id, title, inventory, price, special, small_img FROM product WHERE id != #{id} AND isUsed = 1 "
			+ "AND category_id IN (SELECT id FROM category WHERE parent_id = #{parent_id}) "
			+ "ORDER BY RAND() LIMIT 8")
	public ArrayList<Product> getProductsByRand(Integer id, Integer parent_id);
}
