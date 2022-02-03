package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.OrderController;
import com.neuedu.controller.ProductMsgController;
import com.neuedu.dao.OrderDao;
import com.neuedu.pojo.OrderEntity;
import com.neuedu.pojo.UserEntity;
import com.neuedu.table.EquipmentTypeTable;
import com.neuedu.table.OrderTable;
import com.neuedu.table.ProductMsgTable;
import com.neuedu.utils.DataFileName;
import com.neuedu.utils.DataUtils;
import com.neuedu.utils.JsonUtil;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class trader extends JFrame {

	private JPanel contentPane;
	private JTable table;


	public trader() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 996, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		OrderDao orderdao = new OrderDao();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 120, 926, 315);
		contentPane.add(scrollPane);
		
		OrderTable utm=new OrderTable(null,0);
		table = new JTable(utm);
		scrollPane.setViewportView(table);
		
		
		JButton add = new JButton("新建");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OrderAdd(table).setVisible(true);
			}
		});
		add.setFont(new Font("楷体", Font.PLAIN, 20));
		add.setBounds(10, 30, 110, 45);
		contentPane.add(add);
		
		JButton modify = new JButton("修改");
		modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = table.getRowCount();
				for (int i = 0; i < num; i++) {
					if ((boolean) table.getValueAt(i, 0) == true) {
						String id=(String) table.getValueAt(i, 1);
						new OrderUpdate(id,table).setVisible(true);
					}
				}
				
			}
		});
		modify.setFont(new Font("楷体", Font.PLAIN, 20));
		modify.setBounds(141, 30, 110, 45);
		contentPane.add(modify);
		
		JButton delete = new JButton("删除");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> list=new ArrayList();
				int num = table.getRowCount();
				for (int i = 0; i < num; i++) {
					if ((boolean) table.getValueAt(i, 0) == true) {
						String id=(String) table.getValueAt(i, 1);
						list.add(id);
					}
				}
				OrderController.delele(list);
				JOptionPane.showMessageDialog(contentPane, "成功", "标题", JOptionPane.WARNING_MESSAGE);
				OrderTable ut=new OrderTable(null,0);
				table.setModel(ut);
				table.updateUI();
			}
		});
		delete.setFont(new Font("楷体", Font.PLAIN, 20));
		delete.setBounds(319, 30, 110, 45);
		contentPane.add(delete);
		
		JButton out = new JButton("发布");
		out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = table.getRowCount();
				for (int i = 0; i < num; i++) {
					if ((boolean) table.getValueAt(i, 0) == true) {
						String id=(String) table.getValueAt(i, 1);
						OrderEntity u = OrderController.getInstance().getOrderMsg(id);
						u.setState("已发布");
						try {
							orderdao.updateOrder(u);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(contentPane, "成功", "标题", JOptionPane.WARNING_MESSAGE);
						OrderTable ut=new OrderTable(null,0);
						table.setModel(ut);
						table.updateUI();		
					}
				}
			}
		});
		out.setFont(new Font("楷体", Font.PLAIN, 20));
		out.setBounds(458, 30, 110, 45);
		contentPane.add(out);
		
		JButton delete_1 = new JButton("返回");
		delete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		delete_1.setFont(new Font("楷体", Font.PLAIN, 20));
		delete_1.setBounds(845, 30, 110, 45);
		contentPane.add(delete_1);
		
		JButton out_1 = new JButton("中标情况");
		out_1.setFont(new Font("楷体", Font.PLAIN, 20));
		out_1.setBounds(611, 30, 137, 45);
		contentPane.add(out_1);
	}
}
