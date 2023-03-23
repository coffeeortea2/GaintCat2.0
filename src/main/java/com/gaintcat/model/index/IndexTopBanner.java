package com.gaintcat.model.index;

public class IndexTopBanner {
	private Integer id;
	private String title;
	private String detail;
	private String image;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Benner [id=" + id + ", title=" + title + ", detail=" + detail + ", image=" + image + "]";
	}
	
}
