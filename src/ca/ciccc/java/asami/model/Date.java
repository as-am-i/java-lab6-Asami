package ca.ciccc.java.asami.model;

/**
 * Lab6 Date class
 * 
 * @author tanii_asami
 *
 */
public class Date {
	private int day;
	private int month;
	private int year;

	public static final int JANUARY = 1;
	public static final int FEBRUARY = 2;
	public static final int MARCH = 3;
	public static final int APRIL = 4;
	public static final int MAY = 5;
	public static final int JUNE = 6;
	public static final int JULY = 7;
	public static final int AUGUST = 8;
	public static final int SEPTEMBER = 9;
	public static final int OCTOBER = 10;
	public static final int NOVEMBER = 11;
	public static final int DECEMBER = 12;

	/**
	 * Date constructor
	 * 
	 * @param day
	 *            to be set
	 * @param month
	 *            to be set
	 * @param year
	 *            to be set
	 */
	public Date(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	/**
	 * setter for day
	 * 
	 * @param day
	 *            to be set
	 */
	public void setDay(int day) {
		if (isValidDate(day) == true) {
			this.day = day;
		}
	}

	/**
	 * getter for day
	 * 
	 * @return day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * setter for month
	 * 
	 * @param month
	 *            to be set
	 */
	public void setMonth(int month) {
		if ((month > 0) && (month < 13)) {
			this.month = month;
		}
	}

	/**
	 * getter for month
	 * 
	 * @return month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * getter for year
	 * 
	 * @param year
	 *            to be set
	 */
	public void setYear(int year) {
		if (year > 0) {
			this.year = year;
		}
	}

	/**
	 * getter for year
	 * 
	 * @return year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * calculate month code to be added
	 * 
	 * @return monthCode
	 */
	public int calculateMonthCode() {
		int monthCode = 0;
		switch (month) {
		case JANUARY:
			monthCode += 1;
			if (isLeapYear() == true) {
				monthCode -= 1;
			}
			break;
		case FEBRUARY:
			monthCode += 4;
			if (isLeapYear() == true) {
				monthCode -= 1;
			}
			break;
		case MARCH:
			monthCode += 4;
			break;
		case APRIL:
			monthCode += 0;
			break;
		case MAY:
			monthCode += 2;
			break;
		case JUNE:
			monthCode += 5;
			break;
		case JULY:
			monthCode += 0;
			break;
		case AUGUST:
			monthCode += 3;
			break;
		case SEPTEMBER:
			monthCode += 6;
			break;
		case OCTOBER:
			monthCode += 1;
			break;
		case NOVEMBER:
			monthCode += 4;
			break;
		case DECEMBER:
			monthCode += 6;
			break;
		default:
			monthCode += 0;
		}
		monthCode = checkSpecialYears(monthCode);
		return monthCode;
	}

	/**
	 * check if the date is in special years from 1600s to 2100s
	 * 
	 * @param monthCode
	 *            before check
	 * @return monthCode after check
	 */
	public int checkSpecialYears(int monthCode) {
		int firstTwoDigits = year / 100;
		switch (firstTwoDigits) {
		case 16:
			monthCode += 6;
			break;
		case 17:
			monthCode += 4;
			break;
		case 18:
			monthCode += 2;
			break;
		case 20:
			monthCode += 6;
			break;
		case 21:
			monthCode += 4;
			break;
		default:
			monthCode += 0;
		}
		return monthCode;
	}

	/**
	 * get the day of the week
	 * 
	 * @param mod
	 *            to be taken
	 * @return dayOfTheWeek
	 */
	public String checkDayOfTheWeek(int mod) {
		String dayOfTheWeek;
		switch (mod) {
		case 0:
			dayOfTheWeek = "Saturday";
			break;
		case 1:
			dayOfTheWeek = "Sunday";
			break;
		case 2:
			dayOfTheWeek = "Monday";
			break;
		case 3:
			dayOfTheWeek = "Tuesday";
			break;
		case 4:
			dayOfTheWeek = "Wednesday";
			break;
		case 5:
			dayOfTheWeek = "Thursday";
			break;
		case 6:
			dayOfTheWeek = "Friday";
			break;
		default:
			dayOfTheWeek = null;
		}
		return dayOfTheWeek;
	}

	/**
	 * private method to check if it's leap year or not
	 * 
	 * @return isLeapYear
	 */
	private boolean isLeapYear() {
		boolean isLeapYear = false;
		if (year % 400 == 0) {
			isLeapYear = true;
		} else if ((year % 4 == 0) && !((year % 100 == 0) && (year % 400 != 0))) {
			isLeapYear = true;
		} else {
			isLeapYear = false;
		}
		return isLeapYear;
	}

	/**
	 * check if it's valid date
	 * 
	 * @param day
	 *            to be checked
	 * @return valid
	 */
	public boolean isValidDate(int day) {
		boolean valid = false;
		switch (month) {
		case FEBRUARY:
			if (isLeapYear()) {
				valid = ((day <= 29) && (day > 0)) ? true : false;
			} else {
				valid = ((day <= 28) && (day > 0)) ? true : false;
			}
			break;
		case APRIL:
		case JUNE:
		case SEPTEMBER:
		case NOVEMBER:
			valid = (!(day > 30)) ? true : false;
			break;
		case JANUARY:
		case MARCH:
		case MAY:
		case JULY:
		case AUGUST:
		case OCTOBER:
		case DECEMBER:
			valid = (!(day > 31)) ? true : false;
			break;
		}
		return valid;
	}

	/**
	 * format the day of the week
	 * 
	 * @param dayOfTheWeek
	 *            to be printed
	 * @return dayOfTheWeekString
	 */
	public String printDayOfTheWeek(String dayOfTheWeek) {
		// month
		String monthString = null;
		switch (month) {
		case JANUARY:
			monthString = "January";
			break;
		case FEBRUARY:
			monthString = "February";
			break;
		case MARCH:
			monthString = "March";
			break;
		case APRIL:
			monthString = "April";
			break;
		case MAY:
			monthString = "May";
			break;
		case JUNE:
			monthString = "June";
			break;
		case JULY:
			monthString = "July";
			break;
		case AUGUST:
			monthString = "August";
			break;
		case SEPTEMBER:
			monthString = "September";
			break;
		case OCTOBER:
			monthString = "October";
			break;
		case NOVEMBER:
			monthString = "November";
			break;
		case DECEMBER:
			monthString = "December";
			break;
		}

		// day
		String dayString = null;
		if (day < 10) {
			dayString = "0" + Integer.toString(day);
		} else {
			dayString = Integer.toString(day);
		}

		// (example) September 07, 1999 was on Tuesday.
		String dayOfTheWeekString = monthString + " " + dayString + ", " + Integer.toString(year) + " was on "
				+ dayOfTheWeek + ".";
		return dayOfTheWeekString;
	}

	/**
	 * calculate and return the name of the day of the week
	 * 
	 * @return dayOfTheWeekString
	 */
	public String getDayOfTheWeek() {
		String dayOfTheWeekString = null;
		if ((month != 0) && (day != 0)) {
			// step1
			int lastTwoDigits = year % 100;
			int twelves = lastTwoDigits / 12;

			// step2
			int remainder = lastTwoDigits - twelves * 12;

			// step3
			int fours = remainder / 4;

			// step4
			int dateCode = day;

			// step5
			int monthCode = calculateMonthCode();

			// step6
			int sum = twelves + remainder + fours + dateCode + monthCode;
			int mod = sum % 7;

			// This is your day of the week
			String dayOfTheWeek = checkDayOfTheWeek(mod);

			// format
			dayOfTheWeekString = printDayOfTheWeek(dayOfTheWeek);
		} else {
			dayOfTheWeekString = "It is NOT a valid date!";
		}
		return dayOfTheWeekString;
	}

	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
}