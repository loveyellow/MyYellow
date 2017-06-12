package b;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class isDate {
	private static final boolean False = false;
	@SuppressWarnings("unused")
	public static void getFirstSundayOfMonth(int year, int month,int day)
	{
		Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.YEAR, year);
	    cal.set(Calendar.MONTH, month - 1);
	    int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	    cal.set(Calendar.DATE, day);
		cal.add(Calendar.DATE, -1);
	    int year1 = cal.get(Calendar.YEAR);    //获取年
	    int month1 = cal.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
	    int day1 = cal.get(Calendar.DAY_OF_MONTH);    //获取当前天数
	    System.out.println("该日期的前一天为："+year1+"-"+month1+"-"+day1);
	}
}
