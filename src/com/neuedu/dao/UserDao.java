/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neuedu.dao;
//有重写过的页面
import com.neuedu.pojo.UserEntity;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;
import com.neuedu.utils.DataFileName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author 28224
 */
public class UserDao {
   public boolean saveUser(UserEntity user) {
	
		String json = JsonUtil.objectToJson(user);
		try {
			DataUtils.writeData(DataFileName.USER.toString(), json);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
    }
   public String getMaxId() {
		List<UserEntity> userlist = findUserList();
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
    public List<UserEntity> findUserList(){
		String json = DataUtils.readData(DataFileName.USER.getName());
		System.out.println(json);
		
		if(json.length()==0) {
			return null;
		}
		List<UserEntity> userlist=new ArrayList<>();
		String[] users=json.split("/");
		for(String str: users) {
			UserEntity user = JsonUtil.jsonToObject(str, UserEntity.class);
			userlist.add(user);
		}
		return userlist;
		
	}
    public UserEntity login(String account, String password) {
		List<UserEntity> list = findUserList();
		UserEntity user = null;
		for(int i=0;i<list.size();i++) {
			user = list.get(i);
			if(user.getAccount().equals(account)&&user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

   public List<UserEntity> findListByName(String name) {
		//这个地方两个方法要想清楚
		List<UserEntity> userList = findUserList();
		List<UserEntity> search_list = new ArrayList();
		if(name.equals("out"))
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
   
   public String[] findFactoryName() {
		//这个地方两个方法要想清楚
	
	    Set<String> s=new HashSet<String>();
	    List<String> l1 = new ArrayList();
		List<UserEntity> userList = findUserList();
		List<UserEntity> search_list = new ArrayList();
			for(int i = 0;i<userList.size();i++)
			{
				if(userList.get(i).getPower().equals("FactoryManager"))
				{
					if(s.contains(userList.get(i).getFactoryName()))
					{
					
						continue;
					}
					else {
						
						s.add(userList.get(i).getFactoryName());
		
						System.out.println(userList.get(i).getFactoryName());
						l1.add(userList.get(i).getFactoryName());
					}
				}
			}
			String[] str = l1.toArray(new String[l1.size()]);
			return str;
		}
public List<UserEntity> findListByName(UserEntity user) {
	// TODO Auto-generated method stub
	List<UserEntity> userList = findUserList();
	List<UserEntity> search_list = new ArrayList();
	
		for(int i = 0;i<userList.size();i++)
		{
			if(userList.get(i).getFactoryName().equals(user.getFactoryName()))
			{
				search_list.add(userList.get(i));
			}
		}
		return search_list;	
}
public UserEntity findListByNumber(String number) {
	// TODO Auto-generated method stub
	List<UserEntity> userList = findUserList();
	List<UserEntity> search_list = new ArrayList();
	
		for(int i = 0;i<userList.size();i++)
		{
			if(userList.get(i).getNumber().equals(number))
			{
				return userList.get(i);	
			}
		}
	return null;
}
public void updateUser(UserEntity u) throws IOException {
	// TODO Auto-generated method stub
	List<UserEntity> userList = findUserList();
	for(int i =0;i<userList.size();i++)
	{
		if(userList.get(i).getNumber().equals(u.getNumber()))
		{
			userList.remove(userList.get(i));
			userList.add(u);
			break;
		}
	}
	DataUtils.deleteDataFile(DataFileName.USER.toString());
	if(userList.size()==0)
	{
		DataUtils.creatFile(DataFileName.USER.toString());
	}
	for(int i = 0;i<userList.size();i++)
	{
		String json = JsonUtil.objectToJson(userList.get(i));
		try {
			DataUtils.writeData(DataFileName.USER.toString(), json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
public void deleteUser(List<String> list) {
	// TODO Auto-generated method stub
			List<UserEntity> userList = findUserList();
			for(int i = 0;i<list.size();i++)
			{
				for(int j = 0;j<userList.size();j++)
				{
					if(list.get(i).equals(userList.get(j).getNumber()))
					{
					     userList.remove(userList.get(j));	
					}
				}
			}
			DataUtils.deleteDataFile(DataFileName.USER.toString());
	        try {
				DataUtils.creatFile(DataFileName.USER.toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(int i = 0;i<userList.size();i++)
			{
				String json = JsonUtil.objectToJson(userList.get(i));
				try {
					DataUtils.writeData(DataFileName.USER.toString(), json);
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
}
}
