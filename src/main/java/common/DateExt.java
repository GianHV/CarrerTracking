package common;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/** The DateExt class provides utility methods for validating dates
 * 
 * @version 1.00
 * @author Huynh Van Giang
 */
public class DateExt {
	
	// Constant for the date format used in the validation (dd-MM-yyyy).
	private final static String DATE_FORMAT = "dd-MM-yyyy";
	
	/**
	 * Validates if the provided date string is in the correct format (dd-MM-yyyy) 
	 * and represents a valid date.
	 * 
	 * @param date The date string to be validated.
	 * @return true if the date is valid and in the correct format
	 * @exception ParseException: false if exception is happen
	 */
	public static boolean isValidDate(String date) {
		
		// if date is null or empty
		if(StringExt.isNullOrEmpty(date)) return false;
		
		try {
			// Create a SimpleDateFormat object with the specified DATE_FORMAT and disable lenient parsing.
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            
            // Try to parse the provided date. If parsing succeeds, the date is valid.
            df.parse(date);
            return true;
        } catch (ParseException e) {
        	// If parsing fails, the date is invalid.
            return false;
        }
	}
	
	/**
	 * Converts a given string representation of a date into a Date object.
	 * 
	 * @param data the date as a string in the specified format defined by DATE_FORMAT
	 * @return the Date object parsed from the input string, or null if the parsing fails
	 */
	public static Date convertStringToDate(String data) {
		DateFormat df = new SimpleDateFormat(DATE_FORMAT); 
		Date result = null;
		try {
			result = (Date) df.parse(data);
		} catch (ParseException e) {
		}
		
		return result;
	}
}
