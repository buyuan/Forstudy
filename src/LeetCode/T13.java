package LeetCode;
/**
 * 
 * @author cbuyu
 *13. Roman to Integer
 */
public class T13 {
	public static void main(String[] args) {
		System.out.println(romanToInt("IX"));
	}
    public static int romanToInt(String s) {
    	int sign = 1;
    	int answer = 0;
    	char curSign,nextSign;
        for(int i =0;i<s.length();i++) {
        	curSign = s.charAt(i);
        	if(i+1<s.length()) {
        		nextSign = s.charAt(i+1);
        	}else {
        		nextSign=curSign;
        	}
        	sign = compare(curSign,nextSign);
        	answer+= sign*getValue(curSign);
        }
        return answer;
    }
	private static int getValue(char curSign) {
		// TODO Auto-generated method stub
		switch(curSign) {
		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000;
		default: return -1;
		}

	}
	private static int compare(char curSign, char nextSign) {
		// TODO Auto-generated method stub
		if(getValue(nextSign)<=getValue(curSign)) {
			return 1;
		}
		return -1;
	}
}

