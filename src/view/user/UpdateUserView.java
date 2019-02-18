package view.user;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import entity.User;
import exception.UserException;

import objectfactory.ObjectFactory;

import manager.UserManager;

//import Background.BackgroundPanel05;

public class UpdateUserView extends JFrame {
	// 窗口中的组件当做类的属性
	JLabel userNameLb = new JLabel("用户名:");
	JTextField userNameTf = new JTextField();
	JLabel prePwdLb = new JLabel("原始密码:");
	JPasswordField prePwdPf = new JPasswordField();
	JLabel pwdLb = new JLabel("密     码:");
	JPasswordField pwdPf = new JPasswordField();
	JLabel confirmPwdLb = new JLabel("确认密码:");
	JPasswordField confirmPwdPf = new JPasswordField();
	JLabel nameLb = new JLabel("真实姓名:");
	JTextField nameTf = new JTextField();
	JLabel sexLb = new JLabel("性     别:");
	JComboBox cb = new JComboBox(); // 下拉列表框
	JLabel phoneNumLb = new JLabel("电话号码:");
	JTextField phoneNumTf = new JTextField();
	JLabel emailLb = new JLabel("电子邮箱:");
	JTextField emailTf = new JTextField();
	JLabel addressLb = new JLabel("住     址:");
	JTextField addressTf = new JTextField();

	JButton updateBt = new JButton("修改");
	JButton cancleBt = new JButton("取消");
	// 管理类
	UserManager userManager = (UserManager) ObjectFactory.getObject("usermanager");

	// 添加组件
	public void addComponent() {
		// 自定义布局
		setLayout(null);
		// 设置panel的布局
		userNameLb.setBounds(135, 10, 80, 50);
		userNameTf.setBounds(205, 20, 140, 25);
		prePwdLb.setBounds(135, 50, 80, 50);
		prePwdPf.setBounds(205, 60, 140, 25);
		pwdLb.setBounds(135, 90, 80, 50);
		pwdPf.setBounds(205, 100, 140, 25);
		confirmPwdLb.setBounds(135, 130, 80, 50);
		confirmPwdPf.setBounds(205, 140, 140, 25);
		nameLb.setBounds(135, 170, 80, 50);
		nameTf.setBounds(205, 180, 140, 25);
		sexLb.setBounds(135, 210, 80, 50);
		cb.setBounds(205, 220, 140, 25);
		phoneNumLb.setBounds(135, 250, 80, 50);
		phoneNumTf.setBounds(205, 260, 140, 25);
		emailLb.setBounds(135, 290, 80, 50);
		emailTf.setBounds(205, 300, 140, 25);
		addressLb.setBounds(135, 330, 80, 50);
		addressTf.setBounds(205, 340, 140, 25);
		updateBt.setBounds(210, 390, 60, 30);
		cancleBt.setBounds(260, 390, 60, 30);
		// 设置字体格式和大小
		prePwdLb.setFont(new Font("楷体", 1, 12));
		prePwdPf.setFont(new Font("楷体", 1, 10));
		pwdLb.setFont(new Font("楷体", 1, 12));
		pwdPf.setFont(new Font("楷体", 1, 10));
		confirmPwdLb.setFont(new Font("楷体", 1, 12));
		confirmPwdPf.setFont(new Font("楷体", 1, 10));
		nameLb.setFont(new Font("楷体", 1, 12));
		nameTf.setFont(new Font("楷体", 1, 10));
		sexLb.setFont(new Font("楷体", 1, 12));
		cb.setFont(new Font("楷体", 1, 11));
		phoneNumLb.setFont(new Font("楷体", 1, 12));
		phoneNumTf.setFont(new Font("楷体", 1, 10));
		emailLb.setFont(new Font("楷体", 1, 12));
		emailTf.setFont(new Font("楷体", 1, 10));
		addressLb.setFont(new Font("楷体", 1, 12));
		addressTf.setFont(new Font("楷体", 1, 10));
		updateBt.setFont(new Font("楷体", 1, 12));
		// 添加组件
		add(userNameLb);
		add(userNameTf);
		add(prePwdLb);
		add(prePwdPf);
		add(pwdLb);
		add(pwdPf);
		add(confirmPwdLb);
		add(confirmPwdPf);
		add(nameLb);
		add(nameTf);
		add(sexLb);
		add(cb);
		cb.addItem("男");
		cb.addItem("女");
		add(phoneNumLb);
		add(phoneNumTf);
		add(emailLb);
		add(emailTf);
		add(addressLb);
		add(addressTf);
		add(updateBt);
		add(cancleBt);
		// 设置组件值
		try {
			user = userManager.findUserByUserName(userName);
			userNameTf.setText(user.getUserName());
			userNameTf.setEditable(false);
			pwdPf.setText(user.getPassword());
			confirmPwdPf.setText(user.getPassword());
			nameTf.setText(user.getName());
			cb.setSelectedItem(user.getSex());
			phoneNumTf.setText(user.getPhoneNum());
			emailTf.setText(user.getEmail());
			addressTf.setText(user.getAddress());
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addListener() {

		updateBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String prePwd = String.valueOf(prePwdPf.getPassword()).trim();
				String pwd = String.valueOf(pwdPf.getPassword()).trim();
				String name = nameTf.getText();
				String sex = (String) cb.getSelectedItem();
				String phoneNum = phoneNumTf.getText();
				String email = emailTf.getText();
				String address = addressTf.getText();
				try {
					if (!prePwd.equals(user.getPassword())) {
						JOptionPane.showMessageDialog(null, "原始密码不正确");
						return;
					}
					if (!pwd.matches("\\w{2,16}")) {
						JOptionPane.showMessageDialog(null, "密码是2-16位字母数字");
						return;
					}
					if (!String.valueOf(confirmPwdPf.getPassword()).equals(pwd)) {
						JOptionPane.showMessageDialog(null, "两次输入密码不一致");
						return;
					}
					if (nameTf.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "真实姓名不能为空");
						return;
					}
					if (!name.matches("^[\u4E00-\u9Fa5]+$")) {
						JOptionPane.showMessageDialog(null, "真实姓名是中文");
						return;
					}
					if (!phoneNum.matches("\\d{11}")) {
						JOptionPane.showMessageDialog(null, "电话是11位数字");
						return;
					}
					user.setPassword(String.valueOf(pwdPf.getPassword()));
					user.setName(nameTf.getText().trim());
					user.setSex((String) (cb.getSelectedItem()));
					user.setPhoneNum(phoneNumTf.getText().trim());
					user.setEmail(emailTf.getText().trim());
					user.setAddress(addressTf.getText().trim());
					boolean b = userManager.updateUser(user);
					if (b) {
						JOptionPane.showMessageDialog(null, "修改成功");
						if (!prePwd.equals(pwd)){
							new UserLoginView("用户登陆");
						}else {
							new UserView("用户主页",userName);
						}

						dispose();
					}
				} catch (UserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		cancleBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new UserView("用户主页", userName);
				dispose();
			}
		});

	}

	// 窗口初始化
	public void initFrame() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		// User user=userManager.FindUserByUserName(userName);
		// pwdLb.setText(text);
	}

	String userName = null;
	User user = null;

	public UpdateUserView(String title, String userName) {
		super(title);
		this.userName = userName;
		// JPanel bgPanel = new BackgroundPanel05();
		// bgPanel.setLayout(new BorderLayout(0, 0));// 设置边界布局
		// BackgroundPanel05 backgroundPanel = new BackgroundPanel05(); //
		// 创建背景面板
		// bgPanel.add(backgroundPanel);// 添加背景面板
		// this.setContentPane(bgPanel);
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}

	public static void main(String[] args) {
		new UpdateUserView("a", "A");

	}
}
