package my.practice;

import java.util.Scanner;

public class Pr_0216_6_1 {
//등비수열은 각 항의 앞에 일정한 수를 곱해서 이루어지는 수열을 말합니다. 첫번째 부터 7번째 가지의 수열을 출력하시오.
	//1-1
	public static void main(String[] args) {
		System.out.println("첫 항과 공비를 입력하세요:");
		Scanner scan = new Scanner(System.in);
		double a = scan.nextDouble();
		double r = scan.nextDouble();
		double[] su10 = new double[7];
		for(int i=0;i<7;i++) {
			su10[i] = a;
			a = a*r;
		}
		for(int j=0;j<7;j++) {
			System.out.println(su10[j]);
		}
	}

}
