package music.view;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import music.control.MusicControl;
import music.model.ButtonImgs;

@SuppressWarnings("serial")
public class MusicPlayer extends PlayerBackground{
	
	/*
	 * musicplayer를 제어할 수 있는 다양한 버튼과 그 기능들을 정의해 놓는다.
	 * 	- 목표 -
	 * 	-> 일시정지를 구현
	 * 	-> 재생시간 출력을 구현
	 *  -> 키보드 조작을 구현 (Line 455참조)
	 * 	-> 플레이 리스트 출력을 구현
	 * 	-> 현재 재생 중인 곡이 끝나면 자동으로 다음곡으로 넘어가는 기능 구현
	 * 	-> 한 곡 반복을 선택 할 수 있는 기능 구현
	 */

	ButtonImgs img = new ButtonImgs();
	
	public void start() {
		mainScreen();
		add(playButtonSet());
		add(stopButtonSet());
		add(previousButtonSet());
		add(nextButtonSet());
		add(exitButtonSet());
		add(minimizeButtonSet());
		
	}
	
	boolean isMusicOn; // 음악이 재생 중인지 아닌지 판단
	
	int[] ButtonPosition = {
						115, 70, // 시작 버튼 위치
						110, 75, // 닫기 버튼 위치
						30, 90, // 이전곡 버튼 위치
						280, 90, // 다음곡 버튼 위치
						330, 0, // 닫기 버튼 위치
						300, 8, // 최소화 버튼 위치
					}; 
	int[] ButtonSize = {
			140, 80, // 시작 버튼 및 정지 버튼 크기
			50, 50, // 이전곡 버튼 및 다음곡 버튼 크기
			20, 20, // 닫기 버튼 및 최소화 버튼 크기
	}; 
	
	/*
	 * 버튼을 추가한다면 
	 * 	1. music.model 패키지의 ButtonImgs 클래스에 이미지 파일을 가져오는 변수를 생성(getter 메서드만 만듬)
	 * 	2. ButtonPosition 배열과 ButtonSize 배열에 버튼의 위치와 크기를 추가
	 * 	2. 추가하는 버튼을 생성
	 * 	3. 버튼의 기능을 정의하는 메서드를 생성
	 */
	public JButton playButton = new JButton(img.getPlayButtonBasic()); // 시작 버튼 생성
	public JButton stopButton = new JButton(img.getStopButtonBasic()); // 정지 버튼 생성
	public JButton previousButton = new JButton(img.getPreviousButtonBasic()); // 이전곡 버튼 생성
	public JButton nextButton = new JButton(img.getNextButtonBasic()); // 다음곡 버튼 생성
	public JButton exitButton = new JButton(img.getExitButtonBasic()); // 닫기 버튼 생성
	public JButton minimizeButton = new JButton(img.getMinimizeButtonBasic()); // 최소화 버튼 생성
	
	// 시작 버튼 세팅
	public JButton playButtonSet() {
		playButton.setBounds(ButtonPosition[0], ButtonPosition[1], // 위치 설정
							ButtonSize[0], ButtonSize[1]); // 크기 설정
		// 버튼 이미지 커스텀을 위한 세팅
		playButton.setBorderPainted(false);
		playButton.setContentAreaFilled(false);
		playButton.setFocusPainted(false);
		// 마우스 조작 설정
		playButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼 위로 올때
				playButton.setIcon(img.getPlayButtonEntered()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어날 때
				playButton.setIcon(img.getPlayButtonBasic()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mousePressed(MouseEvent e) { // 버튼을 꾹 누르고 있을때
				playButton.setIcon(img.getPlayButtonBasic()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mouseReleased(MouseEvent e) { // 누르고 있던 버튼을 놓을때
				playButton.setIcon(img.getPlayButtonEntered()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mouseClicked(MouseEvent e) { // 버튼을 클릭할때
				stopMusic(); // 현재 재생되고 있던 노래를 종료한다.
				startMusic(); // 노래를 재생한다.
				buttonVisiblity(isMusicOn); // Play버튼이 꺼지고 Stop버튼이 켜진다
			}
		});
		playButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					try {
						Thread.sleep(200); // 0.2초의 간격을 둔다.
					} catch (InterruptedException e1) {
						System.out.println(e1.getMessage());
					}
					System.exit(0); // 프로그램을 종료한다.
				}
			}
		});
		return playButton;
	}
	
	// 정지 버튼 세팅
	public JButton stopButtonSet() {
		stopButton.setVisible(false);
		stopButton.setBounds(ButtonPosition[2], ButtonPosition[3], // 위치 설정
							ButtonSize[0], ButtonSize[1]); // 크기 설정
		// 버튼 이미지 커스텀을 위한 세팅
		stopButton.setBorderPainted(false);
		stopButton.setContentAreaFilled(false);
		stopButton.setFocusPainted(false);
		// 마우스 조작 설정
		stopButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼 위로 올때
				stopButton.setIcon(img.getStopButtonEntered()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어날 때
				stopButton.setIcon(img.getStopButtonBasic()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mousePressed(MouseEvent e) { // 버튼을 꾹 누르고 있을때
				stopButton.setIcon(img.getStopButtonBasic()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mouseReleased(MouseEvent e) { // 누르고 있던 버튼을 놓을때
				stopButton.setIcon(img.getStopButtonEntered()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mouseClicked(MouseEvent e) { // 버튼을 클릭할때
				stopMusic(); // 현재 재생되고 있던 노래를 종료한다.
				buttonVisiblity(isMusicOn); // Stop버튼이 꺼지고 Play버튼이 켜진다
			}
		});
		return stopButton;
	}
	
	// 이전곡 버튼 세팅
	public JButton previousButtonSet() {
		previousButton.setBounds(ButtonPosition[4], ButtonPosition[5], // 위치 설정
								ButtonSize[2], ButtonSize[3]); // 크기 설정
		// 버튼 이미지 커스텀을 위한 세팅
		previousButton.setBorderPainted(false);
		previousButton.setContentAreaFilled(false);
		previousButton.setFocusPainted(false);
		// 마우스 조작 설정
		previousButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼 위로 올때
				previousButton.setIcon(img.getPreviousButtonEntered()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어날 때
				previousButton.setIcon(img.getPreviousButtonBasic()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mousePressed(MouseEvent e) { // 버튼을 꾹 누르고 있을때
				previousButton.setIcon(img.getPreviousButtonBasic()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mouseReleased(MouseEvent e) { // 누르고 있던 버튼을 놓을때
				previousButton.setIcon(img.getPreviousButtonEntered()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mouseClicked(MouseEvent e) { // 버튼을 클릭할때
				stopMusic(); // 현재 재생되고 있던 노래를 종료한다.
				previousMusic(); // 이전 곡을 선택한다.
				startMusic(); // 노래를 재생한다.
				buttonVisiblity(isMusicOn); // Play버튼이 꺼지고 Stop버튼이 켜진다
			}
		});
		return previousButton;
	}
	
	// 다음곡 버튼 세팅
	public JButton nextButtonSet() {
		nextButton.setBounds(ButtonPosition[6], ButtonPosition[7], // 위치 설정
							ButtonSize[2], ButtonSize[3]); // 크기 설정
		// 버튼 이미지 커스텀을 위한 세팅
		nextButton.setBorderPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setFocusPainted(false);
		// 마우스 조작 설정
		nextButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼 위로 올때
				nextButton.setIcon(img.getNextButtonEntered()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어날 때
				nextButton.setIcon(img.getNextButtonBasic()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mousePressed(MouseEvent e) { // 버튼을 꾹 누르고 있을때
				nextButton.setIcon(img.getNextButtonBasic()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mouseReleased(MouseEvent e) { // 누르고 있던 버튼을 놓을때
				nextButton.setIcon(img.getNextButtonEntered()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mouseClicked(MouseEvent e) { // 버튼을 클릭할때
				stopMusic(); // 현재 재생되고 있던 노래를 종료한다.
				nextMusic(); // 다음 곡을 선택한다.
				startMusic(); // 노래를 재생한다.
				buttonVisiblity(isMusicOn); // Play버튼이 꺼지고 Stop버튼이 켜진다
			}
		});
		return nextButton;
	}

	// 닫기 버튼 세팅
	public JButton exitButtonSet() {
		exitButton.setBounds(ButtonPosition[8], ButtonPosition[9], // 위치 설정
							ButtonSize[4], ButtonSize[5]); // 크기 설정
		// 버튼 이미지 커스텀을 위한 세팅
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		// 마우스 조작 설정
		exitButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼 위로 올때
				exitButton.setIcon(img.getExitButtonEntered()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어날 때
				exitButton.setIcon(img.getExitButtonBasic()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mousePressed(MouseEvent e) { // 버튼을 꾹 누르고 있을때
				exitButton.setIcon(img.getExitButtonBasic()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mouseReleased(MouseEvent e) { // 누르고 있던 버튼을 놓을때
				exitButton.setIcon(img.getExitButtonEntered()); // 해당 이미지로 이미지 변경
			}

			@Override
			public void mouseClicked(MouseEvent e) { // 버튼을 클릭할때
				try {
					Thread.sleep(200); // 0.2초의 간격을 둔다.
				} catch (InterruptedException e1) {
					System.out.println(e1.getMessage());
				}
				System.exit(0); // 프로그램을 종료한다.
			}
		});
		return exitButton;
	}
	
	// 최소화 버튼 세팅 (시스템 트레이로 보내는 역할)
	public JButton minimizeButtonSet() {
		minimizeButton.setBounds(ButtonPosition[10], ButtonPosition[11], // 위치 설정
								ButtonSize[4], ButtonSize[5]); // 크기 설정
		// 버튼 이미지 커스텀을 위한 세팅
		minimizeButton.setBorderPainted(false);
		minimizeButton.setContentAreaFilled(false);
		minimizeButton.setFocusPainted(false);
		// 마우스 조작 설정
		minimizeButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼 위로 올때
				minimizeButton.setIcon(img.getMinimizeButtonEntered()); // 해당 이미지로 이미지 변경
			}
			
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼을 벗어날 때
				minimizeButton.setIcon(img.getMinimizeButtonBasic()); // 해당 이미지로 이미지 변경
			}
			
			@Override
			public void mousePressed(MouseEvent e) { // 버튼을 꾹 누르고 있을때
				minimizeButton.setIcon(img.getMinimizeButtonBasic()); // 해당 이미지로 이미지 변경
			}
			
			@Override
			public void mouseReleased(MouseEvent e) { // 누르고 있던 버튼을 놓을때
				minimizeButton.setIcon(img.getMinimizeButtonEntered()); // 해당 이미지로 이미지 변경
			}
			
			@Override
			public void mouseClicked(MouseEvent e) { // 버튼을 클릭할때
				try {
					Thread.sleep(200); // 0.2초의 간격을 둔다.
				} catch (InterruptedException e1) {
					System.out.println(e1.getMessage());
				}
				setVisible(false); // gui윈도우를 보이지 않게 설정 -> 해당 기능에 대한 버그가 있었다(line 439 참고)
				makeTray(); // 시스템 트레이에 추가
			}
		});
		return minimizeButton;
	}
	
	// 음악 재생 여부에 따라 play버튼과 stop버튼이 점멸
	public void buttonVisiblity(boolean isMusicOn) {
		if (isMusicOn) { // isMusicON이 true일때 (음악이 재생되고 있을때)
			
			// Play버튼을 보이지 않게 하고 Stop버튼을 보이게 한다.
			playButton.setVisible(false); 
			stopButton.setVisible(true); 
			
		} else { // isMusicON이 true일때 (음악이 재생되고 있지 않을때)
			
			// Play버튼을 보이게 하고 Stop버튼을 보이지 않게 한다.
			playButton.setVisible(true); 
			stopButton.setVisible(false); 
		}
	}
	
	// 음악을 시작
	public void startMusic() { // 음악을 시작 한다.
		// 현재 선택된 음악(music.get(currentPlay).getMusicName())을 반복 재생(true)한다는 선언.
		selectedMusic = new MusicControl(music.get(currentPlay).getMusicName(), true);
		selectedMusic.start(); // 음악 재생
		isMusicOn = true; // 음악이 재생되고 있음을 알린다.
	}
	
	// 음악을 정지
	public void stopMusic() {
		if (selectedMusic != null) { // 현재 선택된 음악이 있을 경우
			selectedMusic.close(); // 그 음악을 정지
			isMusicOn = false; // 음악이 정지되었음을 알린다.
		}
	}
	
	/*
	 * mp3파일들을 ArrayList에 넣었기 때문에 List의 index로 접근한다.
	 */
	// 이전 곡 선택
	public void previousMusic() {
		if (currentPlay == 0) { // 현재 선택된 음악의 index가 0일때
			currentPlay = music.size() - 1; // List의 마지막 index에 있는 곡을 선택한다.
		} else {
			currentPlay--; // index를 하나 줄인다.
		}
	}
	// 다음 곡 선택 
	public void nextMusic() {
		if (currentPlay == music.size() - 1) { // 현재 선택된 음악의 index가 마지막 index일때
			currentPlay = 0; // List의 첫번째 index에 있는 곡을 선택한다.
		} else {
			currentPlay++; // index를 하나 더한다.
		}
	}
	
	// 시스템 트레이(최소화)를 위한 메서드
	public void makeTray() {
		/*
		 * PopupMenu에 원하는 기능을 하는 MenuItem을 추가해서 
		 * 트레이 아이콘을 우클릭 시 MenuItem이 보이도록 한다.
		 * MenuItem에 기능추가는 ActionListener로 한다.
		 * 자세한 내용은 아래 사이트를 참조 (또는 구글링)
		 * 	-> https://dydtjr1128.github.io/java/2017/05/25/JAVA-system-tray.html
		 */
	    MenuItem exitItem = new MenuItem("close"); 
	    MenuItem restoreItem = new MenuItem("restore");
	    MenuItem nextItem = new MenuItem("next");
	    MenuItem previousItem = new MenuItem("previous");
	    PopupMenu menu = new PopupMenu("My Menu");
	    TrayIcon myTray = new TrayIcon(img.getMinimizeButtonBasic().getImage(), "music", menu);
	    SystemTray tray = SystemTray.getSystemTray();

	    exitItem.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            System.exit(0);
	        }
	    });
	    menu.add(exitItem);
	    
	    restoreItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tray.remove(myTray);
				setVisible(true);
			}
		});
	    menu.add(restoreItem);
	    
	    nextItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				stopMusic(); // 현재 재생되고 있던 노래를 종료한다.
				nextMusic(); // 다음 곡을 선택한다.
				startMusic(); // 노래를 재생한다.
				buttonVisiblity(isMusicOn); // Play버튼이 꺼지고 Stop버튼이 켜진다
			}
		});
	    menu.add(nextItem);
	    
	    previousItem.addActionListener(new ActionListener() {
	    	
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		stopMusic(); // 현재 재생되고 있던 노래를 종료한다.
				previousMusic(); // 이전 곡을 선택한다.
				startMusic(); // 노래를 재생한다.
				buttonVisiblity(isMusicOn); // Play버튼이 꺼지고 Stop버튼이 켜진다
	    	}
	    });
	    menu.add(previousItem);

	    try {
	        tray.add(myTray);
	    } catch (AWTException e1) {
	        System.out.println(e1.getMessage());
	    }
	    myTray.setImageAutoSize(true);
	}

	
	/*
	 * setVisible()버그에 대한 주석
	 * 
	 * 1. 최초에 설계를 할 때 gui윈도우 생성을 PlayerBackground의 생성자로 진행했었다.
	 * 
	 * 2. 문제는 gui윈도우를 보이지 않게하는 기능을 PlayerBackground클래스를 상속받는 
	 *    MusicPlayer클래스에서 추가를 했는데 setVisible(false)가 원하는 대로 기능하지 않았다.
	 * 
	 * 3. PlayerBackground는 음악 리스트와 gui윈도우만 생성하고 버튼을 MusicPlayer에서 추가하자 해결되었다.
	 * 
	 * 4. 버그의 이유와 해결된 이유를 정확히 알아내지 못했다.(혹시 아시는 분이 계시다면 가르쳐주시기바랍니다...)
	 * 
	 */
	
	
	
	/*
	 * KeyListener 버그에 대한 주석
	 * 
	 * 1. 입력기능을 구현했었지만 Frame에 최초에 추가되는 play버튼에만 키 기능이 추가되고
	 * 
	 * 2. 구현한 입력기능도 최초 한 번만 적용되고 이후에는 적용되지 않는다.
	 * 		ex) space를 입력(음악재생)한 이후 esc를 입력(종료)해도 기능하지 않음
	 * 
	 * 3. 이유를 알 수 없음, 해결하지 못함.
	 */
}
