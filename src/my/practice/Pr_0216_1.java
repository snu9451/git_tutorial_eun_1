package my.practice;

public class Pr_0216_1 { //Question 3: 실행문

	public static void main(String[] args) {
		int x = 5;
		boolean b1 = true;
		boolean b2 = false;
		
		if((x==4) && !b2) {	//5==4이므로 false && !false즉, true
			System.out.println("1");
			System.out.println("2");
		}	
		if((b2=true) && b1)
			System.out.println("3");
	}

}
