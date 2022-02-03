package com.neuedu.pojo;

import java.util.Date;
import java.util.List;

public class OrderEntity {

	private String id;
	private String spid;
	private String name;
	private String num;
	private Date date;
	private Date deadLine;
	private String customer;
	private String customerPhone;
	private String customerAddress;
	private String state;
	private List orderList;
	private String factoryName;
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public List getOrderList() {
		return orderList;
	}
	public void setOrderList(List orderList) {
		this.orderList = orderList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSpid() {
		return spid;
	}
	public void setSpid(String spid) {
		this.spid = spid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date d) {
		this.date = d;
	}
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date d1) {
		this.deadLine = d1;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
