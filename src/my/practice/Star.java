package my.practice;

import java.util.Scanner;

public class Star {

	public static void main(String[] args) {
		int gesu;
		int su;
		Scanner sc = new Scanner(System.in);
		gesu = sc.nextInt();
		su = gesu;
		for(;gesu>0;gesu--) {
			int n=0;
			for(; n<su-gesu; n++) {
				System.out.print(" ");
			}
			for(int i=0;i<gesu;i++) {
				System.out.print("*");
			}
		System.out.println();
		}
		
	}

}
