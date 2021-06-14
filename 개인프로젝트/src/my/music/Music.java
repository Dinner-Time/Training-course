package my.music;
/*
 * 음악을 재생하기 위한 클래스 작성
 * Jlayer가 필요하다. ( https://sourceforge.net/projects/javalayer/)에서 다운로드 가능
 * 클래스 요약
 *  -> music폴더의 노래를 재생한다.
 *  -> 생성자에 매개변수로 노래 파일명과 반복할지 말지를 결정하는 isLoop변수를 받는다.
 */

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javazoom.jl.player.Player;
import my.dance.AppMain;

public class Music extends Thread{
	private Player player; 
	private boolean isLoop; // 노래를 반복 할 것인지 결정하는 변수
	private File file;
	private InputStream fis;
	private BufferedInputStream bis;
	
	public Music (String name, boolean isLoop) { // 생성자
		try {
			this.isLoop = isLoop;
			file = new File(AppMain.class.getResource("../music/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch(Exception e) {
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
			}while (isLoop);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * inputStream에 대한 설명과 Thread에 대한 설명이 부족하다....
	 */
	
	
}
