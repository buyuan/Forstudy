package Other;

import java.util.HashSet;
import java.util.Set;

public class TwoString {
	public static void main(String[] args) {
		String[] a1 = {"ab", "cd", "ef"};
		String[] b1 = {"af", "ee", "ef"};
		String[] a2 = { "ab","cde","efkm","gh" };
		String[] b2 = { "ac","ok","dc","he" };
		String[] a3 ={"hello", "hi", "", "33zq"};
		String[] b3 ={"world", "bye", "a", "q"};
		String[] a =a3;
		String[] b =b3;
		String[] res = TS(a,b);
		for(String x:res) {
			System.out.println(x);
		}
		
		
	}
	public static String[] TS(String[] s1,String[] s2) {
		String[] res = new String[s1.length];
		
		for(int i=0;i<s1.length;i++) {
			res[i]=checkCommon(s1[i],s2[i]);
		}
		return res;
	}

	private static String checkCommon(String s1, String s2) {
		int len = s1.length();
		Set<Character> st = new HashSet<>();
		boolean flag=false;
		for(char c:s1.toCharArray()) {
			st.add(c);
		}
		for(char c:s2.toCharArray()) {
			if(st.contains(c)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			return "YES";
		}
		return "NO";
	}
}
