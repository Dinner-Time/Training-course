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

import javax.swing.JButton;

import com.sun.tools.javac.Main;

import music.control.MusicControl;
import music.model.ButtonImgs;

public class MusicPlayer extends PlayerScreen{

	ButtonImgs b = new ButtonImgs();
	
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

	public JButton playButton = new JButton(b.getPlayButtonBasic()); // 시작 버튼 생성
	public JButton stopButton = new JButton(b.getStopButtonBasic()); // 정지 버튼 생성
	public JButton previousButton = new JButton(b.getPreviousButtonBasic()); // 이전곡 버튼 생성
	public JButton nextButton = new JButton(b.getNextButtonBasic()); // 다음곡 버튼 생성
	public JButton exitButton = new JButton(b.getExitButtonBasic()); // 닫기 버튼 생성
	public JButton minimizeButton = new JButton(b.getMinimizeButtonBasic()); // 최소화 버튼 생성
	
	public JButton playButtonSet() {
		playButton.setBounds(350, 350, 120, 50);
		playButton.setBorderPainted(false);
		playButton.setContentAreaFilled(false);
		playButton.setFocusPainted(false);
		playButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				playButton.setIcon(b.getPlayButtonEntered());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				playButton.setIcon(b.getPlayButtonBasic());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				playButton.setIcon(b.getPlayButtonBasic());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				playButton.setIcon(b.getPlayButtonEntered());
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
		stopButton.setBounds(350, 350, 120, 50);
		stopButton.setBorderPainted(false);
		stopButton.setContentAreaFilled(false);
		stopButton.setFocusPainted(false);
		stopButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				stopButton.setIcon(b.getStopButtonEntered());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				stopButton.setIcon(b.getStopButtonBasic());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				stopButton.setIcon(b.getStopButtonBasic());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				stopButton.setIcon(b.getStopButtonEntered());
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
		previousButton.setBounds(200, 350, 60, 60);
		previousButton.setBorderPainted(false);
		previousButton.setContentAreaFilled(false);
		previousButton.setFocusPainted(false);
		previousButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				previousButton.setIcon(b.getPreviousButtonEntered());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				previousButton.setIcon(b.getPreviousButtonBasic());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				previousButton.setIcon(b.getPreviousButtonBasic());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				previousButton.setIcon(b.getPreviousButtonEntered());
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
		nextButton.setBounds(550, 350, 60, 60);
		nextButton.setBorderPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setFocusPainted(false);
		nextButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				nextButton.setIcon(b.getNextButtonEntered());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				nextButton.setIcon(b.getNextButtonBasic());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				nextButton.setIcon(b.getNextButtonBasic());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				nextButton.setIcon(b.getNextButtonEntered());
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
		exitButton.setBounds(600, 10, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(b.getExitButtonEntered());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(b.getExitButtonBasic());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				exitButton.setIcon(b.getExitButtonBasic());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				exitButton.setIcon(b.getExitButtonEntered());
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
		minimizeButton.setBounds(570, 10, 30, 30);
		minimizeButton.setBorderPainted(false);
		minimizeButton.setContentAreaFilled(false);
		minimizeButton.setFocusPainted(false);
		minimizeButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				minimizeButton.setIcon(b.getMinimizeButtonEntered());
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				minimizeButton.setIcon(b.getMinimizeButtonBasic());
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				minimizeButton.setIcon(b.getMinimizeButtonBasic());
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				minimizeButton.setIcon(b.getMinimizeButtonEntered());
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
	    MenuItem exitItem = new MenuItem("exit");
	    MenuItem restoreItem = new MenuItem("restore");
	    PopupMenu menu = new PopupMenu("My Menu");

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
				setVisible(true);
			}
		});
	    menu.add(restoreItem);

	    TrayIcon myTray = 
	        new TrayIcon(Toolkit.getDefaultToolkit().getImage(
	        		"C:\\dev\\workspace\\MusicPlayer\\src\\img\\exitButtonBasic.png"), "music", menu);
	    SystemTray tray = SystemTray.getSystemTray();

	    try {
	        tray.add(myTray);
	    } catch (AWTException e1) {
	        System.out.println(e1.getMessage());
	    }
	    myTray.setImageAutoSize(true);
	}
}
