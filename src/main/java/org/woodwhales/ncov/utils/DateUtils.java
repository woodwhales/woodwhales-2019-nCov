package org.woodwhales.ncov.utils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

public class DateUtils {
	
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";

	private static final String MIDDLE_DATE_FORMAT = "yyyy-MM-dd HH:mm";
	
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	
	private static final String OFFSETID = "+8";
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
	
	private static final DateTimeFormatter middle_formatter = DateTimeFormatter.ofPattern(MIDDLE_DATE_FORMAT);
	
	private static TimeZone systemTimeZone = TimeZone.getDefault();
	
	public static String format(Date date) {
		return DateFormatUtils.format(date, DEFAULT_DATE_FORMAT, systemTimeZone);
	}
	
	public static String formatIfNull(Date date) {
		if(Objects.isNull(date)) {
			return StringUtils.EMPTY;
		}
		return format(date);
	}
	
	public static String formatSimpleIfNull(Date date) {
		if(Objects.isNull(date)) {
			return StringUtils.EMPTY;
		}
		return formatSimple(date);
	}
	
	public static String formatSimple(Date date) {
		return DateFormatUtils.format(date, SIMPLE_DATE_FORMAT, systemTimeZone);
	}
	
	public static String formatMiddleIfNull(Date date) {
		if(Objects.isNull(date)) {
			return StringUtils.EMPTY;
		}
		return formatMiddle(date);
	}
	
	public static String formatMiddle(Date date) {
		return DateFormatUtils.format(date, MIDDLE_DATE_FORMAT, systemTimeZone);
	}

    public static Long getMilliSecond() {
    	return LocalDateTime.now().toInstant(ZoneOffset.of(OFFSETID)).toEpochMilli();
    }
    
    public static Long getMilliSecond(LocalDateTime localDateTime) {
    	return localDateTime.toInstant(ZoneOffset.of(OFFSETID)).toEpochMilli();
    }
    
    public static Instant getInstant() {
    	Instant instant = LocalDateTime.now().toInstant(ZoneOffset.of(OFFSETID));
    	return instant;
    }
    
    public static Date getNowDate() {
    	Instant instant = getInstant();
    	return convertDate(instant);
    }
    
    public static String getNowStr() {
    	Instant instant = getInstant();
    	return formatter.format(instant);
    }
    
    public static String getNowStr(String formatterStr) {
    	LocalDateTime now = LocalDateTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatterStr);
    	return formatter.format(now);
    }
    
    public static Instant convertInstant(Date date) {
    	Instant instant = date.toInstant();
    	return instant;
    }
    
    public static LocalDateTime convertLocalDateTime(String dateStr) {
    	LocalDateTime localDateTime = LocalDateTime.parse(dateStr, formatter);
    	return localDateTime;
    }
    
    public static LocalDateTime convertLocalDateTime(String dateStr, String formatterStr) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatterStr);
    	LocalDateTime localDateTime = LocalDateTime.parse(dateStr, formatter);
    	return localDateTime;
    }
    
    public static LocalDateTime convertLocalDateTime(Date date) {
		LocalDateTime localDateTime = LocalDateTime.ofInstant(convertInstant(date), ZoneId.systemDefault());
		return localDateTime;
	}

	public static Instant convertInstant(LocalDateTime localDateTime) {
    	Instant instant = localDateTime.toInstant(ZoneOffset.of(OFFSETID));
    	return instant;
    }
    
    public static Date convertDate(String dateStr) {
    	LocalDateTime convertLocalDateTime = convertLocalDateTime(dateStr);
    	Date date = convertDate(convertInstant(convertLocalDateTime));
    	return date;
    }
    
    public static Date convertMiddleDate(String dateStr) {
    	LocalDateTime convertLocalDateTime = LocalDateTime.parse(dateStr, middle_formatter);
    	Date date = convertDate(convertInstant(convertLocalDateTime));
    	return date;
    }
    
    public static Date convertDate(Instant instant) {
    	Date date = Date.from(instant);
    	return date;
    }
    
    public static Date convertDate(LocalDateTime localDateTime) {
    	return Date.from(convertInstant(localDateTime));
    }
    
    public static LocalDate convertLocalDate(LocalDateTime localDateTime) {
    	int year = localDateTime.getYear();
    	Month month = localDateTime.getMonth();
    	int day = localDateTime.getDayOfMonth();
    	LocalDate localDate = LocalDate.of(year, month, day);
    	return localDate;
    }
    
    public static boolean compareDateisAfter(Date date) {
    	LocalDateTime nowLocalDateTime = convertLocalDateTime(getNowDate());
    	LocalDateTime compareLocalDateTime = convertLocalDateTime(date);
    	return compareLocalDateTime.isAfter(nowLocalDateTime);
    }
    
    public static boolean compareDateisBefore(Date date) {
    	return !compareDateisAfter(date);
    }
    
    public static Date plusYears(Date date, int years) {
    	LocalDateTime localDateTime = convertLocalDateTime(date);
    	return convertDate(localDateTime.plusYears(years));
    }
    
    public static Date plusMinutes(Date date, int minutes) {
    	LocalDateTime localDateTime = convertLocalDateTime(date);
    	return convertDate(localDateTime.plusMinutes(minutes));
    }
}