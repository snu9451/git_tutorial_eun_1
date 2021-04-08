package my.practice;

import java.util.Scanner;

public class Pr_0216_5_1 { //두 정수 사이에 있는 3의 배수의 개수?
//1-1
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("정수 두 개 입력:");
		int n = scan.nextInt();
		int nn = n;
		int m = scan.nextInt();
		int i = 0;
		for(n=n+1;n<m;n++) { //양 끝의 정수는 count X
			if(n%3 == 0) {
				i++;
			}
		}
		System.out.println("두 정수 "+nn+"과 "+m+"사이에 있는 3의 배수는 "+i+"개 입니다.");
	}

}

