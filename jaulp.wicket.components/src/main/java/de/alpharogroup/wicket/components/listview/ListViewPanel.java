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
package de.alpharogroup.wicket.components.listview;

import java.util.List;

import lombok.Getter;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.util.lang.Args;

/**
 * The Class ListViewPanel takes a {@link ListView} of a generic type.
 *
 * @param <T>
 *            the generic type
 */
public abstract class ListViewPanel<T> extends GenericPanel<List<T>>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The list view. */
	@Getter
	private final ListView<T> listView;

	/**
	 * Instantiates a new {@link ListViewPanel}.
	 *
	 * @param id
	 *            the id
	 * @param list
	 *            the list
	 */
	public ListViewPanel(String id, List<T> list)
	{
		this(id, new ListModel<>(list));
	}

	/**
	 * Instantiates a new {@link ListViewPanel}.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 */
	public ListViewPanel(String id, IModel<List<T>> model)
	{
		super(id, Args.notNull(model, "model"));
		add(listView = newListView("listView", model));
	}

	/**
	 * New list view.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the list view
	 */
	protected ListView<T> newListView(String id, IModel<List<T>> model)
	{
		ListView<T> listView = new ListView<T>(id, model)
		{
			/** The Constant serialVersionUID. */
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<T> item)
			{
				item.add(newListComponent("item", item));
			}

		};
		return listView;
	}

	/**
	 * New list component.
	 *
	 * @param id
	 *            the id
	 * @param item
	 *            the item
	 * @return the component
	 */
	protected abstract Component newListComponent(String id, ListItem<T> item);

}
