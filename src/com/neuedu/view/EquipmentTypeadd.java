package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.neuedu.dao.EquipmentTypeDao;
import com.neuedu.pojo.EquipmentTypeEntity;
import com.neuedu.table.EquipmentTypeTable;
import com.neuedu.utils.DataFileName;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;
import java.awt.Font;

public class EquipmentTypeadd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
	/**
	 * Create the frame.
	 */
	public EquipmentTypeadd(JTable table) {
		
		EquipmentTypeDao userdao = new EquipmentTypeDao();
		DataUtils dataUtils = new DataUtils();
		JsonUtil jsonUtil = new JsonUtil();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(183, 63, 215, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("产品类别");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel.setBounds(38, 55, 93, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EquipmentTypeEntity u=new EquipmentTypeEntity();
				u.setName(textField.getText());
				u.setId(userdao.getMaxId());
				//可能有点小问题的地方
					
					   try {
						dataUtils.writeData(DataFileName.EQUIPMENTTYPE.toString(), JsonUtil.objectToJson(u));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					   EquipmentTypeTable ut = new EquipmentTypeTable(null);
					   table.setModel(ut);
					   table.updateUI();							
			}
		});
		btnNewButton.setBounds(48, 166, 126, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(220, 166, 126, 39);
		contentPane.add(btnNewButton_1);
	}
}
