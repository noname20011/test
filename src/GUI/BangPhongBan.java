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
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import models.PhongBanModel;
import DAO.PhongBanDAO;

@SuppressWarnings("serial")
public class BangPhongBan extends JPanel {
	
	static PhongBanDAO nxbdao = new PhongBanDAO();
	static JTextField tfID = new JTextField();
	static JTextField tfName = new JTextField();

	static JTextField textFind = new JTextField();

	static JComboBox<String> cbbFind = new JComboBox<String>();

	static DefaultTableModel model = new DefaultTableModel();

	static JTable table = new JTable(model);

	static JScrollPane sp = new JScrollPane(table);

	public BangPhongBan() {
		// ------- Panel Info -------//
		setBounds(165, 1, 828, 765);

		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
				" Department Form ", TitledBorder.CENTER, TitledBorder.TOP);
		titledBorder.setTitleColor(Color.black);

		setBorder(titledBorder);
		setOpaque(false);

		// ------- Panel Text -------//
		JPanel pnTextField = new JPanel();
		pnTextField.setBounds(30, 30, 770, 225);
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Thông tin ",
				TitledBorder.LEFT, TitledBorder.TOP);
		titledBorder1.setTitleColor(Color.black);

		pnTextField.setBorder(titledBorder1);
		pnTextField.setOpaque(false);
		pnTextField.setLayout(null);

		// --------- Text Info --------//

		JLabel lbID = new JLabel("Mã phòng ban");
		JLabel lbName = new JLabel("Tên phòng ban");

		lbID.setBounds(190, 40, 120, 30);
		lbName.setBounds(190, 80, 120, 30);

		tfID.setBounds(330, 40, 60, 30);
		tfName.setBounds(330, 80, 220, 30);

		pnTextField.add(lbID);
		pnTextField.add(lbName);

		pnTextField.add(tfID);
		pnTextField.add(tfName);

		// -------- Panel Button -------//
		JPanel pnButton = new JPanel();
		pnButton.setBounds(70, 140, 630, 70);
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

		btnAdd.setBounds(60, 20, 100, 30);
		btnEdit.setBounds(195, 20, 100, 30);
		btnDelete.setBounds(330, 20, 100, 30);
		btnSave.setBounds(465, 20, 100, 30);

		pnButton.add(btnAdd);
		pnButton.add(btnEdit);
		pnButton.add(btnDelete);
		pnButton.add(btnSave);

		pnTextField.add(pnButton);
		
		tfID.setEditable(false);


		// ------- Panel Table -------//
		JPanel pnTable = new JPanel();
		pnTable.setBounds(30, 275, 770, 475);
		TitledBorder titledBorder2 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Danh sách ",
				TitledBorder.LEFT, TitledBorder.TOP);
		titledBorder.setTitleColor(Color.black);

		pnTable.setBorder(titledBorder2);
		pnTable.setOpaque(false);
		pnTable.setLayout(null);

		// ------ Table -----//
		Vector<String> column = new Vector<String>();

		column.add("Mã Phòng Ban");
		column.add("Tên Phòng Ban");

		model.setColumnIdentifiers(column);

		table.setBounds(1, 1, 728, 341);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow();
				for(int i=0;i<=row;i++) {
					tfID.setText(model.getValueAt(row, 0).toString());
					tfName.setText(model.getValueAt(row, 1).toString());
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
			}
		});

		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});

		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Save Dich Vu");
			}
		});

		btnFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (cbbFind.getSelectedIndex()== 0) {
					findById(Integer.parseInt(textFind.getText()));
				} else {
//					findByName(textFind.getText());
				}
			}
		});
	}
	
	public static void load() {

		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		
		
		List<PhongBanModel> list = nxbdao.getAll();
		for (int i = 0; i < list.size(); i++) {
			PhongBanModel pb = (PhongBanModel) list.get(i);
			Vector<String> row = new Vector<String>();
			row.add(Integer.toString(pb.getMaPhongBan()));
			row.add(pb.getTenPhongBan());
			model.addRow(row);
		}
		
	}
	
	public static void insert() {
		PhongBanModel nv = new PhongBanModel(1 , tfName.getText());
		if (nxbdao.insert(nv) == 1) {
			JOptionPane.showMessageDialog(table, "Thêm thành công",  "About", JOptionPane.INFORMATION_MESSAGE);
			tfID.setText("");
			tfName.setText("");
			load();
		} else {
			JOptionPane.showMessageDialog(table, "Thêm thất bại",  "About", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void update() {
		PhongBanModel nv = new PhongBanModel(Integer.parseInt(tfID.getText()), tfName.getText());
		if (nxbdao.update(nv) == 1) {
			JOptionPane.showMessageDialog(table, "Sửa thành công",  "About", JOptionPane.INFORMATION_MESSAGE);
			tfID.setText("");
			tfName.setText("");

			load();
		} else {
			JOptionPane.showMessageDialog(table, "Sửa thất bại",  "About", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	public static void delete() {
		if (nxbdao.delete(Integer.parseInt(tfID.getText())) == 1 ) {
			JOptionPane.showMessageDialog(table, "Xóa thành công",  "About", JOptionPane.INFORMATION_MESSAGE);
			tfID.setText("");
			tfName.setText("");
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

		PhongBanModel pb = nxbdao.get(id);
		Vector<String> row = new Vector<String>();
		row.add(Integer.toString(pb.getMaPhongBan()));
		row.add(pb.getTenPhongBan());
		model.addRow(row);
	}
}