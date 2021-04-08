package com.base;

public class MaTest {

	public void weirdArrayPrint(String[] values, int pos) {
		int imsi = 2;
		for(int i=pos;i<(2+values.length-pos);i++) {
			System.out.print(values[imsi]+" ");
			if(i>pos) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		MaTest instance = new MaTest();
		String[] sa = {"How","is","the","weather","in","Spain"};
		instance.weirdArrayPrint(sa, 2); //정수 2를 넣으면 s[2] s[2] s[2:] 출력
		instance.weirdArrayPrint(sa, 1); //정수 1을 넣으면 s[1] s[1] s[1:] 출력
	}

}
