package com.neuedu.view;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import org.jdesktop.swingx.JXDatePicker;

import com.neuedu.controller.UserController;
import com.neuedu.pojo.UserEntity;
import com.neuedu.utils.ValidateUserInfo;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class WorkerAdd extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField IDcard;
	private JTextField phone;
	private JTextField address;
	private JTextField email;
	private JTextField account;
	private JPasswordField password;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private UserController userController = UserController.getInstance();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	public WorkerAdd(UserEntity user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(37, 23, 490, 576);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel.setBounds(88, 42, 72, 37);
		contentPane_1.add(lblNewLabel);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(138, 51, 222, 24);
		contentPane_1.add(name);
		
		JLabel lblNewLabel_1 = new JLabel("性别");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(88, 89, 72, 18);
		contentPane_1.add(lblNewLabel_1);
		
		JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
		gender.setBounds(138, 89, 222, 23);
		contentPane_1.add(gender);
		
		JTextPane remark = new JTextPane();
		remark.setBounds(138, 425, 222, 70);
		contentPane_1.add(remark);
		
		Date date = new Date();
		JXDatePicker dp = new JXDatePicker();
		
		dp.setDate(date);
		dp.setBounds(138, 244, 222, 24);
		dp.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
		contentPane_1.add(dp);
		Date d = dp.getDate();
		
	
		JButton registerButton = new JButton("提交");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 UserEntity u = new UserEntity();
			    	//gender获取姓名
			    u.setName(name.getText());
			    u.setGender((String)gender.getSelectedItem());
				u.setIDcard(IDcard.getText());
				u.setPhone(phone.getText());
				u.setAddress(address.getText());
				u.setBirthDate(sdf.format(d));
				u.setEmail(email.getText());
			    u.setAccount(account.getText());
				u.setPassword(String.valueOf(password.getPassword()));
				u.setState((String)gender.getSelectedItem());
				u.setPower("Worker");
				u.setFactoryName(user.getFactoryName());
				u.setRemark(remark.getText());
			        long randomNum = System.currentTimeMillis();
			        String number = "2020" +(int)(randomNum%(8999999)+1000000);
			        u.setNumber(number);
			        String message = ValidateUserInfo.validate(u);
				if(message==null) {
			            Boolean flag=userController.register(u);
			            if(flag) {
					JOptionPane.showMessageDialog(contentPane,"注册成功","标题",JOptionPane.WARNING_MESSAGE);
			            }else{
					JOptionPane.showMessageDialog(contentPane,"注册失败","标题",JOptionPane.WARNING_MESSAGE);
			            }
				}else {
				    	JOptionPane.showMessageDialog(contentPane,message,"标题",JOptionPane.WARNING_MESSAGE);
				    }
			}
		});
		registerButton.setFont(new Font("楷体", Font.PLAIN, 12));
		registerButton.setBounds(119, 505, 113, 27);
		contentPane_1.add(registerButton);
		
		JButton closeButton = new JButton("返回");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		closeButton.setFont(new Font("楷体", Font.PLAIN, 12));
		closeButton.setBounds(247, 505, 113, 27);
		contentPane_1.add(closeButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("身份证号码");
		lblNewLabel_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(50, 117, 80, 37);
		contentPane_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("联系电话");
		lblNewLabel_1_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(50, 155, 80, 37);
		contentPane_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("地址");
		lblNewLabel_1_1_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(80, 202, 80, 37);
		contentPane_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("出生日期");
		lblNewLabel_1_1_1_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(50, 235, 80, 37);
		contentPane_1.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("eMail");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(80, 273, 80, 37);
		contentPane_1.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("账号");
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_2.setBounds(80, 305, 80, 37);
		contentPane_1.add(lblNewLabel_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1_2_1 = new JLabel("密码");
		lblNewLabel_1_1_1_1_1_2_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_2_1.setBounds(80, 341, 80, 37);
		contentPane_1.add(lblNewLabel_1_1_1_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2_1_1 = new JLabel("账号状态");
		lblNewLabel_1_1_1_1_1_2_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_2_1_1.setBounds(50, 378, 80, 37);
		contentPane_1.add(lblNewLabel_1_1_1_1_1_2_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2_1_1_1_1 = new JLabel("备注");
		lblNewLabel_1_1_1_1_1_2_1_1_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_2_1_1_1_1.setBounds(60, 425, 80, 37);
		contentPane_1.add(lblNewLabel_1_1_1_1_1_2_1_1_1_1);
		
		IDcard = new JTextField();
		IDcard.setColumns(10);
		IDcard.setBounds(138, 130, 222, 24);
		contentPane_1.add(IDcard);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(138, 165, 222, 24);
		contentPane_1.add(phone);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(138, 212, 222, 24);
		contentPane_1.add(address);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(138, 283, 222, 24);
		contentPane_1.add(email);
		
		
		
		account = new JTextField();
		account.setColumns(10);
		account.setBounds(138, 320, 222, 24);
		contentPane_1.add(account);
		
		password = new JPasswordField();
		password.setBounds(138, 351, 222, 21);
		contentPane_1.add(password);
		
		JComboBox state = new JComboBox();
		state.setModel(new DefaultComboBoxModel(new String[] {"运行", "关闭"}));
		state.setBounds(138, 388, 222, 23);
		contentPane_1.add(state);
		

		
		
		
	}
}
