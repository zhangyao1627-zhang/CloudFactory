package com.neuedu.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.neuedu.controller.EquipmentTypeController;
import com.neuedu.controller.ProductController;
import com.neuedu.pojo.EquipmentTypeEntity;
import com.neuedu.pojo.ProductEntity;

public class EquipmentTypeTable extends AbstractTableModel{

	private String[] columnNames = { " ", "ID", "类别名称"};
	private Object[][] data;
	private EquipmentTypeController equipmentTypeController = EquipmentTypeController.getInstance();

	/**
	 * 构造方法，初始化二维数组data对应的数据
	 * @param id 
	 */
	public EquipmentTypeTable(String name) {
		List<EquipmentTypeEntity> list=equipmentTypeController.getlist(name);
		if(list==null){
			data=new Object[0][0];
		}else{
		data = new Object[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			data[i][0] = new Boolean(false);
			data[i][1] = list.get(i).getId();
			data[i][2] =list.get(i).getName();
		}
		}
	}

	// 以下为继承自AbstractTableModle的方法，可以自定义
	/**
	 * 得到列名
	 */
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
