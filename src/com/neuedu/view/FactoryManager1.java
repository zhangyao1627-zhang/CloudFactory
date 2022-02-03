package com.neuedu.view;

import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.neuedu.controller.EquipmentManagerController;
import com.neuedu.pojo.UserEntity;
import com.neuedu.table.EquipmentManagerTable;
import com.neuedu.table.EquipmentTypeTable;
import com.neuedu.table.ProductTable;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class FactoryManager1 extends JFrame {

		private JPanel contentPane;
		private JTable table;
		private JTextField searchContent;

		public FactoryManager1(UserEntity u) {

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 904, 553);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			//EquipmentManagerTable et=new EquipmentManagerTable(null,1,u.getFactoryName());
			//table = new JTable(et);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(38, 163, 812, 279);
			contentPane.add(scrollPane);
			scrollPane.setViewportView(table);
			
			JButton btnNewButton = new JButton("新建");
			btnNewButton.setFont(new Font("楷体", Font.PLAIN, 20));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//new EquipmentManageradd(table,1,u).setVisible(true);;
				}
			});
			btnNewButton.setBounds(38, 99, 113, 54);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("租用设备");
			btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 20));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//new Hire(u,table).setVisible(true);;
				}
			});
			btnNewButton_1.setBounds(371, 466, 149, 40);
			contentPane.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("删除");
			btnNewButton_2.setFont(new Font("楷体", Font.PLAIN, 20));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					List<String> list=new ArrayList();
//					int num = table.getRowCount();
//					for (int i = 0; i < num; i++) {
//						if ((boolean) table.getValueAt(i, 0) == true) {
//							String id = (String) table.getValueAt(i, 1);
//							String flag = (String) table.getValueAt(i, 8);
//							if(flag.equals("工厂设备")){
//								list.add(id);
//							}else{
//								JOptionPane.showMessageDialog(contentPane, "只能删除工厂设备", "标题", JOptionPane.WARNING_MESSAGE);
//								break;
//							}
//						}
//					}
//					EquipmentManagerController.deleteEquipment(list);
//					EquipmentManagerTable et=new EquipmentManagerTable(null,1,u.getFactoryName());
//					table.setModel(et);
//					table.updateUI();
				}
			});
			btnNewButton_2.setBounds(407, 99, 113, 54);
			contentPane.add(btnNewButton_2);

			JButton btnNewButton_3 = new JButton("设备状态");
			btnNewButton_3.setFont(new Font("楷体", Font.PLAIN, 20));
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					int num = table.getRowCount();
//					for (int i = 0; i < num; i++) {
//						if ((boolean) table.getValueAt(i, 0) == true) {
//							String id = (String) table.getValueAt(i, 1);
//						    EquipmentManagerController.changeState1(id);
//						}
//					}
//					EquipmentManagerTable pt = new EquipmentManagerTable(null,1,u.getFactoryName());
//					table.setModel(pt);
//					table.updateUI();
				}
			});
			btnNewButton_3.setBounds(716, 36, 134, 45);
			contentPane.add(btnNewButton_3);
			
		
			JButton btnNewButton_4 = new JButton("修改");
			btnNewButton_4.setFont(new Font("楷体", Font.PLAIN, 20));
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					int num = table.getRowCount();
//					for (int i = 0; i < num; i++) {
//						if ((boolean) table.getValueAt(i, 0) == true) {
//							String id=(String) table.getValueAt(i, 1);
//							new EquipmentManagerupdate(id,table).setVisible(true);;
//						}
//					}
				}
			});
			btnNewButton_4.setBounds(407, 36, 113, 48);
			contentPane.add(btnNewButton_4);
			
			JButton btnNewButton_4_1 = new JButton("返回");
			btnNewButton_4_1.setFont(new Font("楷体", Font.PLAIN, 20));
			btnNewButton_4_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton_4_1.setBounds(748, 452, 113, 54);
			contentPane.add(btnNewButton_4_1);
			
			searchContent = new JTextField();
			searchContent.setBounds(38, 36, 194, 45);
			contentPane.add(searchContent);
			searchContent.setColumns(10);

			JButton btnNewButton_5 = new JButton("检索");
			btnNewButton_5.setFont(new Font("楷体", Font.PLAIN, 20));
			btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					String name=searchContent.getText();
//					EquipmentManagerTable ut=new EquipmentManagerTable(name,0,null);
//					table.setModel(ut);
//					table.updateUI();
				}
			});
			btnNewButton_5.setBounds(261, 99, 113, 54);
			contentPane.add(btnNewButton_5);

			JButton btnNewButton_4_2 = new JButton("重置");
			btnNewButton_4_2.setFont(new Font("楷体", Font.PLAIN, 20));
			btnNewButton_4_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					searchContent.setText("");
//					EquipmentManagerTable pt = new EquipmentManagerTable(null,0,null);
//					table.setModel(pt);
//					table.updateUI();
				}
			});
			btnNewButton_4_2.setBounds(261, 36, 113, 48);
			contentPane.add(btnNewButton_4_2);

			JButton btnNewButton_6 = new JButton("产品配置");
			btnNewButton_6.setFont(new Font("楷体", Font.PLAIN, 20));
			btnNewButton_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				//	new EquipmentAdd().setVisible(true);
				}
			});
			btnNewButton_6.setBounds(542, 36, 134, 44);
			contentPane.add(btnNewButton_6);
			
			JButton btnNewButton_7 = new JButton("开机");
			btnNewButton_7.setFont(new Font("楷体", Font.PLAIN, 20));
			btnNewButton_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					int num = table.getRowCount();
//					for (int i = 0; i < num; i++) {
//						if ((boolean) table.getValueAt(i, 0) == true) {
//							String id = (String) table.getValueAt(i, 1);
//						    EquipmentManagerController.changeState2(id);
//						}
//					}
//					EquipmentManagerTable pt = new EquipmentManagerTable(null,1,u.getFactoryName());
//					table.setModel(pt);
//					table.updateUI();
				}
			});
			btnNewButton_7.setBounds(609, 99, 103, 54);
			contentPane.add(btnNewButton_7);
			
			JButton btnNewButton_7_1 = new JButton("关机");
			btnNewButton_7_1.setFont(new Font("楷体", Font.PLAIN, 20));
			btnNewButton_7_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					int num = table.getRowCount();
//					for (int i = 0; i < num; i++) {
//						if ((boolean) table.getValueAt(i, 0) == true) {
//							String id = (String) table.getValueAt(i, 1);
//						    EquipmentManagerController.changeState3(id);
//						}
//					}
//					EquipmentManagerTable pt = new EquipmentManagerTable(null,1,u.getFactoryName());
//					table.setModel(pt);
//					table.updateUI();
				}
			});
			btnNewButton_7_1.setBounds(747, 99, 103, 54);
			contentPane.add(btnNewButton_7_1);
			
			JButton btnNewButton_8 = new JButton("订单接单");
			btnNewButton_8.setFont(new Font("楷体", Font.PLAIN, 20));
			btnNewButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				//	new OrderReceive().setVisible(true);
				}
			});
			btnNewButton_8.setBounds(38, 461, 134, 45);
			contentPane.add(btnNewButton_8);
			
			JButton btnNewButton_9 = new JButton("订单管理");
			btnNewButton_9.setFont(new Font("楷体", Font.PLAIN, 20));
			btnNewButton_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//new OrderManager().setVisible(true);;
				}
			});
			btnNewButton_9.setBounds(202, 464, 124, 45);
			contentPane.add(btnNewButton_9);
			
			JButton btnNewButton_1_1 = new JButton("退还设备");
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					List<String> list=new ArrayList();
//					int num = table.getRowCount();
//					for (int i = 0; i < num; i++) {
//						if ((boolean) table.getValueAt(i, 0) == true) {
//							String id=(String) table.getValueAt(i, 1);
//							if(EquipmentManagerController.getEquipmentMsg(id).getHireState().equals("已被租用")) 
//							{
//							EquipmentManagerController.getBack(id);
//							}
//							EquipmentManagerTable pt = new EquipmentManagerTable(null,1,u.getFactoryName());
//							table.setModel(pt);
//							table.updateUI();
//						}
//					}
				}
				
			});
			btnNewButton_1_1.setFont(new Font("楷体", Font.PLAIN, 20));
			btnNewButton_1_1.setBounds(563, 466, 149, 40);
			contentPane.add(btnNewButton_1_1);
		}
}

