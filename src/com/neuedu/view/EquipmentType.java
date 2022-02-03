package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.EquipmentTypeController;
import com.neuedu.table.EquipmentTypeTable;


import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class EquipmentType extends JFrame {

	private JPanel contentPane;
	private JTextField searchContent;
	private JTable table;
	private EquipmentTypeController productEntityController=EquipmentTypeController.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipmentType frame = new EquipmentType();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EquipmentType() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		EquipmentTypeTable utm=new EquipmentTypeTable(null);
		table = new JTable(utm);
		
		searchContent = new JTextField();
		searchContent.setBounds(35, 27, 135, 34);
		contentPane.add(searchContent);
		searchContent.setColumns(10);
		
		JButton btnNewButton = new JButton("类别名称");
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=searchContent.getText();
				EquipmentTypeTable ut=new EquipmentTypeTable(name);
				table.setModel(ut);
				table.updateUI();
			}
		});
		btnNewButton.setBounds(200, 25, 129, 44);
		contentPane.add(btnNewButton);
		
		JButton reset = new JButton("重置");
		reset.setFont(new Font("华文楷体", Font.PLAIN, 18));
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchContent.setText("");
				EquipmentTypeTable ut=new EquipmentTypeTable(null);
				table.setModel(ut);
				table.updateUI();
			}
		});
		reset.setBounds(339, 25, 129, 44);
		contentPane.add(reset);
		
		JButton btnNewButton_2 = new JButton("返回");
		btnNewButton_2.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(499, 26, 123, 43);
		contentPane.add(btnNewButton_2);
		
		JButton add = new JButton("新建");
		add.setFont(new Font("华文楷体", Font.PLAIN, 18));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EquipmentTypeadd(table).setVisible(true);
			}
		});
		add.setBounds(35, 99, 135, 44);
		contentPane.add(add);
		
		JButton delete = new JButton("删除");
		delete.setFont(new Font("华文楷体", Font.PLAIN, 18));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> list=new ArrayList();
				int num = table.getRowCount();
				//把打对勾的弄到一起
				for (int i = 0; i < num; i++) {
					if ((boolean) table.getValueAt(i, 0) == true) {
						String id=(String) table.getValueAt(i, 1);
						list.add(id);
					}
				}
				EquipmentTypeController.deleteEquipment(list);
				JOptionPane.showMessageDialog(contentPane, "成功", "标题", JOptionPane.WARNING_MESSAGE);
				EquipmentTypeTable ut=new EquipmentTypeTable(null);
				table.setModel(ut);
				table.updateUI();
			}
		});
		delete.setBounds(206, 99, 135, 44);
		contentPane.add(delete);
		
		JButton modify = new JButton("修改");
		modify.setFont(new Font("华文楷体", Font.PLAIN, 18));
		modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = table.getRowCount();
				for (int i = 0; i < num; i++) {
					if ((boolean) table.getValueAt(i, 0) == true) {
						String id=(String) table.getValueAt(i, 1);
						new EquipmentTypeupdate(id,table).setVisible(true);;
					}
				}
			}
		});
		modify.setBounds(499, 99, 113, 44);
		contentPane.add(modify);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 178, 564, 253);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
	}
	
}
