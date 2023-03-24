package com.gaintcat.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gaintcat.mapper.SearchMapper;
import com.gaintcat.model.product.Product;

@Repository
public class SearchDao {
	@Autowired
	private SearchMapper searchMapper;
	
	/**
	 * 透過篩選器搜尋結果
	 * @param pid
	 * @param cid
	 * @param minPrice
	 * @param maxPrice
	 * @param brands
	 * @param sort
	 * @return
	 */
	public ArrayList<Product> getProducts(Integer pid, Integer cid, Double minPrice, Double maxPrice, Integer[] brands, String keyword, String sort, Integer page) {
		return searchMapper.getProducts(pid, cid, minPrice, maxPrice, brands, keyword, sort, page);
	}
	
	/**
	 * 透過篩選器搜尋總筆數
	 * @param pid
	 * @param cid
	 * @param minPrice
	 * @param maxPrice
	 * @param brands
	 * @return
	 */
	public Integer getTotalRow(Integer pid, Integer cid, Double minPrice, Double maxPrice, Integer[] brands, String keyword) {
		return searchMapper.getTotalRow(pid, cid, minPrice, maxPrice, brands, keyword);
	}
}
