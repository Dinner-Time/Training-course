package 배열;
/*
 배열의 요소 타입이 객체인 경우
 */

import java.awt.*;

public class 객체배열 {

	public static void main(String[] args) {
		// 배열 선언
		ScoreApp[] score;
		
		score = new ScoreApp[10];
		
		score[0] = new ScoreApp("park", 80, 90, 100);
		score[1] = new ScoreApp("song", 80, 100, 70);
		score[2] = new ScoreApp("kang", 77, 89, 23);
		
		for (int i = 0; i < score.length; i++) {
			if (score[i]==null) {
				break;
			}
			System.out.println(score[i].name);
		}
		
		// 배열 선언 및 초기화
		ScoreApp[] b = {new ScoreApp("park", 80, 90, 100),
						new ScoreApp("song", 80, 100, 70),
						new ScoreApp("kang", 77, 89, 23)};
		
		for (ScoreApp x : b) {
			System.out.printf("이름:%s 총점:%d\n",x.name,x.sum);
		}
		
		for (ScoreApp y : score) {
			if (y==null) {
				break;
			}
			System.out.println(y.avg);
		}
		
		Point[] c = {new Point(10,10),
					 new Point(30,30),
					 new Point(10,30),
					 new Point(30,10)};
		
		for (Point loc : c) {
			System.out.printf("x좌표:%s y좌표:%d\n",loc.x,loc.y);
		}
		
		
		
	}

}
