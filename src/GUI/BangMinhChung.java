package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
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

import models.ChiTietMinhChung_PhongBanModel;
import models.ChiTietTieuChiModel;
import models.MergeMinhChungPropertyModel;
import models.MinhChungModel;
import models.PhongBanModel;
import models.TieuChiModel;
import DAO.MinhChungDAO;
import DAO.ChiTietMinhChung_PhongBanDAO;
import DAO.ChiTietMinhChung_TieuChiDAO;
import DAO.TieuChuanDAO;
import DAO.TieuChiDAO;
import DAO.PhongBanDAO;

@SuppressWarnings("serial")
public class BangMinhChung extends JPanel{
	
	static long millis=System.currentTimeMillis();  
    
    static Date date = new Date(millis);       
    
	static MinhChungModel mc = new MinhChungModel();
	static ChiTietMinhChung_PhongBanModel ctmc_pb = new ChiTietMinhChung_PhongBanModel();
	static ChiTietTieuChiModel cttc = new ChiTietTieuChiModel();
	static PhongBanModel pb = new PhongBanModel();
	static TieuChiModel tchi = new TieuChiModel();
	
	static MinhChungDAO mcDao = new MinhChungDAO();
	static ChiTietMinhChung_TieuChiDAO ctmc_tcDao = new ChiTietMinhChung_TieuChiDAO();
	static ChiTietMinhChung_PhongBanDAO ctmc_pbDao = new ChiTietMinhChung_PhongBanDAO();
	static TieuChuanDAO tcDao = new TieuChuanDAO();
	static TieuChiDAO tchiDao = new TieuChiDAO();
	static PhongBanDAO pbDao = new PhongBanDAO();
	
	static JTextField tfID = new JTextField();
	static JTextField tfName = new JTextField();
	static JTextArea tfDescription = new JTextArea();
	static JTextField tfIDTieuChuan = new JTextField();
	static JTextField tfNgayChinhSua = new JTextField();
	static JTextField tfNgayTao = new JTextField();
	static JTextField tfNgayCap = new JTextField();

	static JTextField textFind = new JTextField();

	static JComboBox<String> cbbFind = new JComboBox<String>();
	static JComboBox<String> cbbTieuChi = new JComboBox<String>();
	static JComboBox<String> cbbPhongBan = new JComboBox<String>();

	static DefaultTableModel model = new DefaultTableModel();

	static JTable table = new JTable(model);

	static JScrollPane sp = new JScrollPane(table);

	
	
	public BangMinhChung() {
		// ------- Panel Info -------//
				setBounds(165, 1, 828, 765);

				TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
						" Service Form ", TitledBorder.CENTER, TitledBorder.TOP);
				titledBorder.setTitleColor(Color.black);

				setBorder(titledBorder);
				setOpaque(false);

				// ------- Panel Text -------//
				JPanel pnTextField = new JPanel();
				pnTextField.setBounds(30, 30, 770, 360);
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
				JLabel lbIDTieuChi = new JLabel("Tiêu chí");
				JLabel lbIDPhongBan = new JLabel("Phòng ban");
				JLabel lbNgayTao = new JLabel("Ngày Tạo");
				JLabel lbNgayCap = new JLabel("Ngày Ban Hành");
				

				lbID.setBounds(70, 40, 80, 30);
				lbName.setBounds(70, 80, 80, 30);
				lbDescription.setBounds(70, 140, 80, 30);
				lbIDTieuChi.setBounds(70, 200, 80, 30);
				lbIDPhongBan.setBounds(70, 240, 80, 30);
				lbNgayTao.setBounds(70, 280, 80, 30);
				lbNgayCap.setBounds(70, 320, 80, 30);
				
				tfID.setBounds(190, 40, 60, 30);
				tfName.setBounds(190, 80, 220, 30);
				tfDescription.setBounds(190, 120, 220, 70);
				cbbTieuChi.setBounds(190, 200, 220, 30);
				cbbPhongBan.setBounds(190, 240, 220, 30);
				tfNgayTao.setBounds(190, 280, 220, 30);
				tfNgayCap.setBounds(190, 320, 220, 30);

				pnTextField.add(lbID);
				pnTextField.add(lbName);
				pnTextField.add(lbDescription);
				pnTextField.add(lbIDTieuChi);
				pnTextField.add(lbIDPhongBan);
				pnTextField.add(lbNgayTao);
				pnTextField.add(lbNgayCap);

				pnTextField.add(tfID);
				pnTextField.add(tfName);
				pnTextField.add(tfDescription);
				pnTextField.add(tfNgayTao);
				pnTextField.add(tfNgayCap);
				pnTextField.add(cbbTieuChi);
				pnTextField.add(cbbPhongBan	);
				
				tfIDTieuChuan.setEditable(false);
				tfID.setEditable(false);
				tfNgayTao.setEditable(false);
				tfNgayCap.setEditable(false);
				
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
				JButton btnSave = new JButton("Clear Form");
				

				btnAdd.setBounds(25, 20, 100, 30);
				btnEdit.setBounds(25, 60, 100, 30);
				btnDelete.setBounds(25, 100, 100, 30);
				btnSave.setBounds(25, 140, 100, 30);
				
				pnButton.add(btnAdd);
				pnButton.add(btnEdit);
				pnButton.add(btnDelete);
				pnButton.add(btnSave);

				pnTextField.add(pnButton);
				
				// -------- Panel Button Details-------//
				JPanel pnButton1 = new JPanel();
				pnButton1.setBounds(430, 95, 165, 150);
				TitledBorder titledBorder5 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Chi tiết ",
						TitledBorder.LEFT, TitledBorder.TOP);
				titledBorder1.setTitleColor(Color.black);

				pnButton1.setBorder(titledBorder5);
				pnButton1.setOpaque(false);
				pnButton1.setLayout(null);
				
				JButton btnTC = new JButton("Tiêu Chuẩn");
				JButton btnMC = new JButton("Tiêu Chí");
				JButton btnPB = new JButton("Phòng Ban");

				btnTC.setBounds(25, 25, 115, 30);
				btnMC.setBounds(25, 65, 115, 30);
				btnPB.setBounds(25, 105, 115, 30);
				
				pnButton1.add(btnTC);
				pnButton1.add(btnMC);
				pnButton1.add(btnPB);

				pnTextField.add(pnButton1);

				// ------- Panel Table -------//
				JPanel pnTable = new JPanel();
				pnTable.setBounds(30, 410, 770, 345);
				TitledBorder titledBorder2 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Danh sách ",
						TitledBorder.LEFT, TitledBorder.TOP);
				titledBorder.setTitleColor(Color.black);

				pnTable.setBorder(titledBorder2);
				pnTable.setOpaque(false);
				pnTable.setLayout(null);

				// ------ Table -----//
				Vector<String> column = new Vector<String>();

				column.add("Mã minh chứng");
				column.add("Tên minh chứng");
				column.add("Nội dung");
				column.add("Mã tiêu chí");
				column.add("Mã phòng ban");
				column.add("Ngày Tạo");
				column.add("Ngày cấp");

				model.setColumnIdentifiers(column);

				table.setBounds(1, 1, 728, 261);
				
				table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						int row = table.getSelectedRow();
						for(int i=0;i<=row;i++) {
							tfID.setText(model.getValueAt(row, 0).toString());
							tfName.setText(model.getValueAt(row, 1).toString());
							tfDescription.setText(model.getValueAt(row, 2).toString());
							tfNgayTao.setText(model.getValueAt(row, 5).toString());
							tfNgayCap.setText(model.getValueAt(row, 5).toString());
							TieuChiModel tcmodel = tchiDao.getByName(model.getValueAt(row, 3).toString());
							cbbTieuChi.setSelectedItem(tcmodel.getTenTieuChi());
							PhongBanModel pbmodel = pbDao.getByName(model.getValueAt(row, 4).toString());
							cbbPhongBan.setSelectedItem(pbmodel.getTenPhongBan());
						}
						
//						String ten = sachdao.TLBySach(Integer.parseInt(tfID.getText()));
//						tfTL.setText(ten);
					}
				});
				// ------- Scroll Panel -----//

				sp.setBounds(20, 90, 730, 235);

				// -------- Panel Find -------//
				JPanel pnFind = new JPanel();

				pnFind.setBounds(10, 10, 750, 70);

				pnFind.setOpaque(false);
				pnFind.setLayout(null);

				// ------- Text field Find ------//
				cbbFind.setBounds(20, 20, 140, 30);

				cbbFind.addItem("Tên Minh Chứng");
				cbbFind.addItem("Tên CQ BH");
				cbbFind.addItem("Ngày Tạo (Tự Điền)");
				cbbFind.addItem("Ngày Tạo (ASC)");

				JTextField textFind = new JTextField();
				textFind.setBounds(180, 20, 400, 30);

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
						MinhChungModel mc;
						if(tfID.getText().isEmpty()) {
							mc = new MinhChungModel(0, tfName.getText(), tfDescription.getText());
						} else {
							mc = new MinhChungModel(Integer.parseInt(tfID.getText()), tfName.getText(), tfDescription.getText());
						}
						insert(mc);
						System.out.println("Add Dich Vu");
					}
				});

				btnEdit.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						update(new MinhChungModel(Integer.parseInt(tfID.getText()), 
								tfName.getText(), 
								""));
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
						tfID.setText("");
						tfIDTieuChuan.setText("");
						tfName.setText("");
						tfDescription.setText("");
						load();
					}
				});

				

				btnFind.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
							if (cbbFind.getSelectedIndex()== 0) {
								findByName(textFind.getText());
							} else if (cbbFind.getSelectedIndex() == 1) {
								findByDepartment(textFind.getText());
							} else if (cbbFind.getSelectedIndex() == 2) {
								findByDateIssue(Date.valueOf(textFind.getText()));
							} else {
								sortByDateIssue();
							}
						
					}
				});
				
				btnTC.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						TieuChiModel tc = (TieuChiModel) tchiDao.getbyname(cbbTieuChi.getSelectedItem().toString()).get(0);
						new FormTieuChuan(tc.getTieuChuan().getMaTieuChuan());
					}
				});
				
				btnMC.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						TieuChiModel tc = (TieuChiModel) tchiDao.getbyname(cbbTieuChi.getSelectedItem().toString()).get(0);
						new FormTieuChi(tc.getMaTieuChi());
					}
				});
				
				btnPB.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						PhongBanModel pb = (PhongBanModel) pbDao.getByName(cbbPhongBan.getSelectedItem().toString());
						new FormPhongBan(pb.getMaPhongBan());
					}
				});
				
			}
			
			
	
	public static void load() {

		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		
		cbbPhongBan.removeAllItems();
		cbbTieuChi.removeAllItems();
		for(TieuChiModel item : tchiDao.getAll()) {
			cbbTieuChi.addItem(item.getTenTieuChi());
		}
		
		for(PhongBanModel item : pbDao.getAll()) {
			cbbPhongBan.addItem(item.getTenPhongBan());
		}
		
		List<MergeMinhChungPropertyModel> list = mcDao.getAll();
		for (int i = 0; i < list.size(); i++) {
			MergeMinhChungPropertyModel merge = (MergeMinhChungPropertyModel) list.get(i);
			Vector<String> row = new Vector<String>();
			row.add(Integer.toString(merge.getMaMinhChung()));
			row.add(merge.getTenMinhChung());
			row.add(merge.getNoiDung());
			row.add(merge.getTenTieuChi());
			row.add(merge.getTenPhongBan());
			row.add(String.valueOf(merge.getNgayTao()));
			row.add(String.valueOf(merge.getNgayCungCap()));
			model.addRow(row);
		}
		
		
	}
	
	
	public static void insert(MinhChungModel mc) {
		for(PhongBanModel item : pbDao.getAll()) {
			if(item.getTenPhongBan().equals(cbbPhongBan.getSelectedItem())) {
				pb = item;
				break;
			}
		}
		
		for(TieuChiModel item : tchiDao.getAll()) {
			if(item.getTenTieuChi().equals(cbbTieuChi.getSelectedItem())) {
				tchi = item;
				break;
			}
		}
		
		
		if(mc.getMaMinhChung() == 0) {
			if (mcDao.insert(mc) == 1) {
				MinhChungModel response = mcDao.getLast().get(mcDao.getLast().size() - 1);
				ctmc_pb = new ChiTietMinhChung_PhongBanModel(1, response, pb, date, date);
				cttc = new ChiTietTieuChiModel(1, tchi, response);
				
				if(ctmc_pbDao.insert(ctmc_pb) == 1 &&  ctmc_tcDao.insert(cttc) == 1) {
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
		} else {
			if(ctmc_tcDao.isHasMinhChung(tchi.getMaTieuChi(), mc.getMaMinhChung()) == null) {
				cttc = new ChiTietTieuChiModel(1, 
						tchi, 
						mc);
				if(ctmc_tcDao.insert(cttc) == 1) {
					JOptionPane.showMessageDialog(table, "Thêm minh chứng vào tiêu chí thành công",  "About", JOptionPane.INFORMATION_MESSAGE);
					tfID.setText("");
					tfName.setText("");
					tfDescription.setText("");
					tfIDTieuChuan.setText("");
					load();
				} else {
					JOptionPane.showMessageDialog(table, "Thêm minh chứng thất bại",  "About", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(table, "Minh chứng đã có trong tiêu chí này rồi",  "About", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	public static void update(MinhChungModel updateMinhChung) {
//		if (mcDao.update(updateMinhChung) == 1) {
//			JOptionPane.showMessageDialog(table, "Sửa thành công",  "About", JOptionPane.INFORMATION_MESSAGE);
//			tfID.setText("");
//			tfName.setText("");
//			tfDescription.setText("");
//			tfIDPhongBan.setText("");
//			load();
//		} else {
//			JOptionPane.showMessageDialog(table, "Sửa thất bại",  "About", JOptionPane.INFORMATION_MESSAGE);
//		}
		
	}
	
	public static void delete() {
		if (tchiDao.delete(Integer.parseInt(tfID.getText())) == 1 && 
			ctmc_tcDao.delete(tchi.getMaTieuChi(), Integer.parseInt(tfID.getText())) == 1 &&
			ctmc_pbDao.delete(Integer.parseInt(tfID.getText()), pb.getMaPhongBan()) == 1) {
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
	
	public static void findByDepartment(String name) {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		
		
		List<MergeMinhChungPropertyModel> list;
		try {
			list = mcDao.getByDepartment(name);
			for (int i = 0; i < list.size(); i++) {
				MergeMinhChungPropertyModel merge = (MergeMinhChungPropertyModel) list.get(i);
				Vector<String> row = new Vector<String>();
				row.add(Integer.toString(merge.getMaMinhChung()));
				row.add(merge.getTenMinhChung());
				row.add(merge.getNoiDung());
				row.add(merge.getTenTieuChi());
				row.add(merge.getTenPhongBan());
				row.add(String.valueOf(merge.getNgayTao()));
				row.add(String.valueOf(merge.getNgayCungCap()));
				model.addRow(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void findByDateIssue(Date dateIssue) {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		
		
		List<MergeMinhChungPropertyModel> list;
		try {
			list = mcDao.getByDateIssue(dateIssue);
			for (int i = 0; i < list.size(); i++) {
				MergeMinhChungPropertyModel merge = (MergeMinhChungPropertyModel) list.get(i);
				Vector<String> row = new Vector<String>();
				row.add(Integer.toString(merge.getMaMinhChung()));
				row.add(merge.getTenMinhChung());
				row.add(merge.getNoiDung());
				row.add(merge.getTenTieuChi());
				row.add(merge.getTenPhongBan());
				row.add(String.valueOf(merge.getNgayTao()));
				row.add(String.valueOf(merge.getNgayCungCap()));
				model.addRow(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void sortByDateIssue() {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		
		
		List<MergeMinhChungPropertyModel> list;
		try {
			list = mcDao.sortByDateIssue();
			for (int i = 0; i < list.size(); i++) {
				MergeMinhChungPropertyModel merge = (MergeMinhChungPropertyModel) list.get(i);
				Vector<String> row = new Vector<String>();
				row.add(Integer.toString(merge.getMaMinhChung()));
				row.add(merge.getTenMinhChung());
				row.add(merge.getNoiDung());
				row.add(merge.getTenTieuChi());
				row.add(merge.getTenPhongBan());
				row.add(String.valueOf(merge.getNgayTao()));
				row.add(String.valueOf(merge.getNgayCungCap()));
				model.addRow(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void findByName(String name) {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		
		List<MergeMinhChungPropertyModel> list = mcDao.getByName(name);
		for (int i = 0; i < list.size(); i++) {
			MergeMinhChungPropertyModel merge = (MergeMinhChungPropertyModel) list.get(i);
			Vector<String> row = new Vector<String>();
			row.add(Integer.toString(merge.getMaMinhChung()));
			row.add(merge.getTenMinhChung());
			row.add(merge.getNoiDung());
			row.add(merge.getTenTieuChi());
			row.add(merge.getTenPhongBan());
			row.add(String.valueOf(merge.getNgayTao()));
			row.add(String.valueOf(merge.getNgayCungCap()));
			model.addRow(row);
		}
	}
}
