package org.aracrown.commons.ui.paging;

import java.io.Serializable;

import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.model.IModel;

/**
 * Page link css model. Kindly borrowed from http://maciej-miklas.blogspot.com/2013/10/wicket-6-paging-navigator-for-bootstrap.html
 * 
 * @author vicento.ramos
 * 
 */
public class PageLinkIncrementCssModel implements IModel<String>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Pageable component. */
	private final IPageable pageable;

	/** The page number. */
	private final long pageNumber;

	/**
	 * Default constructor.
	 * 
	 * @param pageable
	 *            pageable component
	 * @param pageNumber
	 *            page number
	 */
	public PageLinkIncrementCssModel(IPageable pageable, long pageNumber) {
		this.pageable = pageable;
		this.pageNumber = pageNumber;
	}

	@Override
	public String getObject() {
		return isEnabled() ? "" : "disabled";
	}

	@Override
	public void setObject(String object) {
	}

	@Override
	public void detach() {
	}

	/**
	 * Checks if page link is enabled.
	 * 
	 * @return true page number is not the first one and not the last one
	 */
	public boolean isEnabled() {
		if (pageNumber < 0) {
			return !isFirst();
		} else {
			return !isLast();
		}
	}

	/**
	 * Checks if it is the first page.
	 * 
	 * @return true if current page is the first one
	 */
	public boolean isFirst() {
		return pageable.getCurrentPage() <= 0;
	}

	/**
	 * Checks if it is the last page.
	 * 
	 * @return true if current page is the last one
	 */
	public boolean isLast() {
		return pageable.getCurrentPage() >= (pageable.getPageCount() - 1);
	}

}
