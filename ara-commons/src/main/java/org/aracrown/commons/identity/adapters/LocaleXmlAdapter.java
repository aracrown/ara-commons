package org.aracrown.commons.identity.adapters;

import java.time.ZonedDateTime;
import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.LocaleUtils;

/**
 * Custom xml adapter for java 8 {@link ZonedDateTime} marshalling, unmarshalling.
 * 
 * @author vicento.ramos
 *
 */
public class LocaleXmlAdapter extends XmlAdapter<String, Locale>{

	@Override
	public Locale unmarshal(String v) throws Exception {
		return LocaleUtils.toLocale(v);
	}

	@Override
	public String marshal(Locale v) throws Exception {
		return v.toString();
	}
}
