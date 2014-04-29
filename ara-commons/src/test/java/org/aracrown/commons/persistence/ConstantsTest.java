package org.aracrown.commons.persistence;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Throwables;

public class ConstantsTest {
	@Test
	public void testConstants() {
		Assert.assertEquals(3, Constants.DEFAULT_CODE_STRING_LENGTH);
		Assert.assertEquals(50, Constants.DEFAULT_MAX_QUERY_STRING_LENGTH);
		Assert.assertEquals(255, Constants.DEFAULT_MAX_STRING_LENGTH);
		Assert.assertEquals(2, Constants.DEFAULT_MIN_QUERY_STRING_LENGTH);
		Assert.assertEquals(2, Constants.DEFAULT_MIN_STRING_LENGTH);
		Assert.assertEquals(1900, Constants.DEFAULT_MIN_YEAR_START);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testConstructor() throws Throwable {
		Constructor<Constants> c = Constants.class.getDeclaredConstructor();
		c.setAccessible(true);
		try {
			c.newInstance(); 
		} catch (InvocationTargetException e) {
			throw Throwables.getRootCause(e);
		}
	}
}
