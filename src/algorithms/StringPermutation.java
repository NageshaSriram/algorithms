package algorithms;

public class StringPermutation {

	public static void main(String[] args) {
		String input = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		permute(input, 0, input.length());
	}
	
	public static void permute(String str, int m, int n) {
		if(m==n) {
			System.out.println(str);
		}else {
			for(int i=m;i<n;i++) {
				str = swap(str,m,i);
				permute(str, m+1, n);
				str = swap(str,m,i);
			}
			
		}
	}

	private static String swap(String str, int m, int i) {
		char[] chars = str.toCharArray();
		char c = chars[m];
		chars[m] = chars[i];
		chars[i] = c;
		return String.valueOf(chars);
	}

	
}
