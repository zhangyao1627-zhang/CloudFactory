package com.neuedu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.EquipmentManagerDao;
import com.neuedu.dao.ProductMsgDao;
import com.neuedu.pojo.EquipmentManagerEntity;
import com.neuedu.pojo.EquipmentTypeEntity;
import com.neuedu.pojo.ProductEntity;
import com.neuedu.pojo.ProductMsgEntity;
import com.neuedu.utils.DataFileName;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;

public class EquipmentManagerController {

	private static EquipmentManagerController equipmentmanagercontroller=new EquipmentManagerController();
	private EquipmentManagerDao productdao=new EquipmentManagerDao();
	private EquipmentManagerController() {
	}
	public static EquipmentManagerController getInstance() {
		return equipmentmanagercontroller;
	}
	public List<EquipmentManagerEntity> getlist(String name) {
		EquipmentManagerDao userDao = new EquipmentManagerDao();
		return userDao.findListByName(name);
	}
	
	public static void deleteEquipment(List<String> list) {
		EquipmentManagerDao userDao = new EquipmentManagerDao();
		userDao.deleteEquipment(list);
	}
	public static EquipmentManagerEntity getEquipmentMsg(String id) {
		EquipmentManagerDao userDao = new EquipmentManagerDao();
		EquipmentManagerEntity u=null;
		 List<EquipmentManagerEntity> list= userDao.findUserList();
		 for(int i=0;i<list.size();i++){
			 if(list.get(i).getId().equals(id)){
				 u=list.get(i);
			 }
		 }
		return u;
	}
	
	public static void updateEquipment(EquipmentManagerEntity u) throws IOException {
		EquipmentManagerDao userDao = new EquipmentManagerDao();
		userDao.updateEquipment(u);
	}
	
	public static List<EquipmentManagerEntity> getSelfFactoryList(String FactoryName) {
		List<EquipmentManagerEntity> list= EquipmentManagerDao.findUserList();
		List<EquipmentManagerEntity> searchList=new ArrayList();
		if(FactoryName == null)
		{
			return list;
		}
		for(int i=0;i<list.size();i++){
			//返回一个属于这个工厂的列表
			if(list.get(i).getBelong().equals(FactoryName)){
				searchList.add(list.get(i));
			}		
	    }
		return searchList;
	}
	
	public static void changeState(String id) {
		List<EquipmentManagerEntity> old_list = EquipmentManagerDao.findUserList();
		for(int i=0;i<old_list.size();i++){
			if(id.equals(old_list.get(i).getId())){
				if(old_list.get(i).getState().equals("关机")){
					old_list.get(i).setState("闲置中");
				}else if(old_list.get(i).getState().equals("闲置中")){
					old_list.get(i).setState("关机");
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
			for(int i = 0;i<old_list.size();i++)
			{
				String json = JsonUtil.objectToJson(old_list.get(i));
				try {
					DataUtils.writeData(DataFileName.EQUIPMENTMANAGER.toString(), json);
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		
	}
	
	public List<EquipmentManagerEntity> getUnhireEquipmentList() {
		List<EquipmentManagerEntity> a = EquipmentManagerDao.findUserList();
		List<EquipmentManagerEntity> unhire_list =new ArrayList();
		for(int i=0;i<a.size();i++){
			if(a.get(i).getHireState().equals("未被租用")&&a.get(i).getState().equals("闲置中")){
				unhire_list.add(a.get(i));
				System.out.println(a.get(i).toString());
			}
		}
		return unhire_list;	
	}
	
	public static boolean checkState(List<String> list) {
		List<EquipmentManagerEntity> eq_list = EquipmentManagerDao.findUserList();
		boolean flag=true;
		for(int i=0;i<list.size();i++){
			for(int j=0;j<eq_list.size();j++){
				if(list.get(i).equals(eq_list.get(j).getId())){
					if(eq_list.get(j).getHireState().equals("已被租用")){
						flag=false;
						break;
					}
					if(!eq_list.get(j).getCreator().equals("0")){
						flag=false;
						break;
					}
				}
			}
		}
		return flag;
	}
	
	public static void hireEquipment(List<String> list, com.neuedu.pojo.UserEntity u) {
		List<EquipmentManagerEntity> a =EquipmentManagerDao.findUserList();
		for(int i=0;i<a.size();i++){
			for(int j=0;j<list.size();j++){
				if(a.get(i).getId().equals(list.get(j))){
					a.get(i).setHireState("已被租用");
					a.get(i).setBelong(u.getFactoryName());
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
			for(int i = 0;i<a.size();i++)
			{
				String json = JsonUtil.objectToJson(a.get(i));
				try {
					DataUtils.writeData(DataFileName.EQUIPMENTMANAGER.toString(), json);
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		
	}
	public static String[] getTypeArray() {
		List<EquipmentTypeEntity> list = readPreList();
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
	
	public static  List<EquipmentTypeEntity> readPreList() {
		String msg = DataUtils.readData(DataFileName.EQUIPMENTTYPE.toString());
		if (msg.length() == 0) {
			return null;
		} else {
			String b[] = msg.split("/");
			EquipmentTypeEntity use = new EquipmentTypeEntity();
			List<EquipmentTypeEntity> PreList = new ArrayList();
			for (String string : b) {
				EquipmentTypeEntity u = JsonUtil.jsonToObject(string, EquipmentTypeEntity.class);
				PreList.add(u);
			}
			return PreList;
		}
	}
	public static EquipmentManagerEntity getEquipmentManagerMsg(String id) {
		EquipmentManagerDao productMsgDao = new EquipmentManagerDao();
		EquipmentManagerEntity p=null;
		 List<EquipmentManagerEntity> list= productMsgDao.findUserList();
		 for(int i=0;i<list.size();i++){
			 if(list.get(i).getId().equals(id)){
				 p=list.get(i);
			 }
		 }
		return p;
	}
	public static void changeState1(String id) {
		// TODO Auto-generated method stub
		List<EquipmentManagerEntity> old_list = EquipmentManagerDao.findUserList();
		for(int i=0;i<old_list.size();i++){
			if(id.equals(old_list.get(i).getId())){
					old_list.get(i).setState("闲置中");			
			}
		}
		DataUtils.deleteDataFile(DataFileName.EQUIPMENTMANAGER.toString());
	       try {
					DataUtils.creatFile(DataFileName.EQUIPMENTMANAGER.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			for(int i = 0;i<old_list.size();i++)
			{
				String json = JsonUtil.objectToJson(old_list.get(i));
				try {
					DataUtils.writeData(DataFileName.EQUIPMENTMANAGER.toString(), json);
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		
	}
	public static void changeState2(String id) {
		List<EquipmentManagerEntity> old_list = EquipmentManagerDao.findUserList();
		for(int i=0;i<old_list.size();i++){
			if(id.equals(old_list.get(i).getId())){
					old_list.get(i).setState("开启");			
			}
		}
		DataUtils.deleteDataFile(DataFileName.EQUIPMENTMANAGER.toString());
	       try {
					DataUtils.creatFile(DataFileName.EQUIPMENTMANAGER.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			for(int i = 0;i<old_list.size();i++)
			{
				String json = JsonUtil.objectToJson(old_list.get(i));
				try {
					DataUtils.writeData(DataFileName.EQUIPMENTMANAGER.toString(), json);
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		// TODO Auto-generated method stub
		
	}
	public static void changeState3(String id) {
		// TODO Auto-generated method stub
		List<EquipmentManagerEntity> old_list = EquipmentManagerDao.findUserList();
		for(int i=0;i<old_list.size();i++){
			if(id.equals(old_list.get(i).getId())){
					old_list.get(i).setState("关闭");			
			}
		}
		DataUtils.deleteDataFile(DataFileName.EQUIPMENTMANAGER.toString());
	       try {
					DataUtils.creatFile(DataFileName.EQUIPMENTMANAGER.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			for(int i = 0;i<old_list.size();i++)
			{
				String json = JsonUtil.objectToJson(old_list.get(i));
				try {
					DataUtils.writeData(DataFileName.EQUIPMENTMANAGER.toString(), json);
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
	}
	public static void getBack(String id) {
				List<EquipmentManagerEntity> old_list = EquipmentManagerDao.findUserList();
				for(int i=0;i<old_list.size();i++){
					if(id.equals(old_list.get(i).getId())){
							old_list.get(i).setState("关机");	
							old_list.get(i).setHireState("未被租用");
							old_list.get(i).setBelong("");
					}
				}
				DataUtils.deleteDataFile(DataFileName.EQUIPMENTMANAGER.toString());
			       try {
							DataUtils.creatFile(DataFileName.EQUIPMENTMANAGER.toString());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}
					for(int i = 0;i<old_list.size();i++)
					{
						String json = JsonUtil.objectToJson(old_list.get(i));
						try {
							DataUtils.writeData(DataFileName.EQUIPMENTMANAGER.toString(), json);
						}catch(IOException e) {
							e.printStackTrace();
						}
					}
	}
	public static boolean checkState1(List<String> list) {
		// TODO Auto-generated method stub
		List<EquipmentManagerEntity> eq_list = EquipmentManagerDao.findUserList();
		boolean flag=true;
		for(int i=0;i<list.size();i++){
			for(int j=0;j<eq_list.size();j++){
				if(list.get(i).equals(eq_list.get(j).getId())){
					if(eq_list.get(j).getHireState().equals("已被租用")){
						flag=false;
						break;
					}

				}
			}
		}
		return flag;
	}
}
