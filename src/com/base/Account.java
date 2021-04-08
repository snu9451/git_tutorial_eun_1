package com.base;

public class Account {
	double kor, math, eng, tot, avg;

	double hap(double kor, double math, double eng){
		return (kor + math + eng);	
	}
	
	double avg() {
		Account a = new Account();
		return a.hap(kor, math, eng)/3;
		
	}
	public static void main(String[] args) {
		Account b = new Account();
		b.kor = 74;
		b.math = 34;
		b.eng = 72;
		System.out.println("평균 ====> "+b.avg());
	}

}
