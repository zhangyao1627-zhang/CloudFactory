package com.neuedu.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.EquipmentManagerController;
import com.neuedu.pojo.UserEntity;
import com.neuedu.table.EquipmentManagerTable;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Hire extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	//注意输入进来还要输出的图要怎么进行相应的修改
	public Hire(UserEntity u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		EquipmentManagerTable em=new EquipmentManagerTable(null, 2, null);
		table = new JTable(em);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 91, 692, 312);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> list=new ArrayList();
				int num = table.getRowCount();
				for (int i = 0; i < num; i++) {
					if ((boolean) table.getValueAt(i, 0) == true) {
						String id=(String) table.getValueAt(i, 1);
						list.add(id);
					}
				}
				EquipmentManagerController.hireEquipment(list,u);
				EquipmentManagerTable em=new EquipmentManagerTable(null, 2, null);
				table.setModel(em);
				table.updateUI();
//				EquipmentManagerTable et=new EquipmentManagerTable(null,1,u.getFactoryName());
//				table2.setModel(et);
//				table2.updateUI();
			}
		});
		btnNewButton.setBounds(583, 431, 123, 44);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("请选择相应的需要添加的设备");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(233, 20, 328, 50);
		contentPane.add(lblNewLabel);
		
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(588, 24, 118, 46);
		contentPane.add(btnNewButton_1);
		
		

	}
}
