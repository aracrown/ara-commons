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
package org.aracrown.commons.rest;

import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.PojoValidator;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.NoNestedClassRule;
import com.openpojo.validation.rule.impl.NoPrimitivesRule;
import com.openpojo.validation.rule.impl.NoPublicFieldsExceptStaticFinalRule;
import com.openpojo.validation.rule.impl.NoPublicFieldsRule;
import com.openpojo.validation.rule.impl.NoStaticExceptFinalRule;
import com.openpojo.validation.rule.impl.SerializableMustHaveSerialVersionUIDRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public abstract class AbstractSinglePojoClassTest {
	@Test
	public void testPojo() {
		PojoValidator pojoValidator = new PojoValidator();

		// Create Rules to validate structure for POJO_PACKAGE
		pojoValidator.addRule(new NoPublicFieldsRule());
		pojoValidator.addRule(new NoPrimitivesRule());
		pojoValidator.addRule(new NoStaticExceptFinalRule());
		pojoValidator.addRule(new GetterMustExistRule());
		pojoValidator.addRule(new SetterMustExistRule());
		pojoValidator.addRule(new NoNestedClassRule());
		pojoValidator.addRule(new NoPublicFieldsExceptStaticFinalRule());
		pojoValidator.addRule(new NoStaticExceptFinalRule());
		pojoValidator.addRule(new SerializableMustHaveSerialVersionUIDRule());

		// Create Testers to validate behaviour for POJO_PACKAGE
		pojoValidator.addTester(new SetterTester());
		pojoValidator.addTester(new GetterTester());
		PojoClass pojoClass = PojoClassFactory.getPojoClass(getPojoClass());
		pojoValidator.runValidation(pojoClass);
	}

	protected abstract Class<?> getPojoClass() ;
}
