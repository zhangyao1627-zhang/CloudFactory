package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.ProductController;
import com.neuedu.controller.UserController;
import com.neuedu.pojo.UserEntity;
import com.neuedu.table.ProductTable;
import com.neuedu.table.UserTable;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class FactoryWorkerManagement extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public FactoryWorkerManagement(UserEntity u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(10, 36, 852, 535);
		contentPane.add(contentPane_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(99, 28, 240, 32);
		contentPane_1.add(textField);
		
		JButton reset = new JButton("重置");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		reset.setFont(new Font("楷体", Font.PLAIN, 20));
		reset.setBounds(305, 190, 94, 32);
		contentPane_1.add(reset);
		
		JButton add = new JButton("新建");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WorkerAdd(u).setVisible(true);
			}
		});
		add.setFont(new Font("楷体", Font.PLAIN, 20));
		add.setBounds(10, 190, 120, 32);
		contentPane_1.add(add);
		
		JButton delete = new JButton("删除");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> list=new ArrayList();
				int num = table.getRowCount();
				for (int i = 0; i < num; i++) {
					if ((boolean) table.getValueAt(i, 0) == true) {
						String number = (String) table.getValueAt(i, 4);
							list.add(number);				
					}
				}
				UserController.deleteUser(list);
				UserTable et=new UserTable(u);
				table.setModel(et);
				table.updateUI();
				
			}
		});
		delete.setFont(new Font("楷体", Font.PLAIN, 20));
		delete.setBounds(431, 190, 111, 32);
		contentPane_1.add(delete);
		
		JButton modify = new JButton("修改");
		modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = table.getRowCount();
				for (int i = 0; i < num; i++) {
					if ((boolean) table.getValueAt(i, 0) == true) {
						String number=(String) table.getValueAt(i, 4);
						new UserUpdate(number,table).setVisible(true);;
					}
				}
			}
		});
		modify.setFont(new Font("楷体", Font.PLAIN, 20));
		modify.setBounds(163, 190, 102, 32);
		contentPane_1.add(modify);
		
		UserTable ut=new UserTable(u);
		table = new JTable(ut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 248, 614, 201);
		contentPane_1.add(scrollPane);
		scrollPane.setViewportView(table);
		
		
		JButton search_1 = new JButton("返回");
		search_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		search_1.setFont(new Font("楷体", Font.PLAIN, 20));
		search_1.setBounds(650, 474, 94, 32);
		contentPane_1.add(search_1);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 17));
		lblNewLabel.setBounds(35, 30, 70, 24);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("所属工厂");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 73, 70, 24);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("账号状态");
		lblNewLabel_1_1.setFont(new Font("楷体", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(10, 117, 70, 24);
		contentPane_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("用户编码");
		lblNewLabel_1_1_1.setFont(new Font("楷体", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(453, 36, 70, 24);
		contentPane_1.add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(549, 28, 240, 32);
		contentPane_1.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("用户角色");
		lblNewLabel_1_2.setFont(new Font("楷体", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(453, 84, 70, 24);
		contentPane_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("手机号码");
		lblNewLabel_1_2_1.setFont(new Font("楷体", Font.PLAIN, 17));
		lblNewLabel_1_2_1.setBounds(453, 123, 70, 24);
		contentPane_1.add(lblNewLabel_1_2_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(549, 120, 240, 32);
		contentPane_1.add(textField_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"启动", "关闭"}));
		comboBox_1.setBounds(99, 119, 240, 33);
		contentPane_1.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"工厂主", "工人"}));
		comboBox_2.setBounds(550, 75, 240, 33);
		contentPane_1.add(comboBox_2);
		
		JButton delete_1 = new JButton("查询");
		delete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = textField.getText();
				UserTable ut=new UserTable(s1);
				table.setModel(ut);
				table.updateUI();
			}
		});
		delete_1.setFont(new Font("楷体", Font.PLAIN, 20));
		delete_1.setBounds(563, 190, 111, 32);
		contentPane_1.add(delete_1);
		
		JLabel factoryName = new JLabel(u.getFactoryName());
		factoryName.setBounds(109, 70, 111, 24);
		contentPane_1.add(factoryName);
	}

}
