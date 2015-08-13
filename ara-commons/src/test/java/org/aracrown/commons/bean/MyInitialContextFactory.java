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

import java.util.Hashtable;
import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;

import org.aracrown.commons.util.TestItem;
import org.mockito.Mockito;

public class MyInitialContextFactory implements InitialContextFactory {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
		Context context = Mockito.mock(Context.class);
		BeanManager bm = Mockito.mock(BeanManager.class);
		Mockito.when(context.lookup("java:comp/BeanManager")).thenReturn(bm);
		Set<Bean<?>> beans = Mockito.mock(Set.class);
		Mockito.when(bm.getBeans(Mockito.any(java.lang.reflect.Type.class))).thenReturn(beans);

		Bean value = Mockito.mock(Bean.class);
		Mockito.when(bm.resolve(beans)).thenReturn(value);

		Mockito.when(value.create(Mockito.any(CreationalContext.class))).thenReturn(new TestItem());

		CreationalContext cc = Mockito.mock(CreationalContext.class);
		Mockito.when(bm.createCreationalContext(null)).thenReturn(cc);
		return context;
	}

}
