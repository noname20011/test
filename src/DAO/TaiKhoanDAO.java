package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.DBConnection;
import models.TaiKhoanModel;



public class TaiKhoanDAO {
	static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
	TaiKhoanModel tk = new TaiKhoanModel();
	
	public static TaiKhoanModel check(String taikhoan, String matkhau){
		
		TaiKhoanModel checktk = null;
		 String sql ="select * from qlchs.taikhoan where TaiKhoan=  ?  and MatKhau=  ?  limit 1;";
	        try {
	        	
	        	conn = DBConnection.getMySQLConnection();
	        	ps = conn.prepareStatement(sql);
	        	ps.setString(1, taikhoan);
	        	ps.setString(2, matkhau);
				rs = ps.executeQuery(); 
				while (rs.next()) {
					TaiKhoanModel tk = new TaiKhoanModel();
					tk.setMaTK(rs.getInt(1));
					tk.setTaiKhoan(rs.getString(2));
					tk.setTaiKhoan(rs.getString(3));
					tk.setQuyen(rs.getString(4));
					tk.setMaNV(rs.getInt(5));
					return checktk = tk;
				} 
			} catch (Exception e) {
	            // TODO: handle exception
	        	return checktk = null;
	        }
	     return checktk ;
	}
	
public int update(TaiKhoanModel tk){
		
		 String sql ="update qlchs.taikhoan set TaiKhoan = ?, MatKhau = ?, Quyen = ? where MaTK = ?";
	        try {
	        	
	        	conn = DBConnection.getMySQLConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, tk.getTaiKhoan());
				ps.setString(2, tk.getMatKhau());
				ps.setString(3, tk.getQuyen());
				ps.setInt(4, tk.getMaTK());
				ps.executeUpdate();
					return 1;
			} catch (Exception e) {
	            // TODO: handle exception
	        }
	     return 0; 
	}

}