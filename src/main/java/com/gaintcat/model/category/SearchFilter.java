package com.gaintcat.model.category;

import java.util.Arrays;

public class SearchFilter {
	private String sort;
	private Double minPrice;
	private Double maxPrice;
	private Integer[] brands;
	private Integer page;
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Integer[] getBrands() {
		return brands;
	}
	public void setBrands(Integer[] brands) {
		this.brands = brands;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "SearchFilter [" + (sort != null ? "sort=" + sort + ", " : "")
				+ (minPrice != null ? "minPrice=" + minPrice + ", " : "")
				+ (maxPrice != null ? "maxPrice=" + maxPrice + ", " : "")
				+ (brands != null ? "brands=" + Arrays.toString(brands) + ", " : "")
				+ (page != null ? "page=" + page : "") + "]";
	}
}
