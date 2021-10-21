/**
 * 26. Remove Duplicates from Sorted Array
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

 */
package LeetCode;

public class T26 {
	public static void main(String[] args) {
		int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
		 removeDuplicates3(nums) ;
	}
	//下面这个方法,思路是每一个元素,向后循环,找到重复的个数,然后这个元素的后面元素通通向前移动
    public static int removeDuplicates(int[] nums) {
    	int length = nums.length;
        for(int i=0;i<length;i++) {
        	int moveTimes = 0;
        	int curNum = nums[i];
        	for(int j =i+1;j<length;j++) {
        		if(nums[j]==curNum) {
        			moveTimes++;
        		}else {
        			break;
        		}
        	}
        	if (moveTimes>0) {
        		for(int v = i+1+moveTimes;v<length;v++) {
        			nums[v-moveTimes] = nums[v];
        		}
        		length = length-moveTimes;      		
        	}
        }
        return length;
    }
    //下面这个思路是,快慢指针,快指针找到下一个不同的数,慢指针是当不同的数找到后,插到慢指针的下一个位置
    public static int removeDuplicates2(int[] nums) {
    	int nextDif = 0; 
    	int curIndex=0;
    	while(nextDif<nums.length) {
    		if(nums[curIndex]==nums[nextDif]) {
    			nextDif++;
    		}else {
    			curIndex ++;
    			nums[curIndex]=nums[nextDif];
    		}
    	}
    	return curIndex+1;
    }
    /**
     * 下面是将上面的方法2修改写法,减少行数,但是时间更多,不知为何
     * 
     */
    public static int removeDuplicates3(int[] nums) {
    	int nextDif = 0; 
    	int curIndex=0;
    	while(nextDif<nums.length) {
    		if(nums[curIndex]==nums[nextDif]) {nextDif++;}
    		else {nums[++curIndex]=nums[nextDif];    		}
    	}
    	return curIndex+1;
    }
}
