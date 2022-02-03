package com.neuedu.table;

import java.util.List;


import javax.swing.table.AbstractTableModel;

import com.neuedu.controller.UserController;
import com.neuedu.pojo.UserEntity;

/**
 * @author zhangyao
 *
 */
////有重写过的页面
//public class UserTable extends AbstractTableModel{
//	
//	private String[] columnNames = {" ","序号","姓名","账号","编码","性别","年龄"};
//	private Object[][] data;
//	private UserController userController = UserController.getInstance();
//	public UserTable(String name) {
//		//注意这个地方，等于null就直接输出了相应的所有的表格
//		List<UserEntity> list = userController.getlist(name);
//		
//		if(list==null) {
//			data = new Object[0][0];
//		}else {
//			data = new Object[list.size()][7];
//			for(int i=0;i<list.size();i++) {
//				data[i][0]=new Boolean(false);
//				data[i][1]=list.get(i).getId();
//				data[i][2]=list.get(i).getName();
//				data[i][3]=list.get(i).getAccount();
//                data[i][4]=list.get(i).getNumber();
//				data[i][5]=list.get(i).getGender();
//                int age = 2020 - Integer.parseInt(list.get(i).getBirthDate().substring(0, 5));
//				data[i][6]=age;   
//				System.out.println(data[i][0]);
//				System.out.println(data[i][1]);
//				System.out.println(data[i][2]);
//				System.out.println(data[i][3]);
//				System.out.println(data[i][4]);
//				System.out.println(data[i][5]);
//			}
//		}      
//	}
//	@Override//得到相应的列名
//	public String getColumnName(int column) {
//			return columnNames[column];
//	}
//	@Override//得到表格的列数
//	public int getColumnCount() {
//			return columnNames.length;
//	}
//	@Override//得到表格行数
//	public int getRowCount() {
//			return data.length;
//	}
//	@Override//得到某一个对应位置的数据
//	public Object getValueAt(int rowIndex, int columnIndex) {
//			return data[rowIndex][columnIndex];
//	}
//	@Override//得到指定列的数据类型
//	public Class<?> getColumnClass(int columnIndex) {
//			return data[0][columnIndex].getClass();
//	}
//	@Override//不可编辑地方的数据类型（最后要记得可以加一些）
//	public boolean isCellEditable(int rowIndex, int columnIndex) {
//			if (columnIndex != 1&&columnIndex!=8&&columnIndex!=9) {
//				return true;
//			} else {
//					return false;
//			}
//	}
//	@Override//（如果可以进行相应编辑的话，就换成编辑后的值）
//	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//		data[rowIndex][columnIndex] = aValue;
//		// 通知监听器数据单元数据已经改变 
//		fireTableCellUpdated(rowIndex, columnIndex);
//	}
//}
public class UserTable extends AbstractTableModel{
	
	private String[] columnNames = {" ","ID","姓名","账号","编码","性别","年龄"};
	private Object[][] data;
	private UserController userController = UserController.getInstance();
	
	public UserTable(String name) {
		List<UserEntity> list = userController.getlist(name);
		//注意这个地方，等于null就直接输出了相应的所有的表格
		if(list==null) {
			data = new Object[0][0];
		}else {
			data = new Object[list.size()][7];
			for(int i=0;i<list.size();i++) {
				data[i][0]=new Boolean(false);
				data[i][1]=list.get(i).getId();
				data[i][2]=list.get(i).getName();
				data[i][3]=list.get(i).getAccount();
				data[i][4]=list.get(i).getNumber();
				data[i][5]=list.get(i).getGender();
				int age = 2020 - Integer.parseInt(list.get(i).getBirthDate().substring(0, 4));
				data[i][6]=age;
			}
		}
	}
	public UserTable(UserEntity user) {
		List<UserEntity> list = userController.getlist(user);
		//注意这个地方，等于null就直接输出了相应的所有的表格
		if(list==null) {
			data = new Object[0][0];
		}else {
			data = new Object[list.size()][7];
			for(int i=0;i<list.size();i++) {
				data[i][0]=new Boolean(false);
				data[i][1]=list.get(i).getId();
				data[i][2]=list.get(i).getName();
				data[i][3]=list.get(i).getAccount();
				data[i][4]=list.get(i).getNumber();
				data[i][5]=list.get(i).getGender();
				int age = 2020 - Integer.parseInt(list.get(i).getBirthDate().substring(0, 4));
				data[i][6]=age;
			}
		}
	}
	@Override//得到相应的列名
	public String getColumnName(int column) {
			return columnNames[column];
	}
	@Override//得到表格的列数
	public int getColumnCount() {
			return columnNames.length;
	}
	@Override//得到表格行数
	public int getRowCount() {
			return data.length;
	}
	@Override//得到某一个对应位置的数据
	public Object getValueAt(int rowIndex, int columnIndex) {
			return data[rowIndex][columnIndex];
	}
	@Override//得到指定列的数据类型
	public Class<?> getColumnClass(int columnIndex) {
			return data[0][columnIndex].getClass();
	}
	@Override//不可编辑地方的数据类型（最后要记得可以加一些）
	public boolean isCellEditable(int rowIndex, int columnIndex) {
			if (columnIndex != 1&&columnIndex!=8&&columnIndex!=9) {
				return true;
			} else {
					return false;
			}
	}
	@Override//（如果可以进行相应编辑的话，就换成编辑后的值）
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		data[rowIndex][columnIndex] = aValue;
		// 通知监听器数据单元数据已经改变 
		fireTableCellUpdated(rowIndex, columnIndex);
	}
}