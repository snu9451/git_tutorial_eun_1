package my.practice;

import java.util.Random;

/*연습문제
배열의 크기가 10인 난수 배열에서 가장 큰 숫자는 얼마인지 찾아내는 프로그램을 작성하시오.
출력) 배열: 11 4 2 18 11 17 11 3 4 8
	 최댓값: 18
*/

/*코드설계; 어떤 메소드가 필요할까, 그리고 각 메소드는 어떤 파라미터와 리턴타입을 필요로 하는지 생각해보는 단계
main 메소드
배열을 초기화 하는 메소드 선언:
	리턴타입 initArray(파라미터 개수와 타입을 결정하는 것: 이 부분은 기초가 아님)
최댓값을 찾는 메소드 선언:
	리턴타입 maxInArray(파라미터)
배열을 출력하는 메소드 선언
	리턴타입 printArray(파라미터)
*/

public class LargeNum {
	
	int arr[] = new int[10]; //new가 아니라 arr.length를 사용할 수는 없을까?
			
	//난수를 생성하여 배열을 만드는 메소드
	void nansuArray() {
		
		Random r = new Random();
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = r.nextInt(100);
		}
		//배열에 난수가 잘 들어갔는지 체크하는 코드
		System.out.print("배열: ");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		//arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]+" "+arr[4]+" "+arr[5]+" "+arr[6]+" "+arr[7]+" "+arr[8]+" "+arr[9]);
		//print를 사용하면 이렇게 나열하지 않아도 됨
	}
	
	int maxValue() {
		
		int imsi;
		
		for(int i=1;i<arr.length;i++) {
			if(arr[0]<arr[i]) {
				imsi = arr[0];
				arr[0] = arr[i];
				arr[i] = imsi;
			}
		}
		return arr[0];
		
	}
	
	
	public static void main(String[] args) {
		LargeNum c = new LargeNum();
		c.nansuArray();
		System.out.println("최댓값: "+c.maxValue());
		return;
	}

}
