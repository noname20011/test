package GUI;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import DAO.TieuChuanDAO;
import models.TieuChuanModel;

@SuppressWarnings("serial")
public class FormTieuChuan extends JFrame{
	static int tcId;
	
	static TieuChuanDAO tcdao = new TieuChuanDAO();
	JPanel pnMenu = new JPanel();


	static JTextField tfID = new JTextField();
	static JTextField tfName = new JTextField();
	static JTextField tfDesc = new JTextField();
	
	static DefaultTableModel model = new DefaultTableModel();
	
	static JTable table = new JTable(model);
	
	static JScrollPane sp = new JScrollPane(table);
	
	public FormTieuChuan(int id) {
		tcId = id;
		setTitle("Form Tiêu Chuẩn");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(755, 400);
		setLayout(null);
		setVisible(true);

		// ------- Panel Text -------//

		JPanel pnTextField = new JPanel();
		pnTextField.setBounds(95, 30, 535, 230);
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Thông tin ",
				TitledBorder.LEFT, TitledBorder.TOP);
		titledBorder1.setTitleColor(Color.black);

		pnTextField.setBorder(titledBorder1);
		pnTextField.setOpaque(false);
		pnTextField.setLayout(null);

		// --------- Text Info --------//

		JLabel lbID = new JLabel("Mã tiêu chuẩn");
		JLabel lbName = new JLabel("Tên tiêu chuẩn");
		JLabel lbEmail = new JLabel("Nội dung");

		lbID.setBounds(80, 40, 80, 30);
		lbName.setBounds(80, 80, 80, 30);
		lbEmail.setBounds(80, 120, 80, 30);

		tfID.setBounds(180, 40, 80, 30);
		tfName.setBounds(180, 80, 220, 30);
		tfDesc.setBounds(180, 120, 220, 30);

		pnTextField.add(lbID);
		pnTextField.add(lbName);
		pnTextField.add(lbEmail);

		pnTextField.add(tfID);
		pnTextField.add(tfName);
		pnTextField.add(tfDesc);
		
		tfID.setEditable(false);
		tfName.setEditable(false);
		tfDesc.setEditable(false);
		
		add(pnTextField);

		// -----------------------//
		setLayout(null);
		load();
	}
	
	public static void load() {
		TieuChuanModel tg = tcdao.get(tcId);
		tfID.setText(Integer.toString(tg.getMaTieuChuan())); 
		tfName.setText(tg.getTenTieuChuan());	
		tfDesc.setText(tg.getNoiDung()); 	
	}
	
}