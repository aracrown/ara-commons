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
package org.aracrown.commons.util;

import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;

/**
 * Static utility methods for handling exceptions.
 *
 * @author vicento.ramos
 * @since 1.0.0
 */
public final class Exceptions {
	/**
	 * The singleton instance.
	 */
	private static Exceptions instance;

	private Exceptions() {
	}

	/**
	 * The static getter of singleton instance.
	 *
	 * @return static instance of <i>Exceptions</i>
	 */
	public static Exceptions get() {
		if (instance == null) {
			instance = new Exceptions();
		}
		return instance;
	}

	/**
	 * Checks {@code throwable} for a cause of type {@code class1}. Throws new
	 * exception if found.
	 *
	 * @param throwable
	 *            exception to check for cause type
	 * @param class1
	 *            cause type to check
	 * @param replacedThrowable
	 *            new custom exception to throw if cause type was found
	 * @param <X>
	 *            exception type to search for
	 * @param <Y>
	 *            exception type to be re-thrown
	 * @throws Y
	 *             exception thrown if cause type was found in chain
	 */
	public <X extends Throwable, Y extends Throwable> void throwNewIfContains(Throwable throwable, Class<X> class1, Y replacedThrowable) throws Y {
		Iterable<X> i = Iterables.filter(Throwables.getCausalChain(throwable), class1);
		// Do not expect null here.
		if (i.iterator().hasNext()) {
			throw replacedThrowable;
		}
	}

	/**
	 * Checks {@code throwable} for a cause of type {@code class1}.
	 *
	 * @param throwable
	 *            exception to check for cause type
	 * @param class1
	 *            cause type to check
	 * @param <X>
	 *            exception type to search for
	 * @return true if throwable contains requested exception
	 */
	public <X extends Throwable> boolean contains(Throwable throwable, Class<X> class1) {
		Iterable<X> i = Iterables.filter(Throwables.getCausalChain(throwable), class1);
		// Do not expect null here.
		if (i.iterator().hasNext()) {
			return true;
		}
		return false;
	}

	/**
	 * Checks {@code throwable} for a cause of type {@code class1}. Throws cause
	 * exception if found.
	 *
	 * @param throwable
	 *            exception to check for cause type
	 * @param class1
	 *            cause type to check
	 * @param <X>
	 *            exception type to be re-thrown
	 * @throws X
	 *             exception thrown if cause type was found in chain
	 */
	public <X extends Throwable> void propagate(Throwable throwable, Class<X> class1) throws X {
		Iterable<X> i = Iterables.filter(Throwables.getCausalChain(throwable), class1);
		// Do not expect null here.
		if (i.iterator().hasNext()) {
			throw i.iterator().next();
		}
	}
}
