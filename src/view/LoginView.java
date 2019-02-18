package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class LoginView extends JFrame {
	JLabel nameLabel = new JLabel("用户名:");
	JTextField userName = new JTextField();
	JLabel pwdLabel = new JLabel("密  码:");
	JPasswordField password = new JPasswordField();
	JLabel identityLabel = new JLabel("身  份:");
	ButtonGroup bgIdentity = new ButtonGroup();
	JRadioButton rbInhabitant = new JRadioButton("居民", true);// 默认男被选中
	JRadioButton rbDoctor = new JRadioButton("医生");
	JRadioButton rbAdmin = new JRadioButton("管理员");

	JButton loginBt = new JButton("登录");
	JButton registerBt = new JButton("注册");

	public void initFrame() {
		setSize(500, 300);
		this.setLocationRelativeTo(null);
	}

	// 添加组件
	public void addComponent() {
		setLayout(null);
		// 用户名
		nameLabel.setBounds(50, 40, 100, 40);
		add(nameLabel);

		userName.setBounds(150, 40, 200, 40);
		add(userName);
		// 密码
		pwdLabel.setBounds(50, 80, 100, 40);
		add(pwdLabel);
		password.setBounds(150, 80, 200, 40);
		add(password);
		// 身份
		identityLabel.setBounds(50, 120, 100, 40);
		add(identityLabel);
		// 添加到按钮组
		bgIdentity.add(rbInhabitant);
		bgIdentity.add(rbDoctor);
		bgIdentity.add(rbAdmin);
		rbInhabitant.setBounds(150, 120, 70, 40);
		add(rbInhabitant);
		rbDoctor.setBounds(220, 120, 70, 40);
		add(rbDoctor);
		rbAdmin.setBounds(290, 120, 70, 40);
		add(rbAdmin);
		// 登录按钮
		loginBt.setBounds(150, 200, 95, 40);
		add(loginBt);
		// 注册按钮
		registerBt.setBounds(255, 200, 95, 40);
		add(registerBt);
	}

	// 添加点击事件
	public void addListener() {
		
	}

	public LoginView(String title) {
		super(title);
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}
	public static void main(String[] args) {
		new LoginView("A");
	}
}
