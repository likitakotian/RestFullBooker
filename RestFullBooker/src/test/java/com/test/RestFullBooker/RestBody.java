package com.test.RestFullBooker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RestBody {

	public static String getFN() {
		//String generatedString = RandomStringUtils.randomAlphanumeric(5);
		return "Jim";
	}

	public static String getLN() {
		//String generatedString = RandomStringUtils.randomAlphanumeric(5);
		return "Brown";
	}

	public static Integer getTotalPrice() {
		//String generatedString = RandomStringUtils.randomAlphanumeric(5);
		return 191;
	}

	public static boolean getdepositepaid() {
		//String generatedString = RandomStringUtils.randomAlphanumeric(5);
		return true;
	}

	public static String getcheckin() {
		//String generatedString = RandomStringUtils.randomAlphanumeric(5);
		return "2018-01-01";
	}

	public static String getcheckout() {
		//String generatedString = RandomStringUtils.randomAlphanumeric(5);
		return "2019-01-01";
	}
	
	public static String getFormattedDate(String strDate){
		 DateFormat dateFormatSrc = new SimpleDateFormat("yyyy-mm-dd");
		 DateFormat dateFormatDest = new SimpleDateFormat("dd-mm-yyyy");

		 try {
			Date srcDate = dateFormatSrc.parse(strDate);
			return dateFormatDest.format(srcDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		 
	}
}
