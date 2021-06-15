package music.model;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import music.Main;

public class ButtonImgs {

	// 시작버튼 이미지
	private ImageIcon playButtonBasic = new ImageIcon(Main.class.getResource("../img/playButtonBasic.png"));
	private ImageIcon playButtonEntered = new ImageIcon(Main.class.getResource("../img/playButtonEntered.png"));

	public ImageIcon getPlayButtonBasic() {
		return playButtonBasic;
	}

	public ImageIcon getPlayButtonEntered() {
		return playButtonEntered;
	}

	// 정지버튼 이미지
	private ImageIcon stopButtonBasic = new ImageIcon(Main.class.getResource("../img/stopButtonBasic.png"));
	private ImageIcon stopButtonEntered = new ImageIcon(Main.class.getResource("../img/stopButtonEntered.png"));

	public ImageIcon getStopButtonBasic() {
		return stopButtonBasic;
	}

	public ImageIcon getStopButtonEntered() {
		return stopButtonEntered;
	}

	// 이전곡버튼 이미지
	private ImageIcon previousButtonBasic = new ImageIcon(Main.class.getResource("../img/previousButtonBasic.png"));
	private ImageIcon previousButtonEntered = new ImageIcon(Main.class.getResource("../img/previousButtonEntered.png"));

	public ImageIcon getPreviousButtonBasic() {
		return previousButtonBasic;
	}

	public ImageIcon getPreviousButtonEntered() {
		return previousButtonEntered;
	}

	// 다음곡버튼 이미지
	private ImageIcon nextButtonBasic = new ImageIcon(Main.class.getResource("../img/nextButtonBasic.png"));
	private ImageIcon nextButtonEntered = new ImageIcon(Main.class.getResource("../img/nextButtonEntered.png"));

	public ImageIcon getNextButtonBasic() {
		return nextButtonBasic;
	}

	public ImageIcon getNextButtonEntered() {
		return nextButtonEntered;
	}

	// 닫기버튼 이미지
	private ImageIcon exitButtonBasic = new ImageIcon(Main.class.getResource("../img/exitButtonBasic.png"));
	private ImageIcon exitButtonEntered = new ImageIcon(Main.class.getResource("../img/exitButtonEntered.png"));

	public ImageIcon getExitButtonBasic() {
		return exitButtonBasic;
	}

	public ImageIcon getExitButtonEntered() {
		return exitButtonEntered;
	}
	
	// 최소화버튼 이미지
	private ImageIcon minimizeButtonBasic = new ImageIcon(Main.class.getResource("../img/minimizeButtonBasic.png"));
	private ImageIcon minimizeButtonEntered = new ImageIcon(Main.class.getResource("../img/minimizeButtonEntered.png"));
	
	public ImageIcon getMinimizeButtonBasic() {
		return minimizeButtonBasic;
	}
	
	public ImageIcon getMinimizeButtonEntered() {
		return minimizeButtonEntered;
	}
	
}
