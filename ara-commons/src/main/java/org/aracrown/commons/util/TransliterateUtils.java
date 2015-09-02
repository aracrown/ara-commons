package org.aracrown.commons.util;

import org.apache.commons.codec.language.Metaphone;

import com.google.common.base.Strings;

/**
 * Simple transliteration utility class
 * 
 * @author vytautas r.
 */
public class TransliterateUtils {
	private static final String[] charsTransliterateFrom = new String[] { "Ą", "Č", "Ę", "Ė", "Į", "Š", "Ų", "Ū", "Ž", "ą", "č", "ę", "ė", "į", "š",
			"ų", "ū", "ž", "А", "а", "Б", "б", "В", "в", "Г", "г", "Д", "д", "Е", "е", "Ё", "ё", "Ж", "ж", "З", "з", "И", "и", "Й", "й", "К", "к",
			"Л", "л", "М", "м", "Н", "н", "О", "о", "П", "п", "Р", "р", "С", "с", "Т", "т", "У", "у", "Ф", "ф", "Х", "х", "Ц", "ц", "Ч", "ч", "Ш",
			"ш", "Щ", "щ", "Ъ", "ъ", "Ы", "ы", "Ь", "ь", "Э", "э", "Ю", "ю", "Я", "я" };
	private static final String[] charsTransliterateTo = new String[] { "A", "C", "E", "E", "I", "S", "U", "U", "Z", "a", "c", "e", "e", "i", "s",
			"u", "u", "z", "A", "a", "B", "b", "V", "v", "G", "g", "D", "d", "E", "e", "Yo", "yo", "Zh", "zh", "Z", "z", "I", "i", "J", "j", "K",
			"k", "L", "l", "M", "m", "N", "n", "O", "o", "P", "p", "R", "r", "S", "s", "T", "t", "U", "u", "F", "f", "H", "h", "Ts", "ts", "Ch",
			"ch", "Sh", "sh", "Sch", "sch", "'", "'", "I", "i", "'", "'", "E", "e", "Yu", "yu", "Ya", "ya" };

	/**
	 * Transliterates provided value by simple mapping rules
	 * 
	 * @param value
	 *            string parameter to transliterate
	 * @return transliterated string representation
	 */
	public static String transliterate(String value) {
		for (int i = 0; i < charsTransliterateFrom.length; i++) {
			value = value.replace(charsTransliterateFrom[i], charsTransliterateTo[i]);
		}
		return value;
	}

	/**
	 * Transforms value into fuzzy result
	 * 
	 * @param value
	 *            string parameter to transform into fuzzy result
	 * @return fuzzy string representation of provided string
	 */
	public static String fuzzyCustom(String value) {
		if (Strings.isNullOrEmpty(value)) {
			return null;
		}
		String result = value.toUpperCase().replaceAll("[AEYWYIOU]", DelimiterEnum.EMPTY.value());
		if (Strings.isNullOrEmpty(result)) {
			result = value;
		}
		return result.replaceAll("%", DelimiterEnum.EMPTY.value());
	}

	/**
	 * Uses Apache library to transform into fuzzy result by default
	 * 
	 * @param value
	 * @return fuzzy string
	 */
	public static String fuzzy(String value) {
		return fuzzyExternal(value);
	}

	/**
	 * Uses Apache commons library to transform provided string into fuzzy result
	 * 
	 * @param value
	 * @return fuzzy string
	 */
	public static String fuzzyExternal(String value) {
		if (Strings.isNullOrEmpty(value)) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		String[] items = transliterate(value).split(DelimiterEnum.SPACE.value());
		for (String item : items) {
			result.append(new Metaphone().metaphone(item));
		}
		if (result.length() == 0) {
			result.append(value);
		}
		return result.toString().replaceAll("%", DelimiterEnum.EMPTY.value());
	}

	/**
	 * Strip html tags
	 * 
	 * @param input
	 *            string to remove html parameters from
	 * @return string without html tags
	 */
	public static String textNoHtml(String input) {
		if (Strings.isNullOrEmpty(input)) {
			return null;
		}
		return input.replaceAll("\\<[\\s]*tag[^>]*>", DelimiterEnum.EMPTY.value());
	}

	/**
	 * Transliterates provided value and adds original one
	 * <p>
	 * Returns initial value if it cannot be transliterated
	 * <p>
	 * Result: Original_value {(Transliterated_Value)} {[additional information]}
	 * 
	 * @param value
	 *            provided string to transliterate
	 * @param additionalText
	 *            additional text to add to end of transliterated value
	 * @return transliterated representation of provided value
	 */
	public static String transliterateAndJoin(String value, Long additionalText) {
		String transliterated = transliterate(value);
		StringBuilder sb = new StringBuilder(transliterated);
		if (!value.equals(transliterated)) {
			sb.append(" (");
			sb.append(value);
			sb.append(')');
		}
		if (additionalText != null) {
			sb.append(" [");
			sb.append(additionalText);
			sb.append(']');
		}
		return sb.toString();
	}
}
