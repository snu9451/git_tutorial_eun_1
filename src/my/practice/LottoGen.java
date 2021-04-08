package my.practice;

import java.util.Random;

public class LottoGen {
	
	public static void main(String[] args) {
		int amuSu = 0;
		Random rand = new Random();
		System.out.println("로또번호 자동추첨 시작!");
		for(int i=0;i<7;i++) {
			amuSu = rand.nextInt(46)+1;
			if(i==6)
			{
				System.out.println("보너스 숫자: "+amuSu);
			}
			else
			{
			System.out.println((i+1)+"번째 숫자: "+amuSu);
			}
		}
	}

}
