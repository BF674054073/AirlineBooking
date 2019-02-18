package view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;

import entity.Flight;
import exception.FlightException;

import objectfactory.ObjectFactory;

import manager.AdminManager;
import manager.FlightManager;

//import Background.BackgroundPanel18;
import view.user.TicketsRecordView;

public class ShowAllFlightsView extends JFrame {
	// 窗口中的组件当做类的属性
	JTextArea ticMsgTA = new JTextArea("\t\t\t航班信息\n航班号\t出发地\t目的地\t出发时间\t\t飞行时间\t余票\t票价\n");
	JScrollPane scroll = new JScrollPane(ticMsgTA);// 滑轮条

	// 管理类
	AdminManager adminManager = (AdminManager) ObjectFactory.getObject("adminmanager");
	FlightManager flightManager = (FlightManager) ObjectFactory.getObject("flightManager");

	// 窗口初始化
	public void initFrame() {
		setSize(800, 600);
		setLocationRelativeTo(null);
		try {
			List<Flight> allFlights = flightManager.findAllFlights();
			for (Flight flight : allFlights) {
				ticMsgTA.append(flight + "\n");
			}
		} catch (FlightException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void addComponent() {
		// 自定义布局
		setLayout(null);
		// 显示购票的信息
		ticMsgTA.setEditable(false);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(150, 100, 500, 200);
		add(scroll);
	}

	public ShowAllFlightsView(String title) {
		super(title);
		// JPanel bgPanel = new BackgroundPanel18();
		// bgPanel.setLayout(new BorderLayout(0, 0));// 设置边界布局
		// BackgroundPanel18 backgroundPanel = new BackgroundPanel18(); //
		// 创建背景面板
		// bgPanel.add(backgroundPanel);// 添加背景面板
		// this.setContentPane(bgPanel);
		initFrame();
		addComponent();
		setVisible(true);
	}

	public static void main(String[] args) {
		new ShowAllFlightsView("显示所有航班页面");
	}
}
