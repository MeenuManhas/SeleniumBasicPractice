package testCases;
/*Write a Java program to count capitalised word from String.
 * Sample Input: GoodMorningTechnoCreditsJun

Sample output: 5
*/

public class Practice {

	public static void main(String[] args) {
		int count = 0;
		String str = "GoodMorningTechnoCreditsJun";
		for(int index = 0;index<str.length();index++) {
			char ch = str.charAt(index);
			if(Character.isUpperCase(ch))
				count++;
		}
		System.out.println(count);
	}

}
