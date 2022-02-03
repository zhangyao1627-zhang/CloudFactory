package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.ProductController;
import com.neuedu.table.ProductTable;


import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ProductType extends JFrame {

	private JPanel contentPane;
	private JTextField searchContent;
	private JTable table;
	private ProductController productEntityController=ProductController.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductType frame = new ProductType();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProductType() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ProductTable utm=new ProductTable(null);
		table = new JTable(utm);
		
		searchContent = new JTextField();
		searchContent.setBounds(48, 42, 143, 40);
		contentPane.add(searchContent);
		searchContent.setColumns(10);
		
		JButton btnNewButton = new JButton("类别名称");
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=searchContent.getText();
				ProductTable ut=new ProductTable(name);
				table.setModel(ut);
				table.updateUI();
			}
		});
		btnNewButton.setBounds(223, 42, 143, 40);
		contentPane.add(btnNewButton);
		
		JButton reset = new JButton("重置");
		reset.setFont(new Font("华文楷体", Font.PLAIN, 17));
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchContent.setText("");
				ProductTable ut=new ProductTable(null);
				table.setModel(ut);
				table.updateUI();
			}
		});
		reset.setBounds(417, 42, 125, 40);
		contentPane.add(reset);
		
		JButton btnNewButton_2 = new JButton("返回");
		btnNewButton_2.setFont(new Font("华文楷体", Font.PLAIN, 17));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(564, 42, 113, 40);
		contentPane.add(btnNewButton_2);
		
		JButton add = new JButton("新建");
		add.setFont(new Font("楷体", Font.PLAIN, 17));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProductTypeadd(table).setVisible(true);
			}
		});
		add.setBounds(48, 102, 131, 40);
		contentPane.add(add);
		
		JButton delete = new JButton("删除");
		delete.setFont(new Font("华文楷体", Font.PLAIN, 17));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> list=new ArrayList();
				int num = table.getRowCount();
				//把打对勾的弄到一起
				for (int i = 0; i < num; i++) {
					if ((boolean) table.getValueAt(i, 0) == true) {
						String id=(String) table.getValueAt(i, 1);
						list.add(id);
					}
				}
				ProductController.deleteProduct(list);
				JOptionPane.showMessageDialog(contentPane, "成功", "标题", JOptionPane.WARNING_MESSAGE);
				ProductTable ut=new ProductTable(null);
				table.setModel(ut);
				table.updateUI();
			}
		});
		delete.setBounds(205, 102, 131, 40);
		contentPane.add(delete);
		
		JButton modify = new JButton("修改");
		modify.setFont(new Font("华文楷体", Font.PLAIN, 17));
		modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = table.getRowCount();
				for (int i = 0; i < num; i++) {
					if ((boolean) table.getValueAt(i, 0) == true) {
						String id=(String) table.getValueAt(i, 1);
						new ProductTypeupdate(id,table).setVisible(true);;
					}
				}
			}
		});
		modify.setBounds(396, 102, 113, 40);
		contentPane.add(modify);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 172, 629, 265);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
	}
	
}
