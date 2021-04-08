package my.practice;

import java.util.Scanner;

//main메소드 밖에 메소드를 만들어서 문제를 해결해보자. (1-2)
//void로 하기보다는 변수로 입력 받고 return으로 돌려주는 방법을 이용해보자.

public class Pr_1 {

	
	public double moon(double earth) {		//Quiz1: 달에서의 몸무게
	//메소드 public 으로 지정!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		return earth*(0.17);	
	}
	
	int inthap(int n) {		//Quiz2: 정수들의 합
		int hap=0, i;
		for(i=1;i<=n;i++) {
			hap += i;
		}
		return hap;
	}
	
	
	public static void main(String[] args) {
		//지역변수는 초기화 하고 사용한다(Guideline같은 것/관습Convention/PM의 스타일...)
		//즉, double earth = scan.nextDouble();보다는
		//double earth = 0.0;으로 초기화 후 값을 받는 것이 체계적이라고 볼 수 있다.
		Pr_1 pr1 = new Pr_1();
		Scanner scan = new Scanner(System.in);
		System.out.println("몸무게를 입력하세요.");
		double earth = scan.nextDouble();
		System.out.println("달에서의 몸무게: "+pr1.moon(earth));
		//=====================엔터부분============================
		while(true) {
			String enter1 = scan.nextLine();
			String enter2 = scan.nextLine();
			if(enter1.length()==0 && enter2.length()==0) {
				break;
			}
		}
		//=====================엔터부분============================
		System.out.println("정수를 입력하세요.");
		int num = scan.nextInt();
		System.out.println("1부터 입력한 정수까지의 합: "+pr1.inthap(num));
		
	}

}

