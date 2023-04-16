package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


import DAO.NhanVienDAO;
import DAO.PhongBanDAO;
import models.NhanVienModel;
import models.PhongBanModel;

public class BangQuanLyNhanVien extends JPanel {

	/**
	 * 
	 */
	static PhongBanModel phongBan;
	static boolean isManager = false, isManagement = false;
	private static final long serialVersionUID = 1L;
	private static NhanVienDAO nvdao = new NhanVienDAO();
	static PhongBanDAO pbDao = new PhongBanDAO();
	
	static JTextField tfID = new JTextField();
	static JTextField tfName = new JTextField();
	static JComboBox<String> cbbPhongBan = new JComboBox<String>();
	static JCheckBox cbIsManagerTrue = new JCheckBox("Có");
	static JCheckBox cbIsManagerFalse = new JCheckBox("Không");
	static JCheckBox cbIsManageTrue = new JCheckBox("Có");
	static JCheckBox cbIsManageFalse = new JCheckBox("Không");

	static JTextField textFind = new JTextField();

	static JComboBox<String> cbbFind = new JComboBox<String>();

	static DefaultTableModel model = new DefaultTableModel();

	static JTable table = new JTable(model);

	static JScrollPane sp = new JScrollPane(table);

//	BangDichVu fDichVu = new BangDichVu();
	

	public BangQuanLyNhanVien() {
		// ------- Panel Info -------//
		setBounds(165, 1, 828, 765);

		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
				" Service Form ", TitledBorder.CENTER, TitledBorder.TOP);
		titledBorder.setTitleColor(Color.black);

		setBorder(titledBorder);
		setOpaque(false);

		// ------- Panel Text -------//
		JPanel pnTextField = new JPanel();
		pnTextField.setBounds(30, 30, 770, 240);
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Thông tin ",
				TitledBorder.LEFT, TitledBorder.TOP);
		titledBorder1.setTitleColor(Color.black);

		pnTextField.setBorder(titledBorder1);
		pnTextField.setOpaque(false);
		pnTextField.setLayout(null);

		// --------- Text Info --------//

		JLabel lbID = new JLabel("Mã Nhân Viên");
		JLabel lbName = new JLabel("Tên nhân viên");
		JLabel lbDepartment = new JLabel("Phòng Ban");
		JLabel lbPhone = new JLabel("Quyền Trưởng Phòng");
		JLabel lbEmail = new JLabel("Quyền Quản Trị");
		
		lbID.setBounds(70, 40, 80, 30);
		lbName.setBounds(70, 80, 80, 30);
		lbDepartment.setBounds(70, 120, 80, 30);
		lbPhone.setBounds(70, 160, 80, 30);
		lbEmail.setBounds(70, 200, 80, 30);

		tfID.setBounds(190, 40, 60, 30);
		tfName.setBounds(190, 80, 220, 30);
		cbbPhongBan.setBounds(190, 120, 220, 30);
		cbIsManagerTrue.setBounds(190, 160, 70, 30);
		cbIsManagerFalse.setBounds(260, 160, 100, 30);
		cbIsManageTrue.setBounds(190, 200, 70, 30);
		cbIsManageFalse.setBounds(260, 200, 100, 30);

		pnTextField.add(lbID);
		pnTextField.add(lbName);
		pnTextField.add(lbDepartment);
		pnTextField.add(lbPhone);
		pnTextField.add(lbEmail);

		pnTextField.add(tfID);
		pnTextField.add(tfName);
		pnTextField.add(cbbPhongBan);
		pnTextField.add(cbIsManagerTrue);
		pnTextField.add(cbIsManagerFalse);
		pnTextField.add(cbIsManageTrue);
		pnTextField.add(cbIsManageFalse);
		
		tfID.setEditable(false);

		// -------- Panel Button -------//
		JPanel pnButton = new JPanel();
		pnButton.setBounds(600, 20, 150, 190);
		TitledBorder titledBorder4 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Chức năng ",
				TitledBorder.LEFT, TitledBorder.TOP);
		titledBorder1.setTitleColor(Color.black);

		pnButton.setBorder(titledBorder4);
		pnButton.setOpaque(false);
		pnButton.setLayout(null);

		JButton btnAdd = new JButton("Thêm");
		JButton btnEdit = new JButton("Sửa");
		JButton btnDelete = new JButton("Xóa");
		JButton btnSave = new JButton("Lưu");

		btnAdd.setBounds(25, 20, 100, 30);
		btnEdit.setBounds(25, 60, 100, 30);
		btnDelete.setBounds(25, 100, 100, 30);
		btnSave.setBounds(25, 140, 100, 30);

		pnButton.add(btnAdd);
		pnButton.add(btnEdit);
		pnButton.add(btnDelete);
		pnButton.add(btnSave);

		pnTextField.add(pnButton);

		// ------- Panel Table -------//
		JPanel pnTable = new JPanel();
		pnTable.setBounds(30, 320, 770, 405);
		TitledBorder titledBorder2 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Danh sách ",
				TitledBorder.LEFT, TitledBorder.TOP);
		titledBorder.setTitleColor(Color.black);

		pnTable.setBorder(titledBorder2);
		pnTable.setOpaque(false);
		pnTable.setLayout(null);

		// ------ Table -----//
		Vector<String> column = new Vector<String>();

		column.add("Mã nhân viên");
		column.add("Tên nhân viên");
		column.add("Phòng ban");
		column.add("Trưởng Phòng");
		column.add("Quyền quản trị");

		model.setColumnIdentifiers(column);

		table.setBounds(1, 1, 728, 291);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow();
				for(int i=0;i<=row;i++) {
					tfID.setText(model.getValueAt(row, 0).toString());
					tfName.setText(model.getValueAt(row, 1).toString());
					PhongBanModel pbmodel = pbDao.getByName(model.getValueAt(row, 2).toString());
					cbbPhongBan.setSelectedItem(pbmodel.getTenPhongBan());
					if(model.getValueAt(row, 3).toString().equals("1")) {
						isManager = true;
					} else {
						isManager = false;
					}
					
					if(model.getValueAt(row, 4).toString().equals("1")) {
						isManagement = true;
					} else {
						isManagement = false;
					}
					cbIsManagerTrue.setSelected(isManager);
					cbIsManagerFalse.setSelected(!isManager);
					cbIsManageTrue.setSelected(isManagement);
					cbIsManageFalse.setSelected(!isManagement);
				}
			}
		});
			
		
		// ------- Scroll Panel -----//

		sp.setBounds(20, 90, 730, 305);

		// -------- Panel Find -------//
		JPanel pnFind = new JPanel();

		pnFind.setBounds(10, 10, 750, 70);

		pnFind.setOpaque(false);
		pnFind.setLayout(null);

		// ------- Text field Find ------//
		cbbFind.setBounds(20, 20, 100, 30);

		cbbFind.addItem("Mã");
		cbbFind.addItem("Tên");

		JTextField textFind = new JTextField();
		textFind.setBounds(120, 20, 500, 30);

		JButton btnFind = new JButton("Tìm kiếm");
		btnFind.setBounds(630, 20, 100, 30);

		pnFind.add(cbbFind);
		pnFind.add(textFind);
		pnFind.add(btnFind);

		// -------------//

		pnTable.add(sp);
		pnTable.add(pnFind);
		/*
		 * pnTable.add(cbbFind); pnFind.add(textFind);
		 */
		/* pnTable.add(btnFind); */
		// ----------------------//

		add(pnTextField);
		add(pnTable);

		// -----------------------//
		setLayout(null);
		load();

		// ----------- Event ---------//


		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(PhongBanModel item : pbDao.getAll()) {
					if(item.getTenPhongBan().equals(cbbPhongBan.getSelectedItem())) {
						phongBan = item;
						break;
					}
				}
				
				insert(new NhanVienModel(0, tfName.getText(), isManager, phongBan, isManagement));
			}
		});

		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(PhongBanModel item : pbDao.getAll()) {
					if(item.getTenPhongBan().equals(cbbPhongBan.getSelectedItem())) {
						phongBan = item;
						break;
					}
				}
				
				update(new NhanVienModel(Integer.parseInt(tfID.getText()), tfName.getText(), isManager, phongBan, isManagement));
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				delete(Integer.parseInt(tfID.getText()));
			}
		});

		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				load();
			}
		});

		

		btnFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (cbbFind.getSelectedIndex()== 0) {
					findById(Integer.parseInt(textFind.getText()));
				} else {
					findByName(textFind.getText());
				}
			}
		});
		
		cbIsManagerTrue.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				isManager = true;
				cbIsManagerFalse.setSelected(false);
			}
		});
		
		cbIsManagerFalse.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				isManager = false;
				cbIsManagerTrue.setSelected(false);
			}
		});
		
		cbIsManageTrue.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				isManagement = true;
				cbIsManageFalse.setSelected(false);
			}
		});
		
		cbIsManageFalse.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				isManagement = false;
				cbIsManageTrue.setSelected(false);
			}
		});
	}
	
	
	public static void load() {

		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		
		cbbPhongBan.removeAllItems();
		for(PhongBanModel item : pbDao.getAll()) {
			cbbPhongBan.addItem(item.getTenPhongBan());
		}
		
		
		List<NhanVienModel> list = nvdao.getAll();
		for (int i = 0; i < list.size(); i++) {
			NhanVienModel nv = (NhanVienModel) list.get(i);
			Vector<String> row = new Vector<String>();
			row.add(Integer.toString(nv.getMaNhanVien()));
			row.add(nv.getTenNhanVien());
			row.add(nv.getPhongBan().getTenPhongBan());
			row.add(nv.isTruongPhong() ? "1" : "0");
			row.add(nv.isQuyenQuanTri() ? "1" : "0");
			model.addRow(row);
		}
		
	}
	
	public static void insert(NhanVienModel nv) {
		
		
		if (nvdao.insert(nv) == 1) {
			JOptionPane.showMessageDialog(table, "Thêm thành công",  "About", JOptionPane.INFORMATION_MESSAGE);
			tfID.setText("");
			tfName.setText("");
			cbbPhongBan.setSelectedIndex(0);
			cbIsManagerTrue.setSelected(false);
			cbIsManagerFalse.setSelected(true);
			cbIsManageTrue.setSelected(false);
			cbIsManageFalse.setSelected(true);
			load();
		} else {
			JOptionPane.showMessageDialog(table, "Thêm thất bại",  "About", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void update(NhanVienModel nv) {
		
		if (nvdao.update(nv) == 1) {
			JOptionPane.showMessageDialog(table, "Sửa thành công",  "About", JOptionPane.INFORMATION_MESSAGE);
			tfID.setText("");
			tfName.setText("");
			cbbPhongBan.setSelectedIndex(0);
			cbIsManagerTrue.setSelected(false);
			cbIsManagerFalse.setSelected(true);
			cbIsManageTrue.setSelected(false);
			cbIsManageFalse.setSelected(true);
			load();
		} else {
			JOptionPane.showMessageDialog(table, "Sửa thất bại",  "About", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	public static void delete(int idNhanVien) {
		if (nvdao.delete(idNhanVien) == 1 ) {
			JOptionPane.showMessageDialog(table, "Xóa thành công",  "About", JOptionPane.INFORMATION_MESSAGE);
			tfID.setText("");
			tfName.setText("");
			cbbPhongBan.setSelectedIndex(0);
			cbIsManagerTrue.setSelected(false);
			cbIsManagerFalse.setSelected(true);
			cbIsManageTrue.setSelected(false);
			cbIsManageFalse.setSelected(true);
			load();
		} else {
			JOptionPane.showMessageDialog(table, "Xóa thất bại",  "About", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
	 
	public static void findById(int id) {

		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}

		NhanVienModel nv = nvdao.get(id);
		Vector<String> row = new Vector<String>();
		row.add(Integer.toString(nv.getMaNhanVien()));
		row.add(nv.getTenNhanVien());
		row.add(nv.getPhongBan().getTenPhongBan());
		model.addRow(row);
	}

	public static void findByName(String name) {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}

		List<NhanVienModel> list = nvdao.getbyname(name);
		for (int i = 0; i < list.size(); i++) {
			NhanVienModel nv = (NhanVienModel) list.get(i);
			Vector<String> row = new Vector<String>();
			row.add(Integer.toString(nv.getMaNhanVien()));
			row.add(nv.getTenNhanVien());
			row.add(nv.getPhongBan().getTenPhongBan());
			model.addRow(row);
		}
	}
}
