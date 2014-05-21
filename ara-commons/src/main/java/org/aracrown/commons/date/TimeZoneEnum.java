package org.aracrown.commons.date;

/**
 * Customized time zone.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 *
 */
public enum TimeZoneEnum {
	GMTM1200_INTERNATIONALDATELINEWEST("GMT-12:00", "(GMT-12:00) International Date Line West"),
	GMTM1100_MIDWAYISLAND_SAMOA("GMT-11:00", "(GMT-11:00) Midway Island, Samoa"),
	GMTM1000_HAWAII("GMT-10:00", "(GMT-10:00) Hawaii"),
	GMTM0900_ALASKA("GMT-09:00", "(GMT-09:00) Alaska"),
	GMTM0800_PACIFICTIME_US_CANADA("GMT-08:00", "(GMT-08:00) Pacific Time (US & Canada)"),
	GMTM0800_TIJUANA_BAJACALIFORNIA("GMT-08:00", "(GMT-08:00) Tijuana, Baja California"),
	GMTM0700_ARIZONA("GMT-07:00", "(GMT-07:00) Arizona"),
	GMTM0700_CHIHUAHUA_LAPAZ_MAZATLAN("GMT-07:00", "(GMT-07:00) Chihuahua, La Paz, Mazatlan"),
	GMTM0700_MOUNTAINTIME_US_CANADA("GMT-07:00", "(GMT-07:00) Mountain Time (US & Canada)"),
	GMTM0600_CENTRALAMERICA("GMT-06:00", "(GMT-06:00) Central America"),
	GMTM0600_CENTRALTIME_US_CANADA("GMT-06:00", "(GMT-06:00) Central Time (US & Canada)"),
	GMTM0600_GUADALAJARA_MEXICOCITY_MONTERREY("GMT-06:00", "(GMT-06:00) Guadalajara, Mexico City, Monterrey"),
	GMTM0600_SASKATCHEWAN("GMT-06:00", "(GMT-06:00) Saskatchewan"),
	GMTM0500_BOGOTA_LIMA_QUITO_RIOBRANCO("GMT-05:00", "(GMT-05:00) Bogota, Lima, Quito, Rio Branco"),
	GMTM0500_EASTERNTIME_US_CANADA("GMT-05:00", "(GMT-05:00) Eastern Time (US & Canada)"),
	GMTM0500_INDIANA_EAST("GMT-05:00", "(GMT-05:00) Indiana (East)"),
	GMTM0400_ATLANTICTIME_CANADA("GMT-04:00", "(GMT-04:00) Atlantic Time (Canada)"),
	GMTM0400_CARACAS_LAPAZ("GMT-04:00", "(GMT-04:00) Caracas, La Paz"),
	GMTM0400_MANAUS("GMT-04:00", "(GMT-04:00) Manaus"),
	GMTM0400_SANTIAGO("GMT-04:00", "(GMT-04:00) Santiago"),
	GMTM0330_NEWFOUNDLAND("GMT-03:30", "(GMT-03:30) Newfoundland"),
	GMTM0300_BRASILIA("GMT-03:00", "(GMT-03:00) Brasilia"),
	GMTM0300_BUENOSAIRES_GEORGETOWN("GMT-03:00", "(GMT-03:00) Buenos Aires, Georgetown"),
	GMTM0300_GREENLAND("GMT-03:00", "(GMT-03:00) Greenland"),
	GMTM0300_MONTEVIDEO("GMT-03:00", "(GMT-03:00) Montevideo"),
	GMTM0200_MID_ATLANTIC("GMT-02:00", "(GMT-02:00) Mid-Atlantic"),
	GMTM0100_CAPEVERDEIS("GMT-01:00", "(GMT-01:00) Cape Verde Is."),
	GMTM0100_AZORES("GMT-01:00", "(GMT-01:00) Azores"),
	GMTP0000_CASABLANCA_MONROVIA_REYKJAVIK("GMT+00:00", "(GMT+00:00) Casablanca, Monrovia, Reykjavik"),
	GMTP0000_GREENWICHMEANTIME_DUBLIN_EDINBURGH_LISBON_LONDON("GMT+00:00", "(GMT+00:00) Greenwich Mean Time : Dublin, Edinburgh, Lisbon, London"),
	GMTP0100_AMSTERDAM_BERLIN_BERN_ROME_STOCKHOLM_VIENNA("GMT+01:00", "(GMT+01:00) Amsterdam, Berlin, Bern, Rome, Stockholm, Vienna"),
	GMTP0100_BELGRADE_BRATISLAVA_BUDAPEST_LJUBLJANA_PRAGUE("GMT+01:00", "(GMT+01:00) Belgrade, Bratislava, Budapest, Ljubljana, Prague"),
	GMTP0100_BRUSSELS_COPENHAGEN_MADRID_PARIS("GMT+01:00", "(GMT+01:00) Brussels, Copenhagen, Madrid, Paris"),
	GMTP0100_SARAJEVO_SKOPJE_WARSAW_ZAGREB("GMT+01:00", "(GMT+01:00) Sarajevo, Skopje, Warsaw, Zagreb"),
	GMTP0100_WESTCENTRALAFRICA("GMT+01:00", "(GMT+01:00) West Central Africa"),
	GMTP0200_AMMAN("GMT+02:00", "(GMT+02:00) Amman"),
	GMTP0200_ATHENS_BUCHAREST_ISTANBUL("GMT+02:00", "(GMT+02:00) Athens, Bucharest, Istanbul"),
	GMTP0200_BEIRUT("GMT+02:00", "(GMT+02:00) Beirut"),
	GMTP0200_CAIRO("GMT+02:00", "(GMT+02:00) Cairo"),
	GMTP0200_HARARE_PRETORIA("GMT+02:00", "(GMT+02:00) Harare, Pretoria"),
	GMTP0200_HELSINKI_KYIV_RIGA_SOFIA_TALLINN_VILNIUS("GMT+02:00", "(GMT+02:00) Helsinki, Kyiv, Riga, Sofia, Tallinn, Vilnius"),
	GMTP0200_JERUSALEM("GMT+02:00", "(GMT+02:00) Jerusalem"),
	GMTP0200_MINSK("GMT+02:00", "(GMT+02:00) Minsk"),
	GMTP0200_WINDHOEK("GMT+02:00", "(GMT+02:00) Windhoek"),
	GMTP0300_KUWAIT_RIYADH_BAGHDAD("GMT+03:00", "(GMT+03:00) Kuwait, Riyadh, Baghdad"),
	GMTP0300_MOSCOW_STPETERSBURG_VOLGOGRAD("GMT+03:00", "(GMT+03:00) Moscow, St. Petersburg, Volgograd"),
	GMTP0300_NAIROBI("GMT+03:00", "(GMT+03:00) Nairobi"),
	GMTP0300_TBILISI("GMT+03:00", "(GMT+03:00) Tbilisi"),
	GMTP0330_TEHRAN("GMT+03:30", "(GMT+03:30) Tehran"),
	GMTP0400_ABUDHABI_MUSCAT("GMT+04:00", "(GMT+04:00) Abu Dhabi, Muscat"),
	GMTP0400_BAKU("GMT+04:00", "(GMT+04:00) Baku"),
	GMTP0400_YEREVAN("GMT+04:00", "(GMT+04:00) Yerevan"),
	GMTP0430_KABUL("GMT+04:30", "(GMT+04:30) Kabul"),
	GMTP0500_YEKATERINBURG("GMT+05:00", "(GMT+05:00) Yekaterinburg"),
	GMTP0500_ISLAMABAD_KARACHI_TASHKENT("GMT+05:00", "(GMT+05:00) Islamabad, Karachi, Tashkent"),
	GMTP0530_SRIJAYAWARDENAPURA("GMT+05:30", "(GMT+05:30) Sri Jayawardenapura"),
	GMTP0530_CHENNAI_KOLKATA_MUMBAI_NEWDELHI("GMT+05:30", "(GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi"),
	GMTP0545_KATHMANDU("GMT+05:45", "(GMT+05:45) Kathmandu"),
	GMTP0600_ALMATY_NOVOSIBIRSK("GMT+06:00", "(GMT+06:00) Almaty, Novosibirsk"),
	GMTP0600_ASTANA_DHAKA("GMT+06:00", "(GMT+06:00) Astana, Dhaka"),
	GMTP0630_YANGON_RANGOON("GMT+06:30", "(GMT+06:30) Yangon (Rangoon)"),
	GMTP0700_BANGKOK_HANOI_JAKARTA("GMT+07:00", "(GMT+07:00) Bangkok, Hanoi, Jakarta"),
	GMTP0700_KRASNOYARSK("GMT+07:00", "(GMT+07:00) Krasnoyarsk"),
	GMTP0800_BEIJING_CHONGQING_HONGKONG_URUMQI("GMT+08:00", "(GMT+08:00) Beijing, Chongqing, Hong Kong, Urumqi"),
	GMTP0800_KUALALUMPUR_SINGAPORE("GMT+08:00", "(GMT+08:00) Kuala Lumpur, Singapore"),
	GMTP0800_IRKUTSK_ULAANBATAAR("GMT+08:00", "(GMT+08:00) Irkutsk, Ulaan Bataar"),
	GMTP0800_PERTH("GMT+08:00", "(GMT+08:00) Perth"),
	GMTP0800_TAIPEI("GMT+08:00", "(GMT+08:00) Taipei"),
	GMTP0900_OSAKA_SAPPORO_TOKYO("GMT+09:00", "(GMT+09:00) Osaka, Sapporo, Tokyo"),
	GMTP0900_SEOUL("GMT+09:00", "(GMT+09:00) Seoul"),
	GMTP0900_YAKUTSK("GMT+09:00", "(GMT+09:00) Yakutsk"),
	GMTP0930_ADELAIDE("GMT+09:30", "(GMT+09:30) Adelaide"),
	GMTP0930_DARWIN("GMT+09:30", "(GMT+09:30) Darwin"),
	GMTP1000_BRISBANE("GMT+10:00", "(GMT+10:00) Brisbane"),
	GMTP1000_CANBERRA_MELBOURNE_SYDNEY("GMT+10:00", "(GMT+10:00) Canberra, Melbourne, Sydney"),
	GMTP1000_HOBART("GMT+10:00", "(GMT+10:00) Hobart"),
	GMTP1000_GUAM_PORTMORESBY("GMT+10:00", "(GMT+10:00) Guam, Port Moresby"),
	GMTP1000_VLADIVOSTOK("GMT+10:00", "(GMT+10:00) Vladivostok"),
	GMTP1100_MAGADAN_SOLOMONIS_NEWCALEDONIA("GMT+11:00", "(GMT+11:00) Magadan, Solomon Is., New Caledonia"),
	GMTP1200_AUCKLAND_WELLINGTON("GMT+12:00", "(GMT+12:00) Auckland, Wellington"),
	GMTP1200_FIJI_KAMCHATKA_MARSHALLIS("GMT+12:00", "(GMT+12:00) Fiji, Kamchatka, Marshall Is."),
	GMTP1300_NUKUALOFA("GMT+13:00", "(GMT+13:00) Nuku'alofa");

	/** GMT key for time zone. */
	private final String gmt;
	
	/** Display name of the time zone. */
	private final String name;
	
	TimeZoneEnum(String gmt, String name) {
		this.gmt = gmt;
		this.name = name;
	}
	
	public String getGmt() {
		return gmt;
	}
	
	public String getName() {
		return name;
	}
}
