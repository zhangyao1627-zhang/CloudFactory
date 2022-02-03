package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.EquipmentManagerController;
import com.neuedu.table.EquipmentManagerTable;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class EquipmentManager extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	public EquipmentManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		EquipmentManagerTable em=new EquipmentManagerTable(null,0,null);
		table = new JTable(em);
		
		textField = new JTextField();
		textField.setBounds(49, 11, 122, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton search = new JButton("输入名称查询");
		search.setFont(new Font("楷体", Font.PLAIN, 20));
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				EquipmentManagerTable pt = new EquipmentManagerTable(name,0,null);
				table.setModel(pt);
				table.updateUI();
			}
		});
		search.setBounds(226, 11, 170, 38);
		contentPane.add(search);
		
		JButton reset = new JButton("重置");
		reset.setFont(new Font("楷体", Font.PLAIN, 20));
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				EquipmentManagerTable pt = new EquipmentManagerTable(null,0,null);
				table.setModel(pt);
				table.updateUI();
			}
		});
		reset.setBounds(469, 11, 122, 38);
		contentPane.add(reset);
		
		JButton add = new JButton("新建");
		add.setFont(new Font("楷体", Font.PLAIN, 20));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EquipmentManageradd(table,0,null).setVisible(true);;
			}
		});
		add.setBounds(49, 83, 122, 38);
		contentPane.add(add);
		
		JButton delete = new JButton("删除");
		delete.setFont(new Font("楷体", Font.PLAIN, 20));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> list = new ArrayList();
				int num = table.getRowCount();
				for (int i = 0; i < num; i++) {
					if ((boolean) table.getValueAt(i, 0) == true) {
						String id = (String) table.getValueAt(i, 1);
						list.add(id);
					}
				}
				boolean flag=EquipmentManagerController.checkState(list);
				if(!flag){
					JOptionPane.showMessageDialog(contentPane, "不可删除已被租用或工厂设备", "标题", JOptionPane.WARNING_MESSAGE);
				}else{
				EquipmentManagerController.deleteEquipment(list);
				JOptionPane.showMessageDialog(contentPane, "成功", "标题", JOptionPane.WARNING_MESSAGE);
				EquipmentManagerTable pt = new EquipmentManagerTable(null,0,null);
				table.setModel(pt);
				table.updateUI();
				}
			}
		});
		delete.setBounds(226, 83, 122, 38);
		contentPane.add(delete);
		
		JButton change = new JButton("修改");
		change.setFont(new Font("华文楷体", Font.PLAIN, 20));
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = table.getRowCount();
				for (int i = 0; i < num; i++) {
					if ((boolean) table.getValueAt(i, 0) == true) {
						String id = (String) table.getValueAt(i, 1);
						new EquipmentManagerupdate(id, table).setVisible(true);;
					}
				}
			}
		});
		change.setBounds(394, 83, 122, 38);
		contentPane.add(change);
		
		JButton state = new JButton("设备状态");
		state.setFont(new Font("华文楷体", Font.PLAIN, 20));
		state.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = table.getRowCount();
				for (int i = 0; i < num; i++) {
					if ((boolean) table.getValueAt(i, 0) == true) {
						String id = (String) table.getValueAt(i, 1);
					    EquipmentManagerController.changeState(id);
					}
				}
				EquipmentManagerTable pt = new EquipmentManagerTable(null,0,null);
				table.setModel(pt);
				table.updateUI();
			}
		}); 
		state.setBounds(571, 83, 113, 38);
		contentPane.add(state);
		
		JButton fanhui = new JButton("返回");
		fanhui.setFont(new Font("楷体", Font.PLAIN, 20));
		fanhui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		fanhui.setBounds(571, 421, 113, 40);
		contentPane.add(fanhui);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 157, 635, 242);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
	}
}
