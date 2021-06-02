package pkg.friend;

public class BeanFactory {
	// Object : 최상위 클래스, 자바의 모든 클래스는 Object를 상속받고 있다.
	public static Object getBean(String beanName) {
		if (beanName.equals("samsung")) {
			return new FriendList();
		} else if (beanName.equals("lg")) {
			return new FriendManager();
		}
		return null;
	}
}
