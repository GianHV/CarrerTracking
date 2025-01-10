package dto;

/**
 * Using for mapping with table NGANH
 * 
 * @author Huynh Van Giang
 * @version 1.00
 */
public class Section {

	// university major code
	private String maNganh;

	// specific academic programs
	private String tenNganh;

	/**
	 * Constructor for this class
	 * 
	 * @param maNganh
	 * @param tenNganh
	 */
	public Section(String maNganh, String tenNganh) {
		this.maNganh = maNganh;
		this.tenNganh = tenNganh;
	}

	/**
	 * @return string
	 */
	public String getMaNganh() {
		return maNganh;
	}

	/**
	 * @return string
	 */
	public String getTenNganh() {
		return tenNganh;
	}

}
