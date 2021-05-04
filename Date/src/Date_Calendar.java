
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Date_Calendar {
	public static void main(String[] args) throws ParseException  {
												// 날짜가 요 형태대로 바뀌어서 출력.
		// 현재시간구하기
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);										// 현재날짜출력.
		
		// 밀리세컨드로 고유값 주는거 가능.
		System.out.println(Calendar.getInstance().getTimeInMillis());
		
		// 문자열 캘린더로 바꾸기.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2020-10-01"); // 예외처리, try catch  /  throws
		Calendar cal = sdf.getCalendar();
		
		System.out.println(cal.getTime());
		
		
		
		// 날짜 차이 구하기 - 무식한 방법
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = sdf2.parse("2020-11-21");
		Calendar cal2 = sdf2.getCalendar();
		
		System.out.println(cal.getTime());
		System.out.println(cal2.getTime());
		
		long time1 = cal.getTimeInMillis();
		long time2 = cal2.getTimeInMillis();
		
		long diffTime = time1 - time2;
		long days = diffTime / 1000 / 60 / 60 / 24;
		System.out.println(days);
		
	}

}
