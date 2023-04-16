package models;

public class TaiKhoanModel {
	private int MaTK;
	private String TaiKhoan;
	private String MatKhau;
	private String Quyen;
	private int MaNV;
	public TaiKhoanModel() {
		super();
	}
	public TaiKhoanModel(int maTK, String taiKhoan, String matKhau, String quyen, int maNV) {
		super();
		MaTK = maTK;
		TaiKhoan = taiKhoan;
		MatKhau = matKhau;
		Quyen = quyen;
		MaNV = maNV;
	}
	public int getMaTK() {
		return MaTK;
	}
	public void setMaTK(int maTK) {
		MaTK = maTK;
	}
	public String getTaiKhoan() {
		return TaiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		TaiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public String getQuyen() {
		return Quyen;
	}
	public void setQuyen(String quyen) {
		Quyen = quyen;
	}
	public int getMaNV() {
		return MaNV;
	}
	public void setMaNV(int maNV) {
		MaNV = maNV;
	}
	@Override
	public String toString() {
		return "TaiKhoan [MaTK=" + MaTK + ", TaiKhoan=" + TaiKhoan + ", MatKhau=" + MatKhau + ", Quyen=" + Quyen
				+ ", MaNV=" + MaNV + "]";
	}
	
}
