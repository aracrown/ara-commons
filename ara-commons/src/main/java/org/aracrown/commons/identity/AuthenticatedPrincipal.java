package org.aracrown.commons.identity;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.aracrown.commons.date.IsoDateUtil;
import org.aracrown.commons.date.TimeZoneEnum;
import org.aracrown.commons.identity.adapters.LocaleXmlAdapter;
import org.aracrown.commons.identity.adapters.ZoneIdXmlAdapter;
import org.aracrown.commons.identity.adapters.ZonedDateTimeXmlAdapter;

import com.google.common.base.Strings;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthenticatedPrincipal extends UserPrincipal {

	private static final String ANONYMOUS = "anonymous";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long uniqueIdentifier = -999999999999L;
	
	private String email;

	private String firstName;
	
	private String lastName;

	@XmlJavaTypeAdapter(ZoneIdXmlAdapter.class)
	private ZoneId zoneId;
	
	private TimeZoneEnum timezone;

	@XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
	private ZonedDateTime lastLoginDate;

	private String lastLoginHostName;
	
	@XmlJavaTypeAdapter(LocaleXmlAdapter.class)
	private Locale locale;

	private String socialIdentifier;
	
	/** Application api key if exists. */
	private String apiKey;
	
	public AuthenticatedPrincipal() {
		
	}

	public AuthenticatedPrincipal(AuthenticatedPrincipal principal) {
		updateFrom(principal);
	}

	/**
	 * @return the socialIdentifier
	 */
	public String getSocialIdentifier() {
		return socialIdentifier;
	}

	/**
	 * @param socialIdentifier the socialIdentifier to set
	 */
	public void setSocialIdentifier(String socialIdentifier) {
		this.socialIdentifier = socialIdentifier;
	}

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
		return !Strings.isNullOrEmpty(getName()) && !ANONYMOUS.equalsIgnoreCase(getName());
	}

	/**
	 * @return the zoneId
	 */
	public ZoneId getZoneId() {
		if (this.zoneId == null) {
			return ZoneId.systemDefault();
		}
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
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
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AuthenticatedPrincipal remoteAddress(String remoteAddress) {
		setRemoteAddress(remoteAddress);
		return this;
	}

	public boolean isSocialIdentifierSameAsName() {
		if (Strings.isNullOrEmpty(getSocialIdentifier())) {
			return true;
		}
		return getSocialIdentifier().equals(getEmail());
	}

	public AuthenticatedPrincipal provider(IdentityProviderType provider) {
		setProvider(provider);
		return this;
	}

	public AuthenticatedPrincipal socialIdentifier(String socialIdentifier2) {
		setSocialIdentifier(socialIdentifier2);
		return this;
	}

	public UserPrincipal newPrincipal() {
		return new UserPrincipal(getName(), getRemoteAddress(), getProvider());
	}

	public boolean hasProfile() {
		return !Strings.isNullOrEmpty(getFirstName()) || !Strings.isNullOrEmpty(getLastName());
	}

	/**
	 * @return the persisted
	 */
	public boolean isPersisted() {
		return uniqueIdentifier != null;
	}

	/**
	 * @return the uniqueIdentifier
	 */
	public Long getUniqueIdentifier() {
		return uniqueIdentifier;
	}

	/**
	 * @param uniqueIdentifier the uniqueIdentifier to set
	 */
	public void setUniqueIdentifier(Long uniqueIdentifier) {
		this.uniqueIdentifier = uniqueIdentifier;
	}
	
	public boolean isExternal() {
		return getProvider() != null && !IdentityProviderType.INTERNAL.equals(getProvider());
	}

	public void updateFrom(AuthenticatedPrincipal principal) {
		setName(principal.getName());
		setEmail(principal.getEmail());
		setFirstName(principal.getFirstName());
		setLastName(principal.getLastName());
		setZoneId(principal.getZoneId());
		setLocale(principal.getLocale());
		setProvider(principal.getProvider());
		setSocialIdentifier(principal.getSocialIdentifier());
		setUniqueIdentifier(principal.getUniqueIdentifier());
		setLastLoginDate(principal.getLastLoginDate());
		setLastLoginHostName(principal.getLastLoginHostName());
	}
	
	public String getIsoLastLoginDate() {
		return IsoDateUtil.get().format(getLastLoginDate(), getLocale(), getZoneId());
	}

	/**
	 * @return the lastLoginHostName
	 */
	public String getLastLoginHostName() {
		return lastLoginHostName;
	}

	/**
	 * @param lastLoginHostName the lastLoginHostName to set
	 */
	public void setLastLoginHostName(String lastLoginHostName) {
		this.lastLoginHostName = lastLoginHostName;
	}

	/**
	 * @return the apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * @param apiKey the apiKey to set
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * @return the timezone
	 */
	public TimeZoneEnum getTimezone() {
		if (timezone == null) {
			return TimeZoneEnum.GMTP0200_EUROPE_ATHENS;
		}
		return timezone;
	}

	/**
	 * @param timezone the timezone to set
	 */
	public void setTimezone(TimeZoneEnum timezone) {
		this.timezone = timezone;
	}
}
