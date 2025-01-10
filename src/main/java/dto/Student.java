package dto;

/**
 * Using for mapping with table SINHVIEN
 * 
 * @version 1.00
 * @author Huynh Van Giang
 */
public class Student {
	
	// information identity number of student
	private String soCMND;
	
	// name of student
	private String hoTen;
	
	// email of student
	private String email;
	
	// phone of student
	private String soDT;
	
	// address of student
	private String diaChi;

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
	public String getHoTen() {
		return hoTen;
	}

	/**
	 * @param hoTen: string
	 */
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	/**
	 * @return string
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email: string
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return string
	 */
	public String getSoDT() {
		return soDT;
	}

	/**
	 * @param soDT: string
	 */
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	/**
	 * @return string
	 */
	public String getDiaChi() {
		return diaChi;
	}

	/**
	 * @param diaChi: string
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

}
