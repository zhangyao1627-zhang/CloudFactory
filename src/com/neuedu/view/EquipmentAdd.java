package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.EquipmentManagerController;

import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;

public class EquipmentAdd extends JFrame implements ActionListener {

	private JPanel contentPane;
	private MyJPanel addPanel;
	private int index = 0;
	private JPanel panel;
	private JScrollPane scrollPane;
	private LinkedList<MyJPanel> addList = new LinkedList<>();

	
	public EquipmentAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String str[]=EquipmentManagerController.getTypeArray();
		
		panel = new JPanel();
		panel.setBounds(10, 14, 645, 279);
		panel.setLayout(new BoxLayout(panel,  BoxLayout.Y_AXIS));//盒子布局.从上到下
		contentPane.add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 234, 503, -219);
		contentPane.add(scrollPane);
		
		JButton add = new JButton("\u6DFB\u52A0");
		add.setFont(new Font("楷体", Font.PLAIN, 15));
		add.setBounds(55, 303, 113, 27);
		contentPane.add(add);
		add.addActionListener(this);
		
		JButton delete = new JButton("\u5220\u9664");
		delete.setFont(new Font("楷体", Font.PLAIN, 15));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(panel.getComponentCount()>0) { // 得到panel里的MyJPanel的组件数量
					panel.remove(panel.getComponentCount()-1);//删除末尾的一个组件 ,
					index--;
					addList.removeLast();
					myUpdateUI();
				}
			}
		});
		delete.setBounds(284, 303, 113, 27);
		contentPane.add(delete);
		
		JButton submit = new JButton("\u786E\u5B9A");
		submit.setFont(new Font("楷体", Font.PLAIN, 15));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//点击确定按钮时，获得所有的值
				
			}
		});
		submit.setBounds(512, 303, 113, 27);
		contentPane.add(submit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		addPanel = new MyJPanel(index);
		panel.add(addPanel);//添加1个自己定义的面板组件
		index++;//自加1
		addList.addLast(addPanel);
		myUpdateUI();//刷新界面
	}
	
	//刷新界面函数
	private void myUpdateUI() {
		SwingUtilities.updateComponentTreeUI(this);//添加或删除组件后,更新窗口
		JScrollBar jsb = scrollPane.getVerticalScrollBar();//得到垂直滚动条
		jsb.setValue(jsb.getMaximum());//把滚动条位置设置到最下面
	}
}
