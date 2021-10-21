package LeetCode;

public class T9 {
	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
	}
    public static boolean isPalindrome(int x) {
        if(x<0||(x%10==0&&x!=0)){
            return false;
        }
        int revers = 0;
        int ori = x;
        while(x>0){
            revers = revers*10+x%10;
            x = x/10;
        }
        return revers == ori;
    }
}
