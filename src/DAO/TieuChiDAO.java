package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import app.DBConnection;
import models.TieuChiModel;
import models.TieuChuanModel;



public class TieuChiDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
	TieuChiModel tl = new TieuChiModel();
	final TieuChuanDAO tcdao = new TieuChuanDAO();
	public int insert(TieuChiModel tl) {
		
		 String sql ="insert into test.tieuchi (tentieuchi, noidung, matieuchuan) values(?,?,?)";
	        try {
	            conn = DBConnection.getMySQLConnection();
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, tl.getTenTieuChi());
	            ps.setString(2, tl.getNoiDungTieuChi());
	            ps.setInt(3, tl.getTieuChuan().getMaTieuChuan());
	            ps.executeUpdate();
	            return 1;
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	        return 0;
	 }
	
	public int update(TieuChiModel tl) {
		 String sql = "update test.tieuchi set tentieuchi = ?, noidung = ?, matieuchuan = ? where  idtieuchi = ?";
	        try {
	        	conn = DBConnection.getMySQLConnection();
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, tl.getTenTieuChi());
	            ps.setString(2, tl.getNoiDungTieuChi());
	            ps.setInt(3, tl.getTieuChuan().getMaTieuChuan());
	            ps.setInt(4, tl.getMaTieuChi());
	            ps.executeUpdate();
	            return 1;
	        }catch (Exception e) {
	            // TODO: handle exception
	        }
	        return 0;
	}
	
	public int delete(int idMinhChung) {
		  String sql = "delete from test.tieuchi where idtieuchi = ?";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idMinhChung);
			ps.execute();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public int deleteByIdTieuChuan(int idMinhChung) {
		  String sql = "delete from test.tieuchi where matieuchuan = ?";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idMinhChung);
			ps.execute();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public List<TieuChiModel> getAll() {
		List<TieuChiModel> tl = new ArrayList<TieuChiModel>();
		String sql = "Select * from test.tieuchi";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				TieuChuanModel tcmodel = tcdao.get(rs.getInt(4));
				tl.add(new TieuChiModel(rs.getInt(1), rs.getString(2), rs.getString(3), tcmodel));
			}
		} catch (Exception e) {

		}
		return tl;
	}
	
	public TieuChiModel get(int id) {
		String sql = "Select * from test.tieuchi where idtieuchi =?";
		
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				TieuChiModel tl = new TieuChiModel();
				TieuChuanModel tcmodel = tcdao.get(rs.getInt(4));
				tl.setMaTieuChi(rs.getInt(1));
				tl.setTenTieuChi(rs.getString(2));
				tl.setNoiDungTieuChi(rs.getString(3));
				tl.setTieuChuan(tcmodel);
				return tl;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public TieuChiModel getByName(String name) {
		String sql = "Select * from test.tieuchi where tentieuchi = ? limit 1";
		
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				TieuChiModel tl = new TieuChiModel();
				TieuChuanModel tcmodel = tcdao.get(rs.getInt(4));
				tl.setMaTieuChi(rs.getInt(1));
				tl.setTenTieuChi(rs.getString(2));
				tl.setNoiDungTieuChi(rs.getString(3));
				tl.setTieuChuan(tcmodel);
				return tl;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<TieuChiModel> getbyname(String name)  {
		List<TieuChiModel> tl = new ArrayList<TieuChiModel>();
//		String sql = "Select * from qlchs.theloai where TenLT = ?";
		String sql = "Select * from test.tieuchi where ( tentieuchi like '%' ? '%' )";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				TieuChuanModel tcmodel = tcdao.get(rs.getInt(4));
				tl.add(new TieuChiModel(rs.getInt(1), rs.getString(2), rs.getString(3), tcmodel));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tl;
	}

	public TieuChiModel getBySach(int id)  {
		String sql = "SELECT tieuchi.* FROM test.tieuchi inner join test.tieuchuan on test.tieuchi.matieuchuan = test.tieuchuan.idtieuchuan where (test.tieuchi.matieuchuan = ?)";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				TieuChiModel tl = new TieuChiModel();
				TieuChuanModel tcmodel = tcdao.get(rs.getInt(4));
				tl.setMaTieuChi(rs.getInt(1));
				tl.setTenTieuChi(rs.getString(2));
				tl.setNoiDungTieuChi(rs.getString(3));
				tl.setTieuChuan(tcmodel);
				return tl;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	public List<SachModel> getByMaSach(int id) {
//		List<SachModel> sach = new ArrayList<SachModel>();
//
//		String sql = "SELECT sach.* FROM qlchs.sach inner join qlchs.theloai on qlchs.sach.MATL = qlchs.theloai.MATL where (qlchs.sach.MATL = ?)";
//		try {
//			conn = DBConnection.getMySQLConnection();
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				sach.add(new SachModel(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
//			}
//		} catch (Exception e) {
//
//		}
//		return sach;
//	}
}
