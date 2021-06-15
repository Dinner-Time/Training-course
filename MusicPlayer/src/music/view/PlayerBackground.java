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

public class PlayerBackground extends JFrame {
	
	public static final int SCREEN_WIDTH = 360, SCREEN_HEIGHT = 150;
	ArrayList<Music> music = new ArrayList<Music>();
	MusicControl selectedMusic;
	int currentPlay = 0;

	public PlayerBackground() {
		musicUpdate();
	}
	
	public void musicUpdate() {
		try {
			File dir = new File(Main.class.getResource("../MusicList/").toURI());
			File files[] = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				String s = files[i].getPath();
				s = s.substring(s.lastIndexOf('\\') + 1);
				if (s.substring(s.lastIndexOf('.') + 1).equals("mp3")) {
					music.add(new Music(s));
				}
			}
		} catch (URISyntaxException e) {
			System.out.println(e.getMessage());
		}
	}

	private Image background = new ImageIcon(Main.class.getResource("../img/musicPlayerMain.jpg")).getImage();

	public void mainScreen() {
		setUndecorated(true); // 기본적인 메뉴바가 보이지 않게된다.
		setBackground(new Color(0, 0, 0, 0)); // paintConponent시에 전부 하얀색이 된다.(....?)
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT); // gui창의 크기 설정 -> setSize(가로, 세로)
		setResizable(false); // gui창의 크기 변경 불가
		setLocationRelativeTo(null); // gui창을 실행하면 항상 정중앙에 나온다
		setLayout(null); // gui창의 JLabel, JButton객체들을 원하는 위치에 넣을 수 있다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 해당 메서드를 사용하지 않으면 창을 종료해도 프로그램은 계속 돌아가게 된다.
		setVisible(true); // 화면 출력
	}
	private Image screenImage; // 더블 버퍼링을 위한 변수
	private Graphics screenGraphics; // 더블 버퍼링을 위한 변수

	public void paint(Graphics g) { // 형태가 약속된 메서드
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT); // 1.화면과 같은 크기의 이미지를 생성하고
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
