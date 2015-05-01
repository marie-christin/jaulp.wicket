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
package org.jaulp.wicket.behaviors.examples;

import de.alpharogroup.locale.ResourceBundleKey;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.jaulp.wicket.base.util.application.ApplicationUtils;
import org.jaulp.wicket.base.util.resource.ResourceModelFactory;
import org.jaulp.wicket.behaviors.AddJavascriptBehavior;
import org.jaulp.wicket.behaviors.AddJsResourceReferenceBehavior;
import org.jaulp.wicket.behaviors.FaviconBehavior;
import org.jaulp.wicket.behaviors.components.MailtoLabel;
import org.jaulp.wicket.behaviors.models.MailtoModel;

/**
 * Homepage
 */
public class HomePage extends WebPage
{

	private static final long serialVersionUID = 1L;

	// Add any page properties or variables here

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 *
	 * @param parameters
	 *            Page parameters
	 */
	public HomePage(final PageParameters parameters)
	{
		IModel<String> mailtoAddresModel = ResourceModelFactory.newResourceModel(ResourceBundleKey
			.builder().key("mailtoAddresModel.value").defaultValue("").build(), this);

		IModel<String> mailtoViewModel = ResourceModelFactory.newResourceModel(ResourceBundleKey
			.builder().key("mailtoViewModel.value").defaultValue("").build(), this);

		MailtoModel mailtoModel = new MailtoModel(mailtoAddresModel, mailtoViewModel);

		add(new MailtoLabel("mailtoLabel", mailtoModel));

		Button button = new Button("button")
		{

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit()
			{

			}

		};
		add(new AddJsResourceReferenceBehavior(this.getClass(), "functions.js", "func"));
		add(new AddJavascriptBehavior("alertnow();", "xy"));

		add(new Link<String>("focusRequestExamplePage")
		{

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick()
			{
				setResponsePage(FocusRequestExamplePage.class);
			}
		});

		add(button);
		add(new FaviconBehavior());

		AjaxLink<Void> link01 = new AjaxLink<Void>("link01")
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target)
			{

			}
		};
		link01.add(new AttributeAppender("class", "navbarlink"));
		add(link01);
		AjaxLink<Void> link02 = new AjaxLink<Void>("link02")
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target)
			{

			}
		};
		add(link02);

	}

	@Override
	public void renderHead(IHeaderResponse response)
	{
		super.renderHead(response);
		response.render(JavaScriptHeaderItem.forReference(ApplicationUtils.getJQueryReference()));

	}


}
