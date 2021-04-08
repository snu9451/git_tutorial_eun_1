package my.practice;
class Param{
	int ival; //전변은 초기화를 생략할 수 있음(int의 경우 생략 시 값은 0)
}
public class Pr_0216_4 {
	void effectParam(Param p) { //Hot Spot
		p = new Param();
		p.ival = 500;
		System.out.println("sub ival = "+p.ival);
	}	
	public static void main(String[] args) { //(=ParamTest.java)
		//클래스는 반드시 대문자로 시작하도록!
		Pr_0216_4 pr = new Pr_0216_4();
		Param p = new Param();	//이 인스턴스화가 먼저 와야 pr.effectParam(p)를 실행가능
		p.ival = 100;
		pr.effectParam(p);
		System.out.println("main ival = "+p.ival);
	}
	
}
