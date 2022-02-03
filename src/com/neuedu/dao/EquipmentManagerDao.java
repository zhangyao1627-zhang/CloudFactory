package com.neuedu.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.pojo.EquipmentManagerEntity;
import com.neuedu.pojo.UserEntity;
import com.neuedu.utils.DataFileName;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;

public class EquipmentManagerDao {

	public boolean saveUser(EquipmentManagerEntity user) {
		String json = JsonUtil.objectToJson(user);
		try {
			DataUtils.writeData(DataFileName.EQUIPMENTMANAGER.toString(), json);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	

	public static List<EquipmentManagerEntity> findUserList(){
		String json = DataUtils.readData(DataFileName.EQUIPMENTMANAGER.getName());
		System.out.println(json);
		
		if(json.length()==0) {
			return null;
		}
		List<EquipmentManagerEntity> userlist=new ArrayList<>();
		String[] users=json.split("/");
		for(String str: users) {
			EquipmentManagerEntity user = JsonUtil.jsonToObject(str, EquipmentManagerEntity.class);
			userlist.add(user);
		}
		return userlist;
		
	}
	
	public String getMaxId() {
		List<EquipmentManagerEntity> userlist = findUserList();
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
	
	

	public void updateEquipment(EquipmentManagerEntity u) throws IOException {
		// TODO Auto-generated method stub
		List<EquipmentManagerEntity> userList = findUserList();
		for(int i =0;i<userList.size();i++)
		{
			if(userList.get(i).getId().equals(u.getId()))
			{
				userList.remove(userList.get(i));
				userList.add(u);
				break;
			}
		}
		DataUtils.deleteDataFile(DataFileName.EQUIPMENTMANAGER.toString());
		if(userList.size()==0)
		{
			DataUtils.creatFile(DataFileName.EQUIPMENTMANAGER.toString());
		}
		for(int i = 0;i<userList.size();i++)
		{
			String json = JsonUtil.objectToJson(userList.get(i));
			try {
				DataUtils.writeData(DataFileName.EQUIPMENTMANAGER.toString(), json);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	//快速查询名字的那个地方
	public List<EquipmentManagerEntity> findListByName(String name) {
		//这个地方两个方法要想清楚
		List<EquipmentManagerEntity> userList = findUserList();
		List<EquipmentManagerEntity> search_list = new ArrayList();
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

	public void deleteEquipment(List<String> list) {
		// TODO Auto-generated method stub
		List<EquipmentManagerEntity> userList = findUserList();
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
		DataUtils.deleteDataFile(DataFileName.EQUIPMENTMANAGER.toString());
        try {
			DataUtils.creatFile(DataFileName.EQUIPMENTMANAGER.toString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0;i<userList.size();i++)
		{
			String json = JsonUtil.objectToJson(userList.get(i));
			try {
				DataUtils.writeData(DataFileName.EQUIPMENTMANAGER.toString(), json);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void changeState(List<String> list) {
		// TODO Auto-generated method stub
		List<EquipmentManagerEntity> userList = findUserList();
		for(int i = 0;i<list.size();i++)
		{
			for(int j = 0;j<userList.size();j++)
			{
				if(list.get(i).equals(userList.get(j).getId()))
				{
				     if(userList.get(j).getState().equals("开机"))
				     {	
				    	 userList.get(j).setState("关机");
				     }else if(userList.get(j).getState().equals("关机"))
				     {	
				    	 userList.get(j).setState("开机");
				     }
				}
			}
		}
		DataUtils.deleteDataFile(DataFileName.EQUIPMENTMANAGER.toString());
       try {
				DataUtils.creatFile(DataFileName.EQUIPMENTMANAGER.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		for(int i = 0;i<userList.size();i++)
		{
			String json = JsonUtil.objectToJson(userList.get(i));
			try {
				DataUtils.writeData(DataFileName.EQUIPMENTMANAGER.toString(), json);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
