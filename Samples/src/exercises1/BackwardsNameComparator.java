package exercises1;

import java.util.Comparator;

public class BackwardsNameComparator implements Comparator<String> {
	
	private String reverse(String input) {
		String result = "";
		
		for (int i = 0; i < input.length(); i++) {
			result = input.charAt(i) + result;
		}
		
		return result;
	}

	@Override
	public int compare(String name1, String name2) {
		return reverse(name1).compareTo(reverse(name2));
	}

}