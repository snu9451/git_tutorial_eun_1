package my.practice;

public class Pr_0216_2 { //Question 12: 변수의 적용 범위

	public static void main(String[] args) {
		int x = 5;
		Pr_0216_2 p = new Pr_0216_2();
		p.doStuff(x);
		System.out.println("main메소드 출력");
		System.out.println("main x = "+x);
	}
	
	void doStuff(int x) {
		System.out.println("doStuff출력");
		System.out.println("doStuff x = "+x++);
		//x++의 후위연산은 doStuff 내에서만 유효함(왜냐, main메소드 안의 지역변수이므로)
	}

}
