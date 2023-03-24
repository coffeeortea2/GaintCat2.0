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
	 * 透過篩選器條件回傳商品
	 * @param parentCategoryId
	 * @param childCategoryId
	 * @param searchFilter
	 * @return
	 */
	public ArrayList<Product> getProducts(Integer parentCategoryId, Integer childCategoryId, SearchFilter searchFilter) {
		Integer pid = (parentCategoryId != 0) ? parentCategoryId : null;
		Integer cid = (childCategoryId != 0) ? childCategoryId : null;
		String sort = (searchFilter.getSort().equals("phl")) ? "DESC" : "ASC";
		Double minPrice = searchFilter.getMinPrice();
		Double maxPirce = searchFilter.getMaxPrice();
		Integer[] brands = searchFilter.getBrands();
		String keyword = searchFilter.getKeyword();
		Integer page = searchFilter.getPage();
		int start = (page * 12) - 12;
		return searchDao.getProducts(pid, cid, minPrice, maxPirce, brands, keyword, sort, start);
	}
	
	/**
	 * 回傳透過篩選器條件搜尋後的頁面資訊
	 * @param parentCategoryId
	 * @param childCategoryId
	 * @param searchFilter
	 * @return
	 */
	public Map<String, Integer> getPageInformation(Integer parentCategoryId, Integer childCategoryId, SearchFilter searchFilter) {
		
		Integer pid = (parentCategoryId != 0) ? parentCategoryId : null;
		Integer cid = (childCategoryId != 0) ? childCategoryId : null;
		Double minPrice = searchFilter.getMinPrice();
		Double maxPirce = searchFilter.getMaxPrice();
		Integer[] brands = searchFilter.getBrands();
		String keyword = searchFilter.getKeyword();
		
		// 取得總筆數
		Integer totalRow = searchDao.getTotalRow(pid, cid, minPrice, maxPirce, brands, keyword);
		
		// 取得總頁數
		Double p = (double) totalRow / 12;
		Integer totalPage = (int) Math.ceil(p);
		
		Map<String, Integer> pageInfo = new HashMap<>();
		pageInfo.put("totalRow", totalRow);
		pageInfo.put("totalPage", totalPage);
		
		return pageInfo;
	}
}
