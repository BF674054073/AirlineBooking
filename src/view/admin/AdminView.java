package view.admin;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import objectfactory.ObjectFactory;

import manager.FlightManager;

//import Background.BackgroundPanel13;

public class AdminView extends JFrame {
	// 窗口中的组件当做类的属性
	JButton addFlightBt = new JButton("增加航班");
	JButton delFlightBt = new JButton("删除航班");
	JButton changeFlightBt = new JButton("更改航班");
	JButton showAllFlightsBt = new JButton("显示所有航班");

	FlightManager flightManager = (FlightManager) ObjectFactory.getObject("flightManager");

	public void addComponent() {
		// 自定义布局
		setLayout(null);
		// 设置panel的布局
		addFlightBt.setBounds(190, 20, 98, 30);
		delFlightBt.setBounds(310, 20, 98, 30);
		changeFlightBt.setBounds(430, 20, 98, 30);
		showAllFlightsBt.setBounds(550, 20, 118, 30);
		// 设置字体格式和大小
		addFlightBt.setFont(new Font("楷体", 1, 12));
		delFlightBt.setFont(new Font("楷体", 1, 12));
		changeFlightBt.setFont(new Font("楷体", 1, 12));
		showAllFlightsBt.setFont(new Font("楷体", 1, 12));
		// 添加组件
		add(addFlightBt);
		add(delFlightBt);
		add(changeFlightBt);
		add(showAllFlightsBt);
	}

	// 事件响应
	public void addListener() {
		addFlightBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new AddFlightView("添加航班");
			}
		});

		showAllFlightsBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new ShowAllFlightsView("显示所有航班信息");
			}
		});
		delFlightBt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new DelFlightView("删除航班");
			}
		});
		changeFlightBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ChangeFlightView2();
			}
		});
	}

	// 窗口初始化
	public void initFrame() {
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public AdminView(String title) {
		super(title);
		// JPanel bgPanel = new BackgroundPanel13();
		// bgPanel.setLayout(new BorderLayout(0, 0));// 设置边界布局
		// BackgroundPanel13 backgroundPanel = new BackgroundPanel13(); //
		// 创建背景面板
		// bgPanel.add(backgroundPanel);// 添加背景面板
		// this.setContentPane(bgPanel);
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}

	public static void main(String[] args) {
		new AdminView("A");
	}
}
