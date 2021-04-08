package my.practice;	//달에서의 몸무게 문제; 클래스를 분리해서 풀어보기
/***************************************************************
 * 에러에는 두 가지가 있다.
 * 하나는 Compile Time Error - 문법 에러
 * 다른 하나는 RunTime Error - 실행(논리) 에러
 ***************************************************************/
import java.util.Scanner;

class Common{ //아무것도 없으면 friendly 상태이고 그렇다면 같은 패키지 내에서 자유로이 접근 가능.
	public double moonWeight(double wEarth) {
		//달에서의 몸무게
		double wMoon = 0.0;
		wMoon = (wEarth*(0.17)); //사칙연산에 double이 있으면 결과는 double
		return wMoon;
	}
}

public class Pr_3 {
	public static void main(String[] args) {
		//지구의 몸무게
		double wEarth = 0.0;
		System.out.println("지구의 몸무게를 입력하세요:");
		Scanner scan = new Scanner(System.in); //System(내가 사용하고 있는 컴퓨터)에서 in(입력장치로부터)
		if(scan.hasNextDouble()) {
			wEarth = scan.nextDouble();
			double wMoon = 0.0;
			Pr_3 pr3 = new Pr_3();
			Common cm = new Common();
			wMoon = cm.moonWeight(wEarth);
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
