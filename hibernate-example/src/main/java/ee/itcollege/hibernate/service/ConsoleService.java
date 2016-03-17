package ee.itcollege.hibernate.service;

import ee.itcollege.hibernate.TextIO;

public class ConsoleService implements UserInteractionService {

	public String getString() {
		return TextIO.getlnString();
	}

	public void print(Object a) {
		System.out.println(a);
	}

	public int getInt() {
		return TextIO.getlnInt();
	}

}
