package com.base;

public class Tut_eun_1 {
	double kor, math, eng;

	public static void main(String[] args) {
		Tut_eun_1 t = new Tut_eun_1();
		t.kor = 70;
		t.math = 85;
		t.eng = 90;
		double avg = (t.kor + t.math + t.eng)/3;
		System.out.println("평균 점수는 "+avg+"점 입니다.");
		//double 타입으로 출력할 때 출력 소수점 자리수 정할 수 있나?
		
	}

}
