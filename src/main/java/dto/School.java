package dto;

/**
 * Using for mapping with table TRUONG
 * 
 * @version 1.00
 * @author Huynh Van Giang
 */
public class School {

	// university code
	private String maTruong;

	// specific school name
	private String tenTruong;

	/**
	 * Constructor for this class
	 * 
	 * @param maTruong
	 * @param tenTruong
	 */
	public School(String maTruong, String tenTruong) {
		this.maTruong = maTruong;
		this.tenTruong = tenTruong;
	}

	/**
	 * @return string
	 */
	public String getMaTruong() {
		return maTruong;
	}

	/**
	 * @return string
	 */
	public String getTenTruong() {
		return tenTruong;
	}

}
