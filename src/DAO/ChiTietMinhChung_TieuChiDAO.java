package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.ChiTietTieuChiModel;
import models.MinhChungModel;
import models.TieuChiModel;
import app.DBConnection;

public class ChiTietMinhChung_TieuChiDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
	ChiTietTieuChiModel tcmc = new ChiTietTieuChiModel();
	MinhChungDAO mcDao = new MinhChungDAO();
	TieuChiDAO tcDao = new TieuChiDAO();
	

	public int insert(ChiTietTieuChiModel tcmc_tc)  {

		String sql = "insert into test.`chitietminhchung-tieuchi` (matieuchi, `maminhchung-TC` ) values(?, ?);";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tcmc_tc.getMaTieuChi().getMaTieuChi());
			ps.setInt(2, tcmc_tc.getMaMinhChung().getMaMinhChung());
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
	
	public int delete(int maTieuChi, int maMinhChung) {
		  String sql = "delete from test.`chitietminhchung-tieuchi` where matieuchi = ? and `maminhchung-TC` = ?";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maTieuChi);
			ps.setInt(2, maMinhChung);
			ps.execute();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public ChiTietTieuChiModel isHasMinhChung(int maTieuChi, int maMinhChung) {
		ChiTietTieuChiModel cttc = null;
		String sql = "select * from test.`chitietminhchung-tieuchi` where matieuchi = ? and `maminhchung-TC` = ? limit 1";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maTieuChi);
			ps.setInt(2, maMinhChung);
			rs = ps.executeQuery();
			ChiTietTieuChiModel response = new ChiTietTieuChiModel();
			while (rs.next()) {
				MinhChungModel mc = mcDao.get(rs.getInt(3));
				TieuChiModel tc = tcDao.get(rs.getInt(2));
				response.setMaChiTietTieuChi(rs.getInt(1));
				response.setMaMinhChung(mc);
				response.setMaTieuChi(tc);
				return cttc = response;
			} 
		} catch (Exception e) {
			System.out.print(e);
			return cttc = null;
			// TODO: handle exception
		}
		return cttc;
	}
	
}
