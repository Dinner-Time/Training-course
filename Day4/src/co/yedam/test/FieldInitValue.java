package co.yedam.test;

import java.util.Arrays;

/*
 기본 데이터형 8가지의 기본값은 0
 참조변수(String, [])의 기본값은 null
 */

public class FieldInitValue {
	byte a;
	char b;
	short c;
	int d;
	long e;
	
	boolean f;
	float g;
	double h;
	
	String i;
	int[] arrJ;
	
	FieldInitValue(int myInt, double myDouble){
		d = myInt;
		h = myDouble;
	}
	
	FieldInitValue(){
		
	}
	
	@Override
	public String toString() {
		return "FieldInitValue [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", e=" + e + ", f=" + f + ", g=" + g
				+ ", h=" + h + ", i=" + i + ", arrJ=" + Arrays.toString(arrJ) + "]";
	}
}
