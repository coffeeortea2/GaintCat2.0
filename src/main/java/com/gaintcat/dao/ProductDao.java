package com.gaintcat.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gaintcat.mapper.ProductMapper;
import com.gaintcat.model.product.Product;
import com.gaintcat.model.product.ProductDetail;

@Repository
public class ProductDao {
	@Autowired
	private ProductMapper productMapper;
	
	/**
	 * 取得商品詳細資料
	 * @param productId
	 * @return
	 */
	public ProductDetail getProductDetail(Integer productId) {
		return productMapper.getProductDetail(productId);
	}
	
	/**
	 * 取得相同父類別下的隨機商品
	 * @param productId
	 * @param parentCategoryId
	 * @return
	 */
	public ArrayList<Product> getProductsByRand(Integer productId, Integer parentCategoryId) {
		return productMapper.getProductsByRand(productId, parentCategoryId);
	}
}
