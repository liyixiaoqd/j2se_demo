package hutubill.util;

import java.util.Date;
import java.util.Calendar;

public class DateUtil {
	static long millisecondsOfOneDay = 1000*60*60*24;
	
	/**
	 * 时间转换
	 * @param d
	 * @return
	 */
	public static java.sql.Date utils2sql(Date d){
		return new java.sql.Date(d.getTime());
	}
	
	/**
	 * 获取当天日期,无具体时间
	 * @return
	 */
	public static Date today(){
		Calendar c = Calendar.getInstance();
		c.setTime(new java.util.Date());
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 获取本月第一天
	 * @param args
	 */
	public static Date monthBegin(){
		Calendar c = Calendar.getInstance();
		c.setTime(today());
		c.set(Calendar.DATE, 1);
		
		return c.getTime();
	}
	
	public static Date monthEnd(){
		Calendar c = Calendar.getInstance();
		c.setTime(monthBegin());
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DATE, -1);
		
		return c.getTime();
	}

	/**
	 * 本月多少天
	 * @return
	 */
	public static int thisMonthTotalDay(){
		return (int)((monthEnd().getTime() - monthBegin().getTime())/millisecondsOfOneDay) +1;
	}
	public static int thisMonthLeftDay(){
		return (int)((monthEnd().getTime() - today().getTime())/millisecondsOfOneDay) +1;
	}
	
	public static void main(String args[]){
		System.out.println(today());
		System.out.println(monthBegin());
		System.out.println(monthEnd());
		System.out.println(thisMonthTotalDay());
		System.out.println(thisMonthLeftDay());
	}
	
}
