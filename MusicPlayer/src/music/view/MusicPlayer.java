package music.view;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	public JButton playButton = new JButton(img.getPlayButtonBasic()); // 시작 버튼 생성
	public JButton stopButton = new JButton(img.getStopButtonBasic()); // 정지 버튼 생성
	public JButton previousButton = new JButton(img.getPreviousButtonBasic()); // 이전곡 버튼 생성
	public JButton nextButton = new JButton(img.getNextButtonBasic()); // 다음곡 버튼 생성
	public JButton exitButton = new JButton(img.getExitButtonBasic()); // 닫기 버튼 생성
	public JButton minimizeButton = new JButton(img.getMinimizeButtonBasic()); // 최소화 버튼 생성
	
	// 시작버튼 
	public JButton playButtonSet() {
		playButton.setBounds(ButtonPosition[0], ButtonPosition[1],
							ButtonSize[0], ButtonSize[1]);
		playButton.setBorderPainted(false);
		playButton.setContentAreaFilled(false);
		playButton.setFocusPainted(false);
		playButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				playButton.setIcon(img.getPlayButtonEntered());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				playButton.setIcon(img.getPlayButtonBasic());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				playButton.setIcon(img.getPlayButtonBasic());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				playButton.setIcon(img.getPlayButtonEntered());
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				stopMusic();
				startMusic();
				buttonVisiblity(isMusicOn);
			}
		});
		return playButton;
	}

	public JButton stopButtonSet() {
		stopButton.setVisible(false);
		stopButton.setBounds(ButtonPosition[2], ButtonPosition[3],
							ButtonSize[0], ButtonSize[1]);
		stopButton.setBorderPainted(false);
		stopButton.setContentAreaFilled(false);
		stopButton.setFocusPainted(false);
		stopButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				stopButton.setIcon(img.getStopButtonEntered());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				stopButton.setIcon(img.getStopButtonBasic());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				stopButton.setIcon(img.getStopButtonBasic());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				stopButton.setIcon(img.getStopButtonEntered());
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				stopMusic();
				buttonVisiblity(isMusicOn);
			}
		});
		return stopButton;
	}

	public JButton previousButtonSet() {
		previousButton.setBounds(ButtonPosition[4], ButtonPosition[5], 
								ButtonSize[2], ButtonSize[3]);
		previousButton.setBorderPainted(false);
		previousButton.setContentAreaFilled(false);
		previousButton.setFocusPainted(false);
		previousButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				previousButton.setIcon(img.getPreviousButtonEntered());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				previousButton.setIcon(img.getPreviousButtonBasic());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				previousButton.setIcon(img.getPreviousButtonBasic());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				previousButton.setIcon(img.getPreviousButtonEntered());
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (currentPlay == 0) {
					currentPlay = music.size() - 1;
				} else {
					currentPlay--;
				}
				stopMusic();
				startMusic();
				buttonVisiblity(isMusicOn);
			}
		});
		return previousButton;
	}

	public JButton nextButtonSet() {
		nextButton.setBounds(ButtonPosition[6], ButtonPosition[7], 
							ButtonSize[2], ButtonSize[3]);
		nextButton.setBorderPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setFocusPainted(false);
		nextButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				nextButton.setIcon(img.getNextButtonEntered());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				nextButton.setIcon(img.getNextButtonBasic());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				nextButton.setIcon(img.getNextButtonBasic());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				nextButton.setIcon(img.getNextButtonEntered());
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (currentPlay == music.size() - 1) {
					currentPlay = 0;
				} else {
					currentPlay++;
				}
				stopMusic();
				startMusic();
				buttonVisiblity(isMusicOn);
			}
		});
		return nextButton;
	}

	public JButton exitButtonSet() {
		exitButton.setBounds(ButtonPosition[8], ButtonPosition[9], 
							ButtonSize[4], ButtonSize[5]);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(img.getExitButtonEntered());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(img.getExitButtonBasic());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				exitButton.setIcon(img.getExitButtonBasic());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				exitButton.setIcon(img.getExitButtonEntered());
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
		return exitButton;
	}
	
	public JButton minimizeButtonSet() {
		minimizeButton.setBounds(ButtonPosition[10], ButtonPosition[11], 
								ButtonSize[4], ButtonSize[5]);
		minimizeButton.setBorderPainted(false);
		minimizeButton.setContentAreaFilled(false);
		minimizeButton.setFocusPainted(false);
		minimizeButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				minimizeButton.setIcon(img.getMinimizeButtonEntered());
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				minimizeButton.setIcon(img.getMinimizeButtonBasic());
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				minimizeButton.setIcon(img.getMinimizeButtonBasic());
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				minimizeButton.setIcon(img.getMinimizeButtonEntered());
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					System.out.println(e1.getMessage());
				}
				setVisible(false);
				makeTray();
			}
		});
		return minimizeButton;
	}

	// 음악 재생 여부에 따라 play버튼과 stop버튼이 점멸한다.
	public void buttonVisiblity(boolean isMusicOn) {
		/*
		 * playButton과 stopButton의 setVisible을 조절한다.
		 */
		if (isMusicOn) {
			playButton.setVisible(false);
			stopButton.setVisible(true);
		} else {
			playButton.setVisible(true);
			stopButton.setVisible(false);
		}
	}
	
	public void startMusic() {
		selectedMusic = new MusicControl(music.get(currentPlay).getMusicName(), false);
		selectedMusic.start();
		isMusicOn = true;
		
	}
	
	public void stopMusic() {
		if (selectedMusic != null) {
			selectedMusic.close();
			isMusicOn = false;
		}
	}
	
	// 시스템 트레이(최소화)를 위한 메서드
	public void makeTray() {
		/*
		 * PopupMenu에 원하는 기능을 하는 MenuItem을 추가해서 
		 * 트레이 아이콘을 우클릭 시 MenuItem이 보이도록 한다.
		 * MenuItem에 기능추가는 ActionListener로 한다.
		 */
	    MenuItem exitItem = new MenuItem("close"); 
	    MenuItem restoreItem = new MenuItem("restore");
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

	    try {
	        tray.add(myTray);
	    } catch (AWTException e1) {
	        System.out.println(e1.getMessage());
	    }
	    myTray.setImageAutoSize(true);
	}
}
