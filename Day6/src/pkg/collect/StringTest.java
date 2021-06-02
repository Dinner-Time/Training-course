package pkg.collect;

public class StringTest {

	public static void main(String[] args) {
		String str = "hello everyone!!";
		char c = str.charAt(0);
		System.out.println(c);
		System.out.println(str.substring(6));
		System.out.println(str.substring(6,11));
		System.out.println(str.contains("every"));
		System.out.println(str.endsWith("!!"));
		System.out.println(str.startsWith("hell"));
		
		String num = "210602-4557369";
		String[] arr = num.split("-");
		System.out.println(arr[1].charAt(0));
		
		String path = "c:/temp/image/a.jpg";
		System.out.println(path.indexOf('/'));
		int pos = path.lastIndexOf('/');
		int pos2 = path.lastIndexOf('/', pos-1);
		System.out.println(pos+":"+pos2);
		
		int dot = path.lastIndexOf('.');
		System.out.println(path.substring(dot+1));
		
		System.out.println("파일명: "+StringUtil.getFileName(path));
		System.out.println("확장자: "+StringUtil.getExtension(path));
		System.out.println("경로: "+StringUtil.getPath(path));
		
		String b = "문자열";
//		String d = new String(b.getBytes(),"euc-kr");
		
		String cd = b.replace("문자", "여덟 아홉 ");
		System.out.println(cd);
	}

}
