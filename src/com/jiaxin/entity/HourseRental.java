package com.jiaxin.entity;

public class HourseRental {
	private Integer hourse_rental_id;
	private Integer hourse_type_id;
	private Integer resource;
	private Integer hourse_detail_id;
	private String hourse_price;
	private String img_cover;
	private String province;
	private String city;
	private String district;
	private String state;

	public HourseRental() {
		super();
	}

	public Integer getHourse_rental_id() {
		return hourse_rental_id;
	}

	public void setHourse_rental_id(Integer hourse_rental_id) {
		this.hourse_rental_id = hourse_rental_id;
	}

	public Integer getHourse_type_id() {
		return hourse_type_id;
	}

	public void setHourse_type_id(Integer hourse_type_id) {
		this.hourse_type_id = hourse_type_id;
	}

	public Integer getResource() {
		return resource;
	}

	public void setResource(Integer resource) {
		this.resource = resource;
	}

	public Integer getHourse_detail_id() {
		return hourse_detail_id;
	}

	public void setHourse_detail_id(Integer hourse_detail_id) {
		this.hourse_detail_id = hourse_detail_id;
	}

	public String getHourse_price() {
		return hourse_price;
	}

	public void setHourse_price(String hourse_price) {
		this.hourse_price = hourse_price;
	}

	public String getImg_cover() {
		return img_cover;
	}

	public void setImg_cover(String img_cover) {
		this.img_cover = img_cover;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "HourseRental [hourse_rental_id=" + hourse_rental_id + ", hourse_type_id=" + hourse_type_id
				+ ", resource=" + resource + ", hourse_detail_id=" + hourse_detail_id + ", hourse_price=" + hourse_price
				+ ", img_cover=" + img_cover + ", province=" + province + ", city=" + city + ", district=" + district
				+ ", state=" + state + "]";
	}

}
