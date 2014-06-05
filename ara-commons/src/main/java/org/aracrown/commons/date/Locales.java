package org.aracrown.commons.date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import com.google.common.base.Strings;

/**
 * Sorted list of available locales.
 * 
 * @author vicento.ramos
 *
 */
public class Locales {
	private static final List<Locale> LOCALE_LIST = new ArrayList<Locale>();
	
	static {
		Locale locales[] = SimpleDateFormat.getAvailableLocales();
		for (int i = 0; i < locales.length; i++) {
			if (!Strings.isNullOrEmpty(locales[i].getCountry())) {
				LOCALE_LIST.add(locales[i]);
			}
		}
		Comparator<Locale> comparator = new Comparator<Locale>() {

			@Override
			public int compare(Locale o1, Locale o2) {
				return o1.getDisplayName().compareTo(o2.getDisplayName());
			}
		};

		Collections.sort(LOCALE_LIST, comparator);
	}
	
	public static List<Locale> getAvailableLocales() {
		return new ArrayList<>(LOCALE_LIST);
	}
}
