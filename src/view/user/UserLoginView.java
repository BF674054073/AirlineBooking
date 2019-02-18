package view.user;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import objectfactory.ObjectFactory;

import manager.UserManager;
import entity.User;
import exception.UserException;

//import exception.UserException;
//import manager.UserManager;
//import objectfactory.ObjectFactory;

public class UserLoginView extends JFrame {
	// 窗口中的组件当做类的属性
	JLabel userNameLb = new JLabel("用户名:");
	JTextField userNameTf = new JTextField();
	JLabel pwdLb = new JLabel("密  码:");
	JPasswordField pwdPf = new JPasswordField();
	JButton loginBt = new JButton("登录");
	JButton resetBt = new JButton("重置");

	UserManager userManager = (UserManager) ObjectFactory.getObject("usermanager");

	public void addComponent() {
		// 自定义布局
		setLayout(null);
		// 设置panel的布局
		userNameLb.setBounds(70, 50, 60, 40);
		userNameTf.setBounds(120, 60, 150, 25);
		pwdLb.setBounds(70, 100, 60, 40);
		pwdPf.setBounds(120, 110, 150, 25);
		resetBt.setBounds(90, 160, 60, 30);
		loginBt.setBounds(200, 160, 60, 30);
		// 设置字体格式和大小
		userNameLb.setFont(new Font("楷体", 1, 12));
		userNameTf.setFont(new Font("楷体", 1, 12));
		pwdLb.setFont(new Font("楷体", 1, 12));
		pwdPf.setFont(new Font("楷体", 1, 12));
		loginBt.setFont(new Font("楷体", 1, 12));
		resetBt.setFont(new Font("楷体", 1, 12));
		// 添加组件
		add(userNameLb);
		add(userNameTf);
		add(pwdLb);
		add(pwdPf);
		add(loginBt);
		add(resetBt);
	}

	List<User> userList = null;

	public void addListener() {
		try {
			userList = userManager.findAllUsers();
			for (User user : userList) {
				System.out.println(user);
			}
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (userNameTf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "用户名不能为空");
					return;
				}
				if (pwdPf.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "密码不能为空");
					return;
				}
				for (User user : userList) {
					if (userNameTf.getText().trim().equals(user.getUserName())) {
						if (String.valueOf(pwdPf.getPassword()).equals(user.getPassword())) {
							new UserView("用户主页", user.getUserName());
							dispose();
							return;
						} else {
							JOptionPane.showMessageDialog(null, "密码错误");
							return;
						}
					}
				}
				JOptionPane.showMessageDialog(null, "用户名错误");
				return;
			}
		});

		resetBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				userNameTf.setText("");
				pwdPf.setText("");
			}
		});
	}

	// 窗口初始化
	public void initFrame() {
		setSize(360, 240);
		setLocationRelativeTo(null);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public UserLoginView(String title) {
		super(title);
		// JPanel bgPanel = new BackgroundPanel03();
		// bgPanel.setLayout(new BorderLayout(0, 0));// 设置边界布局
		// BackgroundPanel03 backgroundPanel = new BackgroundPanel03(); //
		// 创建背景面板
		// bgPanel.add(backgroundPanel);// 添加背景面板
		// this.setContentPane(bgPanel);
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}

}
