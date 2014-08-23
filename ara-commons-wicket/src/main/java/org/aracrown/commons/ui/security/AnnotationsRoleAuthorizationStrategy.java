package org.aracrown.commons.ui.security;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authorization.IAuthorizationStrategy;
import org.apache.wicket.request.component.IRequestableComponent;
import org.aracrown.commons.security.SecurityService;

/**
 * Simple authorization strategy implementation, using {@link RolesAllowed} annotations to resolve role and permission
 * names.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 */
public class AnnotationsRoleAuthorizationStrategy implements IAuthorizationStrategy {

	/** Injected security service instance. */
	@Inject
	private SecurityService securityService;

	/**
	 * Construct.
	 * 
	 */
	public AnnotationsRoleAuthorizationStrategy() {
	}

	AnnotationsRoleAuthorizationStrategy(SecurityService securityService) {
		this.securityService = securityService;
	}

	@Override
	public <T extends IRequestableComponent> boolean isInstantiationAuthorized(Class<T> componentClass) {
		final RolesAllowed classAnnotation = componentClass.getAnnotation(RolesAllowed.class);
		boolean authorized = true;
		if (classAnnotation != null) {
			authorized = securityService.hasAnyRole(classAnnotation.value());
		}

		return authorized;
	}

	@Override
	public boolean isActionAuthorized(Component component, Action action) {
		// Get component's class
		final Class<?> componentClass = component.getClass();
		boolean t =  isActionAuthorized(componentClass);
		return t;
	}

	private boolean isActionAuthorized(Class<?> componentClass) {
		final RolesAllowed classAnnotation = componentClass.getAnnotation(RolesAllowed.class);
		boolean authorized = true;
		if (classAnnotation != null) {
			return securityService.hasAnyRole(classAnnotation.value());
		}
		return authorized;
	}
}
