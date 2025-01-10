package common;

/**
 * Utility class for handling common String operations.
 * 
 * @author Huynh Van Giang
 * @version 1.00
 */
public class StringExt {
	
	 /**
     * Checks whether a given String is null, empty, or contains only whitespace,
     * or if it is equal to the literal String "null" (case-insensitive) after trimming.
     * 
     * @param input the String to be checked
     * @return true if the input String is null, empty, or represents "null" after trimming; false otherwise
     */
	public static boolean isNullOrEmpty(String input) {
		return input == null || input.trim().isEmpty() || input.trim().equals("null");
	}
}
