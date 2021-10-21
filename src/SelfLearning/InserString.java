package SelfLearning;

import java.util.Scanner;

public class InserString {
	public static void main(String[] arg) {
		String brk ="";
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please input the first string");
			brk = scan.nextLine();
			if(brk.equals("exit")) {
				System.out.println("Break");
				break;
			}
			String str1 = brk;
			StringBuilder strOrg = new StringBuilder(str1);
			System.out.println("The first string is " + str1);		
			System.out.println("Please input the second string");
			String str2 = scan.nextLine();
			System.out.println("The second string is " + str2);	
			StringBuilder substr = new StringBuilder(str2);
			
			System.out.println("Answer is: ");
			System.out.println(insertStr(strOrg,substr));
		}


		
	}
	public static String insertStr(StringBuilder org, StringBuilder sub) {
		int index = maxACK(org);
		if(index ==0) {
			sub.append(org);
			return sub.toString();
		}else if(index == org.length()) {
			org.append(sub);
			return org.toString();
		}else {
			org.insert(index, sub);
			return org.toString();
		}
	}
	public static int maxACK(StringBuilder str) {
		int max =0;
		for(int i=0;i<str.length();i++) {
			if((int)str.charAt(i)>(int)str.charAt(max)) {
				max = i;
			}
		}
		return max;
	}
}
