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
package de.alpharogroup.wicket.components.labeled.textfield;

import lombok.Getter;

import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import de.alpharogroup.wicket.components.factory.ComponentFactory;
import de.alpharogroup.wicket.components.labeled.LabeledFormComponentPanel;

/**
 * Convenience class for labeled TextField.
 *
 * @param <T>
 *            the generic type
 */
public class LabeledRequiredTextFieldPanel<T> extends LabeledFormComponentPanel<T>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The text field. */
	@Getter
	private final RequiredTextField<T> textField;

	/**
	 * Instantiates a new LabeledTextfieldPanel.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @param labelModel
	 *            the label model
	 */
	public LabeledRequiredTextFieldPanel(String id, IModel<T> model, IModel<String> labelModel)
	{
		super(id, model, labelModel);

		add(textField = newRequiredTextField("textField", model));

		add(feedback = newComponentFeedbackPanel("feedback", textField));

		String markupId = textField.getMarkupId();
		add(label = newLabel("label", markupId, getLabel()));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void convertInput()
	{
		setConvertedInput(textField.getConvertedInput());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getInput()
	{
		return textField.getInput();
	}

	/**
	 * Factory method for creating a new RequiredTextField. This method is invoked in the
	 * constructor from the derived classes and can be overridden so users can provide their own
	 * version of a RequiredTextField.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the new RequiredTextField
	 */
	protected RequiredTextField<T> newRequiredTextField(String id, IModel<T> model)
	{
		return ComponentFactory.newRequiredTextField(id, new PropertyModel<T>(model.getObject(),
			getId()));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onBeforeRender()
	{
		textField.setRequired(isRequired());
		super.onBeforeRender();
	}
}
