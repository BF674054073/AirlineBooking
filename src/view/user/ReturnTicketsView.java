package view.user;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.MainView;

//import Background.BackgroundPanel07;
//import Background.BackgroundPanel09;

public class ReturnTicketsView extends JFrame {
	//窗口中的组件当做类的属性
	JLabel orderNumLb = new JLabel("订 单 号 :");
	JTextField orderNumTf = new JTextField();
	JLabel idLb = new JLabel("身份证号:");
	JTextField  idTf = new JTextField();
	JLabel nameLb = new JLabel("客户姓名:");
	JTextField  nameTf = new JTextField();
	JLabel amountLb = new JLabel("票     数:");
	JTextField amountTf = new JTextField();
	
	JButton returnBt = new JButton("退票");
	JButton resetBt = new JButton("重填");

	//窗口初始化
	public void initFrame() {
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//添加组件
	public void addComponent() {
		//自定义布局
		setLayout(null);
		// 设置panel的布局
		orderNumLb.setBounds(180, 70,80, 50);orderNumTf.setBounds(250, 80, 140, 25);
		idLb.setBounds(180, 130,80, 50);idTf.setBounds(250, 140, 140, 25);
		nameLb.setBounds(180, 190,80, 50);nameTf.setBounds(250, 200, 140, 25);
		amountLb.setBounds(180, 250,80, 50);amountTf.setBounds(250, 260, 140, 25);
		returnBt.setBounds(220,310,60, 30);resetBt.setBounds(310, 310, 60, 30);

		//设置字体格式和大小
		orderNumLb.setFont(new Font("楷体",1,12));orderNumTf.setFont(new Font("楷体",1,11));
		idLb.setFont(new Font("楷体",1,12));idTf.setFont(new Font("楷体",1,10));
		nameLb.setFont(new Font("楷体",1,12));nameTf.setFont(new Font("楷体",1,10));
		amountLb.setFont(new Font("楷体",1,12));amountTf.setFont(new Font("楷体",1,10));
		returnBt.setFont(new Font("楷体",1,11));resetBt.setFont(new Font("楷体",1,11));

		//添加组件
		add(orderNumLb);add(orderNumTf);
		add(idLb);add(idTf);
		add(nameLb);add(nameTf);
		add(amountLb);add(amountTf);
		add(returnBt);add(resetBt);

	}

	
	public void addListener() {
	}
	public ReturnTicketsView(String title) {
		super(title);	
//		JPanel bgPanel = new BackgroundPanel09();
//	    bgPanel.setLayout(new BorderLayout(0, 0));// 设置边界布局
//	    BackgroundPanel09 backgroundPanel = new BackgroundPanel09(); // 创建背景面板
//	    bgPanel.add(backgroundPanel);// 添加背景面板
//	    this.setContentPane(bgPanel);
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}
}
