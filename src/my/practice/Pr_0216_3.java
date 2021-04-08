package my.practice;

public class Pr_0216_3 {

	public static void main(String[] args) {
		int i = 1;
		int j = 2;
		if((++i>j--)&(++i<j)) { //++i는 i=i+1: OK //j--(후위연산자)이므로 비교 후 1 감소
			//2>1 참 & 2<2 거짓 따라서 거짓
			//실행될까?
			System.out.println("참: "+i+", "+j); //String과 int가 같이 쓰이면 concat, 붙여쓰기
		}else {
			//실행될까?
			System.out.println("거짓: "+i+", "+j);
		}
		//변수 초기화가 있을때와 없을때, 둘 사이의 차이가 있는가?
		//MN)아래 다시 초기화 하는 것에 대해 말하는 거라면 없을 듯
		//if문 안에서 일어난 초기화는 if문 안에서만 영향력이 있는 걸로 앎 > NO
		//변수가 for문 내에서만 영향이 있던 것은 for문 안에서 선언된 변수에 한함!!(오해nono)
		//지금 i, j의 경우는 메인메소드 안에 선언된 변수이므로 계속 변화(초기화)는 유지된다.
		i = 1;
		j = 2;
		if((++i>j--)&&(++i<j)){ //&&연산자는 앞에가 거짓이면 뒤에는 가지도 않음.
								//따라서 앞의 조건에서 얻어진 i, j가 최종임
		//++이 앞에 있으면 덧셈 후 크기 비교, ++이 뒤에 있으면 크기 비교 후 덧셈!
			System.out.println("T: "+i+", "+j);
		}else {
			System.out.println("F: "+i+", "+j);
		}
	}

}
