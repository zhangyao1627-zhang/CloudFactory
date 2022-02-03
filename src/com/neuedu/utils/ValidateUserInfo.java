package com.neuedu.utils;

import com.neuedu.dao.UserDao;
import com.neuedu.pojo.ProductEntity;
import com.neuedu.pojo.UserEntity;

public class ValidateUserInfo {
	public static String validate(UserEntity u){
		String message = null;
		String loginName = u.getAccount();
		String password = u.getPassword();
		String phone = u.getPhone();
		if(StringUtils.isEmpty(loginName)){
			message  = "注意用户名不能为空";			
		}
		if(!loginName.matches("\\w{3,20}")){
			return"登陆名必须为3-20位合法字符";
		}
		if(password.length()>12||password.length()<3) {
			return "密码要在3-12位";
		}
		if(phone.length()!=11) {
			return "电话号码格式不正确";
		}
		
		return message;
	}
//	private static boolean isUse(String loginName) {
//		UserDao userdao = new UserDao();	
//		return userdao.isUse(loginName);
//		
//	}

}