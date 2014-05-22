package org.aracrown.commons.ui.paging;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigation;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigationBehavior;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigationIncrementLink;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigationLink;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.LoopItem;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.IPagingLabelProvider;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigation;

import de.agilecoders.wicket.markup.html.bootstrap.navigation.ajax.BootstrapAjaxPagingNavigationBehavior;
import de.agilecoders.wicket.markup.html.bootstrap.navigation.ajax.BootstrapAjaxPagingNavigator;

/**
 * Customized version of paging navigator.
 * 
 * @author vicento.ramos
 * 
 */
public class Bootstrap3AjaxPagingNavigator extends BootstrapAjaxPagingNavigator {
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * 
	 * @param id
	 *            The non-null id of this component
	 * @param pageable
	 *            pageable component
	 */
	public Bootstrap3AjaxPagingNavigator(String id, IPageable pageable) {
		super(id, pageable);
		add(AttributeModifier.remove("class"));
		setOutputMarkupId(true);
	}

	@Override
	protected AbstractLink newPagingNavigationIncrementLink(String id, IPageable pageable, int increment) {

		ExternalLink navCont = new ExternalLink(id + "Cont", (String) null);

		// add css for enable/disable link
		long pageIndex = pageable.getCurrentPage() + increment;
		navCont.add(new AttributeModifier("class", new PageLinkIncrementCssModel(pageable, pageIndex)));

		// change original wicket-link, so that it always generates href
		navCont.add(new AjaxPagingNavigationIncrementLink(id, pageable, increment) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected AjaxPagingNavigationBehavior newAjaxPagingNavigationBehavior(IPageable pageable, String event) {
				return new BootstrapAjaxPagingNavigationBehavior(this, pageable, event);
			}

			@Override
			protected void disableLink(ComponentTag tag) {

			}
		});
		return navCont;
	}

	@Override
	protected AbstractLink newPagingNavigationLink(String id, IPageable pageable, int pageNumber) {
		ExternalLink navCont = new ExternalLink(id + "Cont", (String) null);

		// add css for enable/disable link
		long pageIndex = pageable.getCurrentPage() + pageNumber;
		navCont.add(new AttributeModifier("class", new PageLinkCssModel(pageable, pageIndex, "disabled")));

		// change original wicket-link, so that it always generates href
		navCont.add(new AjaxPagingNavigationLink(id, pageable, pageNumber) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected AjaxPagingNavigationBehavior newAjaxPagingNavigationBehavior(IPageable pageable, String event) {
				return new BootstrapAjaxPagingNavigationBehavior(this, pageable, event);
			}

			@Override
			protected void disableLink(ComponentTag tag) {

			}
		});
		return navCont;

	}

	@Override
	protected PagingNavigation newNavigation(String id, IPageable pageable, IPagingLabelProvider labelProvider) {
		return new AjaxPagingNavigation(id, pageable, labelProvider) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected Link<?> newPagingNavigationLink(String id, IPageable pageable, long pageIndex) {
				return new AjaxPagingNavigationLink(id, pageable, pageIndex) {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					protected AjaxPagingNavigationBehavior newAjaxPagingNavigationBehavior(IPageable pageable, String event) {
						return new BootstrapAjaxPagingNavigationBehavior(this, pageable, event);
					}
				};
			}

			@Override
			protected LoopItem newItem(int iteration) {
				LoopItem item = super.newItem(iteration);

				// add css for enable/disable link
				long pageIndex = getStartIndex() + iteration;
				item.add(new AttributeModifier("class", new PageLinkCssModel(pageable, pageIndex, "active")));

				return item;
			}
		};
	}
}
