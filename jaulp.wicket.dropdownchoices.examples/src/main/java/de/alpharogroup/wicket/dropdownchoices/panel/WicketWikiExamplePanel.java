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
package de.alpharogroup.wicket.dropdownchoices.panel;

import java.util.Arrays;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.panel.Panel;

import de.alpharogroup.wicket.components.i18n.dropdownchoice.LocalisedDropDownChoice;
import de.alpharogroup.wicket.model.dropdownchoices.SelectOptionModel;


public class WicketWikiExamplePanel extends Panel
{

	private static final long serialVersionUID = 1L;

	public WicketWikiExamplePanel(final String id)
	{
		super(id);
		SelectOptionModel[] options = new SelectOptionModel[] {
				new SelectOptionModel("and", "AND"), new SelectOptionModel("|", "OR") };
		ChoiceRenderer<SelectOptionModel> choiceRenderer = new ChoiceRenderer<SelectOptionModel>(
			"value", "key");
		add(new LocalisedDropDownChoice<SelectOptionModel>("connective", Arrays.asList(options),
			choiceRenderer));
	}

}
