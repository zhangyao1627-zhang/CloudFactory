package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.EquipmentManagerController;
import com.neuedu.controller.ProductMsgController;
import com.neuedu.dao.EquipmentManagerDao;
import com.neuedu.table.EquipmentManagerTable;
import com.neuedu.utils.DataFileName;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;
import com.neuedu.pojo.EquipmentManagerEntity;
import com.neuedu.pojo.ProductMsgEntity;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class EquipmentManagerupdate extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldnum;
	private JTextField textFieldname;
	private JTextField textFieldsize;
	private JTextField textFielddetial;

	public EquipmentManagerupdate(String id, JTable table) {
		EquipmentManagerEntity p = EquipmentManagerController.getEquipmentMsg(id);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		EquipmentManagerEntity pm = EquipmentManagerController.getEquipmentManagerMsg(id);
		
		String str[]=EquipmentManagerController.getTypeArray();
		JComboBox comboBox = new JComboBox(str);
		comboBox.setBounds(200, 226, 219, 31);
		contentPane.add(comboBox);
		comboBox.setSelectedItem(pm.getType());
		
		JLabel lblNewLabel = new JLabel("设备编号");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel.setBounds(61, 110, 93, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("设备名称");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(61, 164, 93, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("设备类型");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(61, 226, 93, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("设备规格");
		lblNewLabel_3.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(61, 289, 93, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("设备描述");
		lblNewLabel_4.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(61, 355, 93, 38);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquipmentManagerEntity em=new EquipmentManagerEntity();
				em.setId(p.getId());
				em.setName(textFieldname.getText());
			    em.setSize(textFieldsize.getText());
			    em.setNum(p.getNum());
			    em.setType((String)comboBox.getSelectedItem());
			    em.setDetail(textFielddetial.getText());
				em.setBelong(p.getBelong());
				em.setCreator(p.getCreator());
				em.setHireState(p.getHireState());
				em.setState(p.getState());
				try {
					EquipmentManagerController.updateEquipment(em);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(contentPane, "成功", "标题", JOptionPane.WARNING_MESSAGE);
				EquipmentManagerTable pt = new EquipmentManagerTable(null,0,null);
				table.setModel(pt);
				table.updateUI();
				
			}
		});
		btnNewButton.setBounds(113, 440, 128, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(325, 440, 128, 38);
		contentPane.add(btnNewButton_1);
		
		textFieldnum = new JTextField(pm.getNum());
		textFieldnum.setBounds(200, 110, 219, 36);
		contentPane.add(textFieldnum);
		textFieldnum.setColumns(10);
		
		textFieldname = new JTextField(pm.getName());
		textFieldname.setBounds(200, 164, 219, 38);
		contentPane.add(textFieldname);
		textFieldname.setColumns(10);
		
		textFieldsize = new JTextField(pm.getSize());
		textFieldsize.setBounds(197, 289, 222, 38);
		contentPane.add(textFieldsize);
		textFieldsize.setColumns(10);
		
		textFielddetial = new JTextField(pm.getDetail());
		textFielddetial.setBounds(197, 358, 222, 38);
		contentPane.add(textFielddetial);
		textFielddetial.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("设备更新");
		lblNewLabel_5.setFont(new Font("华文楷体", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(185, 20, 141, 54);
		contentPane.add(lblNewLabel_5);
		
		
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
