package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.OrderController;
import com.neuedu.pojo.OrderEntity;
import java.awt.Font;

public class OrderStart extends JFrame implements ActionListener {

	private JPanel contentPane;
	private MyJPanel addPanel;
	private int index = 0;
	private JPanel panel;
	private JScrollPane scrollPane;
	private LinkedList<MyJPanel> addList = new LinkedList<>();


	public OrderStart(OrderEntity u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel = new JPanel();
		panel.setBounds(0, 0, 688, 355);
		panel.setLayout(new BoxLayout(panel,  BoxLayout.Y_AXIS));//盒子布局.从上到下
		contentPane.add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 234, 503, -219);
		contentPane.add(scrollPane);
		
		JButton add = new JButton("\u6DFB\u52A0");
		add.setFont(new Font("楷体", Font.PLAIN, 20));
		add.setBounds(0, 381, 113, 49);
		contentPane.add(add);
		add.addActionListener(this);
		
		JButton delete = new JButton("\u5220\u9664");
		delete.setFont(new Font("楷体", Font.PLAIN, 20));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//删除
				if(panel.getComponentCount()>0) { // 得到panel里的MyJPanel的组件数量
					panel.remove(panel.getComponentCount()-1);//删除末尾的一个组件 ,
					index--;
					addList.removeLast();
					myUpdateUI();
				}
			}
		});
		delete.setBounds(148, 381, 113, 49);
		contentPane.add(delete);
		
		JButton submit = new JButton("\u786E\u5B9A");
		submit.setFont(new Font("楷体", Font.PLAIN, 20));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//点击确定按钮时，获得所有的值
			}
		});
		submit.setBounds(292, 381, 113, 49);
		contentPane.add(submit);
		
		JButton submit_1 = new JButton("完成相应任务");
		submit_1.setFont(new Font("楷体", Font.PLAIN, 15));
		submit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				u.setState("已完成");
				try {
					OrderController.updateOrder(u);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		submit_1.setBounds(415, 383, 133, 49);
		contentPane.add(submit_1);
		
		JButton submit_2 = new JButton("返回");
		submit_2.setFont(new Font("楷体", Font.PLAIN, 20));
		submit_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		submit_2.setBounds(575, 381, 113, 49);
		contentPane.add(submit_2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addPanel = new MyJPanel(index);
		panel.add(addPanel);//添加1个自己定义的面板组件
		index++;//自加1
		addList.addLast(addPanel);
		myUpdateUI();//刷新界面
	}
	private void myUpdateUI() {
		SwingUtilities.updateComponentTreeUI(this);//添加或删除组件后,更新窗口
		JScrollBar jsb = scrollPane.getVerticalScrollBar();//得到垂直滚动条
		jsb.setValue(jsb.getMaximum());//把滚动条位置设置到最下面
	}
}
