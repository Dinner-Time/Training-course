package music;

import music.view.MusicPlayer;

public class Main {
	public static final int SCREEN_WIDTH = 640, SCREEN_HEIGHT = 480;
	
	public static void main(String[] args) {
		new MusicPlayer().start();
		
	}
}
