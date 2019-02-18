package view.user;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Flight;
import exception.FlightException;

import objectfactory.ObjectFactory;

import manager.AdminManager;
import manager.FlightManager;

//import Background.BackgroundPanel06;

public class SearchFlightView extends JFrame {
	// 窗口中的组件当做类的属性
	JLabel startPlaceLb = new JLabel("出发地:");
	JTextField startPlacecb = new JTextField();
	JLabel endPlaceLb = new JLabel("目的地:");
	JTextField endPlacecb = new JTextField();
	JLabel takeoffTimeLb = new JLabel("出发时间:");
	JTextField takeoffTimeTf = new JTextField();

	JButton searchBt = new JButton("查询");
	JButton cancelBt = new JButton("取消");

	AdminManager adminManager = (AdminManager) ObjectFactory.getObject("adminmanager");
	FlightManager flightManager = (FlightManager) ObjectFactory.getObject("flightManager");

	// 添加组件
	public void addComponent() {
		// 自定义布局
		setLayout(null);

		startPlaceLb.setBounds(80, 70, 70, 30);
		startPlacecb.setBounds(150, 70, 130, 30);
		endPlaceLb.setBounds(80, 105, 70, 30);
		endPlacecb.setBounds(150, 105, 130, 30);
		takeoffTimeLb.setBounds(80, 140, 70, 30);
		takeoffTimeTf.setBounds(150, 140, 130, 30);
		// flightNumLb.setBounds(80, 175, 70, 30);
		// flightNumTf.setBounds(150, 175, 130, 30);
		searchBt.setBounds(98, 190, 100, 30);
		cancelBt.setBounds(202, 190, 100, 30);
		add(startPlaceLb);
		add(startPlacecb);
		add(endPlaceLb);
		add(endPlacecb);
		add(takeoffTimeLb);
		add(takeoffTimeTf);

		add(searchBt);
		add(cancelBt);

	}

	// 事件响应
	public void addListener() {
		searchBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new SearchFlightResultView("航班查询", userName, startPlacecb.getText().trim(), endPlacecb.getText().trim(), takeoffTimeTf.getText());
				dispose();
			}
		});

	}

	// 窗口初始化
	public void initFrame() {
		setSize(400, 400);
		setLocationRelativeTo(null);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	String userName;

	public SearchFlightView(String title, String userName) {
		super(title);
		this.userName = userName;
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}

	public static void main(String[] args) {
		new SearchFlightView("a", "a");
	}
}
