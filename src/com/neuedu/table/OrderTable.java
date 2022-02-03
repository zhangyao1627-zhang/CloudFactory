package com.neuedu.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.neuedu.controller.OrderController;
import com.neuedu.controller.ProductMsgController;
import com.neuedu.pojo.OrderEntity;
import com.neuedu.pojo.ProductMsgEntity;

public class OrderTable extends AbstractTableModel{

	private String[] columnNames = { " ", "ID", "订单编号","产品名称","订购数量","交付日期","投标截止日期","收货人","收货人联系方式","收货人地址","订单状态"};
	private Object[][] data;
	private OrderController orderController = OrderController.getInstance();

	/**
	 * 构造方法，初始化二维数组data对应的数据
	 * @param id 
	 */
	public OrderTable(String name,int power) {
		List<OrderEntity> list = null;
		//原始的
		if(power==0)
		{
		list=OrderController.getList(name);
		}
	    else if(power==1){
		//获得相应的已发布的
		 list= OrderController.getCanList();
		}else if(power==2){
		//获得相应的已中标的
		 list=	OrderController.getReceivedList();
		}else if(power==3) {
			list=OrderController.getFactoryList(name);
		}
		if(list==null){
			data=new Object[0][0];
		}else{
		data = new Object[list.size()][11];
		for (int i = 0; i < list.size(); i++) {
			data[i][0] = Boolean.FALSE;
			data[i][1] = list.get(i).getId();
			data[i][2] =list.get(i).getSpid();
			data[i][3] =list.get(i).getName();
			data[i][4] =list.get(i).getNum();
			data[i][5] =list.get(i).getDate();
			data[i][6] =list.get(i).getDeadLine();
			data[i][7] =list.get(i).getCustomer();
			data[i][8] =list.get(i).getCustomerPhone();
			data[i][9] =list.get(i).getCustomerAddress();
			data[i][10] =list.get(i).getState();
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
