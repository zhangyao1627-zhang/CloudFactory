package com.neuedu.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.UserController;
import com.neuedu.pojo.UserEntity;
import com.neuedu.table.UserTable;
import com.neuedu.utils.ValidateUserInfo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import org.jdesktop.swingx.JXDatePicker;

public class UserUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField IDcard;
	private JTextField phone;
	private JTextField address;
	private JTextField email;
	private JTextField account;
	private JPasswordField password;
	private JTextField textField;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private JTextField remark;
	
	public UserUpdate(String number ,JTable table) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//这个地方直接获得相应的实例不知道会不会出问题
		UserEntity u = UserController.getInstance().getUserMsg(number);
		
		JLabel lblNewLabel = new JLabel("信息修改");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 30));
		lblNewLabel.setBounds(133, 10, 179, 54);
		contentPane.add(lblNewLabel);
		
		JPanel contentPane_1 = new JPanel();
		
		Date date = new Date();
		
		JXDatePicker dp = new JXDatePicker();
		dp.setBounds(138, 244, 222, 24);
		contentPane_1.add(dp);
		
		dp.setDate(date);
		dp.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
		Date d = dp.getDate();
		
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 27, 657, 621);
		
		JLabel lblNewLabel_5 = new JLabel("姓名");
		lblNewLabel_5.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(88, 42, 72, 37);
		
		name = new JTextField(u.getName());
		name.setColumns(10);
		name.setBounds(138, 51, 222, 24);
		
		JLabel lblNewLabel_1_1 = new JLabel("性别");
		lblNewLabel_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(88, 89, 72, 18);
		
		JComboBox gender = new JComboBox();
		gender.setBounds(138, 89, 222, 23);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("身份证号码");
		lblNewLabel_1_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(50, 117, 80, 37);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("联系电话");
		lblNewLabel_1_1_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(50, 155, 80, 37);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("地址");
		lblNewLabel_1_1_1_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(80, 202, 80, 37);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("出生日期");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(50, 235, 80, 37);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("eMail");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(80, 273, 80, 37);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("账号");
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_2.setBounds(80, 305, 80, 37);
		
		JLabel lblNewLabel_1_1_1_1_1_2_1 = new JLabel("密码");
		lblNewLabel_1_1_1_1_1_2_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_2_1.setBounds(80, 341, 80, 37);
		
		JLabel lblNewLabel_1_1_1_1_1_2_1_1 = new JLabel("账号状态");
		lblNewLabel_1_1_1_1_1_2_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_2_1_1.setBounds(50, 378, 80, 37);
		
		JLabel lblNewLabel_1_1_1_1_1_2_1_1_1_1 = new JLabel("备注");
		lblNewLabel_1_1_1_1_1_2_1_1_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_2_1_1_1_1.setBounds(60, 425, 80, 37);
		
		IDcard = new JTextField(u.getIDcard());
		IDcard.setColumns(10);
		IDcard.setBounds(138, 130, 222, 24);
		
		phone = new JTextField(u.getPhone());
		phone.setColumns(10);
		phone.setBounds(138, 165, 222, 24);
		
		address = new JTextField(u.getAddress());
		address.setColumns(10);
		address.setBounds(138, 212, 222, 24);
		
		email = new JTextField(u.getEmail());
		email.setColumns(10);
		email.setBounds(138, 283, 222, 24);
		
		account = new JTextField(u.getAccount());
		account.setColumns(10);
		account.setBounds(138, 320, 222, 24);
		
		password = new JPasswordField(u.getPassword());
		password.setBounds(138, 351, 222, 21);
		
		JComboBox state = new JComboBox();
		state.setBounds(138, 388, 222, 23);
		
		JButton add = new JButton("确认修改");
		add.setBounds(148, 543, 161, 43);
		contentPane_1.add(add);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 UserEntity u1 = new UserEntity();
			    	//gender获取姓名
			    u1.setName(name.getText());
			    u1.setGender((String)gender.getSelectedItem());
				u1.setIDcard(IDcard.getText());
				u1.setPhone(phone.getText());
				u1.setAddress(address.getText());
				u1.setBirthDate(sdf.format(d));
				u1.setEmail(email.getText());
			    u1.setAccount(account.getText());
				u1.setPassword(String.valueOf(password.getPassword()));
				u1.setState((String)gender.getSelectedItem());
				u1.setPower(u.getPower());
				u1.setFactoryName(u.getFactoryName());
				u1.setRemark(remark.getText());		      
			    u1.setNumber(u.getNumber());
			        
			        try {
						UserController.updateUser(u);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(contentPane, "成功", "标题", JOptionPane.WARNING_MESSAGE);
					UserTable ut=new UserTable(u);
					table.setModel(ut);
					table.updateUI();		
			}
		});
		add.setFont(new Font("楷体", Font.PLAIN, 24));
		contentPane.add(contentPane_1);
		contentPane_1.add(lblNewLabel_5);
		contentPane_1.add(name);
		contentPane_1.add(lblNewLabel_1_1);
		contentPane_1.add(gender);
		contentPane_1.add(lblNewLabel_1_1_1);
		contentPane_1.add(lblNewLabel_1_1_1_1);
		contentPane_1.add(lblNewLabel_1_1_1_1_1);
		contentPane_1.add(lblNewLabel_1_1_1_1_1_1);
		contentPane_1.add(lblNewLabel_1_1_1_1_1_1_1);
		contentPane_1.add(lblNewLabel_1_1_1_1_1_2);
		contentPane_1.add(lblNewLabel_1_1_1_1_1_2_1);
		contentPane_1.add(lblNewLabel_1_1_1_1_1_2_1_1);
		contentPane_1.add(lblNewLabel_1_1_1_1_1_2_1_1_1_1);
		contentPane_1.add(IDcard);
		contentPane_1.add(phone);
		contentPane_1.add(address);
		contentPane_1.add(email);
		contentPane_1.add(account);
		contentPane_1.add(password);
		contentPane_1.add(state);
		
		JButton close = new JButton("返回");
		close.setBounds(349, 548, 110, 33);
		contentPane_1.add(close);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		close.setFont(new Font("楷体", Font.PLAIN, 24));
		
		remark = new JTextField(u.getRemark());
		remark.setBounds(138, 435, 222, 98);
		contentPane_1.add(remark);
		remark.setColumns(10);
		
		
		
	}
}

