package ca.ciccc.java.asami.model;

public class Date {
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	public void setDay(int day) {
		if (isValidDate(day) == true) {
			this.day = day;
		}
	}

	public int getDay() {
		return day;
	}

	public void setMonth(int month) {
		if ((month > 0) && (month < 13)) {
			this.month = month;
		}
	}

	public int getMonth() {
		return month;
	}

	public void setYear(int year) {
		if (year > 0) {
			this.year = year;
		}
	}

	public int getYear() {
		return year;
	}

	public int calculateMonthCode() {
		int monthCode = 0;
		switch (month) {
		case 1:
			monthCode += 1;
			if (isLeapYear() == true) {
				monthCode -= 1;
			}
			break;
		case 2:
			monthCode += 4;
			if (isLeapYear() == true) {
				monthCode -= 1;
			}
			break;
		case 3:
			monthCode += 4;
			break;
		case 4:
			monthCode += 0;
			break;
		case 5:
			monthCode += 2;
			break;
		case 6:
			monthCode += 5;
			break;
		case 7:
			monthCode += 0;
			break;
		case 8:
			monthCode += 3;
			break;
		case 9:
			monthCode += 6;
			break;
		case 10:
			monthCode += 1;
			break;
		case 11:
			monthCode += 4;
			break;
		case 12:
			monthCode += 6;
			break;
		default:
			monthCode += 0;
		}
		monthCode = checkSpecialYears(monthCode);
		return monthCode;
	}

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

	private boolean isLeapYear() {
		if (year % 400 == 0) {
			return true;
		} else if ((year % 4 == 0) && !((year % 100 == 0) && (year % 400 != 0))) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isValidDate(int day) {
		boolean valid = false;
		switch (month) {
		case 2:
			if (isLeapYear()) {
				valid = ((day <= 29) && (day > 0)) ? true : false;
			} else {
				valid = ((day <= 28) && (day > 0)) ? true : false;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			valid = (!(day > 30)) ? true : false;
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			valid = (!(day > 31)) ? true : false;
			break;
		}
		return valid;
	}

	public String printDayOfTheWeek(String dayOfTheWeek) {
		String monthString = null;
		switch (month) {
		case 1:
			monthString = "January";
			break;
		case 2:
			monthString = "February";
			break;
		case 3:
			monthString = "March";
			break;
		case 4:
			monthString = "April";
			break;
		case 5:
			monthString = "May";
			break;
		case 6:
			monthString = "June";
			break;
		case 7:
			monthString = "July";
			break;
		case 8:
			monthString = "August";
			break;
		case 9:
			monthString = "September";
			break;
		case 10:
			monthString = "October";
			break;
		case 11:
			monthString = "November";
			break;
		case 12:
			monthString = "December";
			break;
		}

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

	public String getDayOfTheWeek() {
		// System.out.println("" + year + month + day);
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
			String dayOfTheWeekString = printDayOfTheWeek(dayOfTheWeek);
			return dayOfTheWeekString;

		} else {
			String invalidMessage = "It is NOT a valid date!";
			return invalidMessage;
		}

	}

	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}

	public static void main(String[] args) {
		Date date1 = new Date(29, 2, 2017);
		System.out.println(date1.getDayOfTheWeek());

		Date date2 = new Date(29, 2, 2016);
		System.out.println(date2.getDayOfTheWeek());

		Date date3 = new Date(7, 9, 1999);
		System.out.println(date3.getDayOfTheWeek());
	}
}