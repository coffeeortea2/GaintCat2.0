package com.gaintcat.mapper;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gaintcat.model.index.IndexTopBanner;

@Mapper
public interface BannerMapper {
	@Select("SELECT id, title, detail, image FROM benner WHERE isOn = 1")
	public ArrayList<IndexTopBanner> getIndexTopBanner();
}
