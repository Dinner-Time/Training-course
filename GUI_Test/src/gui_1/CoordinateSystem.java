package gui_1;

import javax.swing.*;
import java.awt.*;


public class CoordinateSystem {

	public static void main(String[] args) {
		
		Dimension dim = new Dimension(1000, 800); //윈도우의 사이즈 -> import java.awt.* 필수
		
		JFrame frame = new JFrame("Hello World"); 
		JLabel label = new JLabel("Hello World!");
		frame.add(label);
		frame.setLocation(500,200); //윈도우 위치
		frame.setPreferredSize(dim);
		frame.pack();
		frame.setVisible(true);
	}

}
