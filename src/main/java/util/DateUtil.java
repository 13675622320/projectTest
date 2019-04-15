package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author daox.nie
 * @created 2016年11月22日 下午1:56:51
 * @description
 */
public class DateUtil
{

	public final static String DD = "dd";
	public final static String MM = "MM";
	public final static String HHMMSS = "HHmmss";
	public final static String YYYY = "yyyy"; 
	public final static String YYYYMM = "yyyyMM";
	public final static String YYYYMMDD = "yyyyMMdd";
	public final static String YYYY_MM_DD = "yyyy-MM-dd";
	public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public final static String YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
	public final static String HH_MM_SS_SSS = "HH:mm:ss.SSS";
	public final static String HH_MM_SS = "HH:mm:ss"; 
	public final static String YYYYMMDD_HHMMSSSSS = "yyyy-MM-dd-HH.mm.ss.SSSSSS";
	
	/**
	 * @title getYear
	 * @description 获取年份
	 * @author Nan Ou
	 * @email ou.nan@sunyard.com
	 * @param date
	 * @return
	 */
	public static String getYear(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(YYYY);
		return sdf.format(date);
	}

	/**
	 * @title getMonth
	 * @description 获取月份
	 * @author Nan Ou
	 * @email ou.nan@sunyard.com
	 * @param date
	 * @return
	 */
	public static String getMonth(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(MM);
		return sdf.format(date);
	}

	/**
	 * @title getDay
	 * @description 获取日份
	 * @author Nan Ou
	 * @email ou.nan@sunyard.com
	 * @param date
	 * @return
	 */
	public static String getDay(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DD);
		return sdf.format(date);
	}

	/**
	 * 将字符串解析成Date
	 * @param format
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getDate(String format,String str)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try
		{
			return dateFormat.parse(str);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 获取yyyyMMddHHmmss格式日期
	 * @param str
	 * @return Date
	 */
	public static Date getDefaultDate(String str)
	{
		return getDate(YYYYMMDDHHMMSS, str);
	}
	
	/**
	 * 将时间格式化成字符串
	 * @param format
	 * @param date
	 * @return
	 */
	public static String getDateStr(String format,Date date)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	
	/**
	 * 获取获取yyyyMMddHHmmss格式格式字符串
	 * @param date
	 * @return
	 */
	public static String getDefaultDateStr(Date date)
	{
		return getDateStr(YYYYMMDDHHMMSS, date);
	}
	
	/**
	 * 获取当天开始时间
	 * @return Date
	 */
	public static Date getStartOfTodDay()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	}
	
	/**
	 * 当天的结束时间 
	 * @return
	 */
	public static Date getEndOfTodDay()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}
	
	/**
	 * 获取给定日期之前或之后若干天
	 * @param date 给定日期
	 * @param day 偏移天数
	 * @return 
	 */
	public static Date getOffDate(Date date ,int day)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		return calendar.getTime();
	}
	
	/**
	 * 获取给定日期之前或之后若干月
	 * @param date
	 * @param month
	 * @return 
	 */
	public static Date getOffMonth(Date date ,int month)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		return calendar.getTime();
	}	
	

	/**
	 * 获取给定日期之前或之后若干分钟
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date getOffMinute(Date date , int minute)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minute);
		return calendar.getTime();
	}
	
	/**
	 * 
	 * Description: 根据开始时间和结束时间返回时间段内的时间集合
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static List<Date> getDatesBetweenTwoDate(Date beginDate, Date endDate){
		List<Date> lDate = new ArrayList<Date>();  
        lDate.add(beginDate);// 把开始时间加入集合  
        Calendar cal = Calendar.getInstance();  
        // 使用给定的 Date 设置此 Calendar 的时间  
        cal.setTime(beginDate);  
        boolean bContinue = true;  
        while (bContinue) {  
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量  
            cal.add(Calendar.DAY_OF_MONTH, 1);  
            // 测试此日期是否在指定日期之后  
            if (endDate.after(cal.getTime())) {  
                lDate.add(cal.getTime());  
            } else {  
                break;  
            }  
        }  
        lDate.add(endDate);// 把结束时间加入集合  
        return lDate;  
	}
	
	public static boolean isWorkDay(Date date){
		 Calendar c = Calendar.getInstance();
		 c.setTime(date);
         if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY||
                 c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
             return false;
         }else{
        	 return true;
         }
	}
	
	/**
	 * 
	 * @Title: daysBetween
	 * @Description: 两个日期相差天数
	 * @param @param smdate
	 * @param @param bdate
	 * @param @return
	 * @return int
	 * @throws
	 */
	public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }
	
	/**
	 * 
	 * @Title: monthsBetween
	 * @Description: 两个月份相差月数
	 * @param @param smdate
	 * @param @param bdate
	 * @param @return
	 * @param @throws ParseException
	 * @return int
	 * @throws
	 */
	public static int monthsBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance(); 
        cal1.setTime(smdate);                     
        cal2.setTime(bdate);    
        int year = cal2.get(Calendar.YEAR)-cal1.get(Calendar.YEAR);        
            
        return year*12+cal2.get(Calendar.MONTH)-cal1.get(Calendar.MONTH);        
    }
}
