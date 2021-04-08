package test210317;

public class Son implements Parent {

	public void child() {
		System.out.println("child 호출됨");
	}
	@Override
	public void yogi() {
		System.out.println("yogi 호출됨");
	}

	public static void main(String[] args) {
		Parent p = new Son();
		p.child();
		p.yogi();
	}

}
