package music.view;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;

import music.control.MusicControl;
import music.model.ButtonImgs;

public class MusicPlayer extends PlayerBackground{

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
	
	boolean isMusicOn;

	public JButton playButton = new JButton(img.getPlayButtonBasic()); // 시작 버튼 생성
	public JButton stopButton = new JButton(img.getStopButtonBasic()); // 정지 버튼 생성
	public JButton previousButton = new JButton(img.getPreviousButtonBasic()); // 이전곡 버튼 생성
	public JButton nextButton = new JButton(img.getNextButtonBasic()); // 다음곡 버튼 생성
	public JButton exitButton = new JButton(img.getExitButtonBasic()); // 닫기 버튼 생성
	public JButton minimizeButton = new JButton(img.getMinimizeButtonBasic()); // 최소화 버튼 생성
	
	// 시작버튼 
	public JButton playButtonSet() {
		playButton.setBounds(120, 60, 120, 50);
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
				if (selectedMusic != null) {
					selectedMusic.close();
				}
				selectedMusic = new MusicControl(music.get(currentPlay).getMusicName(), true);
				selectedMusic.start();
				isMusicOn = true;
				buttonVisiblity(isMusicOn);
			}
		});
		return playButton;
	}

	public JButton stopButtonSet() {
		stopButton.setVisible(false);
		stopButton.setBounds(120, 60, 120, 50);
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
				if (selectedMusic != null) {
					isMusicOn = false;
					selectedMusic.close();
				}
				buttonVisiblity(isMusicOn);
			}
		});
		return stopButton;
	}

	public JButton previousButtonSet() {
		previousButton.setBounds(20, 55, 60, 60);
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
				if (selectedMusic != null) {
					selectedMusic.close();
				}
				selectedMusic = new MusicControl(music.get(currentPlay).getMusicName(), true);
				selectedMusic.start();
				isMusicOn = true;
				buttonVisiblity(isMusicOn);
			}
		});
		return previousButton;
	}

	public JButton nextButtonSet() {
		nextButton.setBounds(280, 55, 60, 60);
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
				if (selectedMusic != null) {
					selectedMusic.close();
				}
				selectedMusic = new MusicControl(music.get(currentPlay).getMusicName(), true);
				selectedMusic.start();
				isMusicOn = true;
				buttonVisiblity(isMusicOn);
			}
		});
		return nextButton;
	}

	public JButton exitButtonSet() {
		exitButton.setBounds(330, 0, 30, 30);
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
		minimizeButton.setBounds(0, 0, 30, 30);
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

	public void buttonVisiblity(boolean isMusicOn) {
		if (isMusicOn) {
			playButton.setVisible(false);
			stopButton.setVisible(true);
		} else {
			playButton.setVisible(true);
			stopButton.setVisible(false);
		}
	}
	
	public void makeTray() {
	    MenuItem exitItem = new MenuItem("close");
	    MenuItem restoreItem = new MenuItem("restore");
	    PopupMenu menu = new PopupMenu("My Menu");
	    TrayIcon myTray = 
		        new TrayIcon(Toolkit.getDefaultToolkit().getImage( 
		        		"C:\\Users\\TaeHun\\git\\Training-course\\MusicPlayer\\src\\img\\button\\minimizeButtonBasic.png"), "music", menu);
		    			// 상대경로로 이미지 지정이 되지 않음...
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
