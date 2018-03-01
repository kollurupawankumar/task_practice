package com.java.learning.collections;

/**
 * Hello world!
 *
 */
public class App 
{
	public enum WeekDay {
		MONDAY("abc"), 
		TUESDAY("Tuesday"), 
		WEDNESDAY("Wednesday"), 
		THURSDAY("Thursday"), 
		FRIDAY("Friday"), 
		SATURDAY("Saturday"),
		SUNDAY("Sunday");

		String val;
		
		WeekDay(String val) {
			this.val = val;
		}

		public String getVal(String week) {
			return WeekDay.valueOf(week).val;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(WeekDay.valueOf("MONDAY").getVal("MONDAY"));
	}
}
