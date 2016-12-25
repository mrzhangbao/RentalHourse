package com.jiaxin.entity;

/**
 * 房源租聘的详细信息
 * 
 * @author Benson_Tom
 *
 */
public class HourseDetail {
	private String id;// 房源ID
	private String userId;// 发布用户ID
	private String imgPath;//图片预览地址
	private String title;// 房源标题
	private String rentalType;// 房源类型
	private String layout;// 房源布局
	private String size;// 房源大小
	private String direction;// 房源坐标
	private String floor;// 房源楼层
	private String decoration;// 房源装修度
	private String address;// 房源地址
	private String agent;// 房源中介
	private String role;// 房源中介的角色
	private String price;//房源价格
	private String unit;//价格单位
	private String time;//发布时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRentalType() {
		return rentalType;
	}

	public void setRentalType(String rentalType) {
		this.rentalType = rentalType;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getDecoration() {
		return decoration;
	}

	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "HourseDetail [id=" + id + ", userId=" + userId + ", imgPath=" + imgPath + ", title=" + title
				+ ", rentalType=" + rentalType + ", layout=" + layout + ", size=" + size + ", direction=" + direction
				+ ", floor=" + floor + ", decoration=" + decoration + ", address=" + address + ", agent=" + agent
				+ ", role=" + role + ", price=" + price + ", unit=" + unit + ", time=" + time + "]";
	}

	

	


}
