package com.neuedu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.dao.ProductDao;
import com.neuedu.dao.ProductMsgDao;
import com.neuedu.dao.UserDao;
import com.neuedu.pojo.ProductEntity;
import com.neuedu.pojo.ProductMsgEntity;
import com.neuedu.pojo.UserEntity;
import com.neuedu.utils.DataFileName;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;

public class ProductMsgController {

	private static ProductMsgController productMsgController = new ProductMsgController();
	private ProductMsgDao productMsgDao = new ProductMsgDao();

	private ProductMsgController() {
	}

	public static ProductMsgController getInstance() {
		return productMsgController;
	}

	public static List<ProductMsgEntity> getList(String name) {
		ProductMsgDao productMsgDao = new ProductMsgDao();
		return productMsgDao.findListByName(name);
	}

	public static String[] getTypeArray() {
		// TODO Auto-generated method stub

		List<ProductEntity> list = readPreList();
		String str[] = new String[list.size()];
		if (list.size() == 0) {
			String str1[] = {};
			return str1;
		}
		for (int i = 0; i < list.size(); i++) {
			str[i] = list.get(i).getName();
		}
		return str;
	}

	// 我觉得就是json字符串转化成相应的list类
	//之前那个出来数组得不同
	//这个方法到时候可以整理出来并且记录下
	public static  List<ProductEntity> readPreList() {
		String msg = DataUtils.readData(DataFileName.PRODUCT.toString());
		if (msg.length() == 0) {
			return null;
		} else {
			String b[] = msg.split("/");
			ProductEntity use = new ProductEntity();
			List<ProductEntity> PreList = new ArrayList();
			for (String string : b) {
				ProductEntity u = JsonUtil.jsonToObject(string, ProductEntity.class);
				PreList.add(u);
			}
			return PreList;
		}
	}

	public static void delele(List<String> list) {
		// TODO Auto-generated method stub
		ProductMsgDao productMsgDao = new ProductMsgDao();
		productMsgDao.deleteProductMsg(list);
	}

	public static ProductMsgEntity getProductMsg(String id) {
		 ProductMsgDao productMsgDao = new ProductMsgDao();
		 ProductMsgEntity p=null;
		 List<ProductMsgEntity> list= productMsgDao.findProductMsgList();
		 for(int i=0;i<list.size();i++){
			 if(list.get(i).getId().equals(id)){
				 p=list.get(i);
			 }
		 }
		return p;
	}

	public static void update(ProductMsgEntity pm) throws IOException {
		// TODO Auto-generated method stub
		ProductMsgDao productMsgDao = new ProductMsgDao();
		productMsgDao.updateProductMsg(pm);
	}

}
