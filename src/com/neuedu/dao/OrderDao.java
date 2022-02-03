package com.neuedu.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.pojo.OrderEntity;
import com.neuedu.pojo.ProductEntity;
import com.neuedu.pojo.ProductMsgEntity;
import com.neuedu.utils.DataFileName;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;

public class OrderDao {

	public List<OrderEntity> findListByName(String name) {
		List<OrderEntity> userList = findOrderList();
		List<OrderEntity> search_list = new ArrayList();
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

	public void deleteOrder(List<String> list) {
		// TODO Auto-generated method stub
		List<OrderEntity> userList = findOrderList();
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
		DataUtils.deleteDataFile(DataFileName.ORDER.toString());
        try {
			DataUtils.creatFile(DataFileName.ORDER.toString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0;i<userList.size();i++)
		{
			String json = JsonUtil.objectToJson(userList.get(i));
			try {
				DataUtils.writeData(DataFileName.ORDER.toString(), json);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<OrderEntity> findOrderList() {
		String json = DataUtils.readData(DataFileName.ORDER.getName());
		System.out.println(json);
		
		if(json.length()==0) {
			return null;
		}
		List<OrderEntity> userlist=new ArrayList<>();
		String[] users=json.split("/");
		for(String str: users) {
			OrderEntity user = JsonUtil.jsonToObject(str,OrderEntity.class);
			userlist.add(user);
		}
		return userlist;
	}

	public static String getMaxId() {
		List<OrderEntity> userlist = findOrderList();
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

	public void updateOrder(OrderEntity u) throws IOException {
		// TODO Auto-generated method stub
		List<OrderEntity> userList = findOrderList();
		for(int i =0;i<userList.size();i++)
		{
			if(userList.get(i).getId().equals(u.getId()))
			{
				userList.remove(userList.get(i));
				userList.add(u);
				break;
			}
		}
		DataUtils.deleteDataFile(DataFileName.ORDER.toString());
		if(userList.size()==0)
		{
			DataUtils.creatFile(DataFileName.ORDER.toString());
		}
		for(int i = 0;i<userList.size();i++)
		{
			String json = JsonUtil.objectToJson(userList.get(i));
			try {
				DataUtils.writeData(DataFileName.ORDER.toString(), json);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<OrderEntity> getReceivedList() {
		List<OrderEntity> userList = findOrderList();
		List<OrderEntity> search_list = new ArrayList();
			for(int i = 0;i<userList.size();i++)
			{
				if(userList.get(i).getState().equals("已中标"))
				{
					search_list.add(userList.get(i));
				}
			}
			return search_list;
	}

	public List<OrderEntity> getCanList() {
		List<OrderEntity> userList = findOrderList();
		List<OrderEntity> search_list = new ArrayList();
			for(int i = 0;i<userList.size();i++)
			{
				if(userList.get(i).getState().equals("已发布"))
				{
					search_list.add(userList.get(i));
				}
			}
			return search_list;
	}

	public List<OrderEntity> getFactoryList(String name) {
		List<OrderEntity> userList = findOrderList();
		List<OrderEntity> search_list = new ArrayList();
			for(int i = 0;i<userList.size();i++)
			{
				if(userList.get(i).getFactoryName().equals(name))
				{
					search_list.add(userList.get(i));
				}
			}
			return search_list;
	}
 
 
}
