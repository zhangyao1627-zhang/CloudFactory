package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.alibaba.fastjson.JSONException;
import com.neuedu.controller.ProductMsgController;
import com.neuedu.dao.ProductMsgDao;
import com.neuedu.pojo.ProductMsgEntity;
import com.neuedu.table.ProductMsgTable;
import com.neuedu.utils.DataFileName;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ProductMsgadd extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField size;
	private JTextField msg;

	public ProductMsgadd(JTable table) {
		ProductMsgDao userdao = new ProductMsgDao();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String str[]=ProductMsgController.getTypeArray();
		JComboBox comboBox = new JComboBox(str);
		comboBox.setBounds(163, 186, 265, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("\u4EA7\u54C1\u6DFB\u52A0");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 25));
		lblNewLabel.setBounds(198, 33, 143, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2_1ew = new JLabel("\u4EA7\u54C1\u540D\u79F0");
		lblNewLabel_1_2_1ew.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_1_2_1ew.setBounds(31, 110, 101, 37);
		contentPane.add(lblNewLabel_1_2_1ew);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("\u4EA7\u54C1\u63CF\u8FF0");
		lblNewLabel_1_2_1.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(31, 312, 101, 37);
		contentPane.add(lblNewLabel_1_2_1);
		
		name = new JTextField();
		name.setBounds(163, 110, 265, 37);
		contentPane.add(name);
		name.setColumns(10);
		
		size = new JTextField();
		size.setColumns(10);
		size.setBounds(163, 246, 265, 37);
		contentPane.add(size);
		
		msg = new JTextField();
		msg.setColumns(10);
		msg.setBounds(163, 314, 265, 37);
		contentPane.add(msg);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductMsgEntity pm=new ProductMsgEntity();
				pm.setName(name.getText());
				//4最后记得处理一下符合框中运用以前内容的地方
				
				pm.setType((String)comboBox.getSelectedItem());
				pm.setSize(size.getText());
				pm.setMsg(msg.getText());
				pm.setNum(getRandomString(8));
				pm.setId(userdao.getMaxId());
				//2 创造相应的文件同时写进去
				DataUtils dta = new DataUtils();
				try {
					DataUtils.writeData(DataFileName.PRODUCTMSG.toString(), JsonUtil.objectToJson(pm));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				//3创造相应的表格
				ProductMsgTable pt=new ProductMsgTable(null);
				table.setModel(pt);
				table.updateUI();
			}
		});
		btnNewButton.setBounds(182, 395, 180, 53);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(332, 472, 143, 37);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_2_12_1 = new JLabel("\u4EA7\u54C1\u7C7B\u578B");
		lblNewLabel_1_2_12_1.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_1_2_12_1.setBounds(31, 177, 101, 37);
		contentPane.add(lblNewLabel_1_2_12_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u4EA7\u54C1\u89C4\u683C");
		lblNewLabel_1_1_1.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(31, 244, 101, 37);
		contentPane.add(lblNewLabel_1_1_1);

	}
	public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
}
