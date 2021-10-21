package LeetCode;

import java.util.Stack;

public class T20 {
	public static void main(String[] args) {
		String s= "()[]{}";
		System.out.println(isValid(s));
	}
    public static boolean isValid(String s) {
    	Stack<Character> chr = new Stack<Character>();
    	if(s==null) {
    		return true;
    	}
    	char temp;
    	for(int i =0;i<s.length();i++) {
    		temp = s.charAt(i);
    		if(temp=='('||temp=='['||temp=='{') {
    			chr.push(temp);
    		}else {
    			if(chr.isEmpty()) {
    				return false;
    			}
        		if(temp==')'&&chr.peek()!='(') {
        			return false;
        		}
        		if(temp==']'&&chr.peek()!='[') {
        			return false;
        		}
        		if(temp=='}'&&chr.peek()!='{') {
        			return false;
        		}
        		chr.pop();
    		}

    	}
    	return chr.isEmpty();
    }

}
