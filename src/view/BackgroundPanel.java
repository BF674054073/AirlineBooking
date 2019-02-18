package view;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    String name = "img/c.jpg"; // 将图片放在class类的同级文件夹里

    protected void paintComponent(Graphics g) { //关键代码：重写绘制组件外观
        super.paintComponent(g);
        ImageIcon image = new ImageIcon(name); // 获取图片路径
        g.drawImage(image.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);// 绘制图片与组件大小相同
    }
}
