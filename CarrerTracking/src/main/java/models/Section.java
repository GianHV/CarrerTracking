package models;

public class Section {
	private String MaNganh;
	private String tenNganh;
	private String loaiNganh;
	public String getMaNganh() {
		return MaNganh;
	}
	public void setMaNganh(String maNganh) {
		MaNganh = maNganh;
	}
	public String getTenNganh() {
		return tenNganh;
	}
	public void setTenNganh(String tenNganh) {
		this.tenNganh = tenNganh;
	}
	public String getLoaiNganh() {
		return loaiNganh;
	}
	public void setLoaiNganh(String loaiNganh) {
		this.loaiNganh = loaiNganh;
	}
}
