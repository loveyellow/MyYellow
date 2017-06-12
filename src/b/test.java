package b;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import b.isDate;

public class test {
	private static String date1=null;
	private static Date d1;
	private static Date d2 ;
	public static boolean isValidDate(String sDate) {

	     String datePattern1 = "\\d{4}-\\d{2}-\\d{2}";
	     String datePattern2 = "^((\\d{2}(([02468][048])|([13579][26]))"
	             + "[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|"
	             + "(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?"
	             + "((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?("
	             + "(((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?"
	             + "((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
	     if ((sDate != null)) {
	         Pattern pattern = Pattern.compile(datePattern1);
	         Matcher match = pattern.matcher(sDate);
	         if (match.matches()) {
	             pattern = Pattern.compile(datePattern2);
	             match = pattern.matcher(sDate);
	             return match.matches();
	         }
	         else {
	             return false;
	         }
	     }
	     return false;
	}
	public static void main(String[] args){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.print("请输入日期：");
		Scanner sc=new Scanner(System.in);
		date1=sc.next();
		if(isValidDate(date1)){
		}
		else{
			System.out.println("日期输入错误，请重新输入！");
			System.exit(0);
		}
		try {
			d1 = df.parse(date1);
			Calendar c = Calendar.getInstance();
		    c.setTime(d1);
		    int year1=c.get(Calendar.YEAR);
		    int month1 = c.get(Calendar.MONTH)+1;
		    int day1 = c.get(Calendar.DAY_OF_MONTH);
		    isDate.getFirstSundayOfMonth(year1,month1,day1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
