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

import models.TieuChiModel;
import models.TieuChuanModel;
import DAO.TieuChiDAO;
import DAO.TieuChuanDAO;

@SuppressWarnings("serial")
public class BangTieuChi extends JPanel{
	
	static TieuChiDAO tieuChiDao = new TieuChiDAO();
	static TieuChiModel tieuChi = new TieuChiModel();
	static TieuChuanModel tieuchuan = new TieuChuanModel();
	static TieuChuanDAO tcDao = new TieuChuanDAO();
	
	static JTextField tfID = new JTextField();
	static JTextField tfName = new JTextField();
	static JTextArea tfDescription = new JTextArea();
	static JTextField tfIDTieuChuan = new JTextField();

	static JTextField textFind = new JTextField();

	static JComboBox<String> cbbFind = new JComboBox<String>();
	static JComboBox<String> cbbTieuChuan = new JComboBox<String>();

	static DefaultTableModel model = new DefaultTableModel();

	static JTable table = new JTable(model);

	static JScrollPane sp = new JScrollPane(table);

	
	
	public BangTieuChi() {
		// ------- Panel Info -------//
				setBounds(165, 1, 828, 765);

				TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
						" Service Form ", TitledBorder.CENTER, TitledBorder.TOP);
				titledBorder.setTitleColor(Color.black);

				setBorder(titledBorder);
				setOpaque(false);

				// ------- Panel Text -------//
				JPanel pnTextField = new JPanel();
				pnTextField.setBounds(30, 30, 770, 280);
				TitledBorder titledBorder1 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Thông tin ",
						TitledBorder.LEFT, TitledBorder.TOP);
				titledBorder1.setTitleColor(Color.black);

				pnTextField.setBorder(titledBorder1);
				pnTextField.setOpaque(false);
				pnTextField.setLayout(null);

				// --------- Text Info --------//

				JLabel lbID = new JLabel("Mã tiêu chí");
				JLabel lbName = new JLabel("Tên tiêu chí");
				JLabel lbDescription = new JLabel("Nội dung");
				JLabel lbIDTieuChuan = new JLabel("Tiêu chuẩn");
				

				//	-------------- ComboBox TieuChuan -----------
				
				lbID.setBounds(70, 40, 80, 30);
				lbName.setBounds(70, 80, 80, 30);
				lbDescription.setBounds(70, 140, 80, 30);
				lbIDTieuChuan.setBounds(70, 200, 80, 30);

				tfID.setBounds(190, 40, 60, 30);
				tfName.setBounds(190, 80, 220, 30);
				tfDescription.setBounds(190, 120, 220, 70);
				cbbTieuChuan.setBounds(190, 200, 220, 30);

				tfID.setEditable(false);
				
				pnTextField.add(lbID);
				pnTextField.add(lbName);
				pnTextField.add(lbDescription);
				pnTextField.add(lbIDTieuChuan);
				
				pnTextField.add(tfID);
				pnTextField.add(tfName);
				pnTextField.add(tfDescription);
				pnTextField.add(cbbTieuChuan);
				

				// -------- Panel Button -------//
				JPanel pnButton = new JPanel();
				pnButton.setBounds(605, 80, 150, 190);
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
//				pnButton.add(btnSave);

				pnTextField.add(pnButton);
				
				// -------- Panel Button Details-------//
				JPanel pnButton1 = new JPanel();
				pnButton1.setBounds(430, 95, 165, 70);
				TitledBorder titledBorder5 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Chi tiết ",
						TitledBorder.LEFT, TitledBorder.TOP);
				titledBorder1.setTitleColor(Color.black);

				pnButton1.setBorder(titledBorder5);
				pnButton1.setOpaque(false);
				pnButton1.setLayout(null);
				
				JButton btnTC = new JButton("Tiêu Chuẩn");

				btnTC.setBounds(25, 25, 115, 30);
				
				pnButton1.add(btnTC);

				pnTextField.add(pnButton1);

				// ------- Panel Table -------//
				JPanel pnTable = new JPanel();
				pnTable.setBounds(30, 330, 770, 425);
				TitledBorder titledBorder2 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Danh sách ",
						TitledBorder.LEFT, TitledBorder.TOP);
				titledBorder.setTitleColor(Color.black);

				pnTable.setBorder(titledBorder2);
				pnTable.setOpaque(false);
				pnTable.setLayout(null);

				// ------ Table -----//
				Vector<String> column = new Vector<String>();

				column.add("Mã tiêu chí");
				column.add("Tên tiêu chí");
				column.add("Nội dung");
				column.add("Mã tiêu chuẩn");

				model.setColumnIdentifiers(column);

				table.setBounds(1, 1, 728, 341);
				
				table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						int row = table.getSelectedRow();
						
						for(int i=0;i<=row;i++) {
							tfID.setText(model.getValueAt(row, 0).toString());
							tfName.setText(model.getValueAt(row, 1).toString());
							tfDescription.setText(model.getValueAt(row, 2).toString());
							cbbTieuChuan.setSelectedItem(model.getValueAt(row, 3));
							tfIDTieuChuan.setText(model.getValueAt(row, 3).toString());
							TieuChuanModel tcmodel = tcDao.get(Integer.parseInt(tfIDTieuChuan.getText()));
							cbbTieuChuan.setSelectedItem(tcmodel.getTenTieuChuan());
						}
						
//						String ten = sachdao.TLBySach(Integer.parseInt(tfID.getText()));
//						tfTL.setText(ten);
					}
				});
				// ------- Scroll Panel -----//

				sp.setBounds(20, 90, 730, 315);

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
				
				btnTC.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new FormTieuChuan(Integer.parseInt(tfID.getText()));
					}
				});
				
			}
			
			
	
	public static void load() {

		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		
		cbbTieuChuan.removeAllItems();
		for(TieuChuanModel item : tcDao.getAll()) {
			cbbTieuChuan.addItem(item.getTenTieuChuan());
		}
		
		List<TieuChiModel> list = tieuChiDao.getAll();
		for (int i = 0; i < list.size(); i++) {
			TieuChiModel sach = (TieuChiModel) list.get(i);
			Vector<String> row = new Vector<String>();
			row.add(Integer.toString(sach.getMaTieuChi()));
			row.add(sach.getTenTieuChi());
			row.add((sach.getNoiDungTieuChi()));
			row.add(Integer.toString(sach.getTieuChuan().getMaTieuChuan()));
			model.addRow(row);
		}
		
		
	}
	
	
	public static void insert() {
		for(TieuChuanModel item : tcDao.getAll()) {
			if(item.getTenTieuChuan().equals(cbbTieuChuan.getSelectedItem())) {
				tfIDTieuChuan.setText(String.valueOf(item.getMaTieuChuan()));
				break;
			}
		}
		
		tieuchuan = new TieuChuanModel(Integer.parseInt(tfIDTieuChuan.getText()), "", "") ;
		TieuChiModel sach = new TieuChiModel(1, 
									tfName.getText(), 
									tfDescription.getText(), 
									tieuchuan);
		if (tieuChiDao.insert(sach) == 1) {
			JOptionPane.showMessageDialog(table, "Thêm thành công",  "About", JOptionPane.INFORMATION_MESSAGE);
			tfID.setText("");
			tfName.setText("");
			tfDescription.setText("");
			tfIDTieuChuan.setText("");
			load();
		} else {
			JOptionPane.showMessageDialog(table, "Thêm thất bại",  "About", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void update() {
		
		for(TieuChuanModel item : tcDao.getAll()) {
			if(item.getTenTieuChuan().equals(cbbTieuChuan.getSelectedItem())) {
				tfIDTieuChuan.setText(String.valueOf(item.getMaTieuChuan()));
				break;
			}
		}
		
		tieuchuan = new TieuChuanModel(Integer.parseInt(tfIDTieuChuan.getText()), "", "") ;
		TieuChiModel sach = new TieuChiModel(1, 
				tfName.getText(), 
				tfDescription.getText(), 
				tieuchuan);
		if (tieuChiDao.update(sach) == 1) {
			JOptionPane.showMessageDialog(table, "Sửa thành công",  "About", JOptionPane.INFORMATION_MESSAGE);
			tfID.setText("");
			tfName.setText("");
			tfDescription.setText("");
			tfIDTieuChuan.setText("");
			load();
		} else {
			JOptionPane.showMessageDialog(table, "Sửa thất bại",  "About", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	public static void delete() {
		if (tieuChiDao.delete(Integer.parseInt(tfID.getText())) == 1 ) {
			JOptionPane.showMessageDialog(table, "Xóa thành công",  "About", JOptionPane.INFORMATION_MESSAGE);
			tfID.setText("");
			tfName.setText("");
			tfDescription.setText("");
			tfIDTieuChuan.setText("");

			load();
		} else {
			JOptionPane.showMessageDialog(table, "Xóa thất bại",  "About", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
	
	public static void findById (int id) {
		
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		
		
		TieuChiModel sach = tieuChiDao.get(id);
		Vector<String> row = new Vector<String>();
		row.add(Integer.toString(sach.getMaTieuChi()));
		row.add(sach.getTenTieuChi());
		row.add(sach.getNoiDungTieuChi());
		row.add(Integer.toString(sach.getTieuChuan().getMaTieuChuan()));
		model.addRow(row);
	}
	
	public static void findByName(String name) {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		
		
		List<TieuChiModel> list = tieuChiDao.getbyname(name);
		for (int i = 0; i < list.size(); i++) {
			TieuChiModel sach = (TieuChiModel) list.get(i);
			Vector<String> row = new Vector<String>();
			row.add(Integer.toString(sach.getMaTieuChi()));
			row.add(sach.getTenTieuChi());
			row.add(sach.getNoiDungTieuChi());
			row.add(Integer.toString(sach.getTieuChuan().getMaTieuChuan()));
			model.addRow(row);
		}
	}
	
}
