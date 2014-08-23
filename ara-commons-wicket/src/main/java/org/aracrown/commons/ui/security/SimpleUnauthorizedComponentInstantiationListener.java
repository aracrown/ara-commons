package org.aracrown.commons.ui.security;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.util.WebUtils;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.authorization.IUnauthorizedComponentInstantiationListener;
import org.apache.wicket.authorization.UnauthorizedInstantiationException;
import org.apache.wicket.request.cycle.RequestCycle;

/**
 * Handling class of unauthorized component instantiations.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 */
public abstract class SimpleUnauthorizedComponentInstantiationListener implements IUnauthorizedComponentInstantiationListener {

	@Override
	public void onUnauthorizedInstantiation(Component component) {
		// If there is a sign in page class declared, and the
		// unauthorized component is a page, but it's not the
		// sign in page
		if (component instanceof Page) {
			// Save original request for redirect purposes
			HttpServletRequest request = (HttpServletRequest) RequestCycle.get().getRequest().getContainerRequest();
			WebUtils.saveRequest(request);
			// Redirect to page to let the user sign in
			throw new RestartResponseAtInterceptPageException(getLoginPage());
		} else {
			// The component was not a page, so throw exception
			throw new UnauthorizedInstantiationException(component.getClass());
		}
	}

	/**
	 * Returns login page, containing sign-in form.
	 * 
	 * @return login page class
	 */
	protected abstract Class<? extends Page> getLoginPage();
}
