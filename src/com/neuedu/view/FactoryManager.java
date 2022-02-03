package com.neuedu.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.OrderController;
import com.neuedu.pojo.OrderEntity;
import com.neuedu.pojo.UserEntity;
import com.neuedu.table.OrderTable;

public class FactoryManager extends JFrame {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	
	public FactoryManager(UserEntity u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		OrderTable utm=new OrderTable(null,2);
		table = new JTable(utm);
		
		JLabel lblNewLabel = new JLabel("工厂主");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel.setBounds(182, 10, 98, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 18));
		btnNewButton.setBounds(103, 426, 110, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("注销");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(253, 426, 110, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("设备管理");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EquipmentFactoryManager(u).setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("楷体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(142, 180, 165, 56);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("可接订单");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OrderManager(u).setVisible(true);
				OrderTable utm=new OrderTable(null,2);
				table.setModel(utm);
				table.updateUI();	
			}
		});
		btnNewButton_2_1.setFont(new Font("楷体", Font.PLAIN, 18));
		btnNewButton_2_1.setBounds(142, 270, 165, 56);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("生产管理");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OrderManager1(u).setVisible(true);
				OrderTable utm=new OrderTable(null,2);
				table.setModel(utm);
				table.updateUI();
			}
		});
		btnNewButton_2_2.setFont(new Font("楷体", Font.PLAIN, 18));
		btnNewButton_2_2.setBounds(142, 360, 165, 56);
		contentPane.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("用户管理");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FactoryWorkerManagement(u).setVisible(true);
			}
		});
		btnNewButton_2_3.setFont(new Font("楷体", Font.PLAIN, 18));
		btnNewButton_2_3.setBounds(142, 97, 165, 56);
		contentPane.add(btnNewButton_2_3);
	}
}
