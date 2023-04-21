package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import app.DBConnection;
import models.MergeMinhChungPropertyModel;
import models.MinhChungModel;



public class MinhChungDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
	MinhChungModel mc = new MinhChungModel();
	

	public int insert(MinhChungModel mc)  {

		String sql = "insert into test.minhchung (tenminhchung, noidung ) values(?, ?);";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mc.getTenMinhChung());
			ps.setString(2, mc.getNoiDung());
			ps.executeUpdate();
			return 1;
		} catch (Exception e) {
			System.out.print(e);
			// TODO: handle exception
		}
		return 0;
	}

	public int update(MinhChungModel mc, int maTieuChi)  {
		String sql = "update test.minhchung set tenminhchung = ?, noidung = ? where idminhchung = ?;";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mc.getTenMinhChung());
			ps.setString(2, mc.getNoiDung());			
			ps.setInt(3, mc.getMaMinhChung());
			ps.executeUpdate();
			return 1;
		} catch (Exception e) {
			System.out.print(e);
			// TODO: handle exception
		}
		return 0;
	}
	
	public int delete(int maMinhChung) {
		  String sql = "delete from test.minhchung where idminhchung = ?";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maMinhChung);
			ps.execute();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public MinhChungModel get(int id) {
		String sql = "Select * from test.minhchung where idminhchung =?";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				MinhChungModel pb = new MinhChungModel();
				pb.setMaMinhChung(rs.getInt(1));
				pb.setTenMinhChung(rs.getString(2));
				pb.setNoiDung(rs.getString(2));
				return pb;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<MergeMinhChungPropertyModel> getAll() {
		List<MergeMinhChungPropertyModel> merge = new ArrayList<MergeMinhChungPropertyModel>();

		String sql = "select idminhchung, tenminhchung, minhchung.noidung, tentieuchi, tenphongban, ngaytao, ngaycungcap "
				+ "from test.minhchung left join test.`chitietminhchung-tieuchi` on minhchung.idminhchung = `chitietminhchung-tieuchi`.`maminhchung-TC` "
				+ "left join test.`chitietminhchung-phongban` on minhchung.idminhchung = `chitietminhchung-phongban`.`maminhchung`"
				+ "left join test.tieuchi on tieuchi.idtieuchi = `chitietminhchung-tieuchi`.matieuchi "
				+ "left join test.phongban on phongban.idphongban = `chitietminhchung-phongban`.maphongban;";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				merge.add(new MergeMinhChungPropertyModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getDate(7)));
			}
		} catch (Exception e) {

		}
		return merge;
	}
	
	public List<MinhChungModel> getLast() {
		List<MinhChungModel> mcl = new ArrayList<MinhChungModel>();

		String sql = "SELECT * FROM test.minhchung ORDER BY idminhchung DESC LIMIT 1;";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				mcl.add(new MinhChungModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {
			System.out.print(e);
		}
		return mcl;
	}
	
	public List<MergeMinhChungPropertyModel> getByName(String name)  {
		List<MergeMinhChungPropertyModel> merge = new ArrayList<MergeMinhChungPropertyModel>();
		String sql = "select idminhchung, tenminhchung, minhchung.noidung, tentieuchi, tenphongban, ngaytao, ngaycungcap "
				+ "from test.minhchung left join test.`chitietminhchung-tieuchi` on minhchung.idminhchung = `chitietminhchung-tieuchi`.`maminhchung-TC` "
				+ "left join test.`chitietminhchung-phongban` on minhchung.idminhchung = `chitietminhchung-phongban`.`maminhchung` "
				+ "left join test.tieuchi on tieuchi.idtieuchi = `chitietminhchung-tieuchi`.matieuchi "
				+ "left join test.phongban on phongban.idphongban = `chitietminhchung-phongban`.maphongban "
				+ "where ( tenminhchung like '%'  ? '%' );";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				merge.add(new MergeMinhChungPropertyModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getDate(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return merge;
	}

	public List<MergeMinhChungPropertyModel> getByDepartment(String name) throws SQLException {
		List<MergeMinhChungPropertyModel> merge = new ArrayList<MergeMinhChungPropertyModel>();
		String sql = "select idminhchung, tenminhchung, minhchung.noidung, tentieuchi, tenphongban, ngaytao, ngaycungcap "
				+ "from test.minhchung left join test.`chitietminhchung-tieuchi` on minhchung.idminhchung = `chitietminhchung-tieuchi`.`maminhchung-TC` "
				+ "left join test.`chitietminhchung-phongban` on minhchung.idminhchung = `chitietminhchung-phongban`.`maminhchung` "
				+ "left join test.tieuchi on tieuchi.idtieuchi = `chitietminhchung-tieuchi`.matieuchi "
				+ "left join test.phongban on phongban.idphongban = `chitietminhchung-phongban`.maphongban "
				+ "where tenphongban = ?;";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				merge.add(new MergeMinhChungPropertyModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getDate(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return merge;
	}

	public List<MergeMinhChungPropertyModel> getByDateIssue(Date dateIssue) throws SQLException {
		List<MergeMinhChungPropertyModel> merge = new ArrayList<MergeMinhChungPropertyModel>();
		String sql = "select idminhchung, tenminhchung, minhchung.noidung, tentieuchi, tenphongban, ngaytao, ngaycungcap "
				+ "from test.minhchung left join test.`chitietminhchung-tieuchi` on minhchung.idminhchung = `chitietminhchung-tieuchi`.`maminhchung-TC` "
				+ "left join test.`chitietminhchung-phongban` on minhchung.idminhchung = `chitietminhchung-phongban`.`maminhchung` "
				+ "left join test.tieuchi on tieuchi.idtieuchi = `chitietminhchung-tieuchi`.matieuchi "
				+ "left join test.phongban on phongban.idphongban = `chitietminhchung-phongban`.maphongban "
				+ "where `chitietminhchung-phongban`.`ngaytao` = ?;";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setDate(1, dateIssue);
			rs = ps.executeQuery();
			while (rs.next()) {
				merge.add(new MergeMinhChungPropertyModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getDate(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return merge;
	}
	
	public List<MergeMinhChungPropertyModel> sortByDateIssue() throws SQLException {
		List<MergeMinhChungPropertyModel> merge = new ArrayList<MergeMinhChungPropertyModel>();
		String sql = "select idminhchung, tenminhchung, minhchung.noidung, tentieuchi, tenphongban, ngaytao, ngaycungcap "
				+ "from test.minhchung left join test.`chitietminhchung-tieuchi` on minhchung.idminhchung = `chitietminhchung-tieuchi`.`maminhchung-TC` "
				+ "left join test.`chitietminhchung-phongban` on minhchung.idminhchung = `chitietminhchung-phongban`.`maminhchung` "
				+ "left join test.tieuchi on tieuchi.idtieuchi = `chitietminhchung-tieuchi`.matieuchi "
				+ "left join test.phongban on phongban.idphongban = `chitietminhchung-phongban`.maphongban "
				+ "order by `chitietminhchung-phongban`.`ngaytao` asc ;";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				merge.add(new MergeMinhChungPropertyModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getDate(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return merge;
	}

}
