package LeetCode;

public class T528 {
	//其实就是根据权重,构建一个新数组,取值在第一个数之前的(<),就是第一个index,在第一第二个之间的(<),就是第二个,在第二第三个之间的就是第三个
    public int[] wieght;
	public static void Solution(int[] w) {
    	int[] weight = w;
        for(int i=1;i<w.length;i++) {
        	weight[i] = weight[i-1]+w[i];
        }
    }
    
    public static int pickIndex(int[] weight) {
       T528 out = new T528();
       int rd = (int) (Math.random()*Integer.MAX_VALUE);
       
       int l=0; int r = weight.length-1;
       while(l<r) {
    	   int mid = l+(r-l)/2;
    	   if(weight[mid]<=rd) {
    		   l=mid+1;
    	   }else {
    		   r=mid;
    	   }
       }
       return l;
    }
    public static void main(String[] args) {   	
    	int i=0;
    	while(20>i++) {
    		int rd = ((int)(Math.random()*Integer.MAX_VALUE))%6;
    		System.out.println(rd);
    	}
    }
}
