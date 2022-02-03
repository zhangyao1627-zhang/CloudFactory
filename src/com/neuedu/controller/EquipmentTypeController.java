package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import com.neuedu.dao.EquipmentTypeDao;
import com.neuedu.pojo.EquipmentTypeEntity;


public class EquipmentTypeController {
	private static EquipmentTypeController equipmenttypecontroller=new EquipmentTypeController();
	private EquipmentTypeDao productdao=new EquipmentTypeDao();
	private EquipmentTypeController() {
	}
	public static EquipmentTypeController getInstance() {
		return equipmenttypecontroller;
	}
	public List<EquipmentTypeEntity> getlist(String name) {
		EquipmentTypeDao userDao = new EquipmentTypeDao();
		return userDao.findListByName(name);
	}
	
	public static void deleteEquipment(List<String> list) {
		EquipmentTypeDao userDao = new EquipmentTypeDao();
		userDao.deleteEquipment(list);
	}
	public EquipmentTypeEntity getEquipmentMsg(String id) {
		EquipmentTypeDao userDao = new EquipmentTypeDao();
		EquipmentTypeEntity u=null;
		 List<EquipmentTypeEntity> list= userDao.findUserList();
		 for(int i=0;i<list.size();i++){
			 if(list.get(i).getId().equals(id)){
				 u=list.get(i);
			 }
		 }
		return u;
	}
	
	public static void updateEquipment(EquipmentTypeEntity u) throws IOException {
		EquipmentTypeDao userDao = new EquipmentTypeDao();
		userDao.updateEquipment(u);
	}

}
