package com.neuedu.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.pojo.EquipmentTypeEntity;
import com.neuedu.pojo.ProductEntity;
import com.neuedu.utils.DataFileName;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;

public class EquipmentTypeDao {

		public boolean saveUser(EquipmentTypeEntity user) {
		String json = JsonUtil.objectToJson(user);
		try {
			DataUtils.writeData(DataFileName.EQUIPMENTTYPE.toString(), json);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	

	public List<EquipmentTypeEntity> findUserList(){
		String json = DataUtils.readData(DataFileName.EQUIPMENTTYPE.getName());
		System.out.println(json);
		
		if(json.length()==0) {
			return null;
		}
		List<EquipmentTypeEntity> userlist=new ArrayList<>();
		String[] users=json.split("/");
		for(String str: users) {
			EquipmentTypeEntity user = JsonUtil.jsonToObject(str, EquipmentTypeEntity.class);
			userlist.add(user);
		}
		return userlist;
		
	}
	
	public String getMaxId() {
		List<EquipmentTypeEntity> userlist = findUserList();
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
	
	/*public boolean isUse(String loginName){
		List<ProductEntity> userList = findUserList();
		
		for(ProductEntity user:userList){
			if(loginName.equals(user.getAccount())){
				return false;
			}
		}
		return true;

	}

	public ProductEntity login(String account, String password) {
		List<ProductEntity> list = findUserList();
		ProductEntity user = null;
		for(int i=0;i<list.size();i++) {
			user = list.get(i);
			if(user.getAccount().equals(account)&&user.getPassword().equals(password)) {
				return user;
			}
		} 
		return null;
	}*/

	public void updateEquipment(EquipmentTypeEntity u) throws IOException {
		// TODO Auto-generated method stub
		List<EquipmentTypeEntity> userList = findUserList();
		for(int i =0;i<userList.size();i++)
		{
			if(userList.get(i).getId().equals(u.getId()))
			{
				userList.remove(userList.get(i));
				userList.add(u);
				break;
			}
		}
		DataUtils.deleteDataFile(DataFileName.EQUIPMENTTYPE.toString());
		if(userList.size()==0)
		{
			DataUtils.creatFile(DataFileName.EQUIPMENTTYPE.toString());
		}
		for(int i = 0;i<userList.size();i++)
		{
			String json = JsonUtil.objectToJson(userList.get(i));
			try {
				DataUtils.writeData(DataFileName.EQUIPMENTTYPE.toString(), json);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	//快速查询名字的那个地方
	public List<EquipmentTypeEntity> findListByName(String name) {
		//这个地方两个方法要想清楚
		List<EquipmentTypeEntity> userList = findUserList();
		List<EquipmentTypeEntity> search_list = new ArrayList();
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
		List<EquipmentTypeEntity> userList = findUserList();
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
		DataUtils.deleteDataFile(DataFileName.EQUIPMENTTYPE.toString());
        try {
			DataUtils.creatFile(DataFileName.EQUIPMENTTYPE.toString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0;i<userList.size();i++)
		{
			String json = JsonUtil.objectToJson(userList.get(i));
			try {
				DataUtils.writeData(DataFileName.EQUIPMENTTYPE.toString(), json);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
