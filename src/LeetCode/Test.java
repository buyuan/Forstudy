package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test{
	public static Integer calculatTotal(Integer[] numbers) {
		Integer ans = 0;
		for(int i : numbers) {
			if(i%5==0 || i%8==0) {
				//5
				ans+=5;
				continue;
			}
			if(i%2==0) {
				//even
				ans+=3;
			}else {
				ans+=1;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Integer[] t = {1,1,8};
		System.out.println(calculatTotal(t));
	}
}