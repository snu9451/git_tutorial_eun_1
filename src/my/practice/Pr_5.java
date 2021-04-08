package my.practice;

import java.util.Scanner;

public class Pr_5 {
/*************************************
 * 1부터 N까지 정수들의 합 // 변수는 2개가 필요하다.
 *************************************/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = 0;
		int end = 0;
		int hap = 0;
		System.out.println("정수입력: ");
		end = sc.nextInt();
		for(start=1;start<=end;start++) { //Q: start++ 전위 연산자, 후위 연산자 차이는?
			//System.out.println(start);
			hap = hap + start;
			System.out.println(hap);
		}
		System.out.println(hap);
	}

}
