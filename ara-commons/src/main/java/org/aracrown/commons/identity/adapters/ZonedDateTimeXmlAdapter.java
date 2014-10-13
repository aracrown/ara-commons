package org.aracrown.commons.identity.adapters;

import java.time.ZonedDateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.aracrown.commons.date.IsoDateUtil;

/**
 * Custom xml adapter for java 8 {@link ZonedDateTime} marshalling, unmarshalling.
 * 
 * @author vicento.ramos
 *
 */
public class ZonedDateTimeXmlAdapter extends XmlAdapter<String, ZonedDateTime>{

	@Override
	public ZonedDateTime unmarshal(String v) throws Exception {
		return IsoDateUtil.get().parse(v);
	}

	@Override
	public String marshal(ZonedDateTime v) throws Exception {
		return IsoDateUtil.get().format(v);
	}
}
