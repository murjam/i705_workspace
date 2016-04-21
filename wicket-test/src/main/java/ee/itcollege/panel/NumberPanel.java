package ee.itcollege.panel;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class NumberPanel extends Panel {

	public NumberPanel(String id) {
		super(id);
		Model<Integer> numberModel = new Model<Integer>(1);
		
		final WebMarkupContainer container = new WebMarkupContainer("container");
		container.setOutputMarkupId(true);
		add(container);
		
		Label label = new Label("count", numberModel);
		container.add(label);
		
		container.add(new AjaxLink<Integer>("increase", numberModel) {
			@Override
			public void onClick(AjaxRequestTarget target) {
				setModelObject(getModelObject() + 1);
				target.add(container);
			}
			@Override
			protected void onConfigure() {
				setVisible(getModelObject() < 20);
			}
		});
		
		container.add(new AjaxLink<Integer>("decrease", numberModel) {
			@Override
			public void onClick(AjaxRequestTarget target) {
				setModelObject(getModelObject() - 1);
				target.add(container);
			}
			@Override
			protected void onConfigure() {
				setVisible(getModelObject() > 0);
			}
		});
	}

}
