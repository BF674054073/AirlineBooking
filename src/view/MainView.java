package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import Background.BackgroundPanel01;
import view.admin.AdminLoginView;
import view.user.UserLoginView;
import view.user.UserRegView;

public class MainView extends JFrame {
	// 窗口中的组件当做类的属性
	JButton userLoginBt = new JButton("会员登录");
	JButton userRegBt = new JButton("会员注册");
	JButton adminEntranceBt = new JButton("管理员通道");

	public void addComponent() {
		// 自定义布局
		setLayout(null);
		// 设置panel的布局
		userLoginBt.setBounds(300, 530, 82, 30);
		userRegBt.setBounds(400, 530, 82, 30);
		adminEntranceBt.setBounds(500, 530, 94, 30);
		// 设置字体格式和大小
		userLoginBt.setFont(new Font("楷体", 1, 11));
		userRegBt.setFont(new Font("楷体", 1, 11));
		adminEntranceBt.setFont(new Font("楷体", 1, 11));
		// 添加组件
		add(userLoginBt);
		add(userRegBt);
		add(adminEntranceBt);
	}

	// 事件响应
	public void addListener() {
		userRegBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new UserRegView("用户注册");
			}
		});
		userLoginBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new UserLoginView("用户登陆");
			}
		});
		adminEntranceBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new AdminLoginView("管理员登陆");
			}
		});
	}

	// 窗口初始化
	public void initFrame() {
		setSize(900, 600);
		setLocationRelativeTo(null);
	}

	public MainView(String title) {
		super(title);
		// JPanel bgPanel = new BackgroundPanel01();
		// bgPanel.setLayout(new BorderLayout(0, 0));// 设置边界布局
		// BackgroundPanel01 backgroundPanel = new BackgroundPanel01(); //
		// 创建背景面板
		// bgPanel.add(backgroundPanel);// 添加背景面板
		// this.setContentPane(bgPanel);
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}

	public static void main(String[] args) {
		new MainView("航空订票系统");

	}
}
