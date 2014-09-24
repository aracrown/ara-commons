package org.aracrown.commons.ui;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Iterator;

public class DataProviderTest {
	@org.junit.Test
	public void testDefault() throws Exception {
		DataProvider<TestObj> provider = new DataProvider<TestObj>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public long size() {
				return 0;
			}

			@Override
			public Iterator<TestObj> iterator(long first, long count) {
				return new ArrayList<TestObj>().iterator();
			}
		};
		provider.detach();
		Assert.assertNotNull(provider);
		Assert.assertNotNull(provider.model(new TestObj("test")));
	}

	class TestObj {
		private String name;

		public TestObj() {

		}

		public TestObj(String name) {
			this.name = name;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

	}
}
