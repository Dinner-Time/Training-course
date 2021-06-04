package co.yedam.app.file;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {
//		fileCreate();
//		makeFolder();
//		fileInfo();
		folderList();
	}

	public static void fileCreate() throws IOException {
		File file = new File("d:/temp/diary.txt");
		file.createNewFile();
	}

	private static void makeFolder() {
		File dir = new File("d:/temp/images");
		dir.mkdir();
	}

	private static void fileInfo() {
		File info = new File("d:/temp/image.png");
		System.out.println(info.getName());
		System.out.println(info.canExecute());

	}

	private static void folderList() {
		File dir = new File("d:/temp");
		if(dir.isDirectory()) {
			File[] list = dir.listFiles();
			for(File f : list) {
				if (StringUtil.getExtension(f.getName()).equals("png")) {
					System.out.println(f.getName());
					FileUtil.fileCopy(f.getAbsolutePath(), "d:/temp/images/"+f.getName());
				}
			}
		}
		
	}
}
