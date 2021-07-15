package music;

import music.view.MusicPlayer;

/*
 * 작성자 : 박태훈
 * 작성일 : 2021-06-16
 * 
 * MusicList에 저장된 mp3 형식의 음악 파일들을 재생하는 프로그램
 * 
 * 이미지 편집 : https://pixlr.com/kr/editor/
 * mp3파일 출처(...?) : https://ytmp3.cc/youtube-to-mp3/
 * 참고한 자료 : 백그라운드 디자인 -> youtube 자바(java) 리듬게임 만들기 강좌 by 동빈 나
 * 			  더블 버퍼링 -> https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=lghlove0509&logNo=221009877738
 * 			  시스템 트레이 -> https://dydtjr1128.github.io/java/2017/05/25/JAVA-system-tray.html
 * 			  특정 폴더의 파일명 추출하기 -> https://gaebaldiary.tistory.com/15
 * 			  키 입력 기능 -> https://cruiseweb.tistory.com/entry/JAVA-GUI-%ED%82%A4-%EC%9D%B4%EB%B2%A4%ED%8A%B8
 * 
 * 해결 못한 문제 : 실행파일로 만들어 지지 않음 (경로 문제로 예상)
 * 				Player 객체의 사용법을 정확히 알 수 없음 (JLayer 라이브러리 자료 부족)
 */
public class Main {
	
	// 배경 사이즈 
	public static final int SCREEN_WIDTH = 360, SCREEN_HEIGHT = 150;
	// 파일들 경로
	public static final String IMG_FOLDER_PATH = "C:\\Music\\img\\";
	public static final String BUTTON_IMG_FOLDER_PATH = "C:\\Music\\img\\button\\";
	public static final String MUSIC_FOLDER_PATH = "C:\\Music\\MusicList\\";

	public static void main(String[] args) {
		new MusicPlayer().start();
	}
}
