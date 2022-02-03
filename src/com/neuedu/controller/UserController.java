/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neuedu.controller;
//有重写过的页面
import com.neuedu.dao.UserDao;
import com.neuedu.pojo.UserEntity;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author 28224
 */
public class UserController {
    private final UserDao userDao = new UserDao();
    private static UserController userController = new UserController();
    private UserController() {
    }
    public static UserController getInstance() {
	return userController;
    }
    public boolean register(UserEntity user) {  
	String id = userDao.getMaxId();
	user.setId(id);
	userDao.saveUser(user);
	return true;
    }
    public UserEntity login(String account,String password) {
		UserEntity user = null;
		if(account.equals("admin")&&password.equals("admin")) {
			user = new UserEntity();
			user.setAccount("admin");
			user.setPassword("admin");
			return user;
		}else {
			UserDao userDao = new UserDao();
			user = userDao.login(account,password);
		}
		return user;
	}
    public String[] getAllFactory() {
    
    	UserDao userDao = new UserDao();
    	return userDao.findFactoryName();
    	
    }
    public List<UserEntity> getlist(String name) {
		UserDao userDao = new UserDao();
		return userDao.findListByName(name);
	}
	public List<UserEntity> getlist(UserEntity user) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		return userDao.findListByName(user);
	}
	public UserEntity getUserMsg(String number) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		return userDao.findListByNumber(number);
	}
	public static void updateUser(UserEntity u) throws IOException  {
		UserDao userDao = new UserDao();
		userDao.updateUser(u);
	}
	public static void deleteUser(List<String> list) {
		// TODO Auto-generated method stub
			UserDao userDao = new UserDao();
			userDao.deleteUser(list);
		
	}
}
