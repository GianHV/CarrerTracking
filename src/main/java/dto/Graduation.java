package dto;

/**
 * Using for mapping with table tot_nghiep
 * 
 * @author Huynh Van Giang
 * @version 1.00
 *
 */
public class Graduation {

	// information identity number of student
	private String soCMND;

	// university code
	private String maTruong;

	// university major code
	private String maNganh;

	// level of education completed
	private String heTN;

	// date of education completed
	private String ngayTN;

	// ranking of a student performance
	private String loaiTN;

	/**
	 * @return string
	 */
	public String getSoCMND() {
		return soCMND;
	}

	/**
	 * @param soCMND: string
	 */
	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	/**
	 * @return string
	 */
	public String getMaTruong() {
		return maTruong;
	}

	/**
	 * @param maTruong: string
	 */
	public void setMaTruong(String maTruong) {
		this.maTruong = maTruong;
	}

	/**
	 * @return string
	 */
	public String getMaNganh() {
		return maNganh;
	}

	/**
	 * @param maNganh: string
	 */
	public void setMaNganh(String maNganh) {
		this.maNganh = maNganh;
	}

	/**
	 * @return string
	 */
	public String getHeTN() {
		return heTN;
	}

	/**
	 * @param heTN: string
	 */
	public void setHeTN(String heTN) {
		this.heTN = heTN;
	}

	/**
	 * @return string
	 */
	public String getNgayTN() {
		return ngayTN;
	}

	/**
	 * @param ngayTN: string
	 */
	public void setNgayTN(String ngayTN) {
		this.ngayTN = ngayTN;
	}

	/**
	 * @return string
	 */
	public String getLoaiTN() {
		return loaiTN;
	}

	/**
	 * @param loaiTN: string
	 */
	public void setLoaiTN(String loaiTN) {
		this.loaiTN = loaiTN;
	}
}
