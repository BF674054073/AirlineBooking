package view.admin;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import manager.AdminManager;
import manager.FlightManager;

import dao.AdminDao;
import entity.Flight;
import exception.FlightException;

import objectfactory.ObjectFactory;

public class AddFlightView extends JFrame {
	// 窗口中的组件当做类的属性
	JLabel flightNumLb = new JLabel(" 航班号 :");
	JTextField flightNumTf = new JTextField();
	JLabel startPlaceLb = new JLabel("出发城市:");
	JTextField startPlaceTf = new JTextField();
	JLabel endPlaceLb = new JLabel("抵达城市:");
	JTextField endPlaceTf = new JTextField();
	JLabel takeoffTimeLb = new JLabel("出发时间:");
	JTextField takeoffTimeTf = new JTextField();
	JLabel flyingTimeLb = new JLabel("飞行时间:");
	JTextField flyingTimeTf = new JTextField();
	JLabel priceLb = new JLabel("价    格:");
	JTextField priceTf = new JTextField();
	JLabel ticketsLb = new JLabel("余    票:");
	JTextField ticketsTf = new JTextField();

	JButton addBt = new JButton("添加");
	JButton resetBt = new JButton("重置");

	AdminManager adminManager = (AdminManager) ObjectFactory.getObject("adminManager");
	FlightManager flightManager = (FlightManager) ObjectFactory.getObject("flightManager");

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	// 窗口初始化
	public void initFrame() {
		setSize(800, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void addComponent() {
		// 自定义布局
		setLayout(null);
		// 设置panel的布局
		flightNumLb.setBounds(280, 40, 80, 50);
		flightNumTf.setBounds(350, 50, 140, 25);
		startPlaceLb.setBounds(280, 90, 80, 50);
		startPlaceTf.setBounds(350, 100, 140, 25);
		endPlaceLb.setBounds(280, 140, 80, 50);
		endPlaceTf.setBounds(350, 150, 140, 25);
		takeoffTimeLb.setBounds(280, 190, 80, 50);
		takeoffTimeTf.setBounds(350, 200, 140, 25);
		flyingTimeLb.setBounds(280, 240, 80, 50);
		flyingTimeTf.setBounds(350, 250, 140, 25);
		priceLb.setBounds(280, 290, 80, 50);
		priceTf.setBounds(350, 300, 140, 25);
		ticketsLb.setBounds(280, 340, 80, 50);
		ticketsTf.setBounds(350, 350, 140, 25);
		resetBt.setBounds(320, 400, 60, 30);
		addBt.setBounds(420, 400, 60, 30);

		// 设置字体格式和大小
		flightNumLb.setFont(new Font("楷体", 1, 12));
		flightNumTf.setFont(new Font("楷体", 1, 10));
		startPlaceLb.setFont(new Font("楷体", 1, 12));
		startPlaceTf.setFont(new Font("楷体", 1, 10));
		endPlaceLb.setFont(new Font("楷体", 1, 12));
		endPlaceTf.setFont(new Font("楷体", 1, 10));
		takeoffTimeLb.setFont(new Font("楷体", 1, 12));
		takeoffTimeTf.setFont(new Font("楷体", 1, 10));
		priceLb.setFont(new Font("楷体", 1, 12));
		priceTf.setFont(new Font("楷体", 1, 10));
		ticketsLb.setFont(new Font("楷体", 1, 12));
		ticketsTf.setFont(new Font("楷体", 1, 10));
		resetBt.setFont(new Font("楷体", 1, 12));
		addBt.setFont(new Font("楷体", 1, 12));

		// 添加组件
		add(flightNumLb);
		add(flightNumTf);
		add(startPlaceLb);
		add(startPlaceTf);
		add(endPlaceLb);
		add(endPlaceTf);
		add(takeoffTimeLb);
		add(takeoffTimeTf);
		add(flyingTimeLb);
		add(flyingTimeTf);
		add(priceLb);
		add(priceTf);
		add(ticketsLb);
		add(ticketsTf);
		add(addBt);
		add(resetBt);

	}

	public void addListener() {
		addBt.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try {
					String flightNumber = flightNumTf.getText().trim();
					String startPlace = startPlaceTf.getText().trim();
					String endPlace = endPlaceTf.getText().trim();
					Timestamp nowTime = new Timestamp(System.currentTimeMillis());
					Timestamp takeoffTime = Timestamp.valueOf(takeoffTimeTf.getText().trim());
					if (nowTime.compareTo(takeoffTime) > 0) {
						JOptionPane.showMessageDialog(null, "出发时间不能在当前时间之前");
						return;
					}
					String flyingTime = flyingTimeTf.getText().trim();
					double price = Double.parseDouble(priceTf.getText().trim());
					int tickets = Integer.parseInt(ticketsTf.getText().trim());
					// 1.航班号不能为空
					if (!flightNumber.matches("\\w{5,6}")) {
						JOptionPane.showMessageDialog(null, "航班号为5-6位");
						return;
					}
					// 2.出发地不能为空
					if (!startPlace.matches("^[\u4E00-\u9Fa5]+$")) {
						JOptionPane.showMessageDialog(null, "出发地应为中文");
						return;
					}
					// 3.目的地不能为空
					if (!endPlace.matches("^[\u4E00-\u9Fa5]+$")) {
						JOptionPane.showMessageDialog(null, "目的地应为中文");
						return;
					}
					// 4.起飞时间不能为空
					if (takeoffTimeTf.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "起飞时间不能为空");
						return;
					}
					// 5.飞行时间不能为空
					if (flyingTime.isEmpty()) {
						JOptionPane.showMessageDialog(null, "飞行时间不能为空");
						return;
					}
					// 6.票价不能为空
//					if (priceTf.getText().matches("\\d{1,5}\\.*\\d")) {
					if (!priceTf.getText().matches("^(?!0+(?:\\.0+)?$)(?:[1-9]\\d*|0)(?:\\.\\d{1,2})?$")) {
						JOptionPane.showMessageDialog(null, "票价为正整数或者小数");
						return;
					}
					// 7.余票不能为空
					if (ticketsTf.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "余票不能为空");
						return;
					}

					Flight flight = new Flight(flightNumber, takeoffTime, flyingTime, startPlace, endPlace, tickets, price);
					boolean b = flightManager.addFlight(flight);
					if (b) {
						JOptionPane.showMessageDialog(null, "添加成功");
						dispose();
					}
				} catch (FlightException e) {
					JOptionPane.showMessageDialog(null, "添加失败");
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, "时间格式有误，请修改为 yyyy-MM-dd HH:mm:ss");
				}
			}
		});

	}

	public AddFlightView(String title) {
		super(title);
		// JPanel bgPanel = new BackgroundPanel14();
		// bgPanel.setLayout(new BorderLayout(0, 0));// 设置边界布局
		// BackgroundPanel14 backgroundPanel = new BackgroundPanel14(); //
		// 创建背景面板
		// bgPanel.add(backgroundPanel);// 添加背景面板
		// this.setContentPane(bgPanel);
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}

	public static void main(String[] args) {
		new AddFlightView("a");
	}
}
