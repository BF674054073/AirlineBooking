package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterView extends JFrame {
	// 窗口中的组件当做类的属性
	JLabel userNameLb = new JLabel("用 户 名:");
	JTextField userNameTf = new JTextField();
	JLabel userNameCue = new JLabel("*用户名长度为6-14的字母数字");
	JLabel pwdLb = new JLabel("密    码:");
	JPasswordField pwdTf = new JPasswordField();
	JLabel pwdCue = new JLabel("*密码长度为6-14的数字");
	JLabel confirmPwdLb = new JLabel("确认密码:");
	JTextField confirmPwdTf = new JTextField();
	JLabel confirmPwdCue = new JLabel("*密码必须保持一致");
	JLabel nameLb = new JLabel("真实姓名:");
	JTextField nameTf = new JTextField();
	JLabel nameCue = new JLabel("*应为真实姓名");
	JLabel idLb = new JLabel("身份证号:");
	JTextField idTf = new JTextField();
	JLabel idCue = new JLabel("*真实身份证号");
	JLabel sexLb = new JLabel("性    别:");
	JComboBox cb = new JComboBox(); // 下拉列表框
	JLabel phoneNumLb = new JLabel("电话号码:");
	JTextField phoneNumTf = new JTextField();
	JLabel phoneNumCue = new JLabel("*电话号码长度为11位的数字");
	JLabel emailLb = new JLabel("电子邮箱:");
	JTextField emailTf = new JTextField();
	JLabel emailCue = new JLabel("*选填");
	JLabel addressLb = new JLabel("住   址:");
	JTextField addressTf = new JTextField();
	JLabel addressCue = new JLabel("*选填");

	JButton submitBt = new JButton("提交");
	JButton resetBt = new JButton("重置");

	// 窗口初始化
	public void initFrame() {
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// 添加组件
	public void addComponent() {
		// 自定义布局
		setLayout(null);
		// 设置panel的布局
		userNameLb.setBounds(255, 50, 80, 50);
		userNameTf.setBounds(320, 60, 140, 25);
		userNameCue.setBounds(480, 55, 250, 40);
		pwdLb.setBounds(255, 90, 80, 50);
		pwdTf.setBounds(320, 100, 140, 25);
		pwdCue.setBounds(480, 95, 250, 40);
		confirmPwdLb.setBounds(255, 130, 80, 50);
		confirmPwdTf.setBounds(320, 140, 140, 25);
		confirmPwdCue.setBounds(480, 135, 250, 40);
		nameLb.setBounds(255, 170, 80, 50);
		nameTf.setBounds(320, 180, 140, 25);
		nameCue.setBounds(480, 175, 250, 40);
		idLb.setBounds(255, 210, 80, 50);
		idTf.setBounds(320, 220, 140, 25);
		idCue.setBounds(480, 215, 250, 40);
		sexLb.setBounds(255, 250, 80, 50);
		cb.setBounds(320, 260, 140, 25);
		phoneNumLb.setBounds(255, 290, 80, 50);
		phoneNumTf.setBounds(320, 300, 140, 25);
		phoneNumCue.setBounds(480, 295, 250, 40);
		emailLb.setBounds(255, 330, 80, 50);
		emailTf.setBounds(320, 340, 140, 25);
		emailCue.setBounds(480, 335, 250, 40);
		addressLb.setBounds(255, 370, 80, 50);
		addressTf.setBounds(320, 380, 140, 25);
		addressCue.setBounds(480, 375, 250, 40);
		submitBt.setBounds(330, 420, 80, 30);
		resetBt.setBounds(490, 420, 80, 30);
		// 设置字体格式和大小
		userNameLb.setFont(new Font("楷体", 1, 12));
		userNameTf.setFont(new Font("楷体", 1, 10));
		userNameCue.setFont(new Font("楷体", 1, 10));
		pwdLb.setFont(new Font("楷体", 1, 12));
		pwdTf.setFont(new Font("楷体", 1, 10));
		pwdCue.setFont(new Font("楷体", 1, 10));
		confirmPwdLb.setFont(new Font("楷体", 1, 12));
		confirmPwdTf.setFont(new Font("楷体", 1, 10));
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
		add(pwdTf);
		add(pwdCue);
		add(confirmPwdLb);
		add(confirmPwdTf);
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

	public void run() {
	}

	// 事件响应
	public boolean addListener() {
		return rootPaneCheckingEnabled;
	}

	public RegisterView(String title) {
		super(title);
		JPanel bgPanel = new BackgroundPanel();
		bgPanel.setLayout(new BorderLayout(0, 0));// 设置边界布局
		BackgroundPanel backgroundPanel = new BackgroundPanel(); // 创建背景面板
		bgPanel.add(backgroundPanel);// 添加背景面板
		this.setContentPane(bgPanel);
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}
}