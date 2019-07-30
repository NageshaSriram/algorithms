package algorithms;

import java.util.Stack;

public class StringProblems {
	
	public static void main(String[] args) {
		
		String str = "welcome";
		String reverseStr = reverseStrIteration(str);
		System.out.println(reverseStr);
		
		str = "welcome";
		String reverseRec = reverseStrRecur(str.toCharArray(), 0, str.length() - 1);
		System.out.println(reverseRec);
		
		str = "welcome";
		String reverseStack = reverseStrStack(str);
		System.out.println(reverseStack);
		
		}
	private static String reverseStrRecur(char[] cs, int start, int end) {
		if(start >= end) {
			return new String(cs);
		}else {
			char c = cs[start];
			cs[start] = cs[end];
			cs[end] = c;
			start ++;
			end --;
			reverseStrRecur(cs, start, end);
		}
		
		return new String(cs);
	}
	public static String reverseStrIteration(String str) {
		
		StringBuilder strBuild = new StringBuilder(str);
		
		int start = 0;
		int end = str.length()-1;
		
		while(start < end) {
			char c = strBuild.charAt(start);
			strBuild.replace(start, start+1,""+ strBuild.charAt(end));
			strBuild.replace(end, end + 1, ""+c);
			start++;
			end--;
		}
		
		return strBuild.toString();
	}
	
	public static String reverseStrStack(String str) {
		
		Stack stack = new Stack();
		for(int i=0; i<str.length();i++) {
			stack.push(str.charAt(i));
		}
		StringBuilder strBuild = new StringBuilder();
		
		while(!stack.isEmpty()) {
			strBuild.append(stack.pop());
		}
		
		return strBuild.toString();
	}

}
