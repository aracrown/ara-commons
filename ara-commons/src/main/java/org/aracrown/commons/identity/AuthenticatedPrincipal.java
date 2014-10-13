package org.aracrown.commons.identity;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.aracrown.commons.identity.adapters.LocaleXmlAdapter;
import org.aracrown.commons.identity.adapters.ZoneIdXmlAdapter;
import org.aracrown.commons.identity.adapters.ZonedDateTimeXmlAdapter;

import com.google.common.base.Strings;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthenticatedPrincipal extends UserPrincipal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String email;

	private String firstName;
	
	private String lastName;

	@XmlJavaTypeAdapter(ZoneIdXmlAdapter.class)
	private ZoneId zoneId;

	@XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
	private ZonedDateTime lastLoginDate;

	@XmlJavaTypeAdapter(LocaleXmlAdapter.class)
	private Locale locale;

	private List<String> permissions = new ArrayList<>();

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return new AccountFullNameBuilder(firstName, lastName).build(getName());
	}

	/**
	 * @return the lastLoginDate
	 */
	public ZonedDateTime getLastLoginDate() {
		return lastLoginDate;
	}

	/**
	 * @param lastLoginDate
	 *            the lastLoginDate to set
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
	 * @param locale
	 *            the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public boolean isAuthenticated() {
		return !Strings.isNullOrEmpty(getName()) && !"anonymous".equalsIgnoreCase(getName());
	}

	/**
	 * @return the zoneId
	 */
	public ZoneId getZoneId() {
		return zoneId;
	}

	/**
	 * @param zoneId
	 *            the zoneId to set
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
	 * @param permissions
	 *            the permissions to set
	 */
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isRegistrationRequired() {
		return Strings.isNullOrEmpty(email);
	}

	public AuthenticatedPrincipal remoteAddress(String remoteAddress) {
		setRemoteAddress(remoteAddress);
		return this;
	}
}
