package org.aracrown.commons.identity;

import org.aracrown.commons.persistence.AbstractBuilder;

public abstract class AuthenticatedPrincipalBuilder extends AbstractBuilder<AuthenticatedPrincipal> {

	public AuthenticatedPrincipalBuilder() {
		super(new AuthenticatedPrincipal());
	}

	@Override
	public AuthenticatedPrincipal build() {
		uniqueIdentifier().name().provider().email().firstName().lastName().timeZone().remoteAddress().lastLoginDate().locale();
		return super.build();
	}
	
	protected abstract AuthenticatedPrincipalBuilder uniqueIdentifier();
	
	protected abstract AuthenticatedPrincipalBuilder remoteAddress();

	protected abstract  AuthenticatedPrincipalBuilder provider();
	
	protected abstract  AuthenticatedPrincipalBuilder locale();

	protected abstract  AuthenticatedPrincipalBuilder lastLoginDate();

	protected abstract  AuthenticatedPrincipalBuilder timeZone();

	protected abstract  AuthenticatedPrincipalBuilder firstName();
	
	protected abstract  AuthenticatedPrincipalBuilder lastName();

	protected abstract  AuthenticatedPrincipalBuilder email();

	protected abstract  AuthenticatedPrincipalBuilder name();
}
