import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Anniversary {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = sdf2.parse("2021-10-31");
		Calendar holloween = sdf2.getCalendar();
		System.out.println(holloween.getTimeInMillis());
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		System.out.println(Calendar.getInstance().getTimeInMillis());
		long hol = holloween.getTimeInMillis();
		long today = Calendar.getInstance().getTimeInMillis();

		long diffTime = hol - today;
		long days = diffTime / 1000 / 60 / 60 / 24;
		System.out.println(days);
		
		// 하루가 빠져서 나온다.... 
		LocalDate date = LocalDate.now().plusDays(179);
		System.out.println(date);
		
		
		
	}
}
