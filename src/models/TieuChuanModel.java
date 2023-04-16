package models;

public class TieuChuanModel {
	private int maTieuChuan;
	private String tenTieuChuan;
	private String noiDung;
	public TieuChuanModel(int maTieuChuan, String tenTieuChuan, String noiDung) {
		super();
		this.maTieuChuan = maTieuChuan;
		this.tenTieuChuan = tenTieuChuan;
		this.noiDung = noiDung;
	}
	public TieuChuanModel() {
		super();
	}
	public int getMaTieuChuan() {
		return maTieuChuan;
	}
	public void setMaTieuChuan(int maTieuChuan) {
		this.maTieuChuan = maTieuChuan;
	}
	public String getTenTieuChuan() {
		return tenTieuChuan;
	}
	public void setTenTieuChuan(String tenTieuChuan) {
		this.tenTieuChuan = tenTieuChuan;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	
}
