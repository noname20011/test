package models;

public class PhongBanModel {
	private int maPhongBan;
	private String tenPhongBan;
	public PhongBanModel(int maPhongBan, String tenPhongBan) {
		super();
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
	}
	public int getMaPhongBan() {
		return maPhongBan;
	}
	public void setMaPhongBan(int maPhongBan) {
		this.maPhongBan = maPhongBan;
	}
	public String getTenPhongBan() {
		return tenPhongBan;
	}
	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}
	public PhongBanModel() {
		super();
	}
	
}
