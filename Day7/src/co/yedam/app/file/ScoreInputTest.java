package co.yedam.app.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

public class ScoreInputTest {

	public static void main(String[] args) {
		try {
			BufferedReader fr = new BufferedReader(new FileReader("D:/temp/score.txt"));
			PrintStream out = System.out;
			
			String a;
			while((a=fr.readLine()) != null) {
				String[] arr = a.split(" ");
				out.println(Integer.parseInt(arr[0])+Integer.parseInt(arr[1]));
			}
			fr.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
