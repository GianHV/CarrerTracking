package common;

/**
 * The class contains global variables and constants that are shared across the
 * entire application
 * 
 * @author Huynh Van Giang
 * @version 1.00
 */
public class Constants {

	/*
	 * Screen List
	 */

	// Screen for store student and graduation information
	public static final String T001_FORM = "/WEB-INF/views/T001.jsp";

	/*
	 * Url List
	 */

	// Url for StudentGraduationController
	public static final String T001_URL = "/T001";

	// EMPTY STRING
	public static final String EMPTY_STRING = "";

	/*
	 * Error Message
	 */

	// error message when user fill empty in SoCMND input
	public static final String T001_ERROR_MESSAGE1 = "SoCMND khong duoc de trong";

	// error message when user fill empty in MaTruong input
	public static final String T001_ERROR_MESSAGE2 = "Ma Truong khong duoc de trong";

	// error message when user fill empty in MaNganh input
	public static final String T001_ERROR_MESSAGE3 = "Ma Nganh khong duoc de trong";

	// error message when user fill empty in Ngay Tot Nghiep input
	public static final String T001_ERROR_MESSAGE4 = "Ngay tot nghiep khong hop le";
}
