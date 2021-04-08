package my.practice;

public class CompanyTest {
	public static void main(String[] args) {
		Company com1 = Company.getInstance();
		Company com2 = Company.getInstance();
		System.out.println("com1과 com2에 담긴 값이 같니? "+(com1==com2));
		System.out.println("com1: "+com1);
		System.out.println("com2: "+com2);
		System.out.println("그럼 그 유일한 인스턴스 주소는? "+Company.getInstance());
		
	}
}
