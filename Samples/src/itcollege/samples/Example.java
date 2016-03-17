package itcollege.samples;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Example {
	
	static void methodName(ArrayList<Integer> whatever) {
		whatever.add(4);
	}	
	
	public static void main(String[] args) {
		
		final int iterations = 10000000;
		

		ArrayList<Integer> num1 = new ArrayList<>();
		methodName(num1);
		System.out.println(num1);
		
		long time = System.currentTimeMillis();
		
		for (int i = 0; i < iterations; i++) {
			num1.add((int)(Math.random() * 100));
		}
		System.out.format("ArrayList done %dms\n", System.currentTimeMillis() - time);
		
		
		LinkedList<Integer> num2 = new LinkedList<>();
		time = System.currentTimeMillis();
		
		for (int i = 0; i < iterations; i++) {
			num2.add((int)(Math.random() * 100));
		}
		System.out.format("LinkedList done %dms\n", System.currentTimeMillis() - time);
		
	}

}
