package my.practice;

import java.util.Scanner;

public class EnterCode { //개인연습

	public static void main(String[] args) {
		int num1 = 48;
		Scanner scan = new Scanner(System.in);
		//=====================엔터부분============================
		while(true) {
			String enter1 = scan.nextLine();
			String enter2 = scan.nextLine();
			if(enter1.length()==0 && enter2.length()==0) {
				break;
			}
		}
		//=====================엔터부분============================
		System.out.println("숫자 출력: "+num1);
		
	}

}
