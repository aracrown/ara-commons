package org.aracrown.commons.util;

import org.junit.Assert;
import org.junit.Test;

public class PasswordEncoderTest {
	@Test
	public void testDefault() {
		Assert.assertEquals("f67b9839f481600e23353e10d7f9111b4dd6803befa5a9186d59ffd2b2592dfb5abb319c64e57108fad9b75ecbdc19273f91601fa0bf0b90dd49e5893d51ee97", new PasswordEncoder().encodePassword("test", "test", 1));
	}
}
