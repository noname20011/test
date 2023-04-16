package GUI;

//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.TaiKhoanDAO;
import models.TaiKhoanModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FormDangNhap extends JFrame{

	private static final long serialVersionUID = -3100006640859757983L;
	
	JTextField tfUsername = new JTextField();
	JPasswordField tfPassword = new JPasswordField();
	
	boolean flag = false;
	
	public FormDangNhap() {
		
		
		//------- Tilte --------//
		JLabel lbLogin = new JLabel("QUẢN LÍ MINH CHỨNG");
		lbLogin.setBounds(40,80,320,30);
		lbLogin.setFont(new Font("SVN-Franko", Font.BOLD | Font.ITALIC, 24));
		lbLogin.setForeground(Color.white);
		
		add(lbLogin);
		
		//-------- Login form ------// 
		JLabel lbUsername = new JLabel("Tài Khoản");
		lbUsername.setFont(new Font("SVN-Franko", Font.BOLD, 16));
		JLabel lbPassword = new JLabel("Mật Khẩu");
		lbPassword.setFont(new Font("SVN-Franko", Font.BOLD, 16));
		
		lbUsername.setForeground(Color.white);
		lbPassword.setForeground(Color.white);
		
		lbUsername.setBounds(70,130,80,30);
		lbPassword.setBounds(70,170,80,30);
		
		
		tfUsername.setBounds(150,135,150,30);
		tfPassword.setBounds(150,175,150,30);
		
		add(tfUsername);
		add(tfPassword);
		
		add(lbUsername);
		add(lbPassword);
		
		//----- check box ----//
		
		JCheckBox cbAdmin = new JCheckBox("Quản Lí");
		JCheckBox cbNhanVien = new JCheckBox("Nhân Viên");
		
		cbAdmin.setFont(new Font("SVN-Franko", Font.BOLD, 12));
		cbNhanVien.setFont(new Font("SVN-Franko", Font.BOLD, 12));
		
		cbAdmin.setForeground(Color.white);
		cbNhanVien.setForeground(Color.white);
		
		cbAdmin.setBounds(100,210,80,30);
		cbNhanVien.setBounds(180,210,100,30);
		
		add(cbAdmin);
		add(cbNhanVien);
		
		//-------- Button -------//
		JButton btnLogin = new JButton("LOGIN");
		
		btnLogin.setFont(new Font("SVN-Franko", Font.BOLD, 14));
		
		btnLogin.setBounds(140,250,100,33);
		
		add(btnLogin);
		
		//------ background --------//
		JLabel labeltong = new JLabel();
		labeltong.setBounds(0, 0, 400, 400);
		
//		ImageIcon avtstop =new ImageIcon(new ImageIcon(this.getClass().getResource("/background.jpeg")).getImage().getScaledInstance(labeltong.getWidth(),labeltong.getHeight(), Image.SCALE_SMOOTH));
		
//		labeltong.setIcon(avtstop);
		
		add(labeltong);
		
		setTitle("Đăng Nhập");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		setLayout(null);
		setVisible(true);
		
		
		//---------- Event --------// 
		
		cbAdmin.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flag = true;
				cbNhanVien.setSelected(false);
			}
		});
		
		cbNhanVien.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flag = false;
				cbAdmin.setSelected(false);
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String Username = tfUsername.getText();
				String Password = String.valueOf(tfPassword.getPassword());
				
				TaiKhoanDAO tkdao =new  TaiKhoanDAO();
				TaiKhoanModel tk = TaiKhoanDAO.check(Username, Password);
				if(Username.compareTo("admin") == 0 && Password.compareTo("admin") == 0 && flag) {
					JOptionPane.showMessageDialog(labeltong, "Đăng nhập thành công");
					new FormAdmin();
					dispose();
					
				} else {
					 if( TaiKhoanDAO.check(Username, Password) != null && !flag) {
							JOptionPane.showMessageDialog(labeltong, "Đăng nhập thành công");
							new FormAdmin();
							dispose();
						
					 } else{
							JOptionPane.showMessageDialog(labeltong, "Tài khoản hoặc mật khẩu không đúng. Vui lòng nhập lại.");
						}
				}

			}
		});
	}
}
