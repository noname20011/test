package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import models.TieuChuanModel;
import DAO.TieuChuanDAO;;

@SuppressWarnings("serial")
public class BangTieuChuan extends JPanel{
	
	static TieuChuanDAO hddao = new TieuChuanDAO();
	
	static JTextField tfID = new JTextField();
	static JTextField tfName = new JTextField();
	static JTextArea tfDescription = new JTextArea();

	static JTextField textFind = new JTextField();

	static JComboBox<String> cbbFind = new JComboBox<String>();

	static DefaultTableModel model = new DefaultTableModel();

	static JTable table = new JTable(model);

	static JScrollPane sp = new JScrollPane(table);

//	BangDichVu fDichVu = new BangDichVu();
	

	public BangTieuChuan() {
		// ------- Panel Info -------//
		setBounds(165, 1, 828, 765);

		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
				" Service Form ", TitledBorder.CENTER, TitledBorder.TOP);
		titledBorder.setTitleColor(Color.black);

		setBorder(titledBorder);
		setOpaque(false);

		// ------- Panel Text -------//
		JPanel pnTextField = new JPanel();
		pnTextField.setBounds(30, 30, 770, 220);
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Thông tin ",
				TitledBorder.LEFT, TitledBorder.TOP);
		titledBorder1.setTitleColor(Color.black);

		pnTextField.setBorder(titledBorder1);
		pnTextField.setOpaque(false);
		pnTextField.setLayout(null);

		// --------- Text Info --------//

		JLabel lbID = new JLabel("Mã tiêu chuẩn");
		JLabel lbName = new JLabel("Tên tiêu chuẩn");
		JLabel lbPhone = new JLabel("Nội dung");

		lbID.setBounds(70, 40, 80, 30);
		lbName.setBounds(70, 80, 80, 30);
		lbPhone.setBounds(70, 120, 80, 30);

		tfID.setBounds(190, 40, 60, 30);
		tfName.setBounds(190, 80, 220, 30);
		tfDescription.setBounds(190, 120, 220, 80);

		pnTextField.add(lbID);
		pnTextField.add(lbName);
		pnTextField.add(lbPhone);

		pnTextField.add(tfID);
		pnTextField.add(tfName);
		pnTextField.add(tfDescription);

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
		JButton btnDelete = new JButton("Xóa");
		JButton btnUpdate = new JButton("Sửa");
		JButton btnSave = new JButton("Lưu");

		btnAdd.setBounds(25, 20, 100, 30);
		btnUpdate.setBounds(25, 60, 100, 30);
		btnDelete.setBounds(25, 100, 100, 30);
		btnSave.setBounds(25, 140, 100, 30);

		pnButton.add(btnUpdate);
		pnButton.add(btnAdd);
		pnButton.add(btnDelete);
//		pnButton.add(btnSave);

		pnTextField.add(pnButton);
		tfID.setEditable(false);

		// ------- Panel Table -------//
		JPanel pnTable = new JPanel();
		pnTable.setBounds(30, 280, 770, 475);
		TitledBorder titledBorder2 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Danh sách ",
				TitledBorder.LEFT, TitledBorder.TOP);
		titledBorder.setTitleColor(Color.black);

		pnTable.setBorder(titledBorder2);
		pnTable.setOpaque(false);
		pnTable.setLayout(null);

		// ------ Table -----//
		Vector<String> column = new Vector<String>();

		column.add("Mã tiêu chuẩn");
		column.add("Tên tiêu chuẩn");
		column.add("Nội dung");

		model.setColumnIdentifiers(column);

		table.setBounds(1, 1, 728, 380);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow();
				for(int i=0;i<=row;i++) {
					tfID.setText(model.getValueAt(row, 0).toString());
					tfName.setText(model.getValueAt(row, 1).toString());
					tfDescription.setText(model.getValueAt(row, 2).toString());
				}
				
			}
		});
		// ------- Scroll Panel -----//

		sp.setBounds(20, 90, 730, 365);

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

		/*
		 * btnLoad.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * 
		 * System.out.println("Load Dich Vu"); } });
		 */

		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insert();
				System.out.println("Add Dich Vu");
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				delete();
				System.out.println("Delete Dich Vu");
			}
		});

		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				load();
				System.out.println("Save Dich Vu");
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
		
//		btnUpdate.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new FormChiTietHoaDon(Integer.parseInt(tfID.getText()));
//				
//			}
//		});
	}
	
	public static void load() {

		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		
		
		List<TieuChuanModel> list = hddao.getAll();
		for (int i = 0; i < list.size(); i++) {
			TieuChuanModel hd = (TieuChuanModel) list.get(i);
			Vector<String> row = new Vector<String>();
			row.add(Integer.toString(hd.getMaTieuChuan()));
			row.add(String.valueOf((hd.getTenTieuChuan())));
			row.add(String.valueOf(hd.getNoiDung()));
			model.addRow(row);
		}
		
	}
	
	public static void insert() {
		TieuChuanModel hd = new TieuChuanModel(1,  
									tfName.getText(),
									tfDescription.getText()
									);
		if (hddao.insert(hd) == 1) {
			JOptionPane.showMessageDialog(table, "Thêm thành công",  "About", JOptionPane.INFORMATION_MESSAGE);
			tfID.setText("");
			tfName.setText("");
			tfDescription.setText("");
			load();
		} else {
			JOptionPane.showMessageDialog(table, "Thêm thất bại",  "About", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void update() {
		TieuChuanModel nv = new TieuChuanModel(Integer.parseInt(tfID.getText()), tfName.getText(), tfDescription.getText());
		if (hddao.update(nv) == 1) {
			JOptionPane.showMessageDialog(table, "Sửa thành công",  "About", JOptionPane.INFORMATION_MESSAGE);
			tfID.setText("");
			tfName.setText("");
			tfDescription.setText("");
			load();
		} else {
			JOptionPane.showMessageDialog(table, "Sửa thất bại",  "About", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	public static void delete() {
		if (hddao.delete(Integer.parseInt(tfID.getText())) == 1 ) {
			JOptionPane.showMessageDialog(table, "Xóa thành công",  "About", JOptionPane.INFORMATION_MESSAGE);
			tfID.setText("");
			tfName.setText("");
			tfDescription.setText("");
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

		TieuChuanModel hd = hddao.get(id);
		Vector<String> row = new Vector<String>();
		row.add(Integer.toString(hd.getMaTieuChuan()));
		row.add(String.valueOf((hd.getTenTieuChuan())));
		row.add(String.valueOf(hd.getNoiDung()));
		model.addRow(row);
	}

	public static void findByName(String name) {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}

		List<TieuChuanModel> list = hddao.getbyname(name);
		for (int i = 0; i < list.size(); i++) {
			TieuChuanModel hd = (TieuChuanModel) list.get(i);
			Vector<String> row = new Vector<String>();
			row.add(Integer.toString(hd.getMaTieuChuan()));
			row.add(String.valueOf((hd.getTenTieuChuan())));
			row.add(String.valueOf(hd.getNoiDung()));
			model.addRow(row);
		}
	}
}
