/*
 * Copyright 2013 ARA Crown
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aracrown.commons.security;

import java.io.Serializable;

import org.aracrown.commons.identity.AuthenticatedPrincipal;

/**
 * Security interface, providing authentication and authorization method for the
 * current user.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 */
public interface SecurityService extends Serializable {

	/**
	 * Authenticate the user by it's username and password.
	 * 
	 * @param token
	 *            the username and password combination, submitted for
	 *            authentication
	 * @return authenticated principal instance with proper information populated.
	 */
	AuthenticatedPrincipal authenticate(UsernamePasswordToken token) throws AuthenticationException;

	/**
	 * Returns {@code true} if this Subject has at least one specified role,
	 * {@code false} otherwise.
	 * 
	 * @param roles
	 *            the list of application-specific role identifiers (usually a
	 *            role id or role name).
	 * @return {@code true} if this Subject has at least one specified role,
	 *         {@code false} otherwise.
	 */
	boolean hasAnyRole(String[] roles);

	/**
	 * Returns {@code true} if this Subject is permitted to perform at least one
	 * action or access a resource summarized by the specified permission
	 * string.
	 * 
	 * @param permissions
	 *            the String list representation of one or more Permissions that
	 *            are being checked.
	 * @return true if this Subject is permitted, false otherwise.
	 */
	boolean hasAnyPermission(String[] permissions);

	/**
	 * Logs out this Subject and invalidates and/or removes any associated
	 * entities.
	 */
	void logout();

}
