package sam.pulE;

import java.util.Random;
import java.util.Scanner;

public class RandomGame1_1 {

	public static void main(String[] args) {
		//말로 써보면서 흐름을 먼저 파악하자.
		//1. 난수 발생을 지원하는 클래스 추가하기 - 인스턴스화 하기
		Random r = new Random();
		//2. 그 클래스가 제공하는 메소드를 호출하여 채번하기
		int dap = r.nextInt(10);
		System.out.println(dap); //임시코드 - 삭제예정
		//3. 사용자로부터 값을 입력받아오기
		Scanner sc = new Scanner(System.in);
		//4. 사용자가 입력한 값 담기 - 선언, 초기화
		//질문: Console에서 입력받은 값이 숫자야?문자야?
		
		//5. 0부터 9 중에서 골라봐~
		System.out.println("0부터 9 중에서 골라봐~~");
		int count = 1;
		String user = null;
		//6. 기회는 3번까지만 - 반복
		for(;(user=sc.nextLine())!=null;) //타입을 결정하지 않기 위해 nextLine 이용
		{
			//insert here - 실행문
			//판별식(크냐?작냐?)
			if(count<3) {
				//1번, 2번, 3번
				if(Integer.parseInt(user)==dap) { //문자열을 정수로 변환해주는 parseInt함수 사용
					System.out.println("축하합니다. 정답입니다.");
					break; //for문을  탈출한다.
				}
				else if(Integer.parseInt(user)>dap) { //문자열을 정수로 변환해주는 parseInt함수 사용
					count++; //논리적으로 봤을 때, 힌트("낮춰라")를 듣기 전에 count가 올라가야 함
					System.out.println("낮춰라.");
				}
				else if(Integer.parseInt(user)<dap) { //문자열을 정수로 변환해주는 parseInt함수 사용
					count++;
					System.out.println("높여라.");
				}
				
			}
			else {
				System.out.println("넌 바보이다!");
				break;
			}
			//"정답입니다."
			
			//"넌 바보!" - break;(for문을 탈출하는 장치, if문을 탈출하려면 return;)
			
		}
		//유효성 체크는 완성 후 보충(선택사항)
	}

}
