package my.game.control;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


import my.game.AppMain;

public class Game {
	
	public Game(){
		player.setVisible(true);
	}
	
	int x = 600, y = 300;
	
	private ImageIcon playerImageIcon = new ImageIcon(
			AppMain.class.getResource("../img/dodgeFlightModel.png"));
	private Image playerImage = playerImageIcon.getImage();
	public JLabel player = new JLabel(playerImageIcon);

	public void screenDraw(Graphics g) {
		g.drawImage(playerImage, x, y, null);
	}
	
	public void up() {
		y = y-1;
	}
	
	public void down() {
		y = y+1;
	}
	
	public void left() {
		x = x-1;
	}
	
	public void right() {
		x = x+1;
	}
	
}

