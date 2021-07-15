package exam5;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		File dir = new File("C:\\dev\\workspace\\MusicPlayer\\src\\MusicList");
		File files[] = dir.listFiles();

		for (int i = 0; i < files.length; i++) {
			String s = files[i].getPath();
			s = s.substring(s.lastIndexOf('\\')+1);
			if(s.substring(s.lastIndexOf('.')+1).equals("mp3")) {
				System.out.println(s);
			}
		}
	}
}
