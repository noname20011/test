package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.DBConnection;
import models.ChiTietMinhChung_PhongBanModel;



public class ChiTietMinhChung_PhongBanDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ChiTietMinhChung_PhongBanModel tcmc_pb = new ChiTietMinhChung_PhongBanModel();
	

	public int insert(ChiTietMinhChung_PhongBanModel tcmc_pb)  {

		String sql = "insert into test.`chitietminhchung-phongban` (maminhchung, maphongban, ngaytao, ngaycungcap ) values(?,?,?,?);";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tcmc_pb.getMaMinhChung().getMaMinhChung());
			ps.setInt(2, tcmc_pb.getMaPhongBan().getMaPhongBan());
			ps.setDate(3, tcmc_pb.getNgayTao());
			ps.setDate(4, tcmc_pb.getNgayCungCap());
			ps.executeUpdate();
			return 1;
		} catch (Exception e) {
			System.out.print(e);
			// TODO: handle exception
		}
		return 0;
	}

//	public int update(MinhChungModel mc, int maTieuChi)  {
//		String sql = "update test.minhchung set tenminhchung = ?, noidung = ?, matieuchi = ? where maminhchung = ?;";
//		try {
//			conn = DBConnection.getMySQLConnection();
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, mc.getTenMinhChung());
//			ps.setString(2, mc.getNoiDung());
//			ps.setInt(3, maTieuChi);			
//			ps.setInt(4, mc.getMaMinhChung());
//
//			ps.executeUpdate();
//			return 1;
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return 0;
//	}
	
	public int delete(int maMinhChung, int maPhongBan) {
		  String sql = "delete from test.`chitietminhchung-phongban` where maminhchung = ? and maphongban = ?";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maMinhChung);
			ps.setInt(2, maPhongBan);
			ps.execute();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public int isHasMinhChung(int maMinhChung, int maPhongBan) {
		String sql = "select * from test.`chitietminhchung-phongban` where maminhchung = ? and maphongban = ? limit 1";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maMinhChung);
			ps.setInt(2, maPhongBan);
			ps.execute();
			return 1;
		} catch (Exception e) {
			System.out.print(e);
			// TODO: handle exception
		}
		return 0;
	}
	
}
