package org.aracrown.commons.ui.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;

/**
 * Refresh selected components.
 * 
 * @author vicento.ramos
 * 
 */
public class RefreshClick {
	/** Ajax target. */
	private final AjaxRequestTarget target;

	/**
	 * Default constructor.
	 * 
	 * @param target
	 *            ajax target
	 */
	public RefreshClick(AjaxRequestTarget target) {
		this.target = target;
	}

	/**
	 * Refreshing components.
	 * 
	 * @param components
	 *            components to refresh
	 */
	public void refresh(Component... components) {
		target.add(components);
	}
}
