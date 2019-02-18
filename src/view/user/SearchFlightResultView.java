package view.user;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField; //import Background.BackgroundPanel07;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;

import manager.AdminManager;
import manager.FlightManager;
import manager.OrderManager;
import manager.UserManager;
import objectfactory.ObjectFactory;
import entity.Flight;
import entity.User;
import exception.FlightException;

public class SearchFlightResultView extends JFrame {
	// 窗口中的组件当做类的属性
	JTextArea flightMsg = new JTextArea("\t\t\t航班信息\n航班号\t出发地\t目的地\t出发时间\t\t飞行时间\t余票\t票价\n");
	JScrollPane scroll = new JScrollPane(flightMsg);// 滑轮条
	JLabel[] flightLbArr = new JLabel[7];
	JTextField[] flightArr = new JTextField[7];
	JButton ticketOrderBt = new JButton("订票");

	// 管理类
	AdminManager adminManager = (AdminManager) ObjectFactory.getObject("adminmanager");
	FlightManager flightManager = (FlightManager) ObjectFactory.getObject("flightmanager");
	OrderManager ordreManager = (OrderManager) ObjectFactory.getObject("ordermanager");
	UserManager userManager = (UserManager) ObjectFactory.getObject("usermanager");

	public void addComponent() {
		// 自定义布局
		setLayout(null);
		flightMsg.setEditable(false);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(150, 100, 500, 200);
		add(scroll);
		JPanel panel2 = new JPanel(new GridLayout(2, 7, 10, 0));
		String[] arr = { "航班号", "出发地", "目的地", "出发时间", "飞行时间", "余票", "票价" };
		for (int i = 0; i < flightLbArr.length; i++) {
			flightLbArr[i] = new JLabel();
			flightLbArr[i].setText(arr[i]);
			panel2.add(flightLbArr[i]);
		}
		for (int i = 0; i < flightArr.length; i++) {
			flightArr[i] = new JTextField();
			flightArr[i].setEditable(false);
			panel2.add(flightArr[i]);
		}
		panel2.setBounds(80, 310, 600, 60);
		add(panel2);

		ticketOrderBt.setBounds(700, 340, 90, 30);
		add(ticketOrderBt);

	}

	public void addListener() {

		// 添加插入符侦听器，以便侦听任何插入符的更改通知
		flightMsg.addCaretListener(new CaretListener() {

			public void caretUpdate(CaretEvent e) {
				int offset = e.getDot();// 获得插入符位置
				try {
					int row = flightMsg.getLineOfOffset(offset); // 将偏移量转为行号
					if (row == 0 || row == 1) {
						return;
					}
					int start = flightMsg.getLineStartOffset(row);// 获得光标行的起始位置
					int end = flightMsg.getLineEndOffset(row); // 获得光标行的结束位置
					String str = flightMsg.getText(start, end - start);// 获得光标行的内容

					System.out.println(str);
					String[] arr1 = str.split("\\t");
					if (arr1.length != flightArr.length) {
						return;
					}
					for (int i = 0; i < flightArr.length; i++) {
						flightArr[i].setText(arr1[i]);
					}
					flightNumber = flightArr[0].getText().trim();
					takeoffTime = flightArr[3].getText().trim();
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}
		});

		ticketOrderBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new AddOrderView("购票人信息", userName, flightNumber, Timestamp.valueOf(takeoffTime));
			}
		});
	}

	public void clearTxArr() {
		for (JTextField tf : flightArr) {
			tf.setText("");
			tf.setEditable(false);
		}
	}

	// 窗口初始化
	public void initFrame() {
		setSize(800, 600);
		setLocationRelativeTo(null);

		try {
			List<Flight> list = flightManager.findFlight(startPlace, endPlace, takeoffTime);
			for (Flight flight : list) {
				flightMsg.append(flight + "\n");
			}
		} catch (FlightException e) {
			e.printStackTrace();
		}
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	String userName;
	String flightNumber;
	String startPlace;
	String endPlace;
	String takeoffTime;

	public SearchFlightResultView(String title, String userName, String startPlace, String endPlace, String takeoffTime) {
		super(title);
		this.userName = userName;
		this.flightNumber = flightNumber;
		this.startPlace = startPlace;
		this.endPlace = endPlace;
		this.takeoffTime = takeoffTime;
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}

	// public static void main(String[] args) {
	// new SearchFlightResultView("a");
	// }
}
