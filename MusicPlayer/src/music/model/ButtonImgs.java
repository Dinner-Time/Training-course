package music.model;

import javax.swing.ImageIcon;

import music.Main;

public class ButtonImgs {
	/*
	 * 버튼 이미지를 저장하는 model class
	 * 버튼 이미지들은 변경할 수 없도록 getter메서드들만 만든다.
	 */

	// 시작버튼 이미지
	private ImageIcon playButtonBasic = new ImageIcon(Main.BUTTON_IMG_FOLDER_PATH + "playButtonBasic.png");
	private ImageIcon playButtonEntered = new ImageIcon(Main.BUTTON_IMG_FOLDER_PATH + "playButtonEntered.png");

	public ImageIcon getPlayButtonBasic() {
		return playButtonBasic;
	}

	public ImageIcon getPlayButtonEntered() {
		return playButtonEntered;
	}

	// 정지버튼 이미지
	private ImageIcon stopButtonBasic = new ImageIcon(Main.BUTTON_IMG_FOLDER_PATH + "stopButtonBasic.png");
	private ImageIcon stopButtonEntered = new ImageIcon(Main.BUTTON_IMG_FOLDER_PATH + "stopButtonEntered.png");

	public ImageIcon getStopButtonBasic() {
		return stopButtonBasic;
	}

	public ImageIcon getStopButtonEntered() {
		return stopButtonEntered;
	}

	// 이전곡버튼 이미지
	private ImageIcon previousButtonBasic = new ImageIcon(Main.BUTTON_IMG_FOLDER_PATH + "previousButtonBasic.png");
	private ImageIcon previousButtonEntered = new ImageIcon(Main.BUTTON_IMG_FOLDER_PATH + "previousButtonEntered.png");

	public ImageIcon getPreviousButtonBasic() {
		return previousButtonBasic;
	}

	public ImageIcon getPreviousButtonEntered() {
		return previousButtonEntered;
	}

	// 다음곡버튼 이미지
	private ImageIcon nextButtonBasic = new ImageIcon(Main.BUTTON_IMG_FOLDER_PATH + "nextButtonBasic.png");
	private ImageIcon nextButtonEntered = new ImageIcon(Main.BUTTON_IMG_FOLDER_PATH + "nextButtonEntered.png");

	public ImageIcon getNextButtonBasic() {
		return nextButtonBasic;
	}

	public ImageIcon getNextButtonEntered() {
		return nextButtonEntered;
	}

	// 닫기버튼 이미지
	private ImageIcon exitButtonBasic = new ImageIcon(Main.BUTTON_IMG_FOLDER_PATH + "exitButtonBasic.png");
	private ImageIcon exitButtonEntered = new ImageIcon(Main.BUTTON_IMG_FOLDER_PATH + "exitButtonEntered.png");

	public ImageIcon getExitButtonBasic() {
		return exitButtonBasic;
	}

	public ImageIcon getExitButtonEntered() {
		return exitButtonEntered;
	}
	
	// 최소화버튼 이미지
	private ImageIcon minimizeButtonBasic = new ImageIcon(Main.BUTTON_IMG_FOLDER_PATH + "minimizeButtonBasic.png");
	private ImageIcon minimizeButtonEntered = new ImageIcon(Main.BUTTON_IMG_FOLDER_PATH + "minimizeButtonEntered.png");
	
	public ImageIcon getMinimizeButtonBasic() {
		return minimizeButtonBasic;
	}
	
	public ImageIcon getMinimizeButtonEntered() {
		return minimizeButtonEntered;
	}
	
}
