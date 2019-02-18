package view.admin;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import Background.BackgroundPanel16;

public class ChangeFlightView1 extends JFrame{
	//窗口中的组件当做类的属性
	JLabel titleLb = new JLabel(" 请输入要更改的航班号");
	JLabel flightNumLb = new JLabel("航班号:");
	JTextField flightNumTf = new JTextField();
	
	JButton confirmBt = new JButton("确定");
	JButton cancelBt = new JButton("取消");
	//窗口初始化
	public void initFrame() {
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void addComponent() {
		//自定义布局
		setLayout(null);
		// 设置panel的布局
		titleLb.setBounds(110, 20,200, 80);
		flightNumLb.setBounds(90, 100,80, 50);flightNumTf.setBounds(150, 110, 150, 25);
		cancelBt.setBounds(130,180,60, 30);confirmBt.setBounds(230, 180, 60, 30);

		//设置字体格式和大小
		titleLb.setFont(new Font("楷体",1,15));
		flightNumLb.setFont(new Font("楷体",1,12));flightNumTf.setFont(new Font("楷体",1,10));
		confirmBt.setFont(new Font("楷体",1,12));cancelBt.setFont(new Font("楷体",1,12));

		//添加组件
		add(titleLb);
		add(flightNumLb);add(flightNumTf);
		add(confirmBt);add(cancelBt);

	}
	public void addListener() {
	}
	public ChangeFlightView1(String title) {
		super(title);	

		// JPanel bgPanel = new BackgroundPanel16();
		// bgPanel.setLayout(new BorderLayout(0, 0));// 设置边界布局
		// BackgroundPanel16 backgroundPanel = new BackgroundPanel16(); //
		// 创建背景面板
		// bgPanel.add(backgroundPanel);// 添加背景面板
		// this.setContentPane(bgPanel);
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}
	public static void main(String[] args) {
		new ChangeFlightView1("a");
	}
	
}
