package edu.esprit;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import edu.esprit.locator.EmailValidator;
import edu.esprit.locator.Locator;
import edu.letechno.entity.User;
import edu.letechno.entity.University;
import edu.letechno.session.IUniversitySession;
import edu.letechno.session.IUserSession;

public class AddUniversity extends javax.swing.JFrame {

	public AddUniversity() {
		initComponents();
		ImageIcon icon = new ImageIcon("src/main/resources/favicon.png");
		this.setVisible(true);
		this.setResizable(false);
		this.setIconImage(icon.getImage());
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		b = new javax.swing.JTextField();
		c = new javax.swing.JTextField();
		e = new javax.swing.JTextField();
		f = new javax.swing.JTextField();
		g = new javax.swing.JTextField();
		a = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		d = new javax.swing.JTextField();
		h = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(new java.awt.Dimension(350, 520));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setLayout(null);
		jPanel1.add(jLabel1);
		jLabel1.setBounds(34, 86, 0, 0);

		jLabel16.setText("mail :");
		jPanel1.add(jLabel16);
		jLabel16.setBounds(50, 400, 40, 14);

		jLabel12.setText("Name Of University :");
		jPanel1.add(jLabel12);
		jLabel12.setBounds(11, 58, 120, 14);

		jLabel9.setText("adresse : ");
		jPanel1.add(jLabel9);
		jLabel9.setBounds(40, 105, 60, 14);

		jLabel10.setText("University Information :");
		jPanel1.add(jLabel10);
		jLabel10.setBounds(10, 150, 130, 14);

		jLabel8.setText("Name of director :");
		jPanel1.add(jLabel8);
		jLabel8.setBounds(30, 280, 100, 14);

		jLabel13.setText("Login :");
		jPanel1.add(jLabel13);
		jLabel13.setBounds(50, 320, 40, 14);

		jLabel14.setText("Password :");
		jPanel1.add(jLabel14);
		jLabel14.setBounds(30, 360, 90, 14);
		jPanel1.add(b);
		b.setBounds(160, 100, 180, 30);
		jPanel1.add(c);
		c.setBounds(160, 150, 180, 100);
		jPanel1.add(e);
		e.setBounds(160, 310, 180, 30);
		jPanel1.add(f);
		f.setBounds(160, 350, 180, 30);
		jPanel1.add(g);
		g.setBounds(160, 390, 180, 30);
		jPanel1.add(a);
		a.setBounds(160, 50, 180, 30);

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel2.setIcon(new javax.swing.ImageIcon("src/main/resources/plus_button_symbol_400_clr_6175.png")); // NOI18N
		jLabel2.setText("Add University");
		jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				try {
					jLabel2MouseClicked(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		jPanel1.add(jLabel2);
		jLabel2.setBounds(90, 450, 170, 60);
		jPanel1.add(d);
		d.setBounds(160, 270, 180, 30);

		h.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		h.setForeground(new java.awt.Color(255, 0, 0));
		jPanel1.add(h);
		h.setBounds(160, 430, 180, 20);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE));

		setSize(new java.awt.Dimension(366, 559));
		setLocationRelativeTo(null);
	}// </editor-fold>

	private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) throws Exception {
		// add university
		IUniversitySession iuss = (IUniversitySession) Locator.lookup("UniversitySession", IUniversitySession.class);
		IUserSession user = (IUserSession) Locator.lookup("UserSession", IUserSession.class);
		if (validator.validate(g.getText())) {

			User u = new User(d.getText(), "", e.getText(), g.getText(), validator.md5(f.getText()), "uniAdmin");
			//System.out.println(d.getText()+" "+e.getText()+" "+f.getText()+" "+ g.getText());
			University ee = new University(a.getText(), b.getText(), c.getText(), u);
				iuss.AddUniversity(ee, u);
				System.out.println("c fait");
				a.setText("");
				b.setText("");
				c.setText("");
				d.setText("");
				e.setText("");
				f.setText("");
				g.setText("");
		} else {
			JOptionPane.showMessageDialog(null, "Invalid email Adress form");
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(AddUniversity.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AddUniversity.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AddUniversity.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AddUniversity.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AddUniversity().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JTextField a;
	private javax.swing.JTextField b;
	private javax.swing.JTextField c;
	private javax.swing.JTextField d;
	private javax.swing.JTextField e;
	private javax.swing.JTextField f;
	private javax.swing.JTextField g;
	private javax.swing.JLabel h;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	EmailValidator validator = new EmailValidator();
	// End of variables declaration
}
