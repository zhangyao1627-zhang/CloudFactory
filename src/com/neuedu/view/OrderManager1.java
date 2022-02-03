package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.OrderController;
import com.neuedu.dao.OrderDao;
import com.neuedu.pojo.OrderEntity;
import com.neuedu.pojo.UserEntity;
import com.neuedu.table.OrderTable;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class OrderManager1 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public OrderManager1(UserEntity u1) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 83, 659, 331);
		contentPane.add(scrollPane);
		OrderTable utm=new OrderTable(null,2);
		table = new JTable(utm);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("订单排产");
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = table.getRowCount();
				for (int i = 0; i < num; i++) {
					if ((boolean) table.getValueAt(i, 0) == true) {
						String id=(String) table.getValueAt(i, 1);
						OrderEntity u = OrderController.getInstance().getOrderMsg(id);
						new OrderStart(u).setVisible(true);;
						OrderTable ut=new OrderTable(null,2);
						table.setModel(ut);
						table.updateUI();	
					}
				}
				OrderTable utm=new OrderTable(null,2);
				table = new JTable(utm);
			}
		});
		btnNewButton.setBounds(420, 437, 120, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(573, 437, 97, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("已经收到的订单");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel.setBounds(275, 10, 226, 42);
		contentPane.add(lblNewLabel);
		
		
	}
}
