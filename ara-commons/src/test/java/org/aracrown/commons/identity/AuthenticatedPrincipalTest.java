package org.aracrown.commons.identity;

import java.time.ZoneId;
import java.util.Locale;

import org.aracrown.commons.date.IsoDateUtil;
import org.junit.Assert;
import org.junit.Test;

public class AuthenticatedPrincipalTest {

	@Test
	public void testAllFilled()  {
		AuthenticatedPrincipal p = new PrincipalBuilder().build();
		assertPrincipal(p);
		Assert.assertEquals("2013-12-06T20:45+01:00",p.getLastLoginDate().toString());
		Assert.assertEquals("127.0.0.1",p.getRemoteAddress());
		Assert.assertEquals(Boolean.TRUE,p.hasProfile());
		Assert.assertEquals(Boolean.TRUE,p.isAuthenticated());
		Assert.assertEquals(Boolean.TRUE,p.isPersisted());
		Assert.assertEquals(Boolean.FALSE,p.isSocialIdentifierSameAsName());
		Assert.assertEquals(Boolean.FALSE,p.isExternal());
	}
	

	
	@Test
	public void testAllFilled2()  {
		AuthenticatedPrincipal p = new PrincipalBuilder().build();
		
		AuthenticatedPrincipal p2 = new AuthenticatedPrincipal(p);
		assertPrincipal(p2);
		Assert.assertEquals(null,p2.getLastLoginDate());
		Assert.assertEquals(null,p2.getRemoteAddress());
		Assert.assertEquals(Boolean.TRUE,p2.hasProfile());
		Assert.assertEquals(Boolean.TRUE,p2.isAuthenticated());
		Assert.assertEquals(Boolean.TRUE,p2.isPersisted());
		Assert.assertEquals(Boolean.FALSE,p2.isSocialIdentifierSameAsName());
		Assert.assertEquals(Boolean.FALSE,p2.isExternal());
		
		p2.remoteAddress("127.0.0.1");
		Assert.assertEquals("127.0.0.1",p2.getRemoteAddress());
		
		p2.provider(IdentityProviderType.GITHUB);
		Assert.assertEquals(IdentityProviderType.GITHUB,p2.getProvider());
		Assert.assertEquals(Boolean.TRUE,p2.isExternal());
		
		p2.provider(null);
		Assert.assertEquals(null,p2.getProvider());
		Assert.assertEquals(Boolean.FALSE,p2.isExternal());
		
		p2.socialIdentifier(null);
		Assert.assertEquals(null,p2.getSocialIdentifier());
		Assert.assertEquals(Boolean.TRUE,p2.isSocialIdentifierSameAsName());
		
		p2.setUniqueIdentifier(null);
		Assert.assertEquals(null,p2.getUniqueIdentifier());
		Assert.assertEquals(Boolean.FALSE,p2.isPersisted());
		
		p2.setFirstName(null);
		Assert.assertEquals(Boolean.TRUE,p2.hasProfile());
		
		p2.setLastName(null);
		Assert.assertEquals(Boolean.FALSE,p2.hasProfile());
		
		p2.setName("anonymous");
		Assert.assertEquals(Boolean.FALSE,p2.isAuthenticated());
		
		p2.setName(null);
		Assert.assertEquals(Boolean.FALSE,p2.isAuthenticated());
	}
	
	@Test
	public void testCopyPrincipal()  {
		AuthenticatedPrincipal p = new PrincipalBuilder().build();
		
		UserPrincipal up = p.newPrincipal();
		
		Assert.assertEquals("name",up.getName());
		Assert.assertEquals("127.0.0.1",up.getRemoteAddress());
		Assert.assertEquals(IdentityProviderType.INTERNAL,up.getProvider());
	}

	@Test
	public void testPrincipal()  {
		
		UserPrincipal up = new UserPrincipal("name");
		
		Assert.assertEquals("name",up.getName());
		Assert.assertEquals(null,up.getRemoteAddress());
		Assert.assertEquals(IdentityProviderType.INTERNAL,up.getProvider());
		Assert.assertEquals("internal",up.getProvider().value());
		Assert.assertEquals(IdentityProviderType.INTERNAL,IdentityProviderType.valueOf("INTERNAL"));
	}

	private void assertPrincipal(AuthenticatedPrincipal p) {
		Assert.assertEquals("name",p.getName());
		Assert.assertEquals("firstName LASTNAME",p.getFullName());
		Assert.assertEquals(Locale.ENGLISH,p.getLocale());
		Assert.assertEquals("social",p.getSocialIdentifier());
		Assert.assertEquals("email",p.getEmail());
		
		Assert.assertEquals("Europe/Helsinki",p.getZoneId().toString());
		Assert.assertEquals("firstName",p.getFirstName());
		Assert.assertEquals("lastName",p.getLastName());
		Assert.assertEquals("1",p.getUniqueIdentifier().toString());
		Assert.assertEquals(Boolean.TRUE,p.isPersisted());
		
		Assert.assertEquals(IdentityProviderType.INTERNAL,p.getProvider());
	}
	
	class PrincipalBuilder extends AuthenticatedPrincipalBuilder {
		public PrincipalBuilder() {
			getEntity().setSocialIdentifier("social");
		}
		
		@Override
		protected AuthenticatedPrincipalBuilder uniqueIdentifier() {
			getEntity().setUniqueIdentifier( 1L);
			return this;
		}

		@Override
		protected AuthenticatedPrincipalBuilder remoteAddress() {
			getEntity().setRemoteAddress("127.0.0.1");
			return this;
		}

		@Override
		protected AuthenticatedPrincipalBuilder provider() {
			getEntity().setProvider(IdentityProviderType.INTERNAL);
			return this;
		}

		@Override
		protected AuthenticatedPrincipalBuilder locale() {
			getEntity().setLocale(Locale.ENGLISH);
			return this;
		}

		@Override
		protected AuthenticatedPrincipalBuilder lastLoginDate() {
			getEntity().setLastLoginDate(IsoDateUtil.get().parse("2013-12-06T20:45:00+01:00"));
			return this;
		}

		@Override
		protected AuthenticatedPrincipalBuilder timeZone() {
			getEntity().setZoneId(ZoneId.of("Europe/Helsinki"));
			return this;
		}

		@Override
		protected AuthenticatedPrincipalBuilder firstName() {
			getEntity().setFirstName("firstName");
			return this;
		}

		@Override
		protected AuthenticatedPrincipalBuilder lastName() {
			getEntity().setLastName("lastName");
			return this;
		}

		@Override
		protected AuthenticatedPrincipalBuilder email() {
			getEntity().setEmail("email");
			return this;
		}

		@Override
		protected AuthenticatedPrincipalBuilder name() {
			getEntity().setName("name");
			return this;
		}
		
	}
}
