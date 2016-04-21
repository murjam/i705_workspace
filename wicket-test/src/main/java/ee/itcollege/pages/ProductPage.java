package ee.itcollege.pages;

import java.util.Arrays;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import ee.itcollege.panel.NumberPanel;

public class ProductPage extends WebPage {
	private static final long serialVersionUID = 1L;
	
	public ProductPage(final PageParameters parameters) {
		super(parameters);
		
		add(new ListView<Integer>("panels", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 345, 23, 53, 4, 4, 6)) {
			@Override
			protected void populateItem(ListItem<Integer> item) {
				item.add(new NumberPanel("panel"));
			}
		});
		
    }
}
