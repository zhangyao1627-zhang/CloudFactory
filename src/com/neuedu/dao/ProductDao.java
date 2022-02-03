package com.neuedu.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.pojo.ProductEntity;
import com.neuedu.utils.DataFileName;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;

public class ProductDao {

	public boolean saveUser(ProductEntity user) {
		
		String json = JsonUtil.objectToJson(user);
		try {
			DataUtils.writeData(DataFileName.PRODUCT.toString(), json);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
//	public static List<UserEntity> findList()
//	{
//		String json = DataUtils.readData(DataFileName.USER.toString());
//		if(json.length()==0)
//		{
//			return null;
//		}else {
//			String b[] = json.split("/");
//			List<UserEntity> oldList = new ArrayList<>();
//		    for(String string :b)
//		    {
//		    	UserEntity u = JsonUtil.jsonToObject(string, UserEntity.class);
//		        oldList.add(u);
//	 	    }
//		   return oldList;
//		
//		}	
//	}
	public List<ProductEntity> findUserList(){
		String json = DataUtils.readData(DataFileName.PRODUCT.getName());
		System.out.println(json);
		
		if(json.length()==0) {
			return null;
		}
		List<ProductEntity> userlist=new ArrayList<>();
		String[] users=json.split("/");
		for(String str: users) {
			ProductEntity user = JsonUtil.jsonToObject(str, ProductEntity.class);
			userlist.add(user);
		}
		return userlist;
		
	}
	
	public String getMaxId() {
		List<ProductEntity> userlist = findUserList();
		int max = 0;
		if(userlist == null || userlist.size() == 0) {
			return "1";
		}else {
			for(int i=0;i<userlist.size();i++) {
				if(Integer.parseInt(userlist.get(i).getId())>max) {
					max=(Integer.parseInt(userlist.get(i).getId()));
				}
			}
		}
		String str_max=String.valueOf(max+1);
		return str_max;
	}
	

	public void updateProduct(ProductEntity u) throws IOException {
		// TODO Auto-generated method stub
		List<ProductEntity> userList = findUserList();
		for(int i =0;i<userList.size();i++)
		{
			if(userList.get(i).getId().equals(u.getId()))
			{
				userList.remove(userList.get(i));
				userList.add(u);
				break;
			}
		}
		DataUtils.deleteDataFile(DataFileName.PRODUCT.toString());
		if(userList.size()==0)
		{
			DataUtils.creatFile(DataFileName.PRODUCT.toString());
		}
		for(int i = 0;i<userList.size();i++)
		{
			String json = JsonUtil.objectToJson(userList.get(i));
			try {
				DataUtils.writeData(DataFileName.PRODUCT.toString(), json);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	//快速查询名字的那个地方
	public List<ProductEntity> findListByName(String name) {
		//这个地方两个方法要想清楚
		List<ProductEntity> userList = findUserList();
		List<ProductEntity> search_list = new ArrayList();
		if(name==null)
		{
			return userList;
		}
		else {
			for(int i = 0;i<userList.size();i++)
			{
				if(userList.get(i).getName().equals(name))
				{
					search_list.add(userList.get(i));
				}
			}
			return search_list;
		}
		
	}

	public void deleteProduct(List<String> list) {
		// TODO Auto-generated method stub
		List<ProductEntity> userList = findUserList();
		for(int i = 0;i<list.size();i++)
		{
			for(int j = 0;j<userList.size();j++)
			{
				if(list.get(i).equals(userList.get(j).getId()))
				{
				     userList.remove(userList.get(j));	
				}
			}
		}
		DataUtils.deleteDataFile(DataFileName.PRODUCT.toString());
        try {
			DataUtils.creatFile(DataFileName.PRODUCT.toString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0;i<userList.size();i++)
		{
			String json = JsonUtil.objectToJson(userList.get(i));
			try {
				DataUtils.writeData(DataFileName.PRODUCT.toString(), json);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
