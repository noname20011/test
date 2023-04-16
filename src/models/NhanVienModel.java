package models;

public class NhanVienModel {
	private int maNhanVien;
	private String tenNhanVien;
	private boolean isTruongPhong;
	private boolean quyenQuanTri;
	private PhongBanModel phongBan;
	
	public NhanVienModel(int maNhanVien, String tenNhanVien, boolean isTruongPhong, PhongBanModel phongBan, 
			boolean quyenQuanTri) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.isTruongPhong = isTruongPhong;
		this.quyenQuanTri = quyenQuanTri;
		this.phongBan = phongBan;
	}
	
	public NhanVienModel() {
		super();
	}

	public int getMaNhanVien() {
		return maNhanVien;
	}
	public boolean isQuyenQuanTri() {
		return quyenQuanTri;
	}
	public void setQuyenQuanTri(boolean quyenQuanTri) {
		this.quyenQuanTri = quyenQuanTri;
	}
	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public boolean isTruongPhong() {
		return isTruongPhong;
	}
	public void setTruongPhong(boolean isTruongPhong) {
		this.isTruongPhong = isTruongPhong;
	}
	public PhongBanModel getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(PhongBanModel phongBan) {
		this.phongBan = phongBan;
	}
	
}
