package com.gaintcat.model.product;

public class ProductDetail extends Product {
	private Integer parent_id;
	private String brand_name;
	private String detail;
	private Double length;
	private Double width;
	private Double height;
	private Double weight;
	private String big_img1;
	private String big_img2;
	private String big_img3;
	private String big_img4;
	private String big_img5;
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getBig_img1() {
		return big_img1;
	}
	public void setBig_img1(String big_img1) {
		this.big_img1 = big_img1;
	}
	public String getBig_img2() {
		return big_img2;
	}
	public void setBig_img2(String big_img2) {
		this.big_img2 = big_img2;
	}
	public String getBig_img3() {
		return big_img3;
	}
	public void setBig_img3(String big_img3) {
		this.big_img3 = big_img3;
	}
	public String getBig_img4() {
		return big_img4;
	}
	public void setBig_img4(String big_img4) {
		this.big_img4 = big_img4;
	}
	public String getBig_img5() {
		return big_img5;
	}
	public void setBig_img5(String big_img5) {
		this.big_img5 = big_img5;
	}
	@Override
	public String toString() {
		return "ProductDetail [" + (detail != null ? "detail=" + detail + ", " : "")
				+ (length != null ? "length=" + length + ", " : "") + (width != null ? "width=" + width + ", " : "")
				+ (height != null ? "height=" + height + ", " : "") + (weight != null ? "weight=" + weight + ", " : "")
				+ (big_img1 != null ? "big_img1=" + big_img1 + ", " : "")
				+ (big_img2 != null ? "big_img2=" + big_img2 + ", " : "")
				+ (big_img3 != null ? "big_img3=" + big_img3 + ", " : "")
				+ (big_img4 != null ? "big_img4=" + big_img4 + ", " : "")
				+ (big_img5 != null ? "big_img5=" + big_img5 : "") + "]";
	}
}
