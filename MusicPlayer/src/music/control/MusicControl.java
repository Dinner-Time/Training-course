package music.control;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javazoom.jl.player.Player;
import music.Main;

public class MusicControl extends Thread {
	private Player player;
	private boolean isLoop; // 노래를 반복 할 것인지 결정하는 변수
	private File file;
	private InputStream fis;
	private BufferedInputStream bis;
	
	public MusicControl() {}

	public MusicControl(String name, boolean isLoop) { // 생성자
		try {
			this.isLoop = isLoop;
			file = new File(Main.MUSIC_FOLDER_PATH + name);
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getTime() { // 노래의 시간을 가져오기 위한 메서드
		if (player == null) {
			return 0;
		}
		return player.getPosition();
	}

	public void close() { // 노래를 종료하기 위한 매서드
		isLoop = false;
		player.close();
		this.interrupt(); // thread종료
	}

	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isLoop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * inputStream에 대한 설명과 Thread에 대한 설명이 부족하다....
	 */
}
