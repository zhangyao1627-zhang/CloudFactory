package com.neuedu.view;
//11111111111
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.neuedu.controller.UserController;
import com.neuedu.pojo.UserEntity;
import com.neuedu.table.UserTable;
import com.neuedu.view.UserUpdate;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UserManager extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTable table;
	private JTextField number;
	private JTextField phone;
	private UserController userController = UserController.getInstance();
	
	/**
	 * Create the frame.
	 */
	public UserManager() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//注意顺序的更换，可能到时候有一点小小的问题
		
		UserTable ut=new UserTable("out");
		table = new JTable(ut);
		
		String[] s1 = userController.getAllFactory();
		JComboBox factoryName = new JComboBox(s1);
		factoryName.setBounds(99, 75, 240, 33);
		contentPane.add(factoryName);
		
		JComboBox state = new JComboBox();
		state.setModel(new DefaultComboBoxModel(new String[] {"运行", "关闭"}));
		state.setBounds(99, 119, 240, 33);
		contentPane.add(state);
		
		JComboBox power = new JComboBox();
		power.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
		power.setBounds(550, 75, 240, 33);
		contentPane.add(power);
		
		
		
		name = new JTextField();
		name.setBounds(99, 28, 240, 32);
		contentPane.add(name);
		name.setColumns(10);
		
		JButton reset = new JButton("重置");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				number.setText("");
				phone.setText("");
				//注意重置的时候文本框也要进行相应的操作

				UserTable ut=new UserTable("out");
				table.setModel(ut);
				table.updateUI();
			}
		});
		reset.setFont(new Font("楷体", Font.PLAIN, 20));
		reset.setBounds(453, 190, 94, 32);
		contentPane.add(reset);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 248, 614, 201);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton search_1 = new JButton("\u8FD4\u56DE");
		search_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		search_1.setFont(new Font("楷体", Font.PLAIN, 20));
		search_1.setBounds(548, 480, 94, 32);
		contentPane.add(search_1);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 17));
		lblNewLabel.setBounds(35, 30, 70, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("所属工厂");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 73, 70, 24);
		contentPane.add(lblNewLabel_1);
		
		JButton search_1_1 = new JButton("注销");
		search_1_1.setFont(new Font("楷体", Font.PLAIN, 20));
		search_1_1.setBounds(669, 480, 94, 32);
		contentPane.add(search_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("账号状态");
		lblNewLabel_1_1.setFont(new Font("楷体", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(10, 117, 70, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("用户编码");
		lblNewLabel_1_1_1.setFont(new Font("楷体", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(453, 36, 70, 24);
		contentPane.add(lblNewLabel_1_1_1);
		
		number = new JTextField();
		number.setColumns(10);
		number.setBounds(549, 28, 240, 32);
		contentPane.add(number);
		
		JLabel lblNewLabel_1_2 = new JLabel("用户角色");
		lblNewLabel_1_2.setFont(new Font("楷体", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(453, 84, 70, 24);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("手机号码");
		lblNewLabel_1_2_1.setFont(new Font("楷体", Font.PLAIN, 17));
		lblNewLabel_1_2_1.setBounds(453, 123, 70, 24);
		contentPane.add(lblNewLabel_1_2_1);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(549, 120, 240, 32);
		contentPane.add(phone);
		
		
		
		JButton delete_1 = new JButton("查询");
		delete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = name.getText();
				UserTable ut=new UserTable(s1);
				table.setModel(ut);
				table.updateUI();
			}
		});
		delete_1.setFont(new Font("楷体", Font.PLAIN, 20));
		delete_1.setBounds(563, 190, 111, 32);
		contentPane.add(delete_1);
		}
}