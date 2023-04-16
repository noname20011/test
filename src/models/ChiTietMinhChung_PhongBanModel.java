package models;

import java.sql.Date;

public class ChiTietMinhChung_PhongBanModel {
	private int maChiTietMinhChung_PhongBan;
	private MinhChungModel maMinhChung;
	private PhongBanModel maPhongBan;
	private Date ngayCungCap;
	private Date ngayTao;
	public ChiTietMinhChung_PhongBanModel(int maChiTietMinhChung_PhongBan, MinhChungModel maMinhChung,
			PhongBanModel maPhongBan, Date ngayCungCap, Date ngayTao) {
		super();
		this.maChiTietMinhChung_PhongBan = maChiTietMinhChung_PhongBan;
		this.maMinhChung = maMinhChung;
		this.maPhongBan = maPhongBan;
		this.ngayCungCap = ngayCungCap;
		this.ngayTao = ngayTao;
	}
	
	public ChiTietMinhChung_PhongBanModel() {
		super();
	}

	public int getMaChiTietMinhChung_PhongBan() {
		return maChiTietMinhChung_PhongBan;
	}
	public void setMaChiTietMinhChung_PhongBan(int maChiTietMinhChung_PhongBan) {
		this.maChiTietMinhChung_PhongBan = maChiTietMinhChung_PhongBan;
	}
	public MinhChungModel getMaMinhChung() {
		return maMinhChung;
	}
	public void setMaMinhChung(MinhChungModel maMinhChung) {
		this.maMinhChung = maMinhChung;
	}
	public PhongBanModel getMaPhongBan() {
		return maPhongBan;
	}
	public void setMaPhongBan(PhongBanModel maPhongBan) {
		this.maPhongBan = maPhongBan;
	}
	public Date getNgayCungCap() {
		return ngayCungCap;
	}
	public void setNgayCungCap(Date ngayCungCap) {
		this.ngayCungCap = ngayCungCap;
	}
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	
}
