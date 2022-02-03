package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.ProductMsgController;
import com.neuedu.table.ProductMsgTable;
import java.awt.Font;
import java.awt.Color;

public class ProductMsg extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	public ProductMsg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ProductMsgTable ut=new ProductMsgTable(null);
		contentPane.setLayout(null);
		
		
		table = new JTable(ut);
		table.setBounds(1, 32, 576, 0);
		contentPane.add(table);
		JScrollPane jp=new JScrollPane(table);
		jp.setBounds(53, 112, 578, 253);
		contentPane.add(jp);
		
		JButton btnAdd = new JButton("\u65B0\u5EFA");
		btnAdd.setFont(new Font("楷体", Font.PLAIN, 17));
		btnAdd.setBounds(45, 60, 113, 42);
		contentPane.add(btnAdd);
		
		JButton btnDel = new JButton("\u5220\u9664");
		btnDel.setFont(new Font("华文楷体", Font.PLAIN, 17));
		btnDel.setBounds(275, 60, 127, 42);
		contentPane.add(btnDel);
		
		JButton btnReturn = new JButton("\u8FD4\u56DE");
		btnReturn.setBounds(538, 386, 93, 23);
		contentPane.add(btnReturn);
		
		JButton BtnUpdate = new JButton("\u4FEE\u6539");
		BtnUpdate.setFont(new Font("华文楷体", Font.PLAIN, 17));
		BtnUpdate.setBounds(482, 60, 113, 42);
		contentPane.add(BtnUpdate);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 10, 54, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(46, 10, 123, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("产品名称查询");
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				ProductMsgTable pt=new ProductMsgTable(name);
				table.setModel(pt);
				table.updateUI();
			}
		});
		btnNewButton.setBounds(275, 8, 148, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 17));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				ProductMsgTable pt=new ProductMsgTable(null);
				table.setModel(pt);
				table.updateUI();
			}
		});
		btnNewButton_1.setBounds(482, 10, 113, 42);
		contentPane.add(btnNewButton_1);
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductMsgadd(table).setVisible(true);;
				
			}
		});
		BtnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int num = table.getRowCount();
				for (int i = 0; i < num; i++) {
					if ((boolean) table.getValueAt(i, 0) == true) {
						String id=(String) table.getValueAt(i, 1);
						new ProductMsgupdate(id,table).setVisible(true);
					}
				}
			}
		});
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> list=new ArrayList();
				int num = table.getRowCount();
				for (int i = 0; i < num; i++) {
					if ((boolean) table.getValueAt(i, 0) == true) {
						String id=(String) table.getValueAt(i, 1);
						list.add(id);
					}
				}
				ProductMsgController.delele(list);
				JOptionPane.showMessageDialog(contentPane, "成功", "标题", JOptionPane.WARNING_MESSAGE);
				ProductMsgTable ut=new ProductMsgTable(null);
				table.setModel(ut);
				table.updateUI();
			}
		});
		btnReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
	}
}
