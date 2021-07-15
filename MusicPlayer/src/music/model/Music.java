package music.model;

public class Music {
	/*
	 * 음악파일의 정보를 담는 model class
	 * 확장성을 위해 클래스로 생성
	 */
	
	private String musicName; // mp3파일명을 저장
//	private String musicImg; // 이미지를 저장 -> 해당 변수를 활용한 기능을 추가하지 않음
	

	public Music(String musicName) {
		super();
		this.musicName = musicName;
	}

	public String getMusicName() {
		return musicName;
	}
	
}
