package SelfLearning;

public class MCSS {
	public static void main(String[] arg) {		
		int[][] questionArrs = {
				{-3, 1, 4},
				{-3, -10, 2, 11, -5, -2, 3},
				{-7, -10, -1, -3},
				{12, -5, 6, -4, 3},
				{12, -5, -6, -4, 3}			
		};
		long startTime;
		long totalTime;
		
		System.currentTimeMillis( );
		for(int[] lst:questionArrs) {
			startTime = System.currentTimeMillis( );
			System.out.println("cubicMcss returns "+ cubicMcss(lst));
			totalTime = System.currentTimeMillis( )-startTime;
			System.out.println("cubicMcss costs "+ totalTime + "ms");
			////next method
			startTime = System.currentTimeMillis( );
			System.out.println("quadraticMcssMcss returns "+quadraticMcssMcss(lst));
			totalTime = System.currentTimeMillis( )-startTime;
			System.out.println("quadraticMcssMcss costs "+ totalTime + "ms");
			// next method
			startTime = System.currentTimeMillis( );
			System.out.println("diviAndConMcss returns "+diviAndConMcss(lst,0,lst.length-1));
			totalTime = System.currentTimeMillis( )-startTime;
			System.out.println("diviAndConMcss costs "+ totalTime + "ms");
			
			//每一组的分界线
			System.out.println("---------------------------------------- ");
		}

	}
	public static int cubicMcss(int[] arr) {
		/**
		 * 从左边第一个开始,每一组都计算从左到右的最大连续子序列值
		 * 然后第二组(从第二个开始),第三组(第三个开始)
		 * 跑完之后就知道最大值了.
		 */
		int ansMax   = 0;
		//顺便用来记录一下起止位置
		int ansLeft  = 0;
		int ansRight = 0;
		for(int left =0; left<arr.length;left++) {
			for(int right=left;right<arr.length;right++) {
				int currValue=0;
				for(int index = left; index<=right;index++) {
					currValue=currValue+arr[index];
					if(currValue>ansMax) {
						ansMax = currValue;
						//顺便记录一下起止位置
						ansLeft  = left;
						ansRight = right;
					}
				}
			}
		}
		return ansMax;
	
	}
	public static int quadraticMcssMcss(int[] arr) {
		int ansMax =0;
		int ansLeft  = 0;
		int ansRight = 0;
		for(int left =0; left<arr.length;left++) {
			int currValue = 0;
			for(int index = left; index<arr.length;index++) {
				currValue = currValue+ arr[index];
				if(currValue>ansMax) {
					ansMax = currValue;
					ansLeft  = left;
					ansRight = index;
				}
			}
		}
		return ansMax;
	}
	public static int diviAndConMcss(int[]arr, int left, int right) {
		int maxLeftSum, maxRightSum ;
		int maxLeftBorderSum = 0, maxRightBorderSum = 0;
		int middle = (left+right)/2;
		if(left == right) {						//final level
			return arr[left]>0 ?arr[left] :0 ;  //only one element, if <0, return 0
		}
		maxLeftSum = diviAndConMcss(arr,left,middle);
		maxRightSum =diviAndConMcss(arr,middle+1,right);
		
		int indexLeft =0, indexRight = 0;
		for(int i= middle;i>=left;i--) {
			indexLeft = indexLeft + arr[i];
			if(indexLeft>maxLeftBorderSum) {
				maxLeftBorderSum = indexLeft;
			}
		}
		for(int i = middle+1;i<=right;i++) {
			indexRight = indexRight+arr[i];
			if(maxRightBorderSum<indexRight) {
				maxRightBorderSum = indexRight;
			}
		}
		
		return maxOf3(maxLeftSum,maxRightSum,maxRightBorderSum+maxLeftBorderSum);
	}
	public static int maxOf3(int a, int b, int c) {
		int ans =a>b ? a:b;
		return ans>c? ans : c;
	}
}
