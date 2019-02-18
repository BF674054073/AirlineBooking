package view.user;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import view.MainView;
//import Background.BackgroundPanel08;

public class ReserveFlightView extends JFrame {
	//窗口中的组件当做类的属性
	JLabel nameLb = new JLabel("真实姓名:");
	JTextField nameTf = new JTextField();
	JLabel idLb = new JLabel("身份证号:");
	JTextField idTf = new JTextField();
	JLabel startPlaceLb = new JLabel("出发城市:");
	JComboBox startPlacecb = new JComboBox();	//下拉列表框
	JLabel endPlaceLb = new JLabel("抵达城市:");
	JComboBox endPlacecb = new JComboBox();	//下拉列表框
	JLabel takeoffTimeLb = new JLabel("出发时间:");
	JTextField takeoffTimeTf = new JTextField();
	
	JButton comSubmitBt = new JButton("完成提交");
	JButton resetAllBt = new JButton("重置所有");
	//窗口初始化
	public void initFrame() {
		setSize(800,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//添加组件
	public void addComponent() {
		//自定义布局
		setLayout(null);
		// 设置panel的布局
		nameLb.setBounds(270, 70,80, 50);nameTf.setBounds(360, 80, 140, 25);
		idLb.setBounds(270, 130,80, 50);idTf.setBounds(360, 140, 140, 25);
		startPlaceLb.setBounds(270, 190,80, 50);startPlacecb.setBounds(360, 200, 140, 25);
		endPlaceLb.setBounds(270, 250,80, 50);endPlacecb.setBounds(360, 260, 140, 25);
		takeoffTimeLb.setBounds(270, 310,80, 50);takeoffTimeTf.setBounds(360, 320, 140, 25);
		comSubmitBt.setBounds(280,430,88, 30);resetAllBt.setBounds(400, 430, 88, 30);

		//设置字体格式和大小
		nameLb.setFont(new Font("楷体",1,12));nameTf.setFont(new Font("楷体",1,10));
		idLb.setFont(new Font("楷体",1,12));idTf.setFont(new Font("楷体",1,10));
		startPlaceLb.setFont(new Font("楷体",1,12));startPlacecb.setFont(new Font("楷体",1,10));
		endPlaceLb.setFont(new Font("楷体",1,12));endPlacecb.setFont(new Font("楷体",1,10));
		takeoffTimeLb.setFont(new Font("楷体",1,12));takeoffTimeTf.setFont(new Font("楷体",1,10));
		comSubmitBt.setFont(new Font("楷体",1,12));resetAllBt.setFont(new Font("楷体",1,12));

		//添加组件
		add(nameLb);add(nameTf);
		add(idLb);add(idTf);
		add(startPlaceLb);add(startPlacecb);
		startPlacecb.addItem("南京");startPlacecb.addItem("北京");startPlacecb.addItem("上海");startPlacecb.addItem("成都");startPlacecb.setSelectedItem("南京");
		add(endPlaceLb);add(endPlacecb);
		endPlacecb.addItem("南京");endPlacecb.addItem("北京");endPlacecb.addItem("上海");endPlacecb.addItem("成都");endPlacecb.setSelectedItem("北京");
		add(takeoffTimeLb);add(takeoffTimeTf);
		add(comSubmitBt);add(resetAllBt);

	}

	public void addListener() {
	}
	public ReserveFlightView(String title) {
		super(title);	
//		JPanel bgPanel = new BackgroundPanel08();
//	    bgPanel.setLayout(new BorderLayout(0, 0));// 设置边界布局
//	    BackgroundPanel08 backgroundPanel = new BackgroundPanel08(); // 创建背景面板
//	    bgPanel.add(backgroundPanel);// 添加背景面板
//	    this.setContentPane(bgPanel);
		initFrame();
		addComponent();
		addListener();
		setVisible(true);
	}
}
