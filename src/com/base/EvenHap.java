package com.base;

public class EvenHap { //재사용할 것이 아니므로 지역변수로 하는 게 나음. 지역변수는 stack에 저장되어 '즉시 사라짐'.
	//전역변수는 번거로움+메모리사용. 따라서 클래스의 재사용을 생각할 경우에는 전역변수를 이용하지만, 그렇지 않은 경우(지금과 같은 경우) 지역변수 OK.
	public static void main(String[] args) {
		int oddhap = 0;
		int evenhap = 0;
		//int i = 1;	//do-while문의 일부
		//int i;	//Error: 지역변수 i를 중복으로 선언할 수 없음
		for(int i=1;i<=10;i++) {
			if(i%2==0) {		//if문을 두 번 사용하는 것과의 차이? if, if는 첫번째 if 조건을 만족하더라도 무조건 두번째 조건도 따진다.
								//if, else를 이용하면 첫번째 조건이 만족될 때 else는 무조건 실행되지 않으므로 <비용이 절약>된다.
				evenhap += i;				
			} else {
				oddhap += i;
			}
		}
		/******do-while문을 이용*********************************************************
		do {
			if(i%2==0) {
				hap += i;
			}
			i++;
		} while(i<=10);
		******************************************************************************/
		System.out.println("1부터 10까지 짝수들의 합은 "+evenhap+"이다.");
		System.out.println("1부터 10까지 홀수들의 합은 "+oddhap+"이다.");
		//System.out.println(i);	//Error! 이유: for문 안에서 정의된 변수는 for문 테두리({, }) 안에서만 사용가능하다.
	}

}
