package SelfLearning;

import java.util.Random;

public class Test {
	public static void main(String[] arg) {
		int offset = 1;
		int index = 1;
		for(int i=0;i<8;i++) {		
			System.out.println(offset);
			index++;
			offset = index * index;
		}
		
	}
}
