package org.aracrown.commons.liquibase.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


/**
 * The qualifier to define liquibase persistence context. 
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 *
 */
@Target({ TYPE, METHOD, FIELD })
@Retention(RUNTIME) 
public @interface LiquibasePersistenceContext {

}
