package view.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;

import entity.Order;
import entity.OrderRecord;
import exception.OrderException;
import exception.OrderRecordException;

import objectfactory.ObjectFactory;

import manager.FlightManager;
import manager.OrderManager;
import manager.OrderRecordManager;

//import Background.BackgroundPanel11;
//import objectfactory.ObjectFactory;

public class TicketsRecordView extends JFrame {
	// 窗口中的组件当做类的属性
	// Panel中的显示组件
	JTextArea ticMsgTA = new JTextArea();
	JScrollPane scroll = new JScrollPane(ticMsgTA);// 滑轮条
	JLabel[] ticLbArr = new JLabel[9];
	JTextField[] ticTxArr = new JTextField[9];
	JButton updateBt = new JButton("改签");
	JButton returnBt = new JButton("退票");
	JButton delRecordBt = new JButton("删除订单");

	// 管理类
	OrderManager orderManager = (OrderManager) ObjectFactory.getObject("ordermanager");
	OrderRecordManager orderRecordManager = (OrderRecordManager) ObjectFactory.getObject("orderRecordManager");
	FlightManager flightManager = (FlightManager) ObjectFactory.getObject("flightmanager");

	// 添加组件
	public void addComponent() {
		// 自定义布局
		setLayout(null);
		// 显示购票的信息
		ticMsgTA.setEditable(false);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 600, 180);
		add(scroll);
		JPanel panel2 = new JPanel(new GridLayout(2, 9, 2, 5));
		String[] arr = { "订单号", "航班号", "出发地", "目的地", "出发时间", "票价", "购票人姓名", "身份证号", "订单状态" };
		for (int i = 0; i < ticLbArr.length; i++) {
			ticLbArr[i] = new JLabel();
			ticLbArr[i].setText(arr[i]);
			panel2.add(ticLbArr[i]);
		}
		for (int i = 0; i < ticTxArr.length; i++) {
			ticTxArr[i] = new JTextField();
			ticTxArr[i].setEditable(false);
			panel2.add(ticTxArr[i]);
		}
		panel2.setBounds(0, 230, 700, 65);
		add(panel2);

		updateBt.setBounds(250, 310, 90, 30);
		returnBt.setBounds(360, 310, 90, 30);
		updateBt.setFont(new Font("楷体", 1, 12));
		returnBt.setFont(new Font("楷体", 1, 12));

		delRecordBt.setBounds(5, 310, 90, 30);
		delRecordBt.setFont(new Font("楷体", 1, 12));
		add(updateBt);
		add(returnBt);
		add(delRecordBt);
	}

	public void addListener() {
		// 添加插入符侦听器，以便侦听任何插入符的更改通知
		ticMsgTA.addCaretListener(new CaretListener() {

			public void caretUpdate(CaretEvent e) {
				int offset = e.getDot();// 获得插入符位置
				try {
					int row = ticMsgTA.getLineOfOffset(offset); // 将偏移量转为行号
					if (row == 0) {
						return;
					}
					int start = ticMsgTA.getLineStartOffset(row);// 获得光标行的起始位置
					int end = ticMsgTA.getLineEndOffset(row); // 获得光标行的结束位置
					String str = ticMsgTA.getText(start, end - start);// 获得光标行的内容

					System.out.println(str);
					String[] arr = str.split("\\t");
					System.out.println(arr.length);
					if (arr.length != ticTxArr.length) {
						return;
					}
					for (int i = 0; i < ticTxArr.length; i++) {
						ticTxArr[i].setText(arr[i]);
					}
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}
		});

		returnBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int i = JOptionPane.showConfirmDialog(null, "是否确定退票", "退票订单", JOptionPane.YES_NO_OPTION);
				if (i == 0) {
					if (ticTxArr[8].getText().trim().equals("已过期") || ticTxArr[8].getText().trim().equals("已退票") || ticTxArr[8].getText().trim().equals("已改签")) {
						JOptionPane.showMessageDialog(null, "该票已失效，无法退票");
						return;
					}
					try {
						orderManager.updateOrderStatusByOrderNumber(Integer.parseInt(ticTxArr[0].getText().trim()), "已退票");
						clearTxArr();
						initFrame();
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "订单号格式异常");
					} catch (OrderException e) {
						JOptionPane.showMessageDialog(null, "退票失败");
					}
				}
			}
		});

		updateBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = JOptionPane.showConfirmDialog(null, "是否确定改签", "改签订单", JOptionPane.YES_NO_OPTION);
				if (i == 0) {
					if (ticTxArr[8].getText().trim().equals("改签票")) {
						JOptionPane.showMessageDialog(null, "只能改签一次");
						return;
					}
					if (ticTxArr[8].getText().trim().equals("已过期") || ticTxArr[8].getText().trim().equals("已退票") || ticTxArr[8].getText().trim().equals("已改签")) {
						JOptionPane.showMessageDialog(null, "该票已时效，无法改签");
						return;
					}
					System.out.println(ticTxArr);
					for (int j = 0; j < ticTxArr.length; j++) {
						System.out.println(ticTxArr[j].getText() + " ");
					}
					new UpdateSearchFlightView("改签查询航班", userName, ticTxArr);
					dispose();
				}
			}
		});

		delRecordBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int i = JOptionPane.showConfirmDialog(null, "是否确定删除", "删除订单", JOptionPane.YES_NO_OPTION);
				if (i == 0) {
					try {
						if ((ticTxArr[8].getText().trim()).equals("待使用")) {
							JOptionPane.showMessageDialog(null, "该票还未使用，无法删除订单记录");
							return;
						}
						boolean b = orderManager.delOrderByOrderNum(Integer.parseInt(ticTxArr[0].getText().trim()));
						boolean c = orderRecordManager.delbyorderNum(Integer.parseInt(ticTxArr[0].getText().trim()));
						if (!b || !c) {
							JOptionPane.showMessageDialog(null, "删除订单记录失败");
							return;
						}
						JOptionPane.showMessageDialog(null, "删除订单记录成功");
						clearTxArr();
						initFrame();
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "订单号格式有误");
					} catch (OrderException e) {
						e.printStackTrace();
					} catch (OrderRecordException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	// 窗口初始化
	public void initFrame() {
		setSize(700, 400);
		setLocationRelativeTo(null);
		ticMsgTA.setText("订单号\t航班号\t出发地\t目的地\t出发时间\t\t票价\t购票人姓名\t购票人身份证号\t订单状态\n");
		try {
			List<OrderRecord> list = orderRecordManager.findOrderByUsername(userName);
			Timestamp now = new Timestamp(System.currentTimeMillis());
			for (OrderRecord orderRecord : list) {
				Order order = orderManager.findOrderByOrderNum(orderRecord.getOrderNumber());
				if (order.getTakeoffTime().compareTo(now) < 0 && (order.getStatus().equals("待使用") || order.getStatus().equals("改签票"))) {
					orderManager.updateOrderStatusByOrderNumber(order.getOrderNumber(), "已过期");
				}
				ticMsgTA.append(order + "   \n");
			}
		} catch (OrderRecordException e) {
			e.printStackTrace();
		} catch (OrderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void clearTxArr() {
		for (JTextField tf : ticTxArr) {
			tf.setText("");
			tf.setEditable(false);
		}
	}

	String userName;

	public TicketsRecordView(String title, String userName) {
		super(title);
		this.userName = userName;
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}

	public static void main(String[] args) {
		new TicketsRecordView("购票记录页面", "zhangsan");
	}
}
