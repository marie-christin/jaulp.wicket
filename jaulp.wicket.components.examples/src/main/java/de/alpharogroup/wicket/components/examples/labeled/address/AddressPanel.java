/**
 * Copyright (C) 2010 Asterios Raptis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.alpharogroup.wicket.components.examples.labeled.address;

import lombok.Getter;

import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import de.alpharogroup.wicket.components.examples.fragment.swapping.HomeAddress;
import de.alpharogroup.wicket.components.factory.ComponentFactory;
import de.alpharogroup.wicket.components.labeled.LabeledTwoFormComponentPanel;

public class AddressPanel extends GenericPanel<HomeAddress>
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	@Getter
	LabeledTwoFormComponentPanel<String, String> zipcodeCityPanel;
	@Getter
	LabeledTwoFormComponentPanel<String, String> streetNumberPanel;

	public AddressPanel(String id, final IModel<HomeAddress> model)
	{
		super(id, model);
		setOutputMarkupId(true);
		add(streetNumberPanel = newStreetNumberPanel("streetNumberPanel",
			Model.of("Street / number:")));
		add(zipcodeCityPanel = newZipcodeCityPanel("zipcodeCityPanel", Model.of("Zip / City:")));
	}

	protected LabeledTwoFormComponentPanel<String, String> newZipcodeCityPanel(String id,
		IModel<String> labelModel)
	{
		LabeledTwoFormComponentPanel<String, String> zipcodeCityPanel = new LabeledTwoFormComponentPanel<String, String>(
			id, labelModel)
		{
			/**
			 * The serialVersionUID
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected FormComponent<String> newLeftFormComponent(String id, IModel<String> model02)
			{
				return ComponentFactory.newTextField(id, new PropertyModel<String>(
					AddressPanel.this.getModelObject(), "code"));
			}

			@Override
			protected FormComponent<String> newRightFormComponent(String id, IModel<String> model)
			{
				return ComponentFactory.newTextField(id, new PropertyModel<String>(
					AddressPanel.this.getModelObject(), "city"));
			}
		};
		return zipcodeCityPanel;
	}

	protected LabeledTwoFormComponentPanel<String, String> newStreetNumberPanel(String id,
		IModel<String> labelModel)
	{

		LabeledTwoFormComponentPanel<String, String> streetNumberPanel = new LabeledTwoFormComponentPanel<String, String>(
			id, labelModel)
		{
			/**
			 * The serialVersionUID
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected FormComponent<String> newLeftFormComponent(String id, IModel<String> model)
			{
				return ComponentFactory.newTextField(id, new PropertyModel<String>(
					AddressPanel.this.getModelObject(), "street"));
			}

			@Override
			protected FormComponent<String> newRightFormComponent(String id, IModel<String> model)
			{
				return ComponentFactory.newTextField(id, new PropertyModel<String>(
					AddressPanel.this.getModelObject(), "localNumber"));
			}
		};
		return streetNumberPanel;
	}

}
