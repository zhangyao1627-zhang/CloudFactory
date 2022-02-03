package com.neuedu.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.pojo.ProductEntity;
import com.neuedu.pojo.ProductMsgEntity;
import com.neuedu.utils.DataFileName;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;

public class ProductMsgDao {

public boolean saveUser(ProductMsgEntity user) {
		
		String json = JsonUtil.objectToJson(user);
		try {
			DataUtils.writeData(DataFileName.PRODUCTMSG.toString(), json);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<ProductMsgEntity> findProductMsgList(){
		String json = DataUtils.readData(DataFileName.PRODUCTMSG.getName());
		System.out.println(json);
		
		if(json.length()==0) {
			return null;
		}
		List<ProductMsgEntity> userlist=new ArrayList<>();
		String[] users=json.split("/");
		for(String str: users) {
			ProductMsgEntity user = JsonUtil.jsonToObject(str, ProductMsgEntity.class);
			userlist.add(user);
		}
		return userlist;
		
	}
	
	public String getMaxId() {
		List<ProductMsgEntity> userlist = findProductMsgList();
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

	public void updateProductMsg(ProductMsgEntity u) throws IOException {
		// TODO Auto-generated method stub
		List<ProductMsgEntity> userList = findProductMsgList();
		for(int i =0;i<userList.size();i++)
		{
			if(userList.get(i).getId().equals(u.getId()))
			{
				userList.remove(userList.get(i));
				userList.add(u);
				break;
			}
		}
		DataUtils.deleteDataFile(DataFileName.PRODUCTMSG.toString());
		if(userList.size()==0)
		{
			DataUtils.creatFile(DataFileName.PRODUCTMSG.toString());
		}
		for(int i = 0;i<userList.size();i++)
		{
			String json = JsonUtil.objectToJson(userList.get(i));
			try {
				DataUtils.writeData(DataFileName.PRODUCTMSG.toString(), json);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	//快速查询名字的那个地方
	public List<ProductMsgEntity> findListByName(String name) {
		//这个地方两个方法要想清楚
		List<ProductMsgEntity> userList = findProductMsgList();
		List<ProductMsgEntity> search_list = new ArrayList();
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

	public void deleteProductMsg(List<String> list) {
		// TODO Auto-generated method stub
		List<ProductMsgEntity> userList = findProductMsgList();
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
		DataUtils.deleteDataFile(DataFileName.PRODUCTMSG.toString());
        try {
			DataUtils.creatFile(DataFileName.PRODUCTMSG.toString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0;i<userList.size();i++)
		{
			String json = JsonUtil.objectToJson(userList.get(i));
			try {
				DataUtils.writeData(DataFileName.PRODUCTMSG.toString(), json);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	
}
