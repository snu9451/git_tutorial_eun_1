package my.practice;

public class MyStaticTest_call {
	public static void main(String[] args) {
		MyStaticTest mst = new MyStaticTest();
		mst.A();
		System.out.println("mst.yogi: "+mst.yogi);
		mst.yogi = 10;
		System.out.println("mst.yogi: "+mst.yogi);
		MyStaticTest.yogi = 123;
		System.out.println("MyStaticTest.yogi: "+MyStaticTest.yogi);
		System.out.println("mst.yogi: "+mst.yogi);
	}
}
