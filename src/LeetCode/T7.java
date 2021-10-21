package LeetCode;

public class T7 {
	/**
	 *Given a signed 32-bit integer x, return x with its digits reversed. 
	 *If reversing x causes the value to go outside the signed 
	 *32-bit integer range [-231, 231 - 1], 
	 *then return 0.
	 */
	
	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}
    public static int reverse(int x) {
        int ans=0;
        int temp=0;
        while(x!=0){
            temp = temp*10+x%10;
            x   = x/10;
            //先判断temp是否溢出,如果没溢出,才赋值ans,溢出就返回0
            if(temp/10!=ans){
                return 0;
            }
            ans = temp;
        }

        return ans;
    }
}
