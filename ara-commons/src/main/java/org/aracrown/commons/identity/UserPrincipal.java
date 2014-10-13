package org.aracrown.commons.identity;

import java.io.Serializable;
import java.security.Principal;

import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserPrincipal implements Serializable, Principal {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@FormParam("username")
	private String name;
	
	@FormParam("remoteAddress")
	private String remoteAddress;
	
	@NotNull
	@FormParam("provider")
	private IdentityProviderType provider;
	
	public UserPrincipal() {
	}

	public UserPrincipal(String username2, String remoteAddress, IdentityProviderType provider) {
		this.name = username2;
		this.remoteAddress = remoteAddress;
		this.provider = provider;
	}

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
	 * @return the remoteAddress
	 */
	public String getRemoteAddress() {
		return remoteAddress;
	}

	/**
	 * @param remoteAddress the remoteAddress to set
	 */
	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	/**
	 * @return the provider
	 */
	public IdentityProviderType getProvider() {
		return provider;
	}

	/**
	 * @param provider the provider to set
	 */
	public void setProvider(IdentityProviderType provider) {
		this.provider = provider;
	}
}