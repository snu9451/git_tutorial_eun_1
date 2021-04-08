package com.base;

public class TTest {

	public void weirdArrayPrint(String[] values, int pos) {

		for(int i=0;i<(values.length+2-pos);i++) {
			if(i<2) {
				System.out.print(values[pos]+" ");
			}
			else {
				System.out.print(values[pos+i-2]+" ");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		TTest instance = new TTest();
		String[] sa = {"How","is","the","weather","in","Spain"};
		instance.weirdArrayPrint(sa, 2); //정수 2를 넣으면 s[2] s[2] s[2:] 출력
		instance.weirdArrayPrint(sa, 1); //정수 1을 넣으면 s[1] s[1] s[1:] 출력
	}

}