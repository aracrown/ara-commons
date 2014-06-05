package org.aracrown.commons.ui.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.event.IEvent;

/**
 * Refresh behavior.
 * 
 * @author vicento.ramos
 * 
 */
public class RefreshOnClickBehavior extends Behavior {
	/** */
	private static final long serialVersionUID = 1L;

	@Override
	public void onEvent(Component component, IEvent<?> event) {
		if (event.getPayload() != null && event.getPayload() instanceof RefreshClick) {
			((RefreshClick) event.getPayload()).refresh(component);
		}
	}

}
