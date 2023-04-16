package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.NhanVienDAO;
import DAO.TaiKhoanDAO;
import models.TaiKhoanModel;;
@SuppressWarnings("serial")
public class FormTaiKhoan extends JFrame {
	

	
	private static NhanVienDAO nvdao = new NhanVienDAO();
	private static TaiKhoanDAO tkdao = new TaiKhoanDAO();
	static int staffId= 0;
	static DefaultTableModel model = new DefaultTableModel();
	static JTable table = new JTable(model);
	static JScrollPane sp = new JScrollPane(table);
	

	JPanel pnMenu = new JPanel();

	JButton btnNhanVien = new JButton(" Nhân viên ");
	JButton btnSanPham = new JButton(" Sản phẩm ");
	JButton btnHoaDon = new JButton(" Hóa đơn ");
	/* JButton btnCTHoaDon = new JButton(" Hóa đơn "); */
	JButton btnDangXuat = new JButton(" Đăng xuất ");
	JButton btnTaiKhoan = new JButton("Tài khoản");
	JButton btnTG = new JButton(" Tác giả ");
	JButton btnTL = new JButton(" Thể loại ");
	JButton btnNSX = new JButton(" Nhà sản xuất ");
	JButton btnCTDH = new JButton(" Chi tiết ");

	static JTextField tfID = new JTextField();
	static JTextField tfName = new JTextField();
	static JTextField tfPass = new JTextField();
	static JTextField tfRole = new JTextField();
	static JTextField tfNV = new JTextField();

	public FormTaiKhoan(String id) {
		tfID.setText(id);
		setTitle("Form Tai Khoan");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		setLayout(null);
		setVisible(true);

		
		
		// ------- Panel Text -------//

		JPanel pnTextField = new JPanel();
		pnTextField.setBounds(25, 20, 535, 230);
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Thông tin ",
				TitledBorder.LEFT, TitledBorder.TOP);
		titledBorder1.setTitleColor(Color.black);

		pnTextField.setBorder(titledBorder1);
		pnTextField.setOpaque(false);
		pnTextField.setLayout(null);

		// --------- Text Info --------//

		JLabel lbName = new JLabel("Tên tài khoản");
		JLabel lbPass = new JLabel("Mật khẩu");
		JLabel lbRole = new JLabel("Quyền");

		lbName.setBounds(80, 80, 80, 30);
		lbPass.setBounds(80, 120, 80, 30);
		lbRole.setBounds(80, 160, 80, 30);

		tfName.setBounds(180, 80, 220, 30);
		tfPass.setBounds(180, 120, 220, 30);
		tfRole.setBounds(180, 160, 220, 30);

		pnTextField.add(lbName);
		pnTextField.add(lbPass);
		pnTextField.add(lbRole);

		pnTextField.add(tfID);
		pnTextField.add(tfName);
		pnTextField.add(tfPass);
		pnTextField.add(tfRole);

		// -------- Panel Button -------//
		JPanel pnButton = new JPanel();
		pnButton.setBounds(25, 270, 535, 75);
		TitledBorder titledBorder4 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Chức năng ",
				TitledBorder.LEFT, TitledBorder.TOP);
		titledBorder1.setTitleColor(Color.black);

		pnButton.setBorder(titledBorder4);
		pnButton.setOpaque(false);
		pnButton.setLayout(null);

		JButton btnEdit = new JButton("Sửa");
		JButton btnSave = new JButton("Lưu");

		
		btnEdit.setBounds(145, 30, 100, 30);
		btnSave.setBounds(295, 30, 100, 30);

		pnButton.add(btnEdit);
		pnButton.add(btnSave);

		// ----------------------//
		add(pnButton);
		add(pnTextField);

		// -----------------------//
		setLayout(null);
		load();
		
		// ----- event --------- //
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				update();
				dispose();
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				setVisible(false);
			}
		});
		
	}
	
	public void getstaff(int id) {
		 staffId = id;
	}
	
	public static void load() {
//		TaiKhoanModel tk = nvdao.gettaikhoan(Integer.parseInt(tfID.getText()));
//		tfID.setText(Integer.toString(tk.getMaTK())); 
//		tfName.setText(tk.getTaiKhoan());
//		tfPass.setText(tk.getMatKhau());
//		tfRole.setText(tk.getQuyen());
//		tfNV.setText(Integer.toString(tk.getMaNV()));	
		
	}
	
	public static  void update() {
		TaiKhoanModel tk = new TaiKhoanModel(Integer.parseInt(tfID.getText()), tfName.getText(), tfPass.getText(), tfRole.getText(), Integer.parseInt(tfNV.getText()));
		if (tkdao.update(tk) == 1) {
			JOptionPane.showMessageDialog(table, "Sửa thành công",  "About", JOptionPane.INFORMATION_MESSAGE);
			tfID.setText("");
			tfName.setText("");
			tfPass.setText("");
			tfRole.setText("");
			tfName.setText("");
			load();
		} else {
			JOptionPane.showMessageDialog(table, "Sửa thất bại",  "About", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
