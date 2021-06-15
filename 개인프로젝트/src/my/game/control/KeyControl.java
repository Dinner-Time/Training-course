package my.game.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControl implements KeyListener{
	Game g;

	public KeyControl(Game g) {
		this.g = g;
		g.player.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP: g.up(); break;
		case KeyEvent.VK_DOWN: g.down(); break;
		case KeyEvent.VK_LEFT: g.left(); break;
		case KeyEvent.VK_RIGHT: g.right(); break;
		}
		g.player.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
