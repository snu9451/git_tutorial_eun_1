package my.practice;

import java.util.Scanner;

public class Pr_0216_5_2 { //두 정수 사이에 있는 3의 배수의 개수?
//1-2 사용자 정의 메소드 이용해보기
	int besu3(int n, int m) {
		int i=0;
		for(n=n+1;n<m;n++) {
			if(n%3 == 0) {
				i++;
			}
		}
		return i;
	}
	public static void main(String[] args) {
		System.out.println("정수 두 개 입력:");
		Scanner scan = new Scanner(System.in);
		int su1 = scan.nextInt();
		int su2 = scan.nextInt();
		Pr_0216_5_2 c = new Pr_0216_5_2();
		System.out.println("두 정수 "+su1+"과 "+su2+"사이에 있는 3의 배수는 "+c.besu3(su1, su2)+"개 입니다.");
	}

}
