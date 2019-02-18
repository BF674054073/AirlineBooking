package view.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entity.Flight;
import exception.FlightException;
import exception.OrderException;
import exception.OrderRecordException;

import objectfactory.ObjectFactory;

import manager.FlightManager;
import manager.OrderManager;
import manager.OrderRecordManager;

public class UpdateAddOrderView extends JFrame {

	private JLabel flightNumlabel = new JLabel("航班号：");
	private JLabel namelabel = new JLabel("姓 名：");
	private JLabel takeoffTimeLb = new JLabel("出发时间：");
	private JLabel Idlabel = new JLabel("身份证号：");
	private JTextField flightNumfield = new JTextField();
	private JTextField namefield = new JTextField();
	private JTextField takeoffTimeTf = new JTextField();
	private JTextField Idfield = new JTextField();
	private JButton addbtn = new JButton("预定");
	private JButton resetbtn = new JButton("重置");

	FlightManager flightManager = (FlightManager) ObjectFactory.getObject("flightmanager");
	OrderManager orderManager = (OrderManager) ObjectFactory.getObject("ordermanager");
	OrderRecordManager orderRecordManager = (OrderRecordManager) ObjectFactory.getObject("orderRecordmanager");

	public void addComponent() {
		this.setLayout(null);
		flightNumlabel.setBounds(60, 10, 70, 20);
		flightNumfield.setBounds(125, 10, 100, 20);
		flightNumfield.setEditable(false);
		flightNumfield.setText(flightNumber);
		add(flightNumlabel);
		add(flightNumfield);
		takeoffTimeLb.setBounds(60, 35, 70, 20);
		takeoffTimeTf.setBounds(125, 35, 100, 20);
		takeoffTimeTf.setText(takeoffTime.toString());
		takeoffTimeTf.setEditable(false);
		add(takeoffTimeLb);
		add(takeoffTimeTf);
		namelabel.setBounds(60, 60, 70, 20);
		namefield.setBounds(125, 60, 100, 20);
		namefield.setText(txArr[6].getText().trim());
		add(namelabel);
		add(namefield);
		Idlabel.setBounds(60, 85, 70, 20);
		Idfield.setBounds(125, 85, 100, 20);
		Idfield.setText(txArr[7].getText().trim());
		add(Idlabel);
		add(Idfield);
		resetbtn.setBounds(40, 115, 70, 20);
		addbtn.setBounds(180, 115, 70, 20);
		add(addbtn);
		add(resetbtn);
	}

	public void addListener() {
		addbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (flightNumber.equals(txArr[1].getText().trim()) && takeoffTime.equals(txArr[4].getText())) {
					JOptionPane.showMessageDialog(null, "不能改签同一班飞机");
				}
				try {
					String status = "改签票";
					Flight flight = flightManager.findFlightByNumAndDate(flightNumber, takeoffTime);
					Flight oldFlight = flightManager.findFlightByNumAndDate(txArr[1].getText().trim(), Timestamp.valueOf(txArr[4].getText()));
					if (flight == oldFlight) {
						JOptionPane.showMessageDialog(null, "同一班次无需改签");
						return;
					}
					if (flight.getPrice() > oldFlight.getPrice()) {
						JOptionPane.showMessageDialog(null, "还需要支付" + String.valueOf(flight.getPrice() - oldFlight.getPrice()) + "元");
					}
					if (flight.getPrice() < oldFlight.getPrice()) {
						JOptionPane.showConfirmDialog(null, "将退您" + String.valueOf(oldFlight.getPrice() - flight.getPrice()) + "元");
					}
					int orderNumber = orderManager.addOrderbyNumAndUser(flight, namefield.getText().trim(), Idfield.getText().trim(), userName, status);
					System.out.println("----------------------------");
					System.out.println(userName + " ---- " + orderNumber);
					boolean b = orderRecordManager.addOrderRecord(userName, orderNumber);
					if (b) {
						boolean c = flightManager.updateFlightTickets(oldFlight.getTickets() + 1, oldFlight);
						if (c) {
							JOptionPane.showMessageDialog(null, "改签成功");
						}
					}
					orderManager.updateOrderStatusByOrderNumber(Integer.parseInt(txArr[0].getText().trim()), "已改签");
					dispose();
				} catch (FlightException e) {
					JOptionPane.showMessageDialog(null, "没有该航班");
				} catch (OrderException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (OrderRecordException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		resetbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				namefield.setText("");
				Idfield.setText("");
			}
		});
	}

	public void initFrame() {
		this.setSize(300, 180);
		this.setLocationRelativeTo(null);
	}

	String userName;
	String flightNumber;
	Timestamp takeoffTime;
	JTextField[] txArr;

	public UpdateAddOrderView(String title, String userName, String flightNumber, Timestamp takeoffTime, JTextField[] txArr) {
		super(title);
		this.userName = userName;
		this.flightNumber = flightNumber;
		this.takeoffTime = takeoffTime;
		this.txArr = txArr;
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}

	// public static void main(String[] args) {
	// new UpdateAddOrderView("a", "s", "123", null);
	// }
}
