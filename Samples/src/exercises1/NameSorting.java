package exercises1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NameSorting {
	
	
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.addAll(Arrays.asList(
			"Aavo\tf",
			"Kati\te",
			"Matilde\td",
			"Ants\tc",
			"Ronika\ta",
			"Siim\tb"
		));
		
		Collections.sort(names, new BackwardsNameComparator());
		
		for (String name : names) {
			System.out.println(name);
		}
		
	}

}
