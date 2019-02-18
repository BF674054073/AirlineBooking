package view.user;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ChangeInfoView extends JFrame implements Runnable{
	//窗口中的组件当做类的属性
	JLabel pwdLb = new JLabel("密     码:");
	JPasswordField pwdPf = new JPasswordField();
	JLabel confirmPwdLb = new JLabel("确认密码:");
	JPasswordField confirmPwdPf = new JPasswordField();
	JLabel nameLb = new JLabel("真实姓名:");
	JTextField  nameTf = new JTextField();
	JLabel sexLb = new JLabel("性     别:");
	JComboBox cb = new JComboBox();	//下拉列表框
	JLabel phoneNumLb = new JLabel("电话号码:");
	JTextField phoneNumTf = new JTextField();
	JLabel emailLb = new JLabel("电子邮箱:");
	JTextField emailTf = new JTextField();
	JLabel addressLb = new JLabel("住     址:");
	JTextField addressTf = new JTextField();
	
	JButton changeBt = new JButton("修改");
	//窗口初始化
	public void initFrame() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//添加组件
	public void addComponent() {
		//自定义布局
		setLayout(null);
		// 设置panel的布局
		pwdLb.setBounds(135, 70,80, 50);pwdPf.setBounds(205, 80, 140, 25);
		confirmPwdLb.setBounds(135, 110,80, 50);confirmPwdPf.setBounds(205, 120, 140, 25);
		nameLb.setBounds(135, 150,80, 50);nameTf.setBounds(205, 160, 140, 25);
		sexLb.setBounds(135, 190,80, 50);cb.setBounds(205, 200, 140, 25);
		phoneNumLb.setBounds(135, 230,80, 50);phoneNumTf.setBounds(205,240,140, 25);
		emailLb.setBounds(135, 270,80, 50);emailTf.setBounds(205, 280, 140, 25);
		addressLb.setBounds(135, 310,80, 50);addressTf.setBounds(205, 320, 140,25);
		changeBt.setBounds(240, 370,60, 30);
		//设置字体格式和大小
		pwdLb.setFont(new Font("楷体",1,12));pwdPf.setFont(new Font("楷体",1,10));
		confirmPwdLb.setFont(new Font("楷体",1,12));confirmPwdPf.setFont(new Font("楷体",1,10));
		nameLb.setFont(new Font("楷体",1,12));nameTf.setFont(new Font("楷体",1,10));
		sexLb.setFont(new Font("楷体",1,12));cb.setFont(new Font("楷体",1,11));
		phoneNumLb.setFont(new Font("楷体",1,12));phoneNumTf.setFont(new Font("楷体",1,10));
		emailLb.setFont(new Font("楷体",1,12));emailTf.setFont(new Font("楷体",1,10));
		addressLb.setFont(new Font("楷体",1,12));addressTf.setFont(new Font("楷体",1,10));
		changeBt.setFont(new Font("楷体",1,12));
		//添加组件
		add(pwdLb);add(pwdPf);
		add(confirmPwdLb);add(confirmPwdPf);
		add(nameLb);add(nameTf);
		add(sexLb);add(cb);cb.addItem("男");cb.addItem("女");cb.setSelectedItem("男");
		add(phoneNumLb);add(phoneNumTf);
		add(emailLb);add(emailTf);
		add(addressLb);add(addressTf);
		add(changeBt);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public boolean addListener() {
		changeBt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		return rootPaneCheckingEnabled;
	}
	public ChangeInfoView(String title) {
		super(title);	
//		JPanel bgPanel = new BackgroundPanel05();
//	    bgPanel.setLayout(new BorderLayout(0, 0));// 设置边界布局
//	    BackgroundPanel05 backgroundPanel = new BackgroundPanel05(); // 创建背景面板
//	    bgPanel.add(backgroundPanel);// 添加背景面板
////	    this.setContentPane(bgPanel);
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}
}
