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
public class PageLinkCssModel implements IModel<String>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The page number. */
	private final long pageNumber;

	/** Pageable component. */
	private final IPageable pageable;

	/** Css class value. */
	private final String css;

	/**
	 * Default constructor.
	 * 
	 * @param pageable
	 *            pageable component
	 * @param pageNumber
	 *            page number
	 * @param css
	 *            css class value
	 */
	public PageLinkCssModel(IPageable pageable, long pageNumber, String css) {
		this.pageNumber = pageNumber;
		this.pageable = pageable;
		this.css = css;
	}

	@Override
	public String getObject() {
		return isSelected() ? css : "not_selected";
	}

	@Override
	public void setObject(String object) {
	}

	@Override
	public void detach() {
	}

	/**
	 * Checks if provided page number is the same as current page number.
	 * 
	 * @return true if page is the selected one
	 */
	public boolean isSelected() {
		return getPageNumber() == pageable.getCurrentPage();
	}

	private long getPageNumber() {
		long idx = pageNumber;
		if (idx < 0) {
			idx = pageable.getPageCount() + idx;
		}

		if (idx > (pageable.getPageCount() - 1)) {
			idx = pageable.getPageCount() - 1;
		}

		if (idx < 0) {
			idx = 0;
		}

		return idx;
	}
}
