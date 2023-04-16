package models;

import java.sql.Date;

public class MergeMinhChungPropertyModel {
	private int maMinhChung;
	private String tenMinhChung;
	private String noiDung;
	private String tenTieuChi;
	private String tenPhongBan;
	private Date ngayTao;
	private Date ngayCungCap;
	public MergeMinhChungPropertyModel(int maMinhChung, String tenMinhChung, String noiDung, String tenTieuChi,
			String tenPhongBan, Date ngayTao, Date ngayCungCap) {
		super();
		this.maMinhChung = maMinhChung;
		this.tenMinhChung = tenMinhChung;
		this.noiDung = noiDung;
		this.tenTieuChi = tenTieuChi;
		this.tenPhongBan = tenPhongBan;
		this.ngayTao = ngayTao;
		this.ngayCungCap = ngayCungCap;
	}
	public MergeMinhChungPropertyModel() {
		super();
	}
	public int getMaMinhChung() {
		return maMinhChung;
	}
	public void setMaMinhChung(int maMinhChung) {
		this.maMinhChung = maMinhChung;
	}
	public String getTenMinhChung() {
		return tenMinhChung;
	}
	public void setTenMinhChung(String tenMinhChung) {
		this.tenMinhChung = tenMinhChung;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getTenTieuChi() {
		return tenTieuChi;
	}
	public void setTenTieuChi(String tenTieuChi) {
		this.tenTieuChi = tenTieuChi;
	}
	public String getTenPhongBan() {
		return tenPhongBan;
	}
	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public Date getNgayCungCap() {
		return ngayCungCap;
	}
	public void setNgayCungCap(Date ngayCungCap) {
		this.ngayCungCap = ngayCungCap;
	}
	
	
}
