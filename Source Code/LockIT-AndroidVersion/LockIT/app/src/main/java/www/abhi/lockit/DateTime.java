package www.abhi.lockit;
import java.util.Date;
public class DateTime {
public static int DateTimeToInt(int period) {
	Date d=new Date();
	String timeString;
	@SuppressWarnings("deprecation")
	int currentHour=d.getHours();
	@SuppressWarnings("deprecation")
	int currentMin=d.getMinutes();
	
	int time=13*(currentMin/period);
	timeString=Integer.toOctalString(currentHour)+""+Integer.toOctalString(time);
	
	String dateString;
	@SuppressWarnings("deprecation")
	int currentDate=d.getDate();
	@SuppressWarnings("deprecation")
	int currentMonth=d.getMonth();
	dateString=currentMonth+""+currentDate;
	
	String combinedDateAndTime=dateString+timeString;
	int dateTimeInt=0;
	int num=1;
	int k=3;
	for(int i=0;i<combinedDateAndTime.length();i++)
	{
		if(time%2==0) {
			dateTimeInt+=Integer.parseInt(combinedDateAndTime.substring(i,i+1))+num;
			num+=k*i;
			k=2;
		}
		else {
			dateTimeInt+=Integer.parseInt(combinedDateAndTime.substring(i,i+1))+num;
			num+=k*i;
			k=3;
		}
	}
	return dateTimeInt;
}
}
