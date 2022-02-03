package com.neuedu.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.neuedu.controller.EquipmentManagerController;
import com.neuedu.controller.ProductMsgController;
import com.neuedu.pojo.EquipmentManagerEntity;

public class EquipmentManagerTable extends AbstractTableModel{

	private String[] columnNames = { " ", "ID", "设备名称","设备编号","设备类别","设备规格","设备状态","设备描述","租用状态","所属工厂"};
	private Object[][] data;
	private EquipmentManagerController equipmentManagerController = EquipmentManagerController.getInstance();

	/**
	 * 构造方法，初始化二维数组data对应的数据
	 * @param id 
	 */
	public EquipmentManagerTable(String name,int Power,String FactoryName) {
		List<EquipmentManagerEntity> list=null;
		//什么都没有
		if(Power==0){
		 list=equipmentManagerController.getlist(name);
		 //被工厂租用
		}else if(Power==1){
		 list=equipmentManagerController.getSelfFactoryList(FactoryName);
		//没有被相应租用
		}else if(Power==2){
		 list=equipmentManagerController.getUnhireEquipmentList();
		}
		if(list==null){
			data=new Object[0][0];
		}else{
		data = new Object[list.size()][10];
		for (int i = 0; i < list.size(); i++) {
			data[i][0] = new Boolean(false);
			//
			data[i][1] = list.get(i).getId();
			data[i][2] =list.get(i).getName();
			data[i][3] =list.get(i).getNum();
			data[i][4] =list.get(i).getType();
			data[i][5] =list.get(i).getSize();
			data[i][7] =list.get(i).getDetail();
			//需要一个一个看的地方
			data[i][6] =list.get(i).getState();
			
			data[i][8] =list.get(i).getHireState();
			data[i][9] =list.get(i).getBelong();
			
		}
		}
	}
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	/**
	 * 重写方法，得到表格列数
	 */
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * 得到表格行数
	 */
	@Override
	public int getRowCount() {
		return data.length;
	}

	/**
	 * 得到数据所对应对象
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

	/**
	 * 得到指定列的数据类型
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return data[0][columnIndex].getClass();
	}

	/**
	 * 指定设置数据单元是否可编辑.这里设置"姓名","学号"不可编辑
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex != 1&&columnIndex!=8&&columnIndex!=9) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 如果数据单元为可编辑，则将编辑后的值替换原来的值
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		data[rowIndex][columnIndex] = aValue;
		/* 通知监听器数据单元数据已经改变 */
		fireTableCellUpdated(rowIndex, columnIndex);
	}


}
