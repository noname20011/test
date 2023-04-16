package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import app.DBConnection;
import models.NhanVienModel;
import models.PhongBanModel;



public class NhanVienDAO {
	static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
	static NhanVienModel nv = new NhanVienModel();
	static PhongBanDAO pbDao = new PhongBanDAO();
	
	public int insert(NhanVienModel nv) {
		 String sql ="insert into test.nhanvien (tennhanvien, truongphong, `maphongban-NV`, quyenquantri) values(?,?,?,?)";
	        try {
	            conn = DBConnection.getMySQLConnection();
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, nv.getTenNhanVien());
	            ps.setBoolean(2, nv.isTruongPhong());
	            ps.setInt(3, nv.getPhongBan().getMaPhongBan());
	            ps.setBoolean(4, nv.isQuyenQuanTri());
	            ps.executeUpdate();
	            return 1;

	        } catch (Exception e) {
	            // TODO: handle exception
	        	System.out.println(e);
	        }
	        return 0;
	 }
	
	public int update(NhanVienModel nv) {
		String sql = "update test.nhanvien set tennhanvien =?, truongphong = ?, `maphongban-NV`=?,  quyenquantri = ? where idnhanvien = ?";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, nv.getTenNhanVien());
            ps.setBoolean(2, nv.isTruongPhong());
            ps.setInt(3, nv.getPhongBan().getMaPhongBan());
            ps.setBoolean(4, nv.isQuyenQuanTri());
            ps.setInt(5, nv.getMaNhanVien());
			ps.executeUpdate();

			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public int delete(int MaNV) {
		  String sql = "delete from test.nhanvien where idnhanvien = ?";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, MaNV);
			ps.execute();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	
	public List<NhanVienModel> getAll() {
		List<NhanVienModel> nv = new ArrayList<NhanVienModel>();

		String sql = "Select * from test.nhanvien";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				PhongBanModel pb = pbDao.get(rs.getInt(4));
				nv.add(new NhanVienModel(rs.getInt(1), rs.getString(2), rs.getBoolean(3), pb, rs.getBoolean(5)));
			}
		} catch (Exception e) {

		}
		return nv;
	}
	
	public NhanVienModel get(int id) {
		String sql = "Select * from test.nhanvien where idnhanvien =?";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				NhanVienModel nv = new NhanVienModel();
				PhongBanModel pb = pbDao.get(rs.getInt(4));
				nv.setMaNhanVien(rs.getInt(1));
				nv.setTenNhanVien(rs.getString(2));
				nv.setTruongPhong(rs.getBoolean(3));
				nv.setPhongBan(pb);
				nv.setQuyenQuanTri(rs.getBoolean(5));
				return nv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<NhanVienModel> getbyname(String name) {
		List<NhanVienModel> nv = new ArrayList<NhanVienModel>();
		String sql = "Select * from test.nhanvien where (TenNV like '%' ? '%')";
		try {
			conn = DBConnection.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				PhongBanModel pb = pbDao.get(rs.getInt(4));
				nv.add(new NhanVienModel(rs.getInt(1), rs.getString(2), rs.getBoolean(3), pb, rs.getBoolean(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}

//	public static TaiKhoanModel gettaikhoan(int id) {
//		String sql = "Select taikhoan.* from qlchs.taikhoan inner join qlchs.nhanvien on qlchs.taikhoan.MaNV = qlchs.nhanvien.MaNV where qlchs.nhanvien.MaNV = ? limit 1";
////		String sql = "Select * from qlchs.nhanvien where (TenNV like '%' ? '%')";
//		try {
//			conn = DBConnection.getMySQLConnection();
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				TaiKhoanModel tk = new TaiKhoanModel();
//				tk.setMaTK(rs.getInt(1));
//				tk.setTaiKhoan(rs.getString(2));
//				tk.setMatKhau(rs.getString(3));
//				tk.setQuyen(rs.getString(4));
//				return tk;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
}
