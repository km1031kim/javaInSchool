import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DDay {
	Calendar dDay;
	int days;
	
	DDay(String dateString){
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse("2020-10-01");
			this.dDay = sdf.getCalendar();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			
		} // 예외처리, try catch  /  throws
	}
	
		public void calculationDDay() {
			long now = Calendar.getInstance().getTimeInMillis();
			long dDayTime = dDay.getTimeInMillis();
			
			long diffTime = now - dDayTime;
			this.days = (int)Math.ceil((double)diffTime / 1000 / 60 / 60 / 24);
	}
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "D-day : " + this.days;
	}

}
