package my.practice;

import java.util.Random;
import java.util.Scanner;

public class NumYagu {
	
	//정답으로 생성되는 세 자리 수를 담는 배열
	int arr[] = new int[3];
	//사용자로 부터 받는 세 자리 수를 담음
	int fromKeyboard = 0;
	
	Scanner sc = new Scanner(System.in);
	
	//3자리 숫자를 만드는 메소드
	void _3Jari() {
		Random r = new Random();
		do {
			for(int i=0;i<3;i++) {
				arr[i]=r.nextInt(10);
			}
		}while((arr[0]==0)||(arr[0]==arr[1])||(arr[1]==arr[2])||(arr[2]==arr[0]));
	}
	
	//사용자가 입력한 값을 정답과 비교하는 메소드
	void game() {
		//야구게임이해: 숫자만 같으면 Ball, 자리까지 같으면 Strike

		//사용자로부터 받는 세 자리 수를 담는 배열
		int b[] = new int[3];
		
		//사용자의 시도 횟수를 담음
		int cnt = 0;
		
		int strike = 0;
		int ball = 0;
		
		do {
			//strike와 ball은 반복될 때마다 초기화되어야 함
			strike = 0;
			ball = 0;
			
			//시도횟수 증가
			cnt++;
			
			System.out.println("세 자리 숫자를 입력하세요.");
			System.out.println(cnt+"번째 시도");
			fromKeyboard = sc.nextInt();
			
			b[0] = fromKeyboard/100;
			b[1] = fromKeyboard%100/10;
			b[2] = fromKeyboard%10;
			
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					//같은 값이 있는 경우에 대해 조사
					if(arr[i] == b[j]) {
						//값이 같은 경우 중, 위치까지 같은 경우에 대해 조사
						if(i==j)
							strike++;
						else
							ball++;
					}
				}
			}
			System.out.println("Strike: "+strike+", Ball: "+ball);
		}while(strike<3);
		System.out.println("축하합니다. 정답 "+arr[0]+arr[1]+arr[2]+"을 맞추셨습니다.");
	}
	
	
	
	public static void main(String[] args) {
		
		NumYagu yagu = new NumYagu();
		
		yagu._3Jari();
		System.out.println(""+yagu.arr[0]+yagu.arr[1]+yagu.arr[2]); //임시코드
		yagu.game();
		
		return;
	}

}
