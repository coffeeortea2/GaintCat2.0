package com.gaintcat.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaintcat.dao.ProductDao;
import com.gaintcat.model.product.Product;
import com.gaintcat.model.product.ProductDetail;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	
	/**
	 * 取得商品詳細資料
	 * @param productId
	 * @return
	 */
	public ProductDetail getProductDetail(Integer productId) {
		return productDao.getProductDetail(productId);
	}
	
	/**
	 * 隨機取得相同父類別下的商品
	 * @param productId
	 * @param parentCategoryId
	 * @return
	 */
	public ArrayList<Product> getProductsByRand(Integer productId, Integer parentCategoryId) {
		return productDao.getProductsByRand(productId, parentCategoryId);
	}
}
