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

import DAO.PhongBanDAO;
import models.PhongBanModel;

@SuppressWarnings("serial")
public class FormPhongBan extends JFrame {
	static PhongBanDAO pbdao = new PhongBanDAO();
	static int pbId;
	JPanel pnMenu = new JPanel();


	static JTextField tfID = new JTextField();
	static JTextField tfName = new JTextField();
	static JTextField tfDesc = new JTextField();
	
	static DefaultTableModel model = new DefaultTableModel();
	
	static JTable table = new JTable(model);
	
	static JScrollPane sp = new JScrollPane(table);
	
	public FormPhongBan(int id) {
		pbId = id;
		setTitle("Form Phòng Ban");
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

		JLabel lbID = new JLabel("Mã Phòng Ban");
		JLabel lbName = new JLabel("Tên Phòng Ban");

		lbID.setBounds(80, 40, 80, 30);
		lbName.setBounds(80, 80, 80, 30);

		tfID.setBounds(180, 40, 80, 30);
		tfName.setBounds(180, 80, 220, 30);

		pnTextField.add(lbID);
		pnTextField.add(lbName);

		pnTextField.add(tfID);
		pnTextField.add(tfName);
		
		tfID.setEditable(false);
		tfName.setEditable(false);
		
		add(pnTextField);

		// -----------------------//
		setLayout(null);
		load();
	}
	
	public static void load() {
		PhongBanModel tg = pbdao.get(pbId);
		tfID.setText(Integer.toString(tg.getMaPhongBan())); 
		tfName.setText(tg.getTenPhongBan());	 	
	}
	
	
}
