package ee.itcollege.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class AnotherPage extends WebPage {

	public AnotherPage() {
		PageParameters params = new PageParameters();
		params.add("id", "the ID value");
		add(new BookmarkablePageLink<Void>("click", ProductPage.class, params));
	}
	
}
