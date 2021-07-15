package music.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import music.Main;
import music.control.MusicControl;
import music.model.Music;

@SuppressWarnings("serial")
public class PlayerBackground extends JFrame {
	
	/*
	 * 배경화면 custom과 재생할 음악 리스트를 만든다.
	 */
	
	ArrayList<Music> music = new ArrayList<Music>();
	MusicControl selectedMusic;
	int currentPlay = 0;

	public PlayerBackground() {
		musicUpdate();
	}
	
	// 재생할 음악들을 리스트에 추가하는 메서드
	public void musicUpdate() {
		/*
		 * MusicList폴더 내의 mp3 파일들의 파일명만 가져올 수 있도록 한다. 
		 */
		try {
			File dir = new File(Main.MUSIC_FOLDER_PATH); // 폴더 경로
			File files[] = dir.listFiles(); // 폴더 내의 파일들의 경로를 files배열에 추가
			// 각 요소들을 for문을 통해 파일명을 추출하는 작업
			for (File f : files) {
				String s = f.getPath(); // 파일 경로를 String화 해서
				s = s.substring(s.lastIndexOf('\\') + 1); // substring을 통해 파일명만 가져와서 새로 저장한 후
				if (s.substring(s.lastIndexOf('.') + 1).equals("mp3")) { // 확장자명이 mp3인 파일인지 확인한 다음
					music.add(new Music(s)); // music 리스트에 추가
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 배경 이미지 (배경이미지는 여기서 한 번만 쓰이기 때문에 model에 추가하지 않았다.)
	private Image background = new ImageIcon(Main.IMG_FOLDER_PATH + "backgroundAqua.png").getImage();

	public void mainScreen() {
		/*
		 * 자바의 기본 gui화면을 custom 할 수 있게 하기위한 과정
		 * 자세한 내용은 youtube 자바(JAVA) 리듬게임 만들기 강좌 - 동빈 나 재생 목록을 참고
		 */
		setUndecorated(true); // 기본적인 메뉴바가 보이지 않게된다.
		setBackground(new Color(0, 0, 0, 0)); // paintConponent시에 전부 하얀색이 된다.(....?)
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // gui창의 크기 설정 -> setSize(가로, 세로)
		setResizable(false); // gui창의 크기 변경 불가
		setLocationRelativeTo(null); // gui창을 실행하면 항상 정중앙에 나온다
		setLayout(null); // gui창의 JLabel, JButton객체들을 원하는 위치에 넣을 수 있다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 해당 메서드를 사용하지 않으면 창을 종료해도 프로그램은 계속 돌아가게 된다.
		setVisible(true); // 화면 출력
	}
	
	/* 더블 버퍼링
	 * 
	 * 더블 버퍼링에 관한 설명은 아래 블로그를 참조
	 * https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=lghlove0509&logNo=221009877738
	 */
	private Image screenImage; // 더블 버퍼링을 위한 변수
	private Graphics screenGraphics; // 더블 버퍼링을 위한 변수

	public void paint(Graphics g) { // 형태가 약속된 메서드
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 1.화면과 같은 크기의 이미지를 생성하고
		screenGraphics = screenImage.getGraphics(); // 2.그 이미지를 그래픽으로 담아서
		screenDraw(screenGraphics);
		g.drawImage(screenImage, 0, 0, null); // 5.drawImage메서드를 통해 이미지를 다시 화면에 그린다.
	}

	public void screenDraw(Graphics g) { // 3.drawImage메서드를 통해 이미지를 화면에 그린 후
		g.drawImage(background, 0, 0, null);
		paintComponents(g); // 정적인 이미지들은 paintComponents로 구현한다. (...?)
		this.repaint(); // 4.해당 component를 repaint한다.
	}
	
}
