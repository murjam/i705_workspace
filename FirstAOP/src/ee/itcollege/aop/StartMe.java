package ee.itcollege.aop;

import java.util.ArrayList;

import ee.itcollege.aop.annot.Tracked;

public class StartMe {
	public static String value = "test";
	public static String value1 = "test1";
	public static String value2 = "test2";
	
	@Tracked
	public static ArrayList<String> getList() {
		System.out.println("does this get called?");
		ArrayList<String> list = new ArrayList<>();
		list.add("Mati");
		list.add("Kati");
		return list;
	}

	@Tracked
	public static void main(String[] args) {
		System.out.println(value);
		System.out.println(value2);
		System.out.println(value1);
		System.out.println(getList());
	}

}
