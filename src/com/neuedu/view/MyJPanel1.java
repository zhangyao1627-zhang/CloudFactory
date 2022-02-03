package com.neuedu.view;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.neuedu.controller.EquipmentManagerController;

public class MyJPanel1 extends JPanel{
	private JComboBox comboBox;
	private JTextField capacity;
	public MyJPanel1(int index) {
		JLabel label = new JLabel("\u4EA7\u54C1\u7F16\u53F7\uFF1A" + index);
		label.setBounds(14, 13, 75, 18);
		add(label);
		
		String str[]=EquipmentManagerController.getTypeArray();
		JComboBox comboBox = new JComboBox(str);
		comboBox.setBounds(103, 10, 86, 24);
		add(comboBox);
			
		JLabel label_1 = new JLabel("\u4EA7\u80FD\uFF1A");
		label_1.setBounds(203, 13, 45, 18);
		add(label_1);
		
		capacity = new JTextField();
		capacity.setBounds(268, 10, 86, 24);
		add(capacity);
		capacity.setColumns(10);
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}
	public JTextField getCapacity() {
		return capacity;
	}
	public void setCapacity(JTextField capacity) {
		this.capacity = capacity;
	}
	
}
