package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import com.neuedu.controller.ProductController;
import com.neuedu.dao.ProductDao;
import com.neuedu.pojo.ProductEntity;


public class ProductController {

	private static ProductController productcontroller=new ProductController();
	private ProductDao productdao=new ProductDao();
	private ProductController() {
	}
	public static ProductController getInstance() {
		return productcontroller;
	}
	public List<ProductEntity> getlist(String name) {
		ProductDao userDao = new ProductDao();
		return userDao.findListByName(name);
	}
	
	public static void deleteProduct(List<String> list) {
		ProductDao userDao = new ProductDao();
		userDao.deleteProduct(list);
	}
	public ProductEntity getProductMsg(String id) {
		ProductDao userDao = new ProductDao();
		ProductEntity u=null;
		 List<ProductEntity> list= userDao.findUserList();
		 for(int i=0;i<list.size();i++){
			 if(list.get(i).getId().equals(id)){
				 u=list.get(i);
			 }
		 }
		return u;
	}
	
//	public UserEntity finUserById(String id) {
//		UserDao userDao = new UserDao();
//		return userDao.findUserByID(id);
//	}
//	
	public static void updateProduct(ProductEntity u) throws IOException {
		ProductDao userDao = new ProductDao();
		userDao.updateProduct(u);
	}

}
