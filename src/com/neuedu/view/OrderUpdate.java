package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;

import com.neuedu.controller.EquipmentTypeController;
import com.neuedu.controller.OrderController;
import com.neuedu.controller.ProductMsgController;
import com.neuedu.controller.UserController;
import com.neuedu.dao.OrderDao;
import com.neuedu.pojo.OrderEntity;
import com.neuedu.pojo.UserEntity;
import com.neuedu.table.OrderTable;
import com.neuedu.utils.DataFileName;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class OrderUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField num;
	private JTextField customer;
	private JTextField customerPhone;
	private JTextField customerAddress;

	public OrderUpdate(String id ,JTable table) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		OrderEntity u = OrderController.getInstance().getOrderMsg(id);
		
		JLabel lblNewLabel = new JLabel("修改信息\r\n");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 22));
		lblNewLabel.setBounds(173, 10, 160, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("名称");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 75, 74, 30);
		contentPane.add(lblNewLabel_1);
		
		String str[]=ProductMsgController.getTypeArray();
		JComboBox comboBox = new JComboBox(str);
		comboBox.setBounds(107, 80, 296, 30);
		contentPane.add(comboBox);
		comboBox.setSelectedItem(u.getName());
		
		JLabel lblNewLabel_1_1 = new JLabel("产品数量");
		lblNewLabel_1_1.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 139, 74, 30);
		contentPane.add(lblNewLabel_1_1);
		
		num = new JTextField(u.getNum());
		num.setColumns(10);
		num.setBounds(117, 145, 286, 30);
		contentPane.add(num);
		
		JLabel lblNewLabel_1_2 = new JLabel("确定日期");
		lblNewLabel_1_2.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(10, 203, 74, 30);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("截止日期");
		lblNewLabel_1_3.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(10, 262, 74, 30);
		contentPane.add(lblNewLabel_1_3);
		
		Date date = new Date();
		JXDatePicker dp = new JXDatePicker();
		
		dp.setDate(date);
		dp.setBounds(119, 208, 296, 30);
		dp.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
		getContentPane().add(dp);
		Date d = dp.getDate();
		
		Date date1 = new Date();
		JXDatePicker dp1 = new JXDatePicker();
		
		dp1.setDate(date1);
		dp1.setBounds(117, 267, 296, 30);
		dp1.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
		getContentPane().add(dp1);
		Date d1 = dp1.getDate();
		
		JLabel lblNewLabel_1_3_1 = new JLabel("客户");
		lblNewLabel_1_3_1.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel_1_3_1.setBounds(10, 338, 74, 30);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("客户电话");
		lblNewLabel_1_3_2.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel_1_3_2.setBounds(10, 395, 74, 30);
		contentPane.add(lblNewLabel_1_3_2);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("客户地址");
		lblNewLabel_1_3_3.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel_1_3_3.setBounds(10, 455, 74, 30);
		contentPane.add(lblNewLabel_1_3_3);
		
		customer = new JTextField(u.getCustomer());
		customer.setColumns(10);
		customer.setBounds(117, 338, 286, 30);
		contentPane.add(customer);
		
		customerPhone = new JTextField(u.getCustomerPhone());
		customerPhone.setColumns(10);
		customerPhone.setBounds(117, 401, 286, 30);
		contentPane.add(customerPhone);
		
		customerAddress = new JTextField(u.getCustomerAddress());
		customerAddress.setColumns(10);
		customerAddress.setBounds(117, 461, 286, 30);
		contentPane.add(customerAddress);
		
		JButton btnNewButton_2 = new JButton("确定修改");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderEntity or=new OrderEntity();
				//1 两个想办法自动生成的
				u.setId(u.getId());
				u.setSpid(u.getSpid());
				u.setNum(num.getText());
				u.setName((String)comboBox.getSelectedItem());		
				u.setDate(d);
				u.setDeadLine(d1);
				u.setCustomer(customer.getText());
				u.setCustomerPhone(customerPhone.getText());
				u.setCustomerAddress(customerAddress.getText());  
				u.setState(u.getState());
			     try {
					OrderController.updateOrder(u);
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
		btnNewButton_2.setBounds(152, 517, 133, 43);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(300, 578, 103, 30);
		contentPane.add(btnNewButton);
	}
}
