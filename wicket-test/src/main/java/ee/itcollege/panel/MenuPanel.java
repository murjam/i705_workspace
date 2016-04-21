package ee.itcollege.panel;


import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class MenuPanel extends Panel {

	public MenuPanel(String id, String info) {
		super(id);
		
		Label label = new Label("something", info);
		add(label);
	}

}
