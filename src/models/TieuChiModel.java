package models;

public class TieuChiModel {
	private int maTieuChi;
	private String tenTieuChi;
	private String noiDungTieuChi;
	private TieuChuanModel tieuChuan;
	public TieuChiModel(int maTieuChi, String tenTieuChi, String noiDungTieuChi, TieuChuanModel tieuChuan) {
		super();
		this.maTieuChi = maTieuChi;
		this.tenTieuChi = tenTieuChi;
		this.noiDungTieuChi = noiDungTieuChi;
		this.tieuChuan = tieuChuan;
	}
	public TieuChiModel() {
		super();
	}
	public int getMaTieuChi() {
		return maTieuChi;
	}
	public void setMaTieuChi(int maTieuChi) {
		this.maTieuChi = maTieuChi;
	}
	public String getTenTieuChi() {
		return tenTieuChi;
	}
	public void setTenTieuChi(String tenTieuChi) {
		this.tenTieuChi = tenTieuChi;
	}
	public String getNoiDungTieuChi() {
		return noiDungTieuChi;
	}
	public void setNoiDungTieuChi(String noiDungTieuChi) {
		this.noiDungTieuChi = noiDungTieuChi;
	}
	public TieuChuanModel getTieuChuan() {
		return tieuChuan;
	}
	public void setTieuChuan(TieuChuanModel tieuChuan) {
		this.tieuChuan = tieuChuan;
	}
	
}
