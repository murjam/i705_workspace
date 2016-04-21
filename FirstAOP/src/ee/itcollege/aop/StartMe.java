package ee.itcollege.aop;

import java.util.ArrayList;

public class StartMe {
	
	public static ArrayList<String> getList() {
		System.out.println("does this get called?");
		ArrayList<String> list = new ArrayList<>();
		list.add("Mati");
		list.add("Kati");
		return list;
	}

	public static void main(String[] args) {
		System.out.println(getList());
	}

}
