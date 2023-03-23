package com.gaintcat.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gaintcat.mapper.BannerMapper;
import com.gaintcat.model.index.IndexTopBanner;

@Repository
public class BannerDao {
	@Autowired
	private BannerMapper bannerMapper;
	
	public ArrayList<IndexTopBanner> getIndexTopBanner() {
		ArrayList<IndexTopBanner> indexTopBanners = bannerMapper.getIndexTopBanner();
		return indexTopBanners;
	}
}
