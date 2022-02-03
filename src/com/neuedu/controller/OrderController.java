package com.neuedu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.EquipmentTypeDao;
import com.neuedu.dao.OrderDao;
import com.neuedu.dao.ProductMsgDao;
import com.neuedu.pojo.EquipmentTypeEntity;
import com.neuedu.pojo.OrderEntity;

public class OrderController {
	private static OrderController orderController=new OrderController();
	private OrderDao orderdao=new OrderDao();
	private OrderController() {
	}
	public static OrderController getInstance() {
		return orderController;
	}
	public List<OrderEntity> getlist(String name) {
		OrderDao orderdao=new OrderDao();
		return orderdao.findListByName(name);
	}
	
	public static void deleteOrder(List<String> list) {
		OrderDao orderdao=new OrderDao();
		orderdao.deleteOrder(list);
	}
	public OrderEntity getOrderMsg(String id) {
		OrderDao orderdao=new OrderDao();
		OrderEntity u=null;
		 List<OrderEntity> list= orderdao.findOrderList();
		 for(int i=0;i<list.size();i++){
			 if(list.get(i).getId().equals(id)){
				 u=list.get(i);
			 }
		 }
		return u;
	}
	
	public static void updateOrder(OrderEntity u) throws IOException {
		OrderDao orderdao = new OrderDao();
		orderdao.updateOrder(u);
	}
	public static List<OrderEntity> getList(String name) {
		// TODO Auto-generated method stub
		OrderDao orderDao = new OrderDao();
		return orderDao.findListByName(name);
	}
	public static void delele(List<String> list) {
		// TODO Auto-generated method stub
		OrderDao orderDao = new OrderDao();
		orderDao.deleteOrder(list);
	}
	public static List<OrderEntity> getCanList() {

		OrderDao orderDao = new OrderDao();
		return orderDao.getCanList();
	}
	public static List<OrderEntity> getReceivedList() {
		OrderDao orderDao = new OrderDao();
		return orderDao.getReceivedList();
	}
	public static List<OrderEntity> getFactoryList(String name) {
		OrderDao orderDao = new OrderDao();
		return orderDao.getFactoryList(name);
	}
}
