package com.neuedu.view;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;

import com.neuedu.controller.OrderController;
import com.neuedu.controller.ProductMsgController;
import com.neuedu.dao.OrderDao;
import com.neuedu.pojo.OrderEntity;
import com.neuedu.pojo.ProductMsgEntity;
import com.neuedu.table.OrderTable;
import com.neuedu.table.ProductMsgTable;
import com.neuedu.utils.DataFileName;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

import org.jdesktop.swingx.JXDatePicker;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderAdd extends JFrame {

	private JPanel contentPane;
	private JTextField num;
	private JTextField customer;
	private JTextField customerPhone;
	private JTextField customerAddress;

	public OrderAdd(JTable table) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		String str[]=ProductMsgController.getTypeArray();
		JComboBox comboBox = new JComboBox(str);
		comboBox.setBounds(115, 99, 296, 30);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("订单生成");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 25));
		lblNewLabel.setBounds(159, 20, 183, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("名称");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(20, 94, 74, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("产品数量");
		lblNewLabel_1_1.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(20, 155, 74, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("确定日期");
		lblNewLabel_1_2.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(20, 212, 74, 30);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("截止日期");
		lblNewLabel_1_3.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(20, 272, 74, 30);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("客户");
		lblNewLabel_1_3_1.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel_1_3_1.setBounds(20, 329, 74, 30);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("客户电话");
		lblNewLabel_1_3_2.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel_1_3_2.setBounds(20, 384, 74, 30);
		contentPane.add(lblNewLabel_1_3_2);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("客户地址");
		lblNewLabel_1_3_3.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel_1_3_3.setBounds(20, 441, 74, 30);
		contentPane.add(lblNewLabel_1_3_3);
		
		num = new JTextField();
		num.setBounds(125, 157, 286, 30);
		contentPane.add(num);
		num.setColumns(10);
		
		customer = new JTextField();
		customer.setColumns(10);
		customer.setBounds(125, 329, 286, 30);
		contentPane.add(customer);
		
		customerPhone = new JTextField();
		customerPhone.setColumns(10);
		customerPhone.setBounds(125, 384, 286, 30);
		contentPane.add(customerPhone);
		
		customerAddress = new JTextField();
		customerAddress.setColumns(10);
		customerAddress.setBounds(125, 441, 286, 30);
		contentPane.add(customerAddress);
		
		Date date = new Date();
		JXDatePicker dp = new JXDatePicker();
		
		dp.setDate(date);
		dp.setBounds(115, 212, 224, 30);
		dp.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
		getContentPane().add(dp);
		Date d = dp.getDate();
		
		Date date1 = new Date();
		JXDatePicker dp1 = new JXDatePicker();
		
		dp1.setDate(date1);
		dp1.setBounds(118, 272, 224, 30);
		dp1.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
		getContentPane().add(dp1);
		Date d1 = dp1.getDate();
	
		JButton btnNewButton_2 = new JButton("确定生成");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderEntity or=new OrderEntity();
				//1 两个想办法自动生成的
				or.setId(OrderDao.getMaxId());
				or.setSpid(getRandomString(8));
				//2 获取的几个东西
				or.setName((String)comboBox.getSelectedItem());
				or.setNum(num.getText());
				or.setDate(d);
				or.setDeadLine(d1);
				or.setCustomer(customer.getText());
				or.setCustomerPhone(customerPhone.getText());
				or.setCustomerAddress(customerAddress.getText());
				//3 还得多想想的地方
                or.setState("待完成");
                or.setFactoryName("");
				//5 创造相应的文件(重新添加还有弄一个相应的文件)同时写进去
                DataUtils dta = new DataUtils();
				try {
					DataUtils.writeData(DataFileName.ORDER.toString(), JsonUtil.objectToJson(or));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
				//6 相应的表格要好好弄下
				OrderTable pt=new OrderTable(null,0);
				table.setModel(pt);
				table.updateUI();
			}
		});
		btnNewButton_2.setFont(new Font("楷体", Font.PLAIN, 22));
		btnNewButton_2.setBounds(144, 509, 133, 43);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(308, 563, 103, 30);
		contentPane.add(btnNewButton);
		
	}
	public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
}
