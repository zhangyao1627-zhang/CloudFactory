package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.EquipmentTypeController;
import com.neuedu.pojo.EquipmentTypeEntity;
import com.neuedu.table.EquipmentTypeTable;
import java.awt.Font;;

public class EquipmentTypeupdate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
	public EquipmentTypeupdate(String id ,JTable table) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("产品类别");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel.setBounds(28, 85, 135, 33);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(173, 85, 241, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("确认修改");
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquipmentTypeEntity u=new EquipmentTypeEntity();
				u.setName(textField.getText());
				u.setId(id);
				try {
					EquipmentTypeController.updateEquipment(u);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(contentPane, "成功", "标题", JOptionPane.WARNING_MESSAGE);
				EquipmentTypeTable ut=new EquipmentTypeTable(null);
				table.setModel(ut);
				table.updateUI();
			}
		});
		btnNewButton.setBounds(79, 178, 127, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(266, 178, 127, 44);
		contentPane.add(btnNewButton_1);
	}
}
