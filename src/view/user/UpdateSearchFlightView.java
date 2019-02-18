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
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Flight;
import exception.FlightException;

import objectfactory.ObjectFactory;

import manager.AdminManager;
import manager.FlightManager;

//import Background.BackgroundPanel06;

public class UpdateSearchFlightView extends JFrame {
	// 窗口中的组件当做类的属性
	JLabel startPlaceLb = new JLabel("出发城市:");
	// JComboBox startPlacecb = new JComboBox(); // 下拉列表框
	JTextField startPlacecb = new JTextField();
	JLabel endPlaceLb = new JLabel("抵达城市:");
	// JComboBox endPlacecb = new JComboBox(); // 下拉列表框
	JTextField endPlacecb = new JTextField();
	JLabel takeoffTimeLb = new JLabel("出发时间:");
	JTextField takeoffTimeTf = new JTextField();
	JLabel flightNumLb = new JLabel(" 航班号 :");
	JTextField flightNumTf = new JTextField();

	JLabel selectStyle = new JLabel("查询方式:");
	JComboBox cb = new JComboBox(); // 下拉列表框
	JLabel infoLabel = new JLabel("出发地点:");
	JTextField infoField = new JTextField();
	JButton searchBt = new JButton("查询");

	AdminManager adminManager = (AdminManager) ObjectFactory.getObject("adminmanager");
	FlightManager flightManager = (FlightManager) ObjectFactory.getObject("flightManager");

	// 添加组件
	public void addComponent() {
		// 自定义布局
		setLayout(null);
		// 设置panel的布局
		// startPlaceLb.setBounds(80, 60, 80, 50);
		// startPlacecb.setBounds(150, 70, 140, 25);
		// endPlaceLb.setBounds(80, 120, 80, 50);
		// endPlacecb.setBounds(150, 130, 140, 25);
		// takeoffTimeLb.setBounds(80, 180, 80, 50);
		// takeoffTimeTf.setBounds(150, 190, 140, 25);
		// flightNumLb.setBounds(80, 240, 80, 50);
		// flightNumTf.setBounds(150, 250, 140, 25);
		// serchBt.setBounds(170, 310, 60, 30);
		// 设置字体格式和大小
		// startPlaceLb.setFont(new Font("楷体", 1, 12));
		// startPlacecb.setFont(new Font("楷体", 1, 10));
		// endPlaceLb.setFont(new Font("楷体", 1, 12));
		// endPlacecb.setFont(new Font("楷体", 1, 10));
		// takeoffTimeLb.setFont(new Font("楷体", 1, 12));
		// takeoffTimeTf.setFont(new Font("楷体", 1, 10));
		// flightNumLb.setFont(new Font("楷体", 1, 12));
		// flightNumTf.setFont(new Font("楷体", 1, 11));
		searchBt.setFont(new Font("楷体", 1, 12));
		// 添加组件
		// add(startPlaceLb);
		// add(startPlacecb);
		// add(endPlaceLb);
		// add(endPlacecb);
		// //
		// endPlacecb.addItem("南京");endPlacecb.addItem("北京");endPlacecb.addItem("上海");endPlacecb.addItem("成都");endPlacecb.setSelectedItem("北京");
		// add(takeoffTimeLb);
		// add(takeoffTimeTf);
		// add(flightNumLb);
		// add(flightNumTf);

		selectStyle.setBounds(50, 50, 70, 40);
		add(selectStyle);
		cb.setBounds(125, 50, 150, 40);
		cb.addItem("根据航班号查询");
		cb.addItem("根据出发地查询");
		cb.addItem("根据目的地查询");
		cb.addItem("根据出发时间查询");
		add(cb);
		infoLabel.setBounds(50, 100, 70, 40);
		add(infoLabel);
		infoField.setBounds(125, 100, 150, 40);
		add(infoField);
		searchBt.setBounds(150, 150, 100, 40);
		add(searchBt);
		try {
			List<Flight> flights = flightManager.findAllFlights();

		} catch (FlightException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 事件响应
	public void addListener() {
		cb.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (cb.getSelectedItem().equals("根据航班号查询")) {
					infoLabel.setText("根据航班号查询");
				}
				if (cb.getSelectedItem().equals("根据出发地查询")) {
					infoLabel.setText("出发地点:");
				}
				if (cb.getSelectedItem().equals("根据目的地查询")) {
					infoLabel.setText("目的地:");
				}
				if (cb.getSelectedItem().equals("根据出发时间查询")) {
					infoLabel.setText("出发时间");
				}
			}
		});

		searchBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (cb.getSelectedItem().equals("根据航班号查询")) {
					new UpdateSearchFlightResultView("航班号查询", userName, infoField.getText().trim(), null, null, null, txArr);
					dispose();
				}
				if (cb.getSelectedItem().equals("根据出发地查询")) {
					new UpdateSearchFlightResultView("出发地查询", userName, null, infoField.getText().trim(), null, null, txArr);
					dispose();
				}
				if (cb.getSelectedItem().equals("根据目的地查询")) {
					new UpdateSearchFlightResultView("目的地查询", userName, null, null, infoField.getText().trim(), null, txArr);
					dispose();
				}
				if (cb.getSelectedItem().equals("根据出发时间查询")) {
					new UpdateSearchFlightResultView("出发时间查询", userName, null, null, null, Timestamp.valueOf(infoField.getText().trim()), txArr);
					dispose();
				}

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

	JTextField[] txArr = null;

	public UpdateSearchFlightView(String title, String userName, JTextField[] txArr) {
		super(title);
		this.userName = userName;
		this.txArr = txArr;
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}

	// public static void main(String[] args) {
	// new SearchFlightView("a");
	// }
}
