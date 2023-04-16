package models;

public class ChiTietTieuChiModel {
	private int maChiTietTieuChi;
	private TieuChiModel maTieuChi;
	private MinhChungModel maMinhChung;
	public ChiTietTieuChiModel(int maChiTietTieuChi, TieuChiModel maTieuChi, MinhChungModel maMinhChung) {
		super();
		this.maChiTietTieuChi = maChiTietTieuChi;
		this.maTieuChi = maTieuChi;
		this.maMinhChung = maMinhChung;
	}
	
	public ChiTietTieuChiModel() {
		super();
	}

	public int getMaChiTietTieuChi() {
		return maChiTietTieuChi;
	}
	public void setMaChiTietTieuChi(int maChiTietTieuChi) {
		this.maChiTietTieuChi = maChiTietTieuChi;
	}
	public TieuChiModel getMaTieuChi() {
		return maTieuChi;
	}
	public void setMaTieuChi(TieuChiModel maTieuChi) {
		this.maTieuChi = maTieuChi;
	}
	public MinhChungModel getMaMinhChung() {
		return maMinhChung;
	}
	public void setMaMinhChung(MinhChungModel maMinhChung) {
		this.maMinhChung = maMinhChung;
	}
	
}
