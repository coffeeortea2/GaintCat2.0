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
	
	public Integer getSearchTotalRow(Integer pid, Integer cid) {
		return searchMapper.getSearchTotalRow(pid, cid);
	}
	
	public Integer getFilterTotalRow(Integer pid, Integer cid, Double minPrice, Double maxPrice, Integer[] brands) {
		return searchMapper.getFilterTotalRow(pid, cid, minPrice, maxPrice, brands);
	}
	
	/**
	 * category 頁面預設搜尋結果
	 * @param pid
	 * @param cid
	 * @param sort
	 * @param page
	 * @return
	 */
	public ArrayList<Product> getProductsByChildCategoryId(Integer pid, Integer cid, String sort, Integer page) {
		return searchMapper.getProductsByChildCategoryId(pid, cid, sort, page);
	}
	
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
	public ArrayList<Product> getProductsByFilter(Integer pid, Integer cid, Double minPrice, Double maxPrice, Integer[] brands, String sort, Integer page) {
		return searchMapper.getProductsByFilter(pid, cid, minPrice, maxPrice, brands, sort, page);
	}
}
