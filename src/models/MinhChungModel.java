package models;

public class MinhChungModel {
	private int maMinhChung;
	private String tenMinhChung;
	private String noiDung;
	public MinhChungModel() {
		super();
	}
	
	public MinhChungModel(int maMinhChung, String tenMinhChung, String noiDung) {
		super();
		this.maMinhChung = maMinhChung;
		this.tenMinhChung = tenMinhChung;
		this.noiDung = noiDung;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
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
}
