package Other;

public class ShiftingStrings {
	public static String shiftString(String s, int leftShift, int rightShift){
		//思路，用的index来搞
		int start =0;
		int len = s.length();
		//to left
		start = leftShift%len;
		//to right
		int modRt = rightShift%len;
		start -=modRt;
		if(start<0) {
			start+=len;
		}
		//于是，相当于start这个坐标开始，右半截在前，做半截在后
		String result = s.substring(start)+s.substring(0, start);
		return result;
	}
	public static void main(String[] args) {
		String s1 = "abcde";int l1=2;int r1=0;
		String s2 = "abcde";int l2=0;int r2=2;
		String s3 = "abcde";int l3=1;int r3=2;
		String s4 = "abcde";int l4=0;int r4=1;
		
		
		String s =s4;int l=l4; int r=r4;
		System.out.println(shiftString(s,l,r));
	}
}


/*
The following operations on a string are defined:
Left Shift: A single circular rotation of the string in which the first character becomes the last character and all other characters are shifted
one index to the left. For example, abcde becomes bcdea after one left shift and cdeab after two left shifts.
Right Shift: A single circular rotation of the string in which the last character becomes the first character and all other characters are shifted
one index to the right. For example, abcde becomes eabcd after one right shift and deabc after two right shifts.
*/