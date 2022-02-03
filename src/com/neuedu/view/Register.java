package com.neuedu.view;
//111111111111111
import java.awt.BorderLayout;





import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;
import com.neuedu.controller.UserController;

import com.neuedu.pojo.UserEntity;
import com.neuedu.utils.ValidateUserInfo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private UserController userController = UserController.getInstance();
	private JTextField IDcard;
	private JTextField phone;
	private JTextField address;
	private JTextField birthDate;
	private JTextField email;
	private JTextField account;
	private JPasswordField password;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private JTextField factoryName;
	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel.setBounds(88, 42, 72, 37);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(138, 51, 222, 24);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("性别");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(88, 89, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		
		JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
		gender.setBounds(138, 89, 222, 23);
		contentPane.add(gender);
		
		JTextPane remark = new JTextPane();
		remark.setBounds(138, 456, 222, 70);
		contentPane.add(remark);
		
		Date date = new Date();
		JXDatePicker dp = new JXDatePicker();
		
		dp.setDate(date);
		dp.setBounds(138, 249, 222, 24);
		dp.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
		getContentPane().add(dp);
		Date d = dp.getDate();
		
		ButtonGroup group = new ButtonGroup();
		
		JButton registerButton = new JButton("提交");
		registerButton.setFont(new Font("楷体", Font.PLAIN, 12));
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
	
						u.setPower("FactoryManager");
			 u.setFactoryName(factoryName.getText());
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
		registerButton.setBounds(112, 551, 113, 27);
		contentPane.add(registerButton);
		
		JButton closeButton = new JButton("返回");
		closeButton.setFont(new Font("楷体", Font.PLAIN, 12));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		closeButton.setBounds(235, 551, 113, 27);
		contentPane.add(closeButton);
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("身份证号码");
		lblNewLabel_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(50, 117, 80, 37);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("联系电话");
		lblNewLabel_1_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(50, 155, 80, 37);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("地址");
		lblNewLabel_1_1_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(80, 202, 80, 37);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("出生日期");
		lblNewLabel_1_1_1_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(50, 235, 80, 37);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("eMail");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(80, 273, 80, 37);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("账号");
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_2.setBounds(80, 305, 80, 37);
		contentPane.add(lblNewLabel_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1_2_1 = new JLabel("密码");
		lblNewLabel_1_1_1_1_1_2_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_2_1.setBounds(80, 341, 80, 37);
		contentPane.add(lblNewLabel_1_1_1_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2_1_1 = new JLabel("账号状态");
		lblNewLabel_1_1_1_1_1_2_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_2_1_1.setBounds(50, 378, 80, 37);
		contentPane.add(lblNewLabel_1_1_1_1_1_2_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2_1_1_1 = new JLabel("工厂名称");
		lblNewLabel_1_1_1_1_1_2_1_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_2_1_1_1.setBounds(50, 412, 80, 37);
		contentPane.add(lblNewLabel_1_1_1_1_1_2_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2_1_1_1_1 = new JLabel("备注");
		lblNewLabel_1_1_1_1_1_2_1_1_1_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_2_1_1_1_1.setBounds(48, 459, 80, 37);
		contentPane.add(lblNewLabel_1_1_1_1_1_2_1_1_1_1);
		
		IDcard = new JTextField();
		IDcard.setColumns(10);
		IDcard.setBounds(138, 130, 222, 24);
		contentPane.add(IDcard);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(138, 165, 222, 24);
		contentPane.add(phone);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(138, 212, 222, 24);
		contentPane.add(address);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(138, 283, 222, 24);
		contentPane.add(email);
		
		account = new JTextField();
		account.setColumns(10);
		account.setBounds(138, 320, 222, 24);
		contentPane.add(account);
		
		password = new JPasswordField();
		password.setBounds(138, 351, 222, 21);
		contentPane.add(password);
		
		JComboBox state = new JComboBox();
		state.setModel(new DefaultComboBoxModel(new String[] {"运行", "关闭"}));
		state.setBounds(138, 388, 222, 23);
		contentPane.add(state);
		
		factoryName = new JTextField();
		factoryName.setColumns(10);
		factoryName.setBounds(138, 422, 222, 24);
		contentPane.add(factoryName);
		
		
	
	}
}