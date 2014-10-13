package org.aracrown.commons.identity.adapters;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Custom xml adapter for java 8 {@link ZonedDateTime} marshalling, unmarshalling.
 * 
 * @author vicento.ramos
 *
 */
public class ZoneIdXmlAdapter extends XmlAdapter<String, ZoneId>{

	@Override
	public ZoneId unmarshal(String zoneId) throws Exception {
		return ZoneId.of(zoneId);
	}

	@Override
	public String marshal(ZoneId v) throws Exception {
		return v.getId();
	}
}
