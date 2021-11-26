package newProj;

public class MirrorEnds {

	public static void main(String[] args) {
		String n = "hyelloleh";
		System.out.println(mirrorEnds(n));
		System.out.println(mirrorRec(n));
	}
	
	// for loop
	static String mirrorEnds(String str) {
		String result = "";
		int l = str.length();
		for(int i=0; i<l/2; i++) {
			if(str.charAt(i)==str.charAt(l-1-i)) {
				result += str.charAt(i);
			} else {
				break;
			}
		}
		return result;
	}
	
	// recursion
	static String mirrorRec(String str) {
		String result = "";
		if(str.length() <= 1) {
			return result;
		}
		if(str.charAt(0)==str.charAt(str.length()-1)) {
			result += str.charAt(0);
			return mirrorRec(str.substring(1, str.length()-1));
		}
		return result;
	}
}
