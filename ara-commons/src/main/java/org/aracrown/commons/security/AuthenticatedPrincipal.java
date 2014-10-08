package org.aracrown.commons.security;

import java.security.Principal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.google.common.base.Strings;

public class AuthenticatedPrincipal implements Principal {
	
	private String name;
	
	private String email;
	
	private String fullName;
	
	private ZoneId zoneId;
	
	private ZonedDateTime lastLoginDate;
	
	private Locale locale;
	
	private List<String> permissions = new ArrayList<>();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * @return the lastLoginDate
	 */
	public ZonedDateTime getLastLoginDate() {
		return lastLoginDate;
	}

	/**
	 * @param lastLoginDate the lastLoginDate to set
	 */
	public void setLastLoginDate(ZonedDateTime lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	public boolean isAuthenticated() {
		return !Strings.isNullOrEmpty(name) && !"anonymous".equalsIgnoreCase(name);
	}

	/**
	 * @return the zoneId
	 */
	public ZoneId getZoneId() {
		return zoneId;
	}

	/**
	 * @param zoneId the zoneId to set
	 */
	public void setZoneId(ZoneId zoneId) {
		this.zoneId = zoneId;
	}

	/**
	 * @return the permissions
	 */
	public List<String> getPermissions() {
		return permissions;
	}

	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
}
