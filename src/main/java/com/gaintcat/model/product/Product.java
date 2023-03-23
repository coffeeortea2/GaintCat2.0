package com.gaintcat.model.product;

public class Product {
	private Integer id;
	private Integer brand_id;
	private Integer category_id;
	private Integer pet_id;
	private String title;
	private Integer inventory;
	private Double price;
	private Double special;
	private String small_img;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Integer getPet_id() {
		return pet_id;
	}
	public void setPet_id(Integer pet_id) {
		this.pet_id = pet_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getSpecial() {
		return special;
	}
	public void setSpecial(Double special) {
		this.special = special;
	}
	public String getSmall_img() {
		return small_img;
	}
	public void setSmall_img(String small_img) {
		this.small_img = small_img;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", brand_id=" + brand_id + ", category_id=" + category_id + ", pet_id=" + pet_id
				+ ", title=" + title + ", inventory=" + inventory + ", price=" + price + ", special=" + special
				+ ", small_img=" + small_img + "]";
	}
	
}
