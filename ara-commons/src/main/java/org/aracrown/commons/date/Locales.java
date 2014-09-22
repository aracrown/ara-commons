package org.aracrown.commons.date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
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
	private static final List<Locale> LOCALE_LIST = new ArrayList<>();

	static {
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		for (Locale locale : locales) {
			if (!Strings.isNullOrEmpty(locale.getCountry())) {
				LOCALE_LIST.add(locale);
			}
		}

		Collections.sort(LOCALE_LIST, (o1, o2) -> o1.getDisplayName().compareTo(o2.getDisplayName()));
	}

	private static Locales INSTANCE;

	private Locales() {
	}

	public static Locales get() {
		if (INSTANCE == null) {
			INSTANCE = new Locales();
		}
		return INSTANCE;
	}

	public List<Locale> getAvailableLocales() {
		return new ArrayList<>(LOCALE_LIST);
	}
}
