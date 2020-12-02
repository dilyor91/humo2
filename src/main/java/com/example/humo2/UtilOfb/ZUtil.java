package com.example.humo2.UtilOfb;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class ZUtil {

	public static XMLGregorianCalendar toXmlDate(String dt)
			throws ParseException, DatatypeConfigurationException {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

		if (dt == null) {
			dt = "31.12.9999";
		}
		Date date = format.parse(dt);

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);

		XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(cal);

		return xmlGregCal;
	}
	
	public static XMLGregorianCalendar toXmlDateNew(String dt)
			throws ParseException, DatatypeConfigurationException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		if (dt == null) {
			dt = "31.12.9999";
		}
		Date date = format.parse(dt);

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);

		XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(cal);

		return xmlGregCal;
	}


	public static XMLGregorianCalendar toXmlDateTime(String dt)
			throws ParseException, DatatypeConfigurationException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (dt == null) {
			dt = "31.12.9999";
		}
		Date date = format.parse(dt);

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);

		XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(cal);

		return xmlGregCal;
	}

	public static String[] split(String text, int chunkSize, int maxLength) {

		char[] data = text.toCharArray();
		int len = Math.min(data.length, maxLength);
		String[] result = new String[(len + chunkSize - 1) / chunkSize];
		int linha = 0;
		for (int i = 0; i < len; i += chunkSize) {
			result[linha] = new String(data, i, Math.min(chunkSize, len - i));
			linha++;
		}
		return result;
	}

	public static BigDecimal toBicDec(String val) {
		return BigDecimal.valueOf(Double.valueOf(val));
	}

	public static String nvl(String value) {
		if (value != null) {
			return value;
		} else {
			return "";
		}
	}

	public static String toString(boolean value) {
		if (value) {
			return "Y";
		} else {
			return "N";
		}
	}
}
