/**
 * 1472. Design Browser History
Medium

You have a browser of one tab where you start on the homepage and you can visit another 
url, get back in the history number of steps or move forward in the history number of steps.

Implement the BrowserHistory class:

BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
void visit(string url) Visits url from the current page. It clears up all the forward 
history.
string back(int steps) Move steps back in history. If you can only return x steps in the 
history and steps > x, you will return only x steps. Return the current url after moving
 back in history at most steps.
string forward(int steps) Move steps forward in history. If you can only forward x steps
 in the history and steps > x, you will forward only x steps. Return the current url after 
 forwarding in history at most steps.
 

Example:

Input:
["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
Output:
[null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

Explanation:
BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
 

Constraints:

1 <= homepage.length <= 20
1 <= url.length <= 20
1 <= steps <= 100
homepage and url consist of  '.' or lower case English letters.
At most 5000 calls will be made to visit, back, and forward.
 */
package LeetCode;

import java.util.Stack;

public class T1472 {
	class BrowserHistory {
		Stack<String> backward;
		Stack<String> forward;
		String curSite;
	    public BrowserHistory(String homepage) {
	        this.curSite = homepage;
	        this.backward = new Stack<String>();
	        this.forward  = new Stack<String>();
	    }
	    
	    public void visit(String url) {
	    	backward.push(curSite);
	    	curSite=url;
	    	forward.clear();//题目说了,visit要清空forward历史
	    }
	    
	    public String back(int steps) {
	    	while(steps>0&&(!backward.isEmpty())){
	    		steps--;
	    		forward.push(curSite);
	    		curSite = backward.pop();
		    	
	    	}

	    	return curSite;
	    }
	    
	    public String forward(int steps) {
	    	while(steps>0&&(!forward.isEmpty())){
	    		steps--;
	    		backward.push(curSite);
	    		curSite = forward.pop();

	    	}

	    	return curSite;
	    }
	}
	
	public static void main(String[] args) {
		T1472 out = new T1472();
		BrowserHistory br = out.new BrowserHistory("leetcode.com");
		br.visit("google.com");
		br.visit("facebook.com");
		br.visit("youtube.com");
		String a = br.back(1);
		String b = br.back(1);
		String c = br.forward(1);
		br.visit("linkedin.com");
		String d = br.forward(2);
		String e = br.back(2);
		String f = br.back(7);
		
	}
}


/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
