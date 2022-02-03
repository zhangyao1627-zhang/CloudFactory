package com.neuedu.view;

import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neuedu.pojo.UserEntity;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//111111111111111
public class Admin extends JFrame {

private JPanel cloudFactory;
	
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 713);
		cloudFactory = new JPanel();
		cloudFactory.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cloudFactory);
		cloudFactory.setLayout(null);
		
		JButton productType = new JButton("订单管理");
		productType.setFont(new Font("楷体", Font.PLAIN, 24));
		productType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new trader().setVisible(true);
			}
		});
		productType.setBounds(161, 530, 252, 58);
		cloudFactory.add(productType);
		
		JButton productMsg = new JButton("产品类别管理");
		productMsg.setFont(new Font("楷体", Font.PLAIN, 24));
		productMsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProductType().setVisible(true);
			}
		});
		productMsg.setBounds(161, 258, 252, 58);
		cloudFactory.add(productMsg);
		
		JButton EquipmentMsg = new JButton("设备管理");
		EquipmentMsg.setFont(new Font("楷体", Font.PLAIN, 24));
		EquipmentMsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EquipmentManager().setVisible(true);
			}
		});
		EquipmentMsg.setBounds(161, 190, 252, 58);
		cloudFactory.add(EquipmentMsg);
		
		JButton userManager = new JButton("用户管理");
		userManager.setFont(new Font("楷体", Font.PLAIN, 24));
		userManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserManager().setVisible(true);
			}
		});
		userManager.setBounds(161, 122, 252, 58);
		cloudFactory.add(userManager);
		
		JButton close = new JButton("返回");
		close.setFont(new Font("楷体", Font.PLAIN, 18));
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		close.setBounds(392, 610, 103, 50);
		cloudFactory.add(close);
		
		JLabel lblNewLabel = new JLabel("管理员操作");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 30));
		lblNewLabel.setBounds(210, 38, 252, 58);
		cloudFactory.add(lblNewLabel);
		
		JButton close_1 = new JButton("注销");
		close_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login().setVisible(true);
			}
		});
		close_1.setFont(new Font("楷体", Font.PLAIN, 18));
		close_1.setBounds(503, 610, 103, 50);
		cloudFactory.add(close_1);
		
		JButton productMsg_1 = new JButton("产品信息管理");
		productMsg_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProductMsg().setVisible(true); 
			}
		});
		productMsg_1.setFont(new Font("楷体", Font.PLAIN, 24));
		productMsg_1.setBounds(161, 326, 252, 58);
		cloudFactory.add(productMsg_1);
		
		JButton productMsg_2 = new JButton("设备类别管理");
		productMsg_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EquipmentType().setVisible(true);
			}
		});
		productMsg_2.setFont(new Font("楷体", Font.PLAIN, 24));
		productMsg_2.setBounds(161, 394, 252, 58);
		cloudFactory.add(productMsg_2);
		
		JButton productMsg_2_1 = new JButton("设备信息管理");
		productMsg_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EquipmentManager().setVisible(true);
			}
		});
		productMsg_2_1.setFont(new Font("楷体", Font.PLAIN, 24));
		productMsg_2_1.setBounds(161, 462, 252, 58);
		cloudFactory.add(productMsg_2_1);
	}
}

