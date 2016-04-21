package ee.itcollege.pages;

import org.apache.wicket.markup.html.link.Link;

public class MyLink extends Link<Void> {

	public MyLink(String id) {
		super(id);
	}

	@Override
	public void onClick() {
		System.out.println("anything");
	}

}
