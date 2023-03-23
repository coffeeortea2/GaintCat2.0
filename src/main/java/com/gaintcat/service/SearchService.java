package com.gaintcat.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaintcat.dao.SearchDao;
import com.gaintcat.model.category.SearchFilter;
import com.gaintcat.model.product.Product;

@Service
public class SearchService {
	@Autowired
	private SearchDao searchDao;
	
	/**
	 * 取得當下分頁的商品清單
	 * @param category_id
	 * @param sort
	 * @param page
	 * @return
	 */
	public ArrayList<Product> getSearchProducts(Integer pid, Integer cid, String sort, Integer page) {
		int start = (page * 12) - 12;
		return searchDao.getProductsByChildCategoryId(pid, cid, sort, start);
	}
	
	/**
	 * 回傳分頁資訊
	 * @param category_id
	 * @return
	 */
	public Map<String, Integer> getSearchTotalRow(Integer pid, Integer cid, Integer Page) {
		// 取得總筆數
		Integer totalRow = searchDao.getSearchTotalRow(pid, cid);
		
		// 取得總頁數，使用無條件進位取整數
		Double p = (double) totalRow / 12;
		Integer totalPage = (int) Math.ceil(p);
		
		Map<String, Integer> pageInfo = new HashMap<>();
		pageInfo.put("totalRow", totalRow);
		pageInfo.put("totalPage", totalPage);
		return pageInfo;
	}
	
	public ArrayList<Product> getFilterPorducts(Integer parentCategoryId, Integer childCategoryId, SearchFilter searchFilter) {
		Integer pid = (parentCategoryId != 0) ? parentCategoryId : null;
		Integer cid = (childCategoryId != 0) ? childCategoryId : null;
		String sort = (searchFilter.getSort().equals("phl")) ? "DESC" : "ASC";
		Double minPrice = searchFilter.getMinPrice();
		Double maxPirce = searchFilter.getMaxPrice();
		Integer[] brands = searchFilter.getBrands();
		Integer page = searchFilter.getPage();
		int start = (page * 12) - 12;
		return searchDao.getProductsByFilter(pid, cid, minPrice, maxPirce, brands, sort, start);
	}
	
	public Map<String, Integer> getFilterTotalRow(Integer parentCategoryId, Integer childCategoryId, SearchFilter searchFilter) {
		
		Integer pid = (parentCategoryId != 0) ? parentCategoryId : null;
		Integer cid = (childCategoryId != 0) ? childCategoryId : null;
		Double minPrice = searchFilter.getMinPrice();
		Double maxPirce = searchFilter.getMaxPrice();
		Integer[] brands = searchFilter.getBrands();
		
		// 取得總筆數
		Integer totalRow = searchDao.getFilterTotalRow(pid, cid, minPrice, maxPirce, brands);
		
		// 取得總頁數，使用無條件進位取整數
		Double p = (double) totalRow / 12;
		Integer totalPage = (int) Math.ceil(p);
		
		Map<String, Integer> pageInfo = new HashMap<>();
		pageInfo.put("totalRow", totalRow);
		pageInfo.put("totalPage", totalPage);
		return pageInfo;
	}
}
