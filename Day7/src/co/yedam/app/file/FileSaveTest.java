package co.yedam.app.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class FileSaveTest {

	public static void main(String[] args) {
		//byte:stream	char:reader
		try {
			BufferedReader isr = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new FileWriter("D:/temp/f.dat"));
			while(true) {
				String c = isr.readLine();
				if(c==null) {
					break;
				}
				bw.write(c);
				bw.write("\n");
			}
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
