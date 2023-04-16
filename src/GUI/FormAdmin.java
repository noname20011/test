package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class FormAdmin extends JFrame {

	private static final long serialVersionUID = 9052112333030448917L;

	JPanel pnMenu = new JPanel();

	JButton btnPhongBan = new JButton(" Phòng Ban ");
	JButton btnNhanVien = new JButton(" Nhân viên ");
	JButton btnTieuChuan = new JButton("Tiêu Chuẩn");
	JButton btnTieuChi = new JButton(" Tiêu Chí ");
	JButton btnMinhChung = new JButton("Minh Chứng");
	JButton btnDangXuat = new JButton(" Đăng xuất ");

	BangQuanLyNhanVien fbangnv = new BangQuanLyNhanVien();
	BangPhongBan fphongban = new BangPhongBan();
	BangTieuChuan ftieuchuan = new BangTieuChuan();
	BangTieuChi ftieuchi = new BangTieuChi();
	BangMinhChung fminhchung = new BangMinhChung();
	public FormAdmin() {

		AddPanelMenu();



		add(fbangnv);
		add(fphongban);
		add(ftieuchuan);
		add(ftieuchi);
		add(fminhchung);


		Hide();

		setTitle("Form Admin");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 800);
		setLayout(null);
		setVisible(true);

		// ------------- Event --------------//

		btnPhongBan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Hide();
				fphongban.setVisible(true);
				
			}
		});
		
		btnNhanVien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Hide();
				fbangnv.setVisible(true);

			}
		});
		
		btnTieuChuan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Hide();
				ftieuchuan.setVisible(true);
			}
		});
		
		btnTieuChi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Hide();
				ftieuchi.setVisible(true);
			}
		});
		
		btnMinhChung.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Hide();
				fminhchung.setVisible(true);
			}
		});

		
		btnDangXuat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				new FormDangNhap();
			}
		});
	}

	void AddPanelMenu() {

		pnMenu.setBounds(5, 1, 150, 765);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Dashboard ",
				TitledBorder.CENTER, TitledBorder.TOP);
		titledBorder.setTitleColor(Color.black);
		pnMenu.setBorder(titledBorder);
		pnMenu.setOpaque(false);

		btnPhongBan.setBounds(10, 30, 130, 40);
		btnNhanVien.setBounds(10, 80, 130, 40);
		btnTieuChuan.setBounds(10, 130, 130, 40);
		btnTieuChi.setBounds(10, 180, 130, 40);
		btnMinhChung.setBounds(10, 230, 130,40);
		btnDangXuat.setBounds(10, 280, 130,40);
		
		pnMenu.add(btnNhanVien);
		pnMenu.add(btnPhongBan);
		pnMenu.add(btnTieuChuan);
		pnMenu.add(btnTieuChi);
		pnMenu.add(btnMinhChung);
		pnMenu.add(btnDangXuat);

		pnMenu.setLayout(null);
		this.add(pnMenu);
	}

	void Hide() {

		fbangnv.setVisible(false);
		fphongban.setVisible(false);
		ftieuchuan.setVisible(false);
		ftieuchi.setVisible(false);
		fminhchung.setVisible(false);

	}

}
