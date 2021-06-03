package co.yedam.app.file;

import java.io.FileReader;
import java.io.FileWriter;

public class TextFileCopy {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("D:/temp/data.txt");
			FileWriter fw = new FileWriter("D:/temp/data1.txt");
			char[] c = new char[100];
			while(true) {
				int cnt = fr.read(c);
				if(cnt==-1) break;
				fw.write(c);
			}
			fw.close();
			fr.close();
			
			fr = new FileReader("D:/temp/data.txt");
			FileWriter fw1 = new FileWriter("D:/temp/data2.txt");
			int d;
			while(true) {
				d=fr.read();
				fw1.write(d);
				if(d==-1) {
					break;
				}
			}
			fw1.close();
			fr.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
