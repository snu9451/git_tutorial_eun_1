package my.practice;

import java.util.Scanner;

/*
 * 이순신은 11번가에 물건을 주문하였다. 주문의 내용을 확인하고 싶다면 조건 검색을 해야 한다.
 * 이는 주문 건수가 많기 때문이다.
 * SELECT
 * 	FROM 회원집합, 주문집합
 * 	WHERE 회원집합.아이디(로그인한 아이디<-세션에 저장된 아이디) = 주문집합.아이디
 * 						                       ㄴ 세션: 일정 시간 동안 아이디를 기억하는 클래스임 
 * 	AND 주문한 일자 > '2021-02-01' //2021년 2월 1일 이후 주문 건만 확인하자.
 * 조건에 필요한 값 두 가지: 로그인한 나의 아이디, 주문한 일자
 * 지금 파라미터는 2개이고, 하나 이상일 땐 DeptVO를 사용할 수 있다.
 * 조회결과에는 주문한 사람의 이름과 주문한 날짜와 주문금액, 주문수량 등이 관리되어야 함.
 * 이유; 핸드폰이나 컴퓨터에서 그 목록을 모두 조회할 수 있어야 하기 때문 즉, 화면 출력이 있어야 함.
 * 이 때 DeptVO를 사용할 수 있다.
 * 
 */

/*
 * 연습문제1.
 * 달의 중력은 지구 중력의 17%에 불과합니다. 지구에서 몸무게가 100kg인 사람은 달에 가면 17kg 밖에 안됩니다. 당신의 몸무게는 달에서 얼마입니까?
 * 몸무게 n은 실수이고, 키보드로부터 입력 받습니다.
 * Scanner 클래스를 이용하면 키보드로부터 입력을 받을 수 있습니다.
 */

/*
 * 연습문제2.
 * 1부터 N까지의 정수 합계를 구하는 프로그램을 작성하시오.
 * 출력) 정수(n>0): 100
 * 		합계(1~n): 5050출력
 */

public class Pr_2 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("몸무게를 입력하세요: ");
		double imsi = scan.nextDouble();
		System.out.println("달에서의 몸무게는 "+imsi*(0.17)+"kg입니다.");	
		//=====================엔터부분============================
		while(true) {
			String enter1 = scan.nextLine();
			String enter2 = scan.nextLine();
			if(enter1.length()==0 && enter2.length()==0) {
				break;
			}
		}
		//=====================엔터부분============================
		System.out.println("정수를 입력하세요: ");
		int imsi2 = scan.nextInt();
		int hap=0, i;
		for(i=1;i<=imsi2;i++) {
			hap += i;
		}
		System.out.println("1부터 입력한 정수 "+imsi2+"까지의 합은 "+hap+"입니다.");
		
	}

}

