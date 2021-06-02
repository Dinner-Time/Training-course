package pkg.collect;

public class StringUtil {
	//파일명 추출
	public static String getFileName(String path) {
		String s = null;
		if (path == null) {
			return null;
		}
		s = path.substring(path.lastIndexOf('/')+1);
		return s;
	}
	// 확장자
	public static String getExtension(String path) {
		String s = null;
		if (path == null) {
			return null;
		}
		s = path.substring(path.lastIndexOf('.')+1);
		return s;
	}
	// 경로 (파일명을 제외한 문자열)
	public static String getPath(String path) {
		String s = null;
		if (path == null) {
			return null;
		}
		s = path.substring(0,path.lastIndexOf('/'));
		return s;
	}
}
