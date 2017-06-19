package b;


import java.text.DateFormat;  
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
  
public class DateDistance {  
      
    /** 
     * ����ʱ��֮������������� 
     * @param one ʱ����� 1�� 
     * @param two ʱ����� 2�� 
     * @return ������� 
     */  
    public static long getDistanceDays(String str1, String str2) throws Exception{  
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
        Date one;  
        Date two;  
        long days=0;  
        int i=0;
        try {  
            one = df.parse(str1);  
            two = df.parse(str2);  
            long time1 = one.getTime();  
            long time2 = two.getTime();  
            long diff ;  
            if(time1<time2) {  
                diff = time2 - time1;  
                i=0;
            } else {  
                diff = time1 - time2;  
                i=1;
            }  
            days = diff / (1000 * 60 * 60 * 24);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        if(i==0){
        	return days; 
        }
        else{
        	return -days; 
        }
    }
    static String bdate;
    public static void main(String[] args) throws Exception{
    	String a[]={"A342"};
    	String b=a[0].substring(1,3);
    	String c=a[0].substring(1);
    	System.out.println(b+c);
    }

      
    /** 
     * ����ʱ����������������Сʱ���ٷֶ����� 
     * @param str1 ʱ����� 1 ��ʽ��1990-01-01 12:00:00 
     * @param str2 ʱ����� 2 ��ʽ��2009-01-01 12:00:00 
     * @return long[] ����ֵΪ��{��, ʱ, ��, ��} 
     */  
    public static long[] getDistanceTimes(String str1, String str2) {  
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date one;  
        Date two;  
        long day = 0;  
        long hour = 0;  
        long min = 0;  
        long sec = 0;  
        try {  
            one = df.parse(str1);  
            two = df.parse(str2);  
            long time1 = one.getTime();  
            long time2 = two.getTime();  
            long diff ;  
            if(time1<time2) {  
                diff = time2 - time1;  
            } else {  
                diff = time1 - time2;  
            }  
            day = diff / (24 * 60 * 60 * 1000);  
            hour = (diff / (60 * 60 * 1000) - day * 24);  
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);  
            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        long[] times = {day, hour, min, sec};  
        return times;  
    }  
  
    /** 
     * ����ʱ����������������Сʱ���ٷֶ����� 
     * @param str1 ʱ����� 1 ��ʽ��1990-01-01 12:00:00 
     * @param str2 ʱ����� 2 ��ʽ��2009-01-01 12:00:00 
     * @return String ����ֵΪ��xx��xxСʱxx��xx�� 
     */  
    public static String getDistanceTime(String str1, String str2) {  
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date one;  
        Date two;  
        long day = 0;  
        long hour = 0;  
        long min = 0;  
        long sec = 0;  
        try {  
            one = df.parse(str1);  
            two = df.parse(str2);  
            long time1 = one.getTime();  
            long time2 = two.getTime();  
            long diff ;  
            if(time1<time2) {  
                diff = time2 - time1;  
            } else {  
                diff = time1 - time2;  
            }  
            day = diff / (24 * 60 * 60 * 1000);  
            hour = (diff / (60 * 60 * 1000) - day * 24);  
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);  
            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        return day + "��" + hour + "Сʱ" + min + "��" + sec + "��";  
    }  
}  