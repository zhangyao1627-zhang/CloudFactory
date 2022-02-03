package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;

import com.neuedu.controller.EquipmentManagerController;

import javax.swing.JComboBox;

public class MyJPanel extends JPanel {

	private JComboBox comboBox;
	private JXDatePicker dp;
	
	public MyJPanel(int index) {
		setLayout(null);
		
		JLabel label = new JLabel("设备名称");
		label.setBounds(10, 9, 88, 19);
		add(label);
		
		String str[]=EquipmentManagerController.getTypeArray();
		JComboBox comboBox = new JComboBox(str);
		comboBox.setBounds(108, 5, 94, 23);
		add(comboBox);		
		
		JLabel label_1 = new JLabel("开始时间");
		label_1.setBounds(212, 9, 63, 19);
		add(label_1);
		
		Date date = new Date();
		JXDatePicker dp = new JXDatePicker();
		dp.setBounds(285, 7, 95, 23);
		
		dp.setDate(date);
		dp.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
		add(dp);
		Date d = dp.getDate();
		
		JLabel label_1_1 = new JLabel("结束时间");
		label_1_1.setBounds(394, 9, 63, 19);
		add(label_1_1);
		
		Date date1 = new Date();
		JXDatePicker dp1 = new JXDatePicker();
		dp1.setBounds(467, 7, 95, 23);
		
		dp1.setDate(date1);
		dp1.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
		add(dp1);
		Date d1 = dp1.getDate();
		
	}
	
	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JXDatePicker getDp() {
		return dp;
	}

	public void setDp(JXDatePicker dp) {
		this.dp = dp;
	}
}
