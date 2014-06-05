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
	GMTM1100_PACIFIC_MIDWAY("GMT-11:00", "(GMT-11:00) Pacific/Midway, Niue, Pago_Pago, Samoa", "Pacific/Midway",false),
	GMTM1100_US_SAMOA("GMT-11:00", "(GMT-11:00) US/Samoa", "US/Samoa",false),
	GMTM1000_AMERICA_ADAK("GMT-10:00", "(GMT-10:00/DST) America/Adak, Atka", "America/Adak",true),
	GMTM1000_PACIFIC_HONOLULU("GMT-10:00", "(GMT-10:00) Pacific/Honolulu, Johnston, Rarotonga, Tahiti", "Pacific/Honolulu",false),
	GMTM1000_US_HAWAII("GMT-10:00", "(GMT-10:00) US/Hawaii", "US/Hawaii",false),
	GMTM1000_US_ALEUTIAN("GMT-10:00", "(GMT-10:00/DST) US/Aleutian", "US/Aleutian",true),
	GMTM0930_PACIFIC_MARQUESAS("GMT-09:30", "(GMT-09:30) Pacific/Marquesas", "Pacific/Marquesas",false),
	GMTM0900_AMERICA_ANCHORAGE("GMT-09:00", "(GMT-09:00/DST) America/Anchorage, Juneau, Nome, Sitka, Yakutat", "America/Anchorage",true),
	GMTM0900_PACIFIC_GAMBIER("GMT-09:00", "(GMT-09:00) Pacific/Gambier", "Pacific/Gambier",false),
	GMTM0900_US_ALASKA("GMT-09:00", "(GMT-09:00/DST) US/Alaska", "US/Alaska",true),
	GMTM0800_AMERICA_METLAKATLA("GMT-08:00", "(GMT-08:00) America/Metlakatla", "America/Metlakatla",false),
	GMTM0800_AMERICA_DAWSON("GMT-08:00", "(GMT-08:00/DST) America/Dawson, Ensenada, Los_Angeles, Santa_Isabel, Tijuana, Vancouver", "America/Dawson",true),
	GMTM0800_AMERICA_WHITEHORSE("GMT-08:00", "(GMT-08:00/DST) America/Whitehorse", "America/Whitehorse",true),
	GMTM0800_CANADA_PACIFIC("GMT-08:00", "(GMT-08:00/DST) Canada/Pacific, Yukon", "Canada/Pacific",true),
	GMTM0800_MEXICO_BAJANORTE("GMT-08:00", "(GMT-08:00/DST) Mexico/BajaNorte", "Mexico/BajaNorte",true),
	GMTM0800_PACIFIC_PITCAIRN("GMT-08:00", "(GMT-08:00) Pacific/Pitcairn", "Pacific/Pitcairn",false),
	GMTM0800_US_PACIFIC("GMT-08:00", "(GMT-08:00/DST) US/Pacific, Pacific-New", "US/Pacific",true),
	GMTM0700_AMERICA_CRESTON("GMT-07:00", "(GMT-07:00) America/Creston, Dawson_Creek, Hermosillo, Phoenix", "America/Creston",false),
	GMTM0700_AMERICA_BOISE("GMT-07:00", "(GMT-07:00/DST) America/Boise, Cambridge_Bay, Chihuahua, Denver, Edmonton, Inuvik", "America/Boise",true),
	GMTM0700_AMERICA_MAZATLAN("GMT-07:00", "(GMT-07:00/DST) America/Mazatlan, Ojinaga, Shiprock, Yellowknife", "America/Mazatlan",true),
	GMTM0700_CANADA_MOUNTAIN("GMT-07:00", "(GMT-07:00/DST) Canada/Mountain", "Canada/Mountain",true),
	GMTM0700_MEXICO_BAJASUR("GMT-07:00", "(GMT-07:00/DST) Mexico/BajaSur", "Mexico/BajaSur",true),
	GMTM0700_US_ARIZONA("GMT-07:00", "(GMT-07:00) US/Arizona", "US/Arizona",false),
	GMTM0700_US_MOUNTAIN("GMT-07:00", "(GMT-07:00/DST) US/Mountain", "US/Mountain",true),
	GMTM0600_AMERICA_BELIZE("GMT-06:00", "(GMT-06:00) America/Belize, Costa_Rica, El_Salvador, Guatemala, Managua, Regina", "America/Belize",false),
	GMTM0600_AMERICA_SWIFT_CURRENT("GMT-06:00", "(GMT-06:00) America/Swift_Current, Tegucigalpa", "America/Swift_Current",false),
	GMTM0600_AMERICA_BAHIA_BANDERAS("GMT-06:00", "(GMT-06:00/DST) America/Bahia_Banderas, Cancun, Chicago, Knox_IN, Matamoros, Menominee", "America/Bahia_Banderas",true),
	GMTM0600_AMERICA_MERIDA("GMT-06:00", "(GMT-06:00/DST) America/Merida, Mexico_City, Monterrey, Rainy_River, Rankin_Inlet, Resolute", "America/Merida",true),
	GMTM0600_AMERICA_WINNIPEG("GMT-06:00", "(GMT-06:00/DST) America/Winnipeg", "America/Winnipeg",true),
	GMTM0600_AMERICA_INDIANA_KNOX("GMT-06:00", "(GMT-06:00/DST) America/Indiana/Knox, Tell_City", "America/Indiana/Knox",true),
	GMTM0600_AMERICA_NORTH_DAKOTA_BEULAH("GMT-06:00", "(GMT-06:00/DST) America/North_Dakota/Beulah, Center, New_Salem", "America/North_Dakota/Beulah",true),
	GMTM0600_CANADA_EAST_SASKATCHEWAN("GMT-06:00", "(GMT-06:00) Canada/East-Saskatchewan, Saskatchewan", "Canada/East-Saskatchewan",false),
	GMTM0600_CANADA_CENTRAL("GMT-06:00", "(GMT-06:00/DST) Canada/Central", "Canada/Central",true),
	GMTM0600_MEXICO_GENERAL("GMT-06:00", "(GMT-06:00/DST) Mexico/General", "Mexico/General",true),
	GMTM0600_PACIFIC_GALAPAGOS("GMT-06:00", "(GMT-06:00) Pacific/Galapagos", "Pacific/Galapagos",false),
	GMTM0600_US_CENTRAL("GMT-06:00", "(GMT-06:00/DST) US/Central, Indiana-Starke", "US/Central",true),
	GMTM0500_AMERICA_ATIKOKAN("GMT-05:00", "(GMT-05:00) America/Atikokan, Bogota, Cayman, Coral_Harbour, Eirunepe, Guayaquil", "America/Atikokan",false),
	GMTM0500_AMERICA_JAMAICA("GMT-05:00", "(GMT-05:00) America/Jamaica, Lima, Panama, Porto_Acre, Rio_Branco", "America/Jamaica",false),
	GMTM0500_AMERICA_DETROIT("GMT-05:00", "(GMT-05:00/DST) America/Detroit, Fort_Wayne, Grand_Turk, Havana, Indianapolis, Iqaluit", "America/Detroit",true),
	GMTM0500_AMERICA_LOUISVILLE("GMT-05:00", "(GMT-05:00/DST) America/Louisville, Montreal, Nassau, New_York, Nipigon, Pangnirtung", "America/Louisville",true),
	GMTM0500_AMERICA_PORT_AU_PRINCE("GMT-05:00", "(GMT-05:00/DST) America/Port-au-Prince, Thunder_Bay, Toronto", "America/Port-au-Prince",true),
	GMTM0500_AMERICA_INDIANA_INDIANAPOLIS("GMT-05:00", "(GMT-05:00/DST) America/Indiana/Indianapolis, Marengo, Petersburg, Vevay, Vincennes, Winamac", "America/Indiana/Indianapolis",true),
	GMTM0500_AMERICA_KENTUCKY_LOUISVILLE("GMT-05:00", "(GMT-05:00/DST) America/Kentucky/Louisville, Monticello", "America/Kentucky/Louisville",true),
	GMTM0500_BRAZIL_ACRE("GMT-05:00", "(GMT-05:00) Brazil/Acre", "Brazil/Acre",false),
	GMTM0500_CANADA_EASTERN("GMT-05:00", "(GMT-05:00/DST) Canada/Eastern", "Canada/Eastern",true),
	GMTM0500_CHILE_EASTERISLAND("GMT-05:00", "(GMT-05:00/DST) Chile/EasterIsland", "Chile/EasterIsland",true),
	GMTM0500_PACIFIC_EASTER("GMT-05:00", "(GMT-05:00/DST) Pacific/Easter", "Pacific/Easter",true),
	GMTM0500_US_EAST_INDIANA("GMT-05:00", "(GMT-05:00/DST) US/East-Indiana, Eastern, Michigan", "US/East-Indiana",true),
	GMTM0430_AMERICA_CARACAS("GMT-04:30", "(GMT-04:30) America/Caracas", "America/Caracas",false),
	GMTM0400_AMERICA_ANGUILLA("GMT-04:00", "(GMT-04:00) America/Anguilla, Antigua, Aruba, Barbados, Blanc-Sablon, Boa_Vista", "America/Anguilla",false),
	GMTM0400_AMERICA_CURACAO("GMT-04:00", "(GMT-04:00) America/Curacao, Dominica, Grenada, Guadeloupe, Guyana, Kralendijk", "America/Curacao",false),
	GMTM0400_AMERICA_LA_PAZ("GMT-04:00", "(GMT-04:00) America/La_Paz, Lower_Princes, Manaus, Marigot, Martinique, Montserrat", "America/La_Paz",false),
	GMTM0400_AMERICA_PORT_OF_SPAIN("GMT-04:00", "(GMT-04:00) America/Port_of_Spain, Porto_Velho, Puerto_Rico, Santo_Domingo, St_Barthelemy, St_Kitts", "America/Port_of_Spain",false),
	GMTM0400_AMERICA_ST_LUCIA("GMT-04:00", "(GMT-04:00) America/St_Lucia, St_Thomas, St_Vincent, Tortola, Virgin", "America/St_Lucia",false),
	GMTM0400_AMERICA_GLACE_BAY("GMT-04:00", "(GMT-04:00/DST) America/Glace_Bay, Goose_Bay, Halifax, Moncton, Thule", "America/Glace_Bay",true),
	GMTM0400_ATLANTIC_BERMUDA("GMT-04:00", "(GMT-04:00/DST) Atlantic/Bermuda", "Atlantic/Bermuda",true),
	GMTM0400_BRAZIL_WEST("GMT-04:00", "(GMT-04:00) Brazil/West", "Brazil/West",false),
	GMTM0400_CANADA_ATLANTIC("GMT-04:00", "(GMT-04:00/DST) Canada/Atlantic", "Canada/Atlantic",true),
	GMTM0330_AMERICA_ST_JOHNS("GMT-03:30", "(GMT-03:30/DST) America/St_Johns", "America/St_Johns",true),
	GMTM0330_CANADA_NEWFOUNDLAND("GMT-03:30", "(GMT-03:30/DST) Canada/Newfoundland", "Canada/Newfoundland",true),
	GMTM0300_AMERICA_ARAGUAINA("GMT-03:00", "(GMT-03:00) America/Araguaina, Bahia, Belem, Buenos_Aires, Catamarca, Cayenne", "America/Araguaina",false),
	GMTM0300_AMERICA_CORDOBA("GMT-03:00", "(GMT-03:00) America/Cordoba, Fortaleza, Jujuy, Maceio, Mendoza, Paramaribo", "America/Cordoba",false),
	GMTM0300_AMERICA_RECIFE("GMT-03:00", "(GMT-03:00) America/Recife, Rosario, Santarem", "America/Recife",false),
	GMTM0300_AMERICA_ASUNCION("GMT-03:00", "(GMT-03:00/DST) America/Asuncion, Campo_Grande, Cuiaba, Godthab, Miquelon, Santiago", "America/Asuncion",true),
	GMTM0300_AMERICA_ARGENTINA_BUENOS_AIRES("GMT-03:00", "(GMT-03:00) America/Argentina/Buenos_Aires, Catamarca, ComodRivadavia, Cordoba, Jujuy, La_Rioja", "America/Argentina/Buenos_Aires",false),
	GMTM0300_AMERICA_ARGENTINA_MENDOZA("GMT-03:00", "(GMT-03:00) America/Argentina/Mendoza, Rio_Gallegos, Salta, San_Juan, San_Luis, Tucuman", "America/Argentina/Mendoza",false),
	GMTM0300_AMERICA_ARGENTINA_USHUAIA("GMT-03:00", "(GMT-03:00) America/Argentina/Ushuaia", "America/Argentina/Ushuaia",false),
	GMTM0300_ANTARCTICA_ROTHERA("GMT-03:00", "(GMT-03:00) Antarctica/Rothera", "Antarctica/Rothera",false),
	GMTM0300_ANTARCTICA_PALMER("GMT-03:00", "(GMT-03:00/DST) Antarctica/Palmer", "Antarctica/Palmer",true),
	GMTM0300_ATLANTIC_STANLEY("GMT-03:00", "(GMT-03:00) Atlantic/Stanley", "Atlantic/Stanley",false),
	GMTM0300_CHILE_CONTINENTAL("GMT-03:00", "(GMT-03:00/DST) Chile/Continental", "Chile/Continental",true),
	GMTM0200_AMERICA_NORONHA("GMT-02:00", "(GMT-02:00) America/Noronha", "America/Noronha",false),
	GMTM0200_AMERICA_MONTEVIDEO("GMT-02:00", "(GMT-02:00/DST) America/Montevideo, Sao_Paulo", "America/Montevideo",true),
	GMTM0200_ATLANTIC_SOUTH_GEORGIA("GMT-02:00", "(GMT-02:00) Atlantic/South_Georgia", "Atlantic/South_Georgia",false),
	GMTM0200_BRAZIL_DENORONHA("GMT-02:00", "(GMT-02:00) Brazil/DeNoronha", "Brazil/DeNoronha",false),
	GMTM0200_BRAZIL_EAST("GMT-02:00", "(GMT-02:00/DST) Brazil/East", "Brazil/East",true),
	GMTM0100_AMERICA_SCORESBYSUND("GMT-01:00", "(GMT-01:00/DST) America/Scoresbysund", "America/Scoresbysund",true),
	GMTM0100_ATLANTIC_CAPE_VERDE("GMT-01:00", "(GMT-01:00) Atlantic/Cape_Verde", "Atlantic/Cape_Verde",false),
	GMTM0100_ATLANTIC_AZORES("GMT-01:00", "(GMT-01:00/DST) Atlantic/Azores", "Atlantic/Azores",true),
	GMTP0000_AFRICA_ABIDJAN("GMT+00:00", "(GMT+00:00) Africa/Abidjan, Accra, Bamako, Banjul, Bissau, Conakry", "Africa/Abidjan",false),
	GMTP0000_AFRICA_DAKAR("GMT+00:00", "(GMT+00:00) Africa/Dakar, Freetown, Lome, Monrovia, Nouakchott, Ouagadougou", "Africa/Dakar",false),
	GMTP0000_AFRICA_SAO_TOME("GMT+00:00", "(GMT+00:00) Africa/Sao_Tome, Timbuktu", "Africa/Sao_Tome",false),
	GMTP0000_AFRICA_CASABLANCA("GMT+00:00", "(GMT+00:00/DST) Africa/Casablanca, El_Aaiun", "Africa/Casablanca",true),
	GMTP0000_AMERICA_DANMARKSHAVN("GMT+00:00", "(GMT+00:00) America/Danmarkshavn", "America/Danmarkshavn",false),
	GMTP0000_ATLANTIC_REYKJAVIK("GMT+00:00", "(GMT+00:00) Atlantic/Reykjavik, St_Helena", "Atlantic/Reykjavik",false),
	GMTP0000_ATLANTIC_CANARY("GMT+00:00", "(GMT+00:00/DST) Atlantic/Canary, Faeroe, Faroe, Madeira", "Atlantic/Canary",true),
	GMTP0000_ETC_GREENWICH("GMT+00:00", "(GMT+00:00) Etc/Greenwich, UCT, UTC, Universal, Zulu", "Etc/Greenwich",false),
	GMTP0000_EUROPE_BELFAST("GMT+00:00", "(GMT+00:00/DST) Europe/Belfast, Dublin, Guernsey, Isle_of_Man, Jersey, Lisbon", "Europe/Belfast",true),
	GMTP0000_EUROPE_LONDON("GMT+00:00", "(GMT+00:00/DST) Europe/London", "Europe/London",true),
	GMTP0100_AFRICA_ALGIERS("GMT+01:00", "(GMT+01:00) Africa/Algiers, Bangui, Brazzaville, Douala, Kinshasa, Lagos", "Africa/Algiers",false),
	GMTP0100_AFRICA_LIBREVILLE("GMT+01:00", "(GMT+01:00) Africa/Libreville, Luanda, Malabo, Ndjamena, Niamey, Porto-Novo", "Africa/Libreville",false),
	GMTP0100_AFRICA_TUNIS("GMT+01:00", "(GMT+01:00) Africa/Tunis", "Africa/Tunis",false),
	GMTP0100_AFRICA_CEUTA("GMT+01:00", "(GMT+01:00/DST) Africa/Ceuta", "Africa/Ceuta",true),
	GMTP0100_ARCTIC_LONGYEARBYEN("GMT+01:00", "(GMT+01:00/DST) Arctic/Longyearbyen", "Arctic/Longyearbyen",true),
	GMTP0100_ATLANTIC_JAN_MAYEN("GMT+01:00", "(GMT+01:00/DST) Atlantic/Jan_Mayen", "Atlantic/Jan_Mayen",true),
	GMTP0100_EUROPE_AMSTERDAM("GMT+01:00", "(GMT+01:00/DST) Europe/Amsterdam, Andorra, Belgrade, Berlin, Bratislava, Brussels", "Europe/Amsterdam",true),
	GMTP0100_EUROPE_BUDAPEST("GMT+01:00", "(GMT+01:00/DST) Europe/Budapest, Busingen, Copenhagen, Gibraltar, Ljubljana, Luxembourg", "Europe/Budapest",true),
	GMTP0100_EUROPE_MADRID("GMT+01:00", "(GMT+01:00/DST) Europe/Madrid, Malta, Monaco, Oslo, Paris, Podgorica", "Europe/Madrid",true),
	GMTP0100_EUROPE_PRAGUE("GMT+01:00", "(GMT+01:00/DST) Europe/Prague, Rome, San_Marino, Sarajevo, Skopje, Stockholm", "Europe/Prague",true),
	GMTP0100_EUROPE_TIRANE("GMT+01:00", "(GMT+01:00/DST) Europe/Tirane, Vaduz, Vatican, Vienna, Warsaw, Zagreb", "Europe/Tirane",true),
	GMTP0100_EUROPE_ZURICH("GMT+01:00", "(GMT+01:00/DST) Europe/Zurich", "Europe/Zurich",true),
	GMTP0200_AFRICA_BLANTYRE("GMT+02:00", "(GMT+02:00) Africa/Blantyre, Bujumbura, Cairo, Gaborone, Harare, Johannesburg", "Africa/Blantyre",false),
	GMTP0200_AFRICA_KIGALI("GMT+02:00", "(GMT+02:00) Africa/Kigali, Lubumbashi, Lusaka, Maputo, Maseru, Mbabane", "Africa/Kigali",false),
	GMTP0200_AFRICA_TRIPOLI("GMT+02:00", "(GMT+02:00) Africa/Tripoli", "Africa/Tripoli",false),
	GMTP0200_AFRICA_WINDHOEK("GMT+02:00", "(GMT+02:00/DST) Africa/Windhoek", "Africa/Windhoek",true),
	GMTP0200_ASIA_BEIRUT("GMT+02:00", "(GMT+02:00/DST) Asia/Beirut, Damascus, Gaza, Hebron, Istanbul, Jerusalem", "Asia/Beirut",true),
	GMTP0200_ASIA_NICOSIA("GMT+02:00", "(GMT+02:00/DST) Asia/Nicosia, Tel_Aviv", "Asia/Nicosia",true),
	GMTP0200_EUROPE_ATHENS("GMT+02:00", "(GMT+02:00/DST) Europe/Athens, Bucharest, Chisinau, Helsinki, Istanbul, Kiev", "Europe/Athens",true),
	GMTP0200_EUROPE_MARIEHAMN("GMT+02:00", "(GMT+02:00/DST) Europe/Mariehamn, Nicosia, Riga, Simferopol, Sofia, Tallinn", "Europe/Mariehamn",true),
	GMTP0200_EUROPE_TIRASPOL("GMT+02:00", "(GMT+02:00/DST) Europe/Tiraspol, Uzhgorod, Vilnius, Zaporozhye", "Europe/Tiraspol",true),
	GMTP0300_AFRICA_ADDIS_ABABA("GMT+03:00", "(GMT+03:00) Africa/Addis_Ababa, Asmara, Asmera, Dar_es_Salaam, Djibouti, Juba", "Africa/Addis_Ababa",false),
	GMTP0300_AFRICA_KAMPALA("GMT+03:00", "(GMT+03:00) Africa/Kampala, Khartoum, Mogadishu, Nairobi", "Africa/Kampala",false),
	GMTP0300_ANTARCTICA_SYOWA("GMT+03:00", "(GMT+03:00) Antarctica/Syowa", "Antarctica/Syowa",false),
	GMTP0300_ASIA_ADEN("GMT+03:00", "(GMT+03:00) Asia/Aden, Amman, Baghdad, Bahrain, Kuwait, Qatar", "Asia/Aden",false),
	GMTP0300_ASIA_RIYADH("GMT+03:00", "(GMT+03:00) Asia/Riyadh", "Asia/Riyadh",false),
	GMTP0300_EUROPE_KALININGRAD("GMT+03:00", "(GMT+03:00) Europe/Kaliningrad, Minsk", "Europe/Kaliningrad",false),
	GMTP0300_INDIAN_ANTANANARIVO("GMT+03:00", "(GMT+03:00) Indian/Antananarivo, Comoro, Mayotte", "Indian/Antananarivo",false),
	GMTP0330_ASIA_TEHRAN("GMT+03:30", "(GMT+03:30/DST) Asia/Tehran", "Asia/Tehran",true),
	GMTP0400_ASIA_DUBAI("GMT+04:00", "(GMT+04:00) Asia/Dubai, Muscat, Tbilisi, Yerevan", "Asia/Dubai",false),
	GMTP0400_ASIA_BAKU("GMT+04:00", "(GMT+04:00/DST) Asia/Baku", "Asia/Baku",true),
	GMTP0400_EUROPE_MOSCOW("GMT+04:00", "(GMT+04:00) Europe/Moscow, Samara, Volgograd", "Europe/Moscow",false),
	GMTP0400_INDIAN_MAHE("GMT+04:00", "(GMT+04:00) Indian/Mahe, Mauritius, Reunion", "Indian/Mahe",false),
	GMTP0430_ASIA_KABUL("GMT+04:30", "(GMT+04:30) Asia/Kabul", "Asia/Kabul",false),
	GMTP0500_ANTARCTICA_MAWSON("GMT+05:00", "(GMT+05:00) Antarctica/Mawson", "Antarctica/Mawson",false),
	GMTP0500_ASIA_AQTAU("GMT+05:00", "(GMT+05:00) Asia/Aqtau, Aqtobe, Ashgabat, Ashkhabad, Dushanbe, Karachi", "Asia/Aqtau",false),
	GMTP0500_ASIA_ORAL("GMT+05:00", "(GMT+05:00) Asia/Oral, Samarkand, Tashkent", "Asia/Oral",false),
	GMTP0500_INDIAN_KERGUELEN("GMT+05:00", "(GMT+05:00) Indian/Kerguelen, Maldives", "Indian/Kerguelen",false),
	GMTP0530_ASIA_CALCUTTA("GMT+05:30", "(GMT+05:30) Asia/Calcutta, Colombo, Kolkata", "Asia/Calcutta",false),
	GMTP0545_ASIA_KATHMANDU("GMT+05:45", "(GMT+05:45) Asia/Kathmandu, Katmandu", "Asia/Kathmandu",false),
	GMTP0600_ANTARCTICA_VOSTOK("GMT+06:00", "(GMT+06:00) Antarctica/Vostok", "Antarctica/Vostok",false),
	GMTP0600_ASIA_ALMATY("GMT+06:00", "(GMT+06:00) Asia/Almaty, Bishkek, Dacca, Dhaka, Qyzylorda, Thimbu", "Asia/Almaty",false),
	GMTP0600_ASIA_THIMPHU("GMT+06:00", "(GMT+06:00) Asia/Thimphu, Yekaterinburg", "Asia/Thimphu",false),
	GMTP0600_INDIAN_CHAGOS("GMT+06:00", "(GMT+06:00) Indian/Chagos", "Indian/Chagos",false),
	GMTP0630_ASIA_RANGOON("GMT+06:30", "(GMT+06:30) Asia/Rangoon", "Asia/Rangoon",false),
	GMTP0630_INDIAN_COCOS("GMT+06:30", "(GMT+06:30) Indian/Cocos", "Indian/Cocos",false),
	GMTP0700_ANTARCTICA_DAVIS("GMT+07:00", "(GMT+07:00) Antarctica/Davis", "Antarctica/Davis",false),
	GMTP0700_ASIA_BANGKOK("GMT+07:00", "(GMT+07:00) Asia/Bangkok, Ho_Chi_Minh, Hovd, Jakarta, Novokuznetsk, Novosibirsk", "Asia/Bangkok",false),
	GMTP0700_ASIA_OMSK("GMT+07:00", "(GMT+07:00) Asia/Omsk, Phnom_Penh, Pontianak, Saigon, Vientiane", "Asia/Omsk",false),
	GMTP0700_INDIAN_CHRISTMAS("GMT+07:00", "(GMT+07:00) Indian/Christmas", "Indian/Christmas",false),
	GMTP0800_ANTARCTICA_CASEY("GMT+08:00", "(GMT+08:00) Antarctica/Casey", "Antarctica/Casey",false),
	GMTP0800_ASIA_BRUNEI("GMT+08:00", "(GMT+08:00) Asia/Brunei, Choibalsan, Chongqing, Chungking, Harbin, Hong_Kong", "Asia/Brunei",false),
	GMTP0800_ASIA_KASHGAR("GMT+08:00", "(GMT+08:00) Asia/Kashgar, Krasnoyarsk, Kuala_Lumpur, Kuching, Macao, Macau", "Asia/Kashgar",false),
	GMTP0800_ASIA_MAKASSAR("GMT+08:00", "(GMT+08:00) Asia/Makassar, Manila, Shanghai, Singapore, Taipei, Ujung_Pandang", "Asia/Makassar",false),
	GMTP0800_ASIA_ULAANBAATAR("GMT+08:00", "(GMT+08:00) Asia/Ulaanbaatar, Ulan_Bator, Urumqi", "Asia/Ulaanbaatar",false),
	GMTP0800_AUSTRALIA_PERTH("GMT+08:00", "(GMT+08:00) Australia/Perth, West", "Australia/Perth",false),
	GMTP0845_AUSTRALIA_EUCLA("GMT+08:45", "(GMT+08:45) Australia/Eucla", "Australia/Eucla",false),
	GMTP0900_ASIA_DILI("GMT+09:00", "(GMT+09:00) Asia/Dili, Irkutsk, Jayapura, Pyongyang, Seoul, Tokyo", "Asia/Dili",false),
	GMTP0900_PACIFIC_PALAU("GMT+09:00", "(GMT+09:00) Pacific/Palau", "Pacific/Palau",false),
	GMTP0930_AUSTRALIA_DARWIN("GMT+09:30", "(GMT+09:30) Australia/Darwin, North", "Australia/Darwin",false),
	GMTP1000_ANTARCTICA_DUMONTDURVILLE("GMT+10:00", "(GMT+10:00) Antarctica/DumontDUrville", "Antarctica/DumontDUrville",false),
	GMTP1000_ASIA_KHANDYGA("GMT+10:00", "(GMT+10:00) Asia/Khandyga, Yakutsk", "Asia/Khandyga",false),
	GMTP1000_AUSTRALIA_BRISBANE("GMT+10:00", "(GMT+10:00) Australia/Brisbane, Lindeman, Queensland", "Australia/Brisbane",false),
	GMTP1000_PACIFIC_CHUUK("GMT+10:00", "(GMT+10:00) Pacific/Chuuk, Guam, Port_Moresby, Saipan, Truk, Yap", "Pacific/Chuuk",false),
	GMTP1030_AUSTRALIA_ADELAIDE("GMT+10:30", "(GMT+10:30/DST) Australia/Adelaide, Broken_Hill, South, Yancowinna", "Australia/Adelaide",true),
	GMTP1100_ANTARCTICA_MACQUARIE("GMT+11:00", "(GMT+11:00) Antarctica/Macquarie", "Antarctica/Macquarie",false),
	GMTP1100_ASIA_SAKHALIN("GMT+11:00", "(GMT+11:00) Asia/Sakhalin, Ust-Nera, Vladivostok", "Asia/Sakhalin",false),
	GMTP1100_AUSTRALIA_ACT("GMT+11:00", "(GMT+11:00/DST) Australia/ACT, Canberra, Currie, Hobart, LHI, Lord_Howe", "Australia/ACT",true),
	GMTP1100_AUSTRALIA_MELBOURNE("GMT+11:00", "(GMT+11:00/DST) Australia/Melbourne, NSW, Sydney, Tasmania, Victoria", "Australia/Melbourne",true),
	GMTP1100_PACIFIC_EFATE("GMT+11:00", "(GMT+11:00) Pacific/Efate, Guadalcanal, Kosrae, Noumea, Pohnpei, Ponape", "Pacific/Efate",false),
	GMTP1130_PACIFIC_NORFOLK("GMT+11:30", "(GMT+11:30) Pacific/Norfolk", "Pacific/Norfolk",false),
	GMTP1200_ASIA_ANADYR("GMT+12:00", "(GMT+12:00) Asia/Anadyr, Kamchatka, Magadan", "Asia/Anadyr",false),
	GMTP1200_PACIFIC_FUNAFUTI("GMT+12:00", "(GMT+12:00) Pacific/Funafuti, Kwajalein, Majuro, Nauru, Tarawa, Wake", "Pacific/Funafuti",false),
	GMTP1200_PACIFIC_WALLIS("GMT+12:00", "(GMT+12:00) Pacific/Wallis", "Pacific/Wallis",false),
	GMTP1200_PACIFIC_FIJI("GMT+12:00", "(GMT+12:00/DST) Pacific/Fiji", "Pacific/Fiji",true),
	GMTP1300_ANTARCTICA_MCMURDO("GMT+13:00", "(GMT+13:00/DST) Antarctica/McMurdo, South_Pole", "Antarctica/McMurdo",true),
	GMTP1300_PACIFIC_ENDERBURY("GMT+13:00", "(GMT+13:00) Pacific/Enderbury, Fakaofo, Tongatapu", "Pacific/Enderbury",false),
	GMTP1300_PACIFIC_AUCKLAND("GMT+13:00", "(GMT+13:00/DST) Pacific/Auckland", "Pacific/Auckland",true),
	GMTP1345_PACIFIC_CHATHAM("GMT+13:45", "(GMT+13:45/DST) Pacific/Chatham", "Pacific/Chatham",true),
	GMTP1400_PACIFIC_KIRITIMATI("GMT+14:00", "(GMT+14:00) Pacific/Kiritimati", "Pacific/Kiritimati",false),
	GMTP1400_PACIFIC_APIA("GMT+14:00", "(GMT+14:00/DST) Pacific/Apia", "Pacific/Apia",true);

	/** GMT key for time zone. */
	private final String gmt;
	
	/** Display name of the time zone. */
	private final String name;
	
	/** The time zone id. */
	private final String timeZoneId;
	
	/** The daylight saving is used. */
	private final boolean daylightSavings;
	
	TimeZoneEnum(String gmt, String name, String timeZoneId, boolean daylightSavings) {
		this.gmt = gmt;
		this.name = name;
		this.timeZoneId = timeZoneId;
		this.daylightSavings = daylightSavings;
	}
	
	public String getGmt() {
		return gmt;
	}
	
	public String getName() {
		return name;
	}

	/**
	 * @return the timeZoneId
	 */
	public String getTimeZoneId() {
		return timeZoneId;
	}

	/**
	 * @return the daylightSavings
	 */
	public boolean isDaylightSavings() {
		return daylightSavings;
	}
	
	
}
