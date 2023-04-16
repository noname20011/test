package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import app.DBConnection;
import models.TieuChuanModel;



public class TieuChuanDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    TieuChuanModel tc = new TieuChuanModel();

	public int insert(TieuChuanModel tc) {

		String sql = "insert into test.tieuchuan (tentieuchuan, noidung) values(?,?)";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tc.getTenTieuChuan());
			ps.setString(2, tc.getNoiDung());
			ps.executeUpdate();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return 0;
	}

	public int update(TieuChuanModel tc) {
		String sql = "update test.tieuchuan set tentieuchuan = ?, noidung = ? where idtieuchuan = ?";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tc.getTenTieuChuan());
			ps.setString(2, tc.getNoiDung());
			ps.setInt(3, tc.getMaTieuChuan());
			ps.executeUpdate();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public int delete(int maTC) {
		String sql = "delete from test.tieuchuan where idtieuchuan = ?";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maTC);
			ps.execute();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return 0;
	}
	
	
	public List<TieuChuanModel> getAll() {
		List<TieuChuanModel> tc = new ArrayList<TieuChuanModel>();

		String sql = "Select * from test.tieuchuan";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				tc.add(new TieuChuanModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {

		}
		return tc;
	}
	
	public TieuChuanModel get(int id) {
		String sql = "Select * from test.tieuchuan where idtieuchuan = ?";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				TieuChuanModel tc = new TieuChuanModel();
				tc.setMaTieuChuan(rs.getInt(1));
				tc.setTenTieuChuan(rs.getString(2));
				tc.setNoiDung(rs.getString(3));
				return tc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<TieuChuanModel> getbyname(String name) {
		List<TieuChuanModel> hd = new ArrayList<TieuChuanModel>();
		String sql = "SELECT hoadon.* FROM qlchs.hoadon inner join qlchs.nhanvien on qlchs.hoadon.MaNV = qlchs.nhanvien.MaNV where (qlchs.nhanvien.TenNV like '%' ? '%' );";
//		String sql = "SELECT hoadon.* FROM qlchs.hoadon inner join qlchs.nhanvien on qlchs.hoadon.MaNV = qlchs.nhanvien.MaNV where qlchs.nhanvien.TenNV = ?;";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				hd.add(new TieuChuanModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hd;
	}
}
