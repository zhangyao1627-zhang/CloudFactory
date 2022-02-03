package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.neuedu.dao.ProductDao;
import com.neuedu.pojo.ProductEntity;
import com.neuedu.table.ProductTable;
import com.neuedu.utils.DataFileName;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;
import com.neuedu.utils.ValidateUserInfo;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ProductTypeadd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public ProductTypeadd(JTable table) {
		ProductDao userdao = new ProductDao();
		DataUtils dataUtils = new DataUtils();
		JsonUtil jsonUtil = new JsonUtil();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(181, 94, 171, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("产品类别");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel.setBounds(55, 94, 92, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProductEntity u=new ProductEntity();
				u.setName(textField.getText());
				u.setId(userdao.getMaxId());
				//可能有点小问题的地方
					
					   try {
						dataUtils.writeData(DataFileName.PRODUCT.toString(), JsonUtil.objectToJson(u));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					   ProductTable ut = new ProductTable(null);
					   table.setModel(ut);
					   table.updateUI();							
			}
		});
		btnNewButton.setBounds(55, 179, 133, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(255, 181, 127, 32);
		contentPane.add(btnNewButton_1);
	}
}
