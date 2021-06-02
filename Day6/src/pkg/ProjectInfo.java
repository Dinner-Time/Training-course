package pkg;

/**
 * 
 * @author 박태훈
 * 
 */
public class ProjectInfo {
	//final과 private의 차이 : private은 해당 필드에서는 변경가능
	//						final은 해당 필드에서도 변경 불가
	public final static String NAME = "Yedam"; // 변경 할 수 없고 객체생성없이 사용가능
	static String uploadpath = "c:/temp";
	
	int version = 1; // 인스턴스
}
