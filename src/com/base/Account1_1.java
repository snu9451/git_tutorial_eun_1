package com.base;

public class Account1_1 {
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
	 * <값에 의한 호출>이다.
	 * 평균을 구하는 메소드입니다.
	 * @param tot - hap메소드를 호출하여 tot를 받아온다.
	 * @param subjectNumber - 과목 수
	 * @return 평균 점수
	 ***********************************************************************/
	private double avg(double tot, int subjectNumber) {
		//메소드에서 파라미터를 사용할 때(호출할 때) 발생하는 "배달사고"에 주의하기.
		System.out.println("파라미터로 넘어온 tot 값 출력해보기 =====> "+tot);
		//만약 0, 0이 찍힌다면 배달사고가 발생한 것이다. - <단위테스트>를 통해 확인하고 진행하기
		//단위테스트; 중간중간에 값을 출력해서 확인해 보는 것? 그렇다. 업무별로 또는 업무의 구간별로 나누어서 테스트해보는 것.
		//또는 화면단과 업무를 처리하는 영역과 데이터베이스 서버와 연동하는 부분들을 나누어서 테스트 하는 것도 포함함.

		System.out.println("tot ===> "+tot+", subjectNumber ===> "+subjectNumber);
		double imsi = tot/(double)subjectNumber; //(tot가 double이므로 subNum을 double화 하지 않아도 됨)
		return imsi;
	}

	public static void main(String[] args){
		Account1_1 ac = new Account1_1(); //인스턴스화
		ac.kor = 70;
		ac.math = 90;
		ac.eng = 90;
		int subjectNumber = 3;
		double tot = ac.hap(ac.kor, ac.math, ac.eng);
		//위에서 계산한 총점을 avg메소드의 파라미터로 넘기려면 반드시 리턴타입이 필요함.
		//double test_avg = ac.avg(tot); //평균이 계산됨 ※avg의 파라미터 앞에 타입 적지 않았음
		double test_avg = ac.avg(tot, subjectNumber);
		System.out.println("평균 ======> "+test_avg);
	}
}