package view.admin;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//import Background.BackgroundPanel12;

public class AdminLoginView extends JFrame {
	// 窗口中的组件当做类的属性
	JLabel adminNameLb = new JLabel("管理员名:");
	JTextField adminNameTf = new JTextField();
	JLabel pwdLb = new JLabel("密   码:");
	JPasswordField pwdPf = new JPasswordField();
	JButton loginBt = new JButton("登录");
	JButton resetBt = new JButton("重置");

	// 窗口初始化
	public void initFrame() {
		setSize(360, 240);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void addComponent() {
		// 自定义布局
		setLayout(null);
		// 设置panel的布局
		adminNameLb.setBounds(70, 50, 85, 40);
		adminNameTf.setBounds(130, 60, 150, 25);
		pwdLb.setBounds(70, 100, 85, 40);
		pwdPf.setBounds(130, 110, 150, 25);
		resetBt.setBounds(90, 160, 60, 30);
		loginBt.setBounds(200, 160, 60, 30);
		// 设置字体格式和大小
		adminNameLb.setFont(new Font("楷体", 1, 12));
		adminNameTf.setFont(new Font("楷体", 1, 12));
		pwdLb.setFont(new Font("楷体", 1, 12));
		pwdPf.setFont(new Font("楷体", 1, 12));
		loginBt.setFont(new Font("楷体", 1, 12));
		resetBt.setFont(new Font("楷体", 1, 12));
		// 添加组件
		add(adminNameLb);
		add(adminNameTf);
		add(pwdLb);
		add(pwdPf);
		add(loginBt);
		add(resetBt);
	}

	public void addListener() {
		loginBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (adminNameTf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "用户名不能为空");
					return;
				}
				if (pwdPf.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "密码不能为空");
					return;
				}
				if (adminNameTf.getText().trim().equals("admin")) {
					if (String.valueOf(pwdPf.getPassword()).equals("admin")) {
						new AdminView("管理员界面");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "密码错误,请重新输入");
						return;
					}
				} else {
					JOptionPane.showMessageDialog(null, "用户名错误,请重新输入");
					return;
				}
			}
		});
		resetBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				adminNameTf.setText("");
				pwdPf.setText("");
			}
		});
	}

	public AdminLoginView(String title) {
		super(title);
		// JPanel bgPanel = new BackgroundPanel12();
		// bgPanel.setLayout(new BorderLayout(0, 0));// 设置边界布局
		// BackgroundPanel12 backgroundPanel = new BackgroundPanel12(); //
		// 创建背景面板
		// bgPanel.add(backgroundPanel);// 添加背景面板
		// this.setContentPane(bgPanel);
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}
}
