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

import manager.UserManager;

import entity.User;
import exception.UserException;

import objectfactory.ObjectFactory;

//import Background.BackgroundPanel02;
//import entity.User;
//import exception.UserException;
//import manager.UserManager;

public class UserRegView extends JFrame {
	// 窗口中的组件当做类的属性
	JLabel userNameLb = new JLabel("用 户 名:");
	JTextField userNameTf = new JTextField();
	JLabel userNameCue = new JLabel("*用户名长度为6-14的字母数字");
	JLabel pwdLb = new JLabel("密     码:");
	JPasswordField pwdPf = new JPasswordField();
	JLabel pwdCue = new JLabel("*密码长度为6-14的数字");
	JLabel confirmPwdLb = new JLabel("确认密码:");
	JPasswordField confirmPwdPf = new JPasswordField();
	JLabel confirmPwdCue = new JLabel("*密码必须保持一致");
	JLabel nameLb = new JLabel("真实姓名:");
	JTextField nameTf = new JTextField();
	JLabel nameCue = new JLabel("*应为真实姓名");
	JLabel idLb = new JLabel("身份证号:");
	JTextField idTf = new JTextField();
	JLabel idCue = new JLabel("*真实身份证号");
	JLabel sexLb = new JLabel("性     别:");
	JComboBox cb = new JComboBox(); // 下拉列表框
	JLabel phoneNumLb = new JLabel("手机号码:");
	JTextField phoneNumTf = new JTextField();
	JLabel phoneNumCue = new JLabel("*手机号码长度为11位的数字");
	JLabel emailLb = new JLabel("电子邮箱:");
	JTextField emailTf = new JTextField();
	JLabel emailCue = new JLabel("*选填");
	JLabel addressLb = new JLabel("住     址:");
	JTextField addressTf = new JTextField();
	JLabel addressCue = new JLabel("*选填");

	JButton submitBt = new JButton("提交");
	JButton resetBt = new JButton("重置");

	// 管理类
	UserManager userManager = (UserManager) ObjectFactory.getObject("usermanager");

	// 窗口初始化
	public void initFrame() {
		setSize(900, 600);
		setLocationRelativeTo(null);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// 添加组件
	public void addComponent() {
		// 自定义布局
		setLayout(null);
		// 设置panel的布局
		userNameLb.setBounds(255, 70, 80, 50);
		userNameTf.setBounds(320, 80, 140, 25);
		userNameCue.setBounds(480, 75, 250, 40);
		pwdLb.setBounds(255, 110, 80, 50);
		pwdPf.setBounds(320, 120, 140, 25);
		pwdCue.setBounds(480, 115, 250, 40);
		confirmPwdLb.setBounds(255, 150, 80, 50);
		confirmPwdPf.setBounds(320, 160, 140, 25);
		confirmPwdCue.setBounds(480, 155, 250, 40);
		nameLb.setBounds(255, 190, 80, 50);
		nameTf.setBounds(320, 200, 140, 25);
		nameCue.setBounds(480, 195, 250, 40);
		idLb.setBounds(255, 230, 80, 50);
		idTf.setBounds(320, 240, 140, 25);
		idCue.setBounds(480, 235, 250, 40);
		sexLb.setBounds(255, 270, 80, 50);
		cb.setBounds(320, 280, 140, 25);
		phoneNumLb.setBounds(255, 310, 80, 50);
		phoneNumTf.setBounds(320, 320, 140, 25);
		phoneNumCue.setBounds(480, 315, 250, 40);
		emailLb.setBounds(255, 350, 80, 50);
		emailTf.setBounds(320, 360, 140, 25);
		emailCue.setBounds(480, 355, 250, 40);
		addressLb.setBounds(255, 390, 80, 50);
		addressTf.setBounds(320, 400, 140, 25);
		addressCue.setBounds(480, 395, 250, 40);
		submitBt.setBounds(330, 440, 60, 30);
		resetBt.setBounds(490, 440, 60, 30);
		// 设置字体格式和大小
		userNameLb.setFont(new Font("楷体", 1, 12));
		userNameTf.setFont(new Font("楷体", 1, 10));
		userNameCue.setFont(new Font("楷体", 1, 10));
		pwdLb.setFont(new Font("楷体", 1, 12));
		pwdPf.setFont(new Font("楷体", 1, 10));
		pwdCue.setFont(new Font("楷体", 1, 10));
		confirmPwdLb.setFont(new Font("楷体", 1, 12));
		confirmPwdPf.setFont(new Font("楷体", 1, 10));
		confirmPwdCue.setFont(new Font("楷体", 1, 10));
		nameLb.setFont(new Font("楷体", 1, 12));
		nameTf.setFont(new Font("楷体", 1, 10));
		nameCue.setFont(new Font("楷体", 1, 10));
		idLb.setFont(new Font("楷体", 1, 12));
		idTf.setFont(new Font("楷体", 1, 10));
		idCue.setFont(new Font("楷体", 1, 10));
		sexLb.setFont(new Font("楷体", 1, 12));
		cb.setFont(new Font("楷体", 1, 11));
		phoneNumLb.setFont(new Font("楷体", 1, 12));
		phoneNumTf.setFont(new Font("楷体", 1, 10));
		phoneNumCue.setFont(new Font("楷体", 1, 10));
		emailLb.setFont(new Font("楷体", 1, 12));
		emailTf.setFont(new Font("楷体", 1, 10));
		emailCue.setFont(new Font("楷体", 1, 10));
		addressLb.setFont(new Font("楷体", 1, 12));
		addressTf.setFont(new Font("楷体", 1, 10));
		addressCue.setFont(new Font("楷体", 1, 10));
		submitBt.setFont(new Font("楷体", 1, 12));
		resetBt.setFont(new Font("楷体", 1, 12));
		// 添加组件
		add(userNameLb);
		add(userNameTf);
		add(userNameCue);
		add(pwdLb);
		add(pwdPf);
		add(pwdCue);
		add(confirmPwdLb);
		add(confirmPwdPf);
		add(confirmPwdCue);
		add(nameLb);
		add(nameTf);
		add(nameCue);
		add(idLb);
		add(idTf);
		add(idCue);
		add(sexLb);
		add(cb);
		cb.addItem("男");
		cb.addItem("女");
		cb.setSelectedItem("男");
		add(phoneNumLb);
		add(phoneNumTf);
		add(phoneNumCue);
		add(emailLb);
		add(emailTf);
		add(emailCue);
		add(addressLb);
		add(addressTf);
		add(addressCue);
		add(submitBt);
		add(resetBt);
	}

	// 事件响应
	public void addListener() {
		submitBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// 获取输入的用户信息
					String userName = userNameTf.getText();
					String pwd = String.valueOf(pwdPf.getPassword());
					String name = nameTf.getText();
					String id = idTf.getText();
					String sex = (String) cb.getSelectedItem();
					String phoneNum = phoneNumTf.getText();
					String email = emailTf.getText();
					String address = addressTf.getText();

					// 对用户信息的判断
					// 1.用户名的字符长度在[6，14]
					if (!userName.matches("\\w{6,14}")) {
						JOptionPane.showMessageDialog(null, "用户名是6-14位字母数字");
						return;
					}
					User user = userManager.findUserByUserName(userName);
					if (user != null) {
						JOptionPane.showMessageDialog(null, "用户已存在");
						return;
					}

					// 2.密码的字符长度在[6，14]
					if (!pwd.matches("\\w{6,14}")) {
						JOptionPane.showMessageDialog(null, "密码是6-14位字母数字");
						return;
					}
					// 3.密码必须保持一致
					if (!String.valueOf(confirmPwdPf.getPassword()).equals(pwd)) {
						JOptionPane.showMessageDialog(null, "两次输入密码不一致");
						return;
					}
					// 4.应为真实姓名
					if (nameTf.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "真实姓名不能为空");
						return;
					}
					if (!name.matches("^[\u4E00-\u9Fa5]+$")) {
						JOptionPane.showMessageDialog(null, "真实姓名是中文");
						return;
					}
					// 5.应为真实身份证号
					if (!id.matches("\\d{18}")) {
						JOptionPane.showMessageDialog(null, "请输入18为身份证号码");
						return;
					}
					// 6.应为真实手机号码
					if (!phoneNum.matches("\\d{11}")) {
						JOptionPane.showMessageDialog(null, "电话是11位数字");
						return;
					}

					// 用信息构造医生对象
					User user2 = new User(id, name, userName, pwd, sex, phoneNum, email, address);

					// 调用userManager中的添加用户的方法
					if (userManager.addUser(user2)) {
						JOptionPane.showMessageDialog(null, "会员注册成功");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "会员注册失败");
					}
				} catch (Exception e) {
				}
			}
		});

		resetBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				userNameTf.setText("");
				pwdPf.setText("");
				confirmPwdPf.setText("");
				nameTf.setText("");
				idTf.setText("");
				phoneNumTf.setText("");
				emailTf.setText("");
				addressTf.setText("");
			}
		});

	}

	public UserRegView(String title) {
		super(title);
		// JPanel bgPanel = new BackgroundPanel02();
		// bgPanel.setLayout(new BorderLayout(0, 0));// 设置边界布局
		// BackgroundPanel02 backgroundPanel = new BackgroundPanel02(); //
		// 创建背景面板
		// bgPanel.add(backgroundPanel);// 添加背景面板
		// this.setContentPane(bgPanel);
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}
}
