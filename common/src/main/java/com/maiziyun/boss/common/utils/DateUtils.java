package com.maiziyun.boss.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by yangyaofeng on 2016/5/11.
 */
public class DateUtils {
    private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String SIMPLE_DATE_PATTERN = "yyyy-MM-dd";

	public static String SIMPLE_DATE_HOURS_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static final String SDF_YMD_PATTERN = "yyyyMMdd";

	public static final String SDF_YM = "yyyy-MM";

	public static final String SDF_MINUTS = "yyyy-MM-dd HH:mm";

	public static final String SDF_HOUR_MINUTS = "HH:mm";

	public static final String SDF_MD_PATTERN = "MM-dd";

	public static final String SDF_MD_HM_PATTERN = "MM-dd HH:mm";

	public static final String SDF_YMDHMS_PATTERN = "yyyyMMddHHmmss";
	
    
    public static Date stringToDate(String str, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(Boolean.FALSE.booleanValue());
        Date date = sdf.parse(str);
        return date;
    }

    private static final long daytimes = 86400000L;
	public static final String YYMMDDHHMMSS = "yyMMddhhmmss";

    public static Date parseDatetime(String datetime, String pattern) throws ParseException {
        SimpleDateFormat format = (SimpleDateFormat) datetimeFormat.clone();
        format.applyPattern(pattern);
        return format.parse(datetime);
    }

    public static Date getDateByFormat(Date sourceDate, String format) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat(format);
        String dateString = f.format(sourceDate);
        Date date = f.parse(dateString);
        return date;
    }


    public static String formatDatetime(Date date) {
        return datetimeFormat.format(date);
    }

    public static String formatDatetime(Date date, String pattern) {
        SimpleDateFormat customFormat = (SimpleDateFormat) datetimeFormat.clone();
        customFormat.applyPattern(pattern);
        return customFormat.format(date);
    }

    /**
     * 获取当天开始时间
     * 
     * @return
     * @throws ParseException
     */
    public static Date getTodayStartTime() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return datetimeFormat.parse(format.format(new Date()) + " 00:00:00");
    }

    /**
     * 获取当天结束时间
     * 
     * @return
     * @throws ParseException
     */
    public static Date getTodayEndTime() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return datetimeFormat.parse(format.format(new Date()) + " 23:59:59");
    }

    /** 返回今天的日期，带时分秒 */
    public static Date currentDateTime() {
        return new Date();
    }

    /**
     * 格式化日期
     * 
     * @param date
     * @param formatString
     * @return
     */
    public static String format(Date date, String formatString) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat df = new SimpleDateFormat(formatString);
            return df.format(date);
        }
    }

    public static Date addDay(Date date, int amount) {
        Calendar cal = calendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, amount);
        return cal.getTime();
    }

    public static Date addMonths(Date lenderDate, int intValueExact) {
        Calendar cal = calendar();
        cal.setTime(lenderDate);
        cal.add(Calendar.MONTH, intValueExact);
        return cal.getTime();
    }

    public static Date addYear(Date lenderDate, int intValueExact) {
        Calendar cal = calendar();
        cal.setTime(lenderDate);
        cal.add(Calendar.YEAR, intValueExact);
        return cal.getTime();
    }

    public static Calendar calendar() {
        Calendar cal = GregorianCalendar.getInstance(Locale.CHINESE);
        cal.setFirstDayOfWeek(2);
        return cal;
    }

    public static boolean isEqual(Date date1, Date date2) {
        return date1.compareTo(date2) == 0;
    }

    public static Date today() {
        return new Date();
    }

    public static long getDateSubDays(Date date1, Date date2) {
        long d1 = date1.getTime();
        long d2 = date2.getTime();
        long diff = 0L;
        if (d1 == d2)
            return diff;
        if (d1 > d2)
            diff = d1 - d2;
        else {
            diff = d2 - d1;
        }
        return diff / daytimes;
    }

    /**
     * ifNowBetweenTwoDate:判断当前时间是否在传参的开始和结束时间之间. <br/>
     *
     * @author owen.wang
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean ifNowBetweenTwoDate(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return true;
        }
        Date nowDate = new Date();
        if (nowDate.compareTo(startDate) >= 0 && nowDate.compareTo(endDate) <= 0) {
            return true;
        }
        return false;
    }

    /**
     * dateToString:按指定格式化时间数据. <br/>
     *
     * @author Owen.Wang
     * @param date
     *            传输的时间数据
     * @param pattern
     *            格式化格式
     * @return
     * @throws ParseException
     */
    public static String dateToString(Date date, String pattern) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        return sf.format(date);
    }

    /**
     * 
     * getTime:TODO. 获得当天时间<br/>
     *
     * @author Len.Song
     * @param parrten
     *            输出的时间格式
     * @return
     */
    public static String getTime(String parrten) {
        String timestr;
        if (parrten == null || parrten.equals("")) {
            parrten = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(parrten);
        Date cday = new Date();
        timestr = sdf.format(cday);
        return timestr;
    }


	/**
	 * 获取本月第一天
	*/
	public static String getMonthFirstDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String first = format.format(c.getTime());
		return first;
	}
	
	
	/**
	 * 获取当前第几月
	*/
	@SuppressWarnings("deprecation")
	public static int getMonth(){
		return new Date().getMonth() +1;
	}

	/**
	 * 获取当前第几年
	*/
	@SuppressWarnings("deprecation")
	public static int getYear() {
		int currentYear = (new Date()).getYear() + 1900;
		return currentYear;
	}
	
    
	/**
	 * 获取本月第一天
	*/
	public static String getMonthLastDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = format.format(ca.getTime());
		return last;
	}
	
	
    
    /**
     * 相差分钟数
     */
    public static int differMinute(Date startDate,Date endDate){
    	long minutes=(endDate.getTime()-startDate.getTime())/(1000 * 60);
    	return (int) minutes;
    }
    
    
    /**
     * date类型转换
     */
    public static Date date2date(Date date,String format){
    	try {
			String dateStr = dateToString(date, format);
			return stringToDate(dateStr, format);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
}
