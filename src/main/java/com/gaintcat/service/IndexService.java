package com.gaintcat.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaintcat.dao.BannerDao;
import com.gaintcat.model.index.IndexTopBanner;

@Service
public class IndexService {
	@Autowired
	private BannerDao bannerDao;
	
	/**
	 * 呼叫 DAO 執行查詢所有資料
	 * @return ArrayList<IndexTopBanner> 資料集合
	 */
	public ArrayList<IndexTopBanner> getTopBanners() {
		return bannerDao.getIndexTopBanner();
	}
	
	/**
	 * 呼叫 DAO 執行查詢所有資料
	 * @return ArrayList<Product> 資料集合
	 */
//	public ArrayList<Product> getIndexProducts() {
//		return productDao.getIndexProducts();
//	}
}
