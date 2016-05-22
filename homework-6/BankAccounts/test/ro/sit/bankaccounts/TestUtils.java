package ro.sit.bankaccounts;

import java.util.Calendar;
import java.util.Date;

public class TestUtils {

	public static Date getDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month + 1, day);
		return calendar.getTime();
	}
}
