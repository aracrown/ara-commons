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
package org.aracrown.commons.bean;

import javax.naming.Context;

import org.aracrown.commons.date.IsoDateUtil;
import org.aracrown.commons.util.TestItem;
import org.junit.Assert;
import org.junit.Test;

public class BeanResolverTest {

	@Test
	public void testResolver() {
		System.setProperty(Context.INITIAL_CONTEXT_FACTORY, MyInitialContextFactory.class.getName());
		System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
		try (BeanResolver<TestItem> bean = new BeanResolver<>(TestItem.class)) {
			TestItem test = bean.getBean();
			test = bean.getBean();

			Assert.assertNotNull(test);
		} catch (BeanResolveException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = BeanResolveException.class)
	public void testResolver1() throws BeanResolveException {
		try (BeanResolver<TestItem> bean = new BeanResolver<>(TestItem.class)) {
			bean.getBean();
		}
	}

	@Test(expected = BeanResolveException.class)
	public void testResolver2() throws BeanResolveException {
		System.setProperty(Context.INITIAL_CONTEXT_FACTORY, MyInitialContextFactory2.class.getName());
		System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
		try (BeanResolver<IsoDateUtil> bean = new BeanResolver<>(IsoDateUtil.class)) {
			bean.getBean();
		}
	}
}
