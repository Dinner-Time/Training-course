package api;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class SystemTest {
	public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
		
//		System.out.println(System.currentTimeMillis());
//		
//		Map<String, String> map = System.getenv();
//		Iterator<String> iter = map.keySet().iterator();
//		while(iter.hasNext()) {
//			String key = iter.next();
//			System.out.println(key + ":" + map.get(key));
//		}
		
		Field[] fields = Book.class.getDeclaredFields();
		for(Field f : fields) {
			System.out.println(f.getName());
			System.out.println(f.getType());
			System.out.println();
		}
		
		URI uri = Book.class.getResource("/resources/menu.txt").toURI();
		Scanner scanner = new Scanner(new File(uri));
		System.out.println(scanner.next());
		
	}
}
