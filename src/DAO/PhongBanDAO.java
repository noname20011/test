package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import app.DBConnection;
import models.PhongBanModel;

public class PhongBanDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	PhongBanModel pb = new PhongBanModel();

	public int insert(PhongBanModel pb) {
		String sql = "insert into test.phongban (tenphongban) values(?)";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getTenPhongBan());
			ps.executeUpdate();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public int update(PhongBanModel pb) {
		String sql = "update test.phongban set tenphongban = ? where idphongban = ?";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getTenPhongBan());
			ps.setInt(2, pb.getMaPhongBan());
			ps.executeUpdate();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public int delete(int maPhongBan) {
		String sql = "delete from test.phongban where idphongban = ?";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maPhongBan);
			ps.execute();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public List<PhongBanModel> getAll() {
		List<PhongBanModel> pb = new ArrayList<PhongBanModel>();

		String sql = "Select * from test.phongban";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				pb.add(new PhongBanModel(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {

		}
		return pb;
	}

	public PhongBanModel get(int id) {
		String sql = "Select * from test.phongban where idphongban =?";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				PhongBanModel pb = new PhongBanModel();
				pb.setMaPhongBan(rs.getInt(1));
				pb.setTenPhongBan(rs.getString(2));
				return pb;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public PhongBanModel getByName(String name) {
		String sql = "Select * from test.phongban where tenphongban = ? limit 1";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				PhongBanModel pb = new PhongBanModel();
				pb.setMaPhongBan(rs.getInt(1));
				pb.setTenPhongBan(rs.getString(2));
				return pb;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
