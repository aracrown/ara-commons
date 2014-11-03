package org.aracrown.commons.mail;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * The qualifier to define template directory for emails
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 *
 */
@Target({ TYPE, METHOD, FIELD })
@Retention(RUNTIME)
public @interface TemplateDirectory {

}
