package my.game.view;

/**
 * 작성자 : 박태훈
 * 작성일 : 2021-06-14
 * 
 * 게임 gui환경을 구축한다. 
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import my.game.AppMain;
import my.game.model.Track;
import my.game.util.Music;

public class MainGUI extends JFrame { // GUI 환경 구축을 위해 JFrame클래스를 상속 -> JFrame내의 메서드를 클래스 선언 없이 사용가능하다.

	// 생성자를 활용해서 GameGUI클래스를 생성하면 게임시작 화면이 나오도록 한다.
	public MainGUI() {

		// ****** 화면 디자인 ******
		setUndecorated(true); // 기본적인 메뉴바가 보이지 않게된다.
		setBackground(new Color(0, 0, 0, 0)); // paintConponent시에 전부 하얀색이 된다.(....?)
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT); // gui창의 크기 설정 -> setSize(가로, 세로)
		setResizable(false); // gui창의 크기 변경 불가
		setLocationRelativeTo(null); // gui창을 실행하면 항상 정중앙에 나온다
		setLayout(null); // gui창의 JLabel, JButton객체들을 원하는 위치에 넣을 수 있다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 해당 메서드를 사용하지 않으면 창을 종료해도 프로그램은 계속 돌아가게 된다.
		setVisible(true); // 화면 출력

		// ****** 음악 ******
		introMusic = new Music("IntroMusic.mp3", true);
		introMusic.start(); // 인트로 음악 재생
		track = new ArrayList<Track>(); // 게임에 사용할 음악 리스트 생성
		track.add(new Track("Clouds by Joakim Karud.png","CloudsTitleImage.png","CloudsTitleEntered.png", "Clouds by Joakim Karud (official).mp3"));
		track.add(new Track("Fireplace by Joakim Karud.png","FireplaceTitleImage.png","FireplaceTitleEntered.png", "Fireplace by Joakim Karud (Official).mp3"));

		// ****** 버튼 ******
		startSet(); // 시작버튼 -> 클릭하면 화면이 전환되고 인트로 음악이 종료된다.
		exitSet(); // 종료버튼 -> 클릭하면 화면이 종료된다.
		scoreBoardSet(); // 점수판버튼 -> 클릭하면 점수판이 나타난다.

		// 곡 선택 버튼 -> 시작버튼 클릭시 활성화 된다.
		leftSelectSet();
		rightSelectSet();

		// 시작화면가기 버튼 -> 시작버튼, 점수판버튼 클릭시 활성화 된다.
		toIntro();
		
		// 게임시작 버튼 -> 곡 선택 화면에서 활성화된다.
		gameStartSet();

	}
	
//	******************************** 변수 ********************************
	// 창 가로(WIDTH), 창 세로(HEIGHT)
	public final int SCREEN_WIDTH = 1280, SCREEN_HEIGHT = 720;
	// main화면인지 아닌지 확인하는 변수
	private boolean isMain = false;
	private boolean isIntro = true;
	private boolean isGamePlay = false;

	// 배경화면 이미지
	private Image background = new ImageIcon(
			AppMain.class.getResource("../img/IntroBackground.jpg")).getImage();

	// 시작 버튼 이미지
	private ImageIcon startButtonBasic = new ImageIcon(
			AppMain.class.getResource("../img/StartButtonBasic.png"));
	private ImageIcon startButtonEntered = new ImageIcon(
			AppMain.class.getResource("../img/StartButtonEntered.png"));
	private JButton startButton = new JButton(startButtonBasic); // 시작 버튼 생성

	// 종료 버튼 이미지
	private ImageIcon exitButtonBasic = new ImageIcon(
			AppMain.class.getResource("../img/ExitButtonBasic.png"));
	private ImageIcon exitButtonEntered = new ImageIcon(
			AppMain.class.getResource("../img/ExitButtonEntered.png"));
	private JButton exitButton = new JButton(exitButtonBasic); // 종료 버튼 생성

	// 점수판 버튼 이미지
	private ImageIcon scoreBoardButtonBasic = new ImageIcon(
			AppMain.class.getResource("../img/ScoreBoardButtonBasic.png"));
	private ImageIcon scoreBoardButtonEntered = new ImageIcon(
			AppMain.class.getResource("../img/ScoreBoardButtonEntered.png"));
	private JButton scoreBoardButton = new JButton(scoreBoardButtonBasic); // 점수판 버튼 생성

	// 곡 선택 버튼(왼쪽) 이미지
	private ImageIcon leftButtonBasic = new ImageIcon(
			AppMain.class.getResource("../img/LeftButtonBasic.png"));
	private ImageIcon leftButtonEntered = new ImageIcon(
			AppMain.class.getResource("../img/LeftButtonEntered.png"));
	private JButton leftButton = new JButton(leftButtonBasic); // 곡 선택 버튼(왼쪽) 생성

	// 곡 선택 버튼(오른쪽) 이미지
	private ImageIcon rightButtonBasic = new ImageIcon(
			AppMain.class.getResource("../img/RightButtonBasic.png"));
	private ImageIcon rightButtonEntered = new ImageIcon(
			AppMain.class.getResource("../img/RightButtonEntered.png"));
	private JButton rightButton = new JButton(rightButtonBasic); // 곡 선택 버튼(오른쪽) 생성

	// 시작화면가기 버튼 이미지
	private ImageIcon toIntroButtonBasic = new ImageIcon(
			AppMain.class.getResource("../img/IntroButtonBasic.png"));
	private ImageIcon toIntroButtonEntered = new ImageIcon(
			AppMain.class.getResource("../img/IntroButtonEntered.png"));
	private JButton toIntroButton = new JButton(toIntroButtonBasic); // 시작화면가기 버튼 생성
	
	// 게임 시작 버튼 이미지
	private ImageIcon gameStartButtonBasic = new ImageIcon(
			AppMain.class.getResource("../img/CloudsTitleImage.png"));
	private ImageIcon gameStartButtonEntered = new ImageIcon(
			AppMain.class.getResource("../img/CloudsTitleEntered.png"));
	private JButton gameStartButton = new JButton(gameStartButtonBasic);

	// 곡 관련 변수
	private Image selectedImage;
	private Music introMusic;
	private ArrayList<Track> track;
	private Music selectedMusic;
	private int nowSelected = 0;
	
//	******************************** 메서드 ********************************
	/*
	 * 사작화면과 관련된 변수들과 매서드 
	 * -> 자바에서 제공하는 이미지를 화면에 띄우는 방식을 사용하게되면 버퍼링이 심하다. 
	 * -> 따라서 더블버퍼링이라는 기법을 사용한다. 
	 */
	private Image screenImage; // 더블 버퍼링을 위한 변수
	private Graphics screenGraphics; // 더블 버퍼링을 위한 변수

//	더블 버퍼링을 사용하지 않은 메서드
//		-> 아래 두 메서드를 주석처리하고 해당 메서드로 실행하면 버퍼링 시간이 차이가 심하다는 것을 알 수 있다.
//	public void paint(Graphics g) {  
//		g.drawImage(background, 0, 0, null);
//	}
	public void paint(Graphics g) { // 형태가 약속된 메서드
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT); // 1.화면과 같은 크기의 이미지를 생성하고
		screenGraphics = screenImage.getGraphics(); // 2.그 이미지를 그래픽으로 담아서
		screenDraw(screenGraphics);
		g.drawImage(screenImage, 0, 0, null); // 5.drawImage메서드를 통해 이미지를 다시 화면에 그린다.
	}

	public void screenDraw(Graphics g) { // 3.drawImage메서드를 통해 이미지를 화면에 그린 후
		g.drawImage(background, 0, 0, null);
		if (isMain) {
			g.drawImage(selectedImage, 350, 60, null);
		}
		paintComponents(g); // 정적인 이미지들은 paintComponents로 구현한다. (...?)
		this.repaint(); // 4.해당 component를 repaint한다.
	}
	/*
	 * 더블 버퍼링 과정에서 repaint()메서드를 활용하는 부분에 대한 설명이 부족하지만 더블버퍼링이 이러한 과정을 통해서 진행되고 더블
	 * 버퍼링을 사용한 경우와 사용하지 않은 경우를 비교할 수 있다.
	 */
	
	// 버튼 관련 매서드
	public void startSet() {
		startButton.setBounds(800, 150, 300, 50);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEntered);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasic);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				startButton.setIcon(startButtonBasic);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				startButton.setIcon(startButtonEntered);
			}

			//	게임 시작 이벤트
			@Override
			public void mouseClicked(MouseEvent e) {
				isIntro = false;
				isMain = true;
				isGamePlay = false;
				
				introMusic.close();
				selectTrack(nowSelected);
				startButton.setVisible(false);
				exitButton.setBounds(1050, 30, 300, 50);
				scoreBoardButton.setVisible(false);
				toIntroButton.setVisible(true);
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				gameStartButton.setVisible(true);
				
				background = new ImageIcon(AppMain.class.getResource("../img/MainBackground.jpg")).getImage();
			}
		});
		add(startButton);
	}

	public void exitSet() {
		exitButton.setBounds(800, 220, 300, 50);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEntered);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasic);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				startButton.setIcon(startButtonBasic);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				startButton.setIcon(startButtonEntered);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					System.out.println(e1.getMessage());
				}
				System.exit(0);
			}
		});
		add(exitButton);
	}

	public void scoreBoardSet() {
		scoreBoardButton.setBounds(800, 400, 300, 50);
		scoreBoardButton.setBorderPainted(false);
		scoreBoardButton.setContentAreaFilled(false);
		scoreBoardButton.setFocusPainted(false);
		scoreBoardButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				scoreBoardButton.setIcon(scoreBoardButtonEntered);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				scoreBoardButton.setIcon(scoreBoardButtonBasic);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				scoreBoardButton.setIcon(scoreBoardButtonBasic);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				scoreBoardButton.setIcon(scoreBoardButtonEntered);
			}

			// 점수판 버튼 이벤트
			@Override
			public void mouseClicked(MouseEvent e) {
				startButton.setVisible(false);
				exitButton.setBounds(1050, 30, 300, 50);
				scoreBoardButton.setVisible(false);
				toIntroButton.setVisible(true);

				background = new ImageIcon(AppMain.class.getResource("../img/MainBackground.jpg")).getImage();
			}
		});
		add(scoreBoardButton);
	}

	public void leftSelectSet() {
		leftButton.setVisible(false);
		leftButton.setBounds(50, 300, 100, 100);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEntered);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasic);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				leftButton.setIcon(leftButtonBasic);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				leftButton.setIcon(leftButtonEntered);
			}

//			 왼쪽 버튼 이벤트
			@Override
			public void mouseClicked(MouseEvent e) {
				leftClick();
			}
		});
		add(leftButton);
	}

	public void rightSelectSet() {
		rightButton.setVisible(false);
		rightButton.setBounds(1150, 300, 100, 100);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEntered);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasic);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				rightButton.setIcon(rightButtonBasic);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				rightButton.setIcon(rightButtonEntered);
			}

//			 오른쪽 버튼 이벤트
			@Override
			public void mouseClicked(MouseEvent e) {
				rightClick();
			}
		});
		add(rightButton);
	}

	public void toIntro() {
		toIntroButton.setVisible(false);
		toIntroButton.setBounds(0, 30, 300, 50);
		toIntroButton.setBorderPainted(false);
		toIntroButton.setContentAreaFilled(false);
		toIntroButton.setFocusPainted(false);
		toIntroButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				toIntroButton.setIcon(toIntroButtonEntered);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				toIntroButton.setIcon(toIntroButtonBasic);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				toIntroButton.setIcon(toIntroButtonBasic);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				toIntroButton.setIcon(toIntroButtonEntered);
			}

//			시작화면가기 버튼 이벤트
			@Override
			public void mouseClicked(MouseEvent e) {
				
				isIntro = true;
				isMain = false;
				isGamePlay = false;
				
				startButton.setVisible(true);
				exitButton.setBounds(800, 220, 300, 50);
				scoreBoardButton.setVisible(true);
				toIntroButton.setVisible(false);
				leftButton.setVisible(false);
				rightButton.setVisible(false);
				gameStartButton.setVisible(false);
				
				if(selectedMusic != null) {
					selectedMusic.close();
				}
				
				if(introMusic != null) {
					introMusic.close();
					introMusic = new Music("IntroMusic.mp3", true);
					introMusic.start();
				}
				
				background = new ImageIcon(AppMain.class.getResource("../img/IntroBackground.jpg")).getImage();
			}
		});
		add(toIntroButton);
	}

	public void gameStartSet() {
		
		gameStartButton.setVisible(false);
		gameStartButton.setBounds(350, 540, 640, 100);
		gameStartButton.setBorderPainted(false);
		gameStartButton.setContentAreaFilled(false);
		gameStartButton.setFocusPainted(false);
		gameStartButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				gameStartButton.setIcon(gameStartButtonEntered);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				gameStartButton.setIcon(gameStartButtonBasic);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				gameStartButton.setIcon(gameStartButtonBasic);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				gameStartButton.setIcon(gameStartButtonEntered);
			}

//			 게임시작 버튼 이벤트
			@Override
			public void mouseClicked(MouseEvent e) {
				isIntro = false;
				isMain = false;
				isGamePlay = true;
				
				gameStartButton.setVisible(false);
				leftButton.setVisible(false);
				rightButton.setVisible(false);
				isMain = false;
				selectedMusic.close();
			}
		});
		add(gameStartButton);
	}

	public void selectTrack(int nowSelected) {
		if (selectedMusic != null) {
			selectedMusic.close();
		}
		gameStartButtonBasic = new ImageIcon(AppMain.class.getResource("../img/"+track.get(nowSelected).getGameStartButtonBasic()));
		gameStartButtonEntered = new ImageIcon(AppMain.class.getResource("../img/"+track.get(nowSelected).getGameStartButtonEntered()));
		gameStartButton.setIcon(gameStartButtonBasic);
		selectedImage = new ImageIcon(AppMain.class.getResource("../img/"+track.get(nowSelected).getSelectedImage())).getImage();
		selectedMusic = new Music(track.get(nowSelected).getSelectedMusic(), true);
		selectedMusic.start();
	}
	
	public void leftClick() {
		if(nowSelected == 0) {
			nowSelected = track.size()-1;
		} else {
			nowSelected--;
		}
		selectTrack(nowSelected);
	}
	
	public void rightClick() {
		if(nowSelected == track.size()-1) {
			nowSelected = 0;
		} else {
			nowSelected++;
		}
		selectTrack(nowSelected);
	}
	
}
