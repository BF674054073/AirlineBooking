package view.user;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel; //import Background.BackgroundPanel04;
import view.MainView;

public class UserView extends JFrame {
	// 窗口中的组件当做类的属性
	JButton updateUser = new JButton("修改信息");
	JButton searchBt = new JButton("查询");
	JButton reserveBt = new JButton("订票");
	JButton returnBt = new JButton("退票");
	JButton alterTicBt = new JButton("改签");
	JButton recordBt = new JButton("购票记录");

	// 窗口初始化
	public void initFrame() {
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void addComponent() {
		// 自定义布局
		setLayout(null);
		// 设置panel的布局
		updateUser.setBounds(140, 20, 98, 30);
		searchBt.setBounds(260, 20, 78, 30);
		reserveBt.setBounds(360, 20, 78, 30);
		returnBt.setBounds(460, 20, 78, 30);
		alterTicBt.setBounds(560, 20, 78, 30);
		recordBt.setBounds(660, 20, 98, 30);
		// 设置字体格式和大小
		updateUser.setFont(new Font("楷体", 1, 12));
		searchBt.setFont(new Font("楷体", 1, 12));
		reserveBt.setFont(new Font("楷体", 1, 12));
		returnBt.setFont(new Font("楷体", 1, 12));
		alterTicBt.setFont(new Font("楷体", 1, 12));
		recordBt.setFont(new Font("楷体", 1, 12));
		// 添加组件
		add(updateUser);
		add(searchBt);
		add(reserveBt);
		add(returnBt);
		add(alterTicBt);
		add(recordBt);
	}

	// 事件响应
	public void addListener() {
		updateUser.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new UpdateUserView("修改用户信息", userName);
				dispose();
			}
		});

		searchBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new SearchFlightView("查询航班", userName);
			}
		});

		recordBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new TicketsRecordView("订单记录", userName);
			}
		});

	}

	String userName = null;

	public UserView(String title, String userName) {
		super(title);
		// JPanel bgPanel = new BackgroundPanel04();
		// bgPanel.setLayout(new BorderLayout(0, 0));// 设置边界布局
		// BackgroundPanel04 backgroundPanel = new BackgroundPanel04(); //
		// 创建背景面板
		// bgPanel.add(backgroundPanel);// 添加背景面板
		// this.setContentPane(bgPanel);
		this.userName = userName;
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}

	// public static void main(String[] args) {
	// new UserView("A", "aaa");
	// }
}
