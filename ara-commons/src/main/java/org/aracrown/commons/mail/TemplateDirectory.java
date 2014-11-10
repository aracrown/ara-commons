package org.aracrown.commons.mail;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * The qualifier to define template directory for emails
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 *
 */
@Qualifier
@Target({ TYPE, METHOD, FIELD,PARAMETER })
@Retention(RUNTIME)
public @interface TemplateDirectory {

}
