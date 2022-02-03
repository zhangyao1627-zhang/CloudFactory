/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neuedu.pojo;
//有重写过的页面

/**
 *
 * @author 28224
 */
public class UserEntity {
        private String id;
        private String account;
	private String password;
	private String name;
	private String gender;
	private String IDcard;
	private String phone;
	private String address;
	private String birthDate;
	private String email;
	private Boolean accountState;
	private String remark;
	private String power;
        private String state;
        private String number;
        private String factoryName;
	public String getFactoryName() {
			return factoryName;
		}
		public void setFactoryName(String factoryName) {
			this.factoryName = factoryName;
		}
		//power 
	//admin,FactoryManager1,worker
        public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
        public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
        public String getState(){
            return state;
        }
        public void setState(String state){
            this.state = state;
        }
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIDcard() {
		return IDcard;
	}
	public void setIDcard(String iDcard) {
		IDcard = iDcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Boolean getAccountState() {
		return accountState;
	}
	public void setAccountState(Boolean accountState) {
		this.accountState = accountState;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

   
}
