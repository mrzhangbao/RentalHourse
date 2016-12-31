package com.jiaxin.entity;


/**
 * 房源租聘的详细信息
 * 
 * @author Benson_Tom
 *
 */
public class HourseDetail {
	private Integer hourse_detail_id;// 房源ID
	private String user_id;// 发布用户ID
	private String hourse_title;// 房源标题
	private String hourse_size;// 
	private String hourse_floor;// 房源布局
	private String hourse_price;
	private String description;
	private String img_data;
	private String send_time;
	
	
	public HourseDetail() {
		super();
	}
	public Integer getHourse_detail_id() {
		return hourse_detail_id;
	}
	public void setHourse_detail_id(Integer hourse_detail_id) {
		this.hourse_detail_id = hourse_detail_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getHourse_title() {
		return hourse_title;
	}
	public void setHourse_title(String hourse_title) {
		this.hourse_title = hourse_title;
	}
	public String getHourse_size() {
		return hourse_size;
	}
	public void setHourse_size(String hourse_size) {
		this.hourse_size = hourse_size;
	}
	public String getHourse_floor() {
		return hourse_floor;
	}
	public void setHourse_floor(String hourse_floor) {
		this.hourse_floor = hourse_floor;
	}
	
	public String getHourse_price() {
		return hourse_price;
	}
	public void setHourse_price(String hourse_price) {
		this.hourse_price = hourse_price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImg_data() {
		return img_data;
	}
	public void setImg_data(String img_data) {
		this.img_data = img_data;
	}
	
	
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	@Override
	public String toString() {
		return "HourseDetail [hourse_detail_id=" + hourse_detail_id + ", user_id=" + user_id + ", hourse_title="
				+ hourse_title + ", hourse_size=" + hourse_size + ", hourse_floor=" + hourse_floor 
				+ ", hourse_price=" + hourse_price + ", description=" + description + ", img_data=" + img_data
				+ ", send_time=" + send_time + "]";
	}


}
