package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.ProductMsgController;
import com.neuedu.dao.ProductMsgDao;
import com.neuedu.pojo.ProductMsgEntity;
import com.neuedu.table.ProductMsgTable;
import com.neuedu.utils.DataFileName;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;

public class ProductMsgupdate extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField size;
	private JTextField msg;
	
	public ProductMsgupdate(String id, JTable table) {
		
		ProductMsgDao userdao = new ProductMsgDao();
		ProductMsgEntity p = ProductMsgController.getProductMsg(id);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ProductMsgEntity pm = ProductMsgController.getProductMsg(id);
		
		String str[]=ProductMsgController.getTypeArray();		
		JComboBox comboBox = new JComboBox(str);
		comboBox.setBounds(163, 186, 265, 23);
		contentPane.add(comboBox);
		comboBox.setSelectedItem(pm.getType());
		
		JLabel lblNewLabel = new JLabel("\u4EA7\u54C1\u4FEE\u6539");
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
		
		name = new JTextField(pm.getName());
		name.setBounds(163, 110, 265, 37);
		contentPane.add(name);
		name.setColumns(10);
		
		size = new JTextField(pm.getSize());
		size.setColumns(10);
		size.setBounds(163, 246, 265, 37);
		contentPane.add(size);
		
		msg = new JTextField(pm.getMsg());
		msg.setColumns(10);
		msg.setBounds(163, 314, 265, 37);
		contentPane.add(msg);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductMsgEntity pm = new ProductMsgEntity();
				pm.setName(name.getText());
				pm.setSize(size.getText());
				pm.setType((String) comboBox.getSelectedItem());
				pm.setMsg(msg.getText());
				pm.setId(p.getId());
				pm.setNum(p.getNum());
				try {
					ProductMsgController.update(pm);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(contentPane, "成功", "标题", JOptionPane.WARNING_MESSAGE);
				ProductMsgTable pt = new ProductMsgTable(null);
				table.setModel(pt);
				table.updateUI();
			}
		});
		btnNewButton.setBounds(163, 383, 178, 47);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(318, 459, 163, 37);
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
