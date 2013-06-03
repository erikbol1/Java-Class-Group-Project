package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		      Date date1;
		      date1 = new SimpleDateFormat("MM/dd/yy").parse("05/18/05");
		      System.out.println(date1);
		      Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse("05/18/2007");
		      System.out.println(date2);
		    } catch (ParseException e) {
		      e.printStackTrace();
		    }
		  }

}
