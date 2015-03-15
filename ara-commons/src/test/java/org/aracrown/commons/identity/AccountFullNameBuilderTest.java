package org.aracrown.commons.identity;

import org.junit.Assert;
import org.junit.Test;

public class AccountFullNameBuilderTest {
	@Test
	public void testDefault() {
		AccountFullNameBuilder builder = new AccountFullNameBuilder(null, null);
		Assert.assertEquals("", builder.build());
		Assert.assertEquals("", builder.buildForUsername());
		Assert.assertEquals("default name", builder.build(" default name "));
		Assert.assertEquals("", builder.build(null));
		Assert.assertEquals("", builder.build(""));
		Assert.assertEquals("", builder.build(" "));
	}
	
	@Test
	public void testFirstNameOnly() {
		AccountFullNameBuilder builder = new AccountFullNameBuilder("test", null);
		Assert.assertEquals("test", builder.build());
		Assert.assertEquals("test", builder.buildForUsername());
		Assert.assertEquals("test", builder.build(" default name "));
	}
	
	@Test
	public void testLastNameOnly() {
		AccountFullNameBuilder builder = new AccountFullNameBuilder(null, "test");
		Assert.assertEquals("TEST", builder.build());
		Assert.assertEquals("test", builder.buildForUsername());
		Assert.assertEquals("TEST", builder.build(" default name "));
	}
	
	@Test
	public void testLastFirstName() {
		AccountFullNameBuilder builder = new AccountFullNameBuilder("first", "last");
		Assert.assertEquals("first LAST", builder.build());
		Assert.assertEquals("first.last", builder.buildForUsername());
		Assert.assertEquals("first LAST", builder.build(" default name "));
	}
	
	@Test
	public void testLastFirstNameDot() {
		AccountFullNameBuilder builder = new AccountFullNameBuilder("first", "la_st...");
		Assert.assertEquals("first LA_ST", builder.build());
		Assert.assertEquals("first.la_st", builder.buildForUsername());
		Assert.assertEquals("first LA_ST", builder.build(" default name "));
	}
}
