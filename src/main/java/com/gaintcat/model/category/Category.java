package com.gaintcat.model.category;

import java.util.ArrayList;

public class Category {
	private Integer id;
	private String name;
	private String image;
	private ArrayList<ChildCategory> childCategories;
	private Integer isParent;
	private Integer parent_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public ArrayList<ChildCategory> getChildCategories() {
		return childCategories;
	}
	public void setChildCategories(ArrayList<ChildCategory> childCategories) {
		this.childCategories = childCategories;
	}
	public Integer getIsParent() {
		return isParent;
	}
	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
}
