package Other;

public class Guidewire_OA {
	public static void main(String[] args) {
		System.out.println(stringLen("baaabbabbb"));
		System.out.println(stringLen("babba"));
		System.out.println(stringLen("abaaaa"));
	}
	
	public static int square(int A, int B) {
        int totalSticks = A + B;
        int maxLenghthTogether = totalSticks / 4;
        while(maxLenghthTogether > 0) {
        int maxLenghthA = A / maxLenghthTogether;
        int maxLenghthB = B / maxLenghthTogether;
        if(maxLenghthA + maxLenghthB >= 4) {
            return maxLenghthTogether;
        }
        maxLenghthTogether--;
        }
        return 0;
    }
	
	public static int stringLen(String S) {
        // write your code in Java SE 8， only a or b
		char[] charArr = S.toCharArray();
		int result = 2;
		int len = S.length();
		//a window with len of 3
		for(int i=0;i<len-2;i++) {
			int left=i;
			while(window(left,charArr)) {
				//no 3 contiguous letter
				if(left == len-2) {
					//only 2 letter left, and the last 3 are not the same
					left=len-1;
					result = result>left-i+1? result: left-i+1;
					return result;
				}else {
					left++;
				}
			}
			//left+2 is the right edge, i is the left edge
			result = result>left+1-i+1? result: left+1-i+1;
			i=left;
		}
		return result;
    }

	private static boolean window(int left, char[] charArr) {
		if(charArr[left] == charArr[left+1]&& charArr[left]== charArr[left+2]) {
			return false;
		}
		return true;
	}
}



