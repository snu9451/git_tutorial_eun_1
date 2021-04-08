package my.practice;	//달에서의 몸무게 문제; 클래스를 분리해서 풀어보기
/***************************************************************
 * 에러에는 두 가지가 있다.
 * 하나는 Compile Time Error - 문법 에러
 * 다른 하나는 RunTime Error - 실행(논리) 에러
 ***************************************************************/
import java.util.Scanner;

public class Pr_4 {
	public static void main(String[] args) {
		//지구의 몸무게
		double wEarth = 0.0;
		System.out.println("지구의 몸무게를 입력하세요:");
		Scanner scan = new Scanner(System.in); //System(내가 사용하고 있는 컴퓨터)에서 in(입력장치로부터)
		try {
			wEarth = scan.nextDouble();
		} catch (Exception e) {
			System.out.println("Exception: "+e.toString());
			//return; 쓸 수 있음
		}
		if(scan.hasNextDouble()) {	//유효성 검증 과정
			double wMoon = 0.0;
			Pr_4 pr4 = new Pr_4();
			Common cm1 = new Common();
			wMoon = cm1.moonWeight(wEarth);
			System.out.println("지구의 몸무게가 "+wEarth+" kg일 때");
			System.out.println("달의 몸무게는 "+wMoon+" kg이다.");
		}
		else {
			System.out.println("실수만 입력하세요!");
			return; //main메소드 탈출! 더 이상 진행하지 않음
		}
		System.out.println("숫자를 입력했군요!"); //return에 의해, if절이 만족되지 않으면(즉, else가 실행되어) 이 부분은 출력X
	}

}
