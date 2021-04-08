package my.practice;
//싱글톤패턴을 이용하여 하나의 클래스 구현하기 연습(교재 p194)
public class Company {
	
	private Company() {}	//
	public static Company instance_juso;
	
	
	public static Company getInstance() {
	//Company라고 쓰는 것은 반환타입이 Company라는 것이다.
	//즉, return으로 Company의 인스턴스(인스턴스 주소)만 줄 수 있다.
		if(instance_juso == null) {
			instance_juso = new Company();
		}
		return instance_juso;
	}
}
