package my.practice;
//for문과 switch문을 사용해서 FizzBuzz 만들기	//비효율적이긴 한데 switch 연습을 위해!
public class Quiz_0225 {

	public static void main(String[] args) {
		int num	 	 = 0;
		for(num=1;num<1000;num++) {
			switch(num%35) {
				case 0:
					System.out.println("FizzBuzz");
					break;
				case 5: case 10: case 15: case 20: case 25: case 30:
						System.out.println("Fizz");
						break;
				case 7: case 14: case 21: case 28:
					System.out.println("Buzz");
					break;
				default:
					System.out.println(num);
			}
		}
	}

}
