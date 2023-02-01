package Other;
/*
 *  给一个数组，按照 最大，最小，第二大，第二小，..排列
 */
public class Meandering_array {
	public static int[] Marry(int[] arry) {
		//1. sort the arry
		for(int i=0;i<arry.length-1;i++) {
			int temp = arry[i+1];
			int j = i+1;
			while(j>0&&temp<arry[j-1]) {
				arry[j]=arry[j-1];
				j--;
			}
			arry[j]=temp;
		}
		
		//2.from left and right, peek the maxest, second maxest, smallest,second smallest...	
		int left =0; int right = arry.length-1;
		int[] result = new int[arry.length];
		int index=0;
		while(left<right) {
			result[index++]=arry[right--];
			result[index++]=arry[left++];
		}
		result[index] = arry[left];
		return result;
		
	}
	public static void main(String[] args) {
		int[] arry = {-1,1,2,3,-5};
		int[] ar = Marry(arry);
		System.out.println();
	}
}
