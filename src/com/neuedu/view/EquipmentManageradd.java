package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.EquipmentManagerController;
import com.neuedu.dao.EquipmentManagerDao;
import com.neuedu.pojo.UserEntity;
import com.neuedu.table.EquipmentManagerTable;
import com.neuedu.utils.DataFileName;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;
import com.neuedu.pojo.EquipmentManagerEntity;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class EquipmentManageradd extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldnum;
	private JTextField textFieldname;
	private JTextField textFieldsize;
	private JTextField textFielddetial;

	public EquipmentManageradd(JTable table,int power,UserEntity u) {
		EquipmentManagerDao userdao = new EquipmentManagerDao();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String str[]=EquipmentManagerController.getTypeArray();
		JComboBox comboBox = new JComboBox(str);
		comboBox.setBounds(203, 152, 172, 24);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("设备编号");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel.setBounds(61, 41, 93, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("设备名称");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(61, 98, 93, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("设备类型");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(61, 154, 93, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("设备规格");
		lblNewLabel_3.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(61, 212, 93, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("设备描述");
		lblNewLabel_4.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(61, 270, 93, 32);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquipmentManagerEntity em=new EquipmentManagerEntity();
				em.setId(userdao.getMaxId());
				em.setName(textFieldname.getText());
			    em.setSize(textFieldsize.getText());
			    em.setNum(getRandomString(8));
			    em.setType((String)comboBox.getSelectedItem());
			    em.setDetail(textFielddetial.getText());
				em.setState("关机");
				//1 power的作用(直接将整体代码分成三个部分)
				if(power==0){
					em.setHireState("未被租用");
					em.setCreator("0");
					em.setBelong("");
				}else if(power==1){
					em.setBelong(u.getFactoryName());	
					em.setHireState("工厂设备");
					em.setCreator(u.getId());
				}
				DataUtils dta = new DataUtils();
				try {
					DataUtils.writeData(DataFileName.EQUIPMENTMANAGER.toString(), JsonUtil.objectToJson(em));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				if(power==0){
					EquipmentManagerTable et=new EquipmentManagerTable(null,0,null);
					table.setModel(et);
					table.updateUI();	
				}else if(power==1){
						EquipmentManagerTable et=new EquipmentManagerTable(null,1,u.getFactoryName());
						table.setModel(et);
						table.updateUI();	
					}
			}
		});
		btnNewButton.setBounds(47, 336, 135, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(247, 336, 128, 41);
		contentPane.add(btnNewButton_1);
		
		textFieldnum = new JTextField();
		textFieldnum.setBounds(200, 38, 164, 32);
		contentPane.add(textFieldnum);
		textFieldnum.setColumns(10);
		
		textFieldname = new JTextField();
		textFieldname.setBounds(200, 95, 172, 32);
		contentPane.add(textFieldname);
		textFieldname.setColumns(10);
		
		textFieldsize = new JTextField();
		textFieldsize.setBounds(200, 209, 175, 32);
		contentPane.add(textFieldsize);
		textFieldsize.setColumns(10);
		
		textFielddetial = new JTextField();
		textFielddetial.setBounds(200, 267, 175, 35);
		contentPane.add(textFielddetial);
		textFielddetial.setColumns(10);
		
		
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
