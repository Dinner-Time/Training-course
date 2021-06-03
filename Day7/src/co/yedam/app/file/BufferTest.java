package co.yedam.app.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

public class BufferTest {

	public static void main(String[] args) {
		try {
			BufferedReader fr = new BufferedReader(new FileReader("D:/temp/data.txt"));
			PrintStream out = System.out;
			
			String a;
			while((a=fr.readLine()) != null) {
				out.println(a);
			}
			fr.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
