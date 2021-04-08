package com.base;

public class Account_wT {
	double kor = 0; //국어점수 담기
	double math = 0; //수학점수 담기
	double eng = 0; //영어점수 담기
	/***********************************************************************
	 * 총점을 구하는 메소드입니다.
	 * @param kor2 - 학생의 국어 점수
	 * @param maht2 - 학생의 수학 점수
	 * @param eng2 - 학생의 영어 점수	 
	 * @return tot - 한 학생의 세 과목의 총점
	 **********************************************************************/
	private double hap(double kor2, double math2, double eng2) {
		double tot = 0;
		tot = kor2 + math2 + eng2; //insert here
		System.out.println("tot =====> " + tot); //tot를 미리 출력해보기
		return tot;
	}
	/***********************************************************************
	 * 평균을 구하는 메소드입니다.
	 * @param tot - hap메소드를 호출하여 tot를 받아온다.
	 * @param subNum
	 * @return 평균 점수
	 ***********************************************************************/
	private double avg(double tot, int subNum) {
		//메소드에서 파라미터를 사용할 때(호출할 때) 발생하는 "배달사고"에 주의하기.
		System.out.println("파라미터로 넘어온 tot 값 출력해보기 =====> "+tot);
		return tot/(double)subNum; //(tot가 double이므로 subNum을 double화 하지 않아도 됨)
	}

	public static void main(String[] args){
		Account_wT ac = new Account_wT(); //인스턴스화
		ac.kor = 70;
		ac.math = 90;
		ac.eng = 90;
		int subNum = 3;
		double tot = ac.hap(ac.kor, ac.math, ac.eng);
		//위에서 계산한 총점을 avg메소드의 파라미터로 넘기려면 반드시 리턴타입이 필요함.
		//double test_avg = ac.avg(tot); //평균이 계산됨 ※avg의 파라미터 앞에 타입 적지 않았음
		double test_avg = ac.avg(tot, subNum);
		System.out.println("평균 ======> "+test_avg);
	}
}