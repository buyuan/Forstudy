package LeetCode;

public class T14 {
	public	static void main(String[] args) {
		String[] strs = new String[] {"ab", "a"} ;
		System.out.println(longestCommonPrefix(strs));
		
	}
	
    public static String longestCommonPrefix(String[] strs) {
        String ans = "";
        char temp;
        for(int i =0;i<strs[0].length();i++){
        	temp = strs[0].charAt(i);
            for(int j =1;j<strs.length;j++){
            	if(strs[j]==null) {
            		return ans;
            	}
            	if(i>strs[j].length()-1||temp!=strs[j].charAt(i)) {
            		return ans;
            	}
            }
            ans = ans+temp;
        }
        return ans;
    }
}
