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
import com.neuedu.utils.DataFileName;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class OrderReceive extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;


	public OrderReceive(UserEntity u1) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 774, 335);
		contentPane.add(scrollPane);
		//注意这个地方
		OrderTable utm=new OrderTable(null,1);
		table = new JTable(utm);
		scrollPane.setViewportView(table);

		
		JLabel lblNewLabel = new JLabel("订单接单");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 23));
		lblNewLabel.setBounds(329, 10, 147, 47);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("接单");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = table.getRowCount();
				for (int i = 0; i < num; i++) {
					if ((boolean) table.getValueAt(i, 0) == true) {
						String id=(String) table.getValueAt(i, 1);
						OrderEntity u = OrderController.getInstance().getOrderMsg(id);
						u.setState("已中标");
						u.setFactoryName(u1.getFactoryName());
						OrderDao orderDao = new OrderDao();
						try {
							orderDao.updateOrder(u);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						OrderTable ut=new OrderTable(null,1);
						table.setModel(ut);
						table.updateUI();	
					}
				}		
				OrderTable utm=new OrderTable(null,1);
				table.setModel(utm);
				table.updateUI();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 17));
		btnNewButton.setBounds(637, 416, 109, 47);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 17));
		btnNewButton_1.setBounds(507, 416, 109, 47);
		contentPane.add(btnNewButton_1);
		
	}
}
