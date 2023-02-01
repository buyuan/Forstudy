package LeetCode;

public class T443 {
    public int compress(char[] chars) {
        //双指针（用HashMap不行，因为会打乱顺序
    	//注意不能开辟新空间，所以要修改原数组
    	int len = chars.length;int curPos=0;
    	for(int i=0, j=0;i<len;i=j) {
    		//当j走到一个不同的字符之后， 再从这个开始新的寻找（i=j)
    		while(j<len&& chars[j]==chars[i]) {
    			j++;//相同字符，j继续走，跳出while时候，是发现了新的字符
    		}
    		//当前的char[i]是第一个或者是和之前不同的一个字符
    		chars[curPos] = chars[i];
    		curPos++;//curPos是新的坐标，输出结果的字符串的坐标
    		if(j-i==1) {
    			//这个字符只有一个,不需要处理数量
    			continue;
    		}
    		String ss = ""+(j-i);
    		//转换为数组，因为可能是不止一位数
    		for(char c : ss.toCharArray()) {
    			chars[curPos++]=c;
    		}
    	}
    	return curPos;//处理完之后，这个坐标就是新字符串的长度，因为从0开始,最后一次之后加了1.
    	
    }
}

/*
443. String Compression
Medium

2360

4504

Add to List

Share
Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.

 

Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
Example 2:

Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.
Example 3:

Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
*/