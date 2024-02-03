package airline;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import com.toedter.calendar.JCalendar;

@SuppressWarnings("unused")
public class register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField mail;
	private JTextField num;
	private JTextField us;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public register() {
		setBackground(new Color(0, 0, 0));
		setForeground(new Color(0, 0, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\HD-wallpaper-aeroplane-military-aircraft.jpg"));
		setTitle("Registration Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 590);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setForeground(new Color(30, 144, 255));
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setContentPane(contentPane);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setBounds(29, 108, 179, 35);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(29, 76, 115, 33);
		contentPane.add(lblNewLabel);
		
		mail = new JTextField();
		mail.setBounds(29, 167, 200, 32);
		contentPane.add(mail);
		mail.setColumns(10);
		
		num = new JTextField();
		num.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
			}
		});
		num.setBounds(29, 242, 161, 32);
		contentPane.add(num);
		num.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(218, 76, 0, 198);
		contentPane.add(separator);
		
		us = new JTextField();
		us.setBounds(279, 111, 115, 30);
		contentPane.add(us);
		us.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(279, 168, 115, 30);
		contentPane.add(pass);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(29, 153, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("phone number:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(29, 226, 140, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("username:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(280, 97, 114, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(279, 153, 115, 13);
		contentPane.add(lblNewLabel_4);
		JCheckBox accept = new JCheckBox("I accept all terms and conditions");
		accept.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 10));
		accept.setBackground(new Color(128, 128, 255));
		accept.setBounds(29, 305, 390, 21);
		contentPane.add(accept);
		
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n= name.getText();
				String em= mail.getText();
				String mobile= num.getText();
				String user= us.getText();
				char[] p= pass.getPassword();
				String pas=new String(p);

				
				if(accept.isSelected()) {
				
					
						
				
				
					
						try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","Yoge@123");
							String sql="insert into login values('"+user+"','"+pas+"','"+em+"','"+n+"','"+mobile+"')";
							PreparedStatement stm=con.prepareStatement(sql);
							stm.execute();
							JOptionPane.showMessageDialog(null, "Registration succesful"); 
							con.close();
						}

						catch(Exception ex) {
							System.out.print(ex);
							JOptionPane.showMessageDialog(null,"OOPS! Please try again","Error",JOptionPane.ERROR_MESSAGE);
						}
						
					
				}
				
				else JOptionPane.showMessageDialog(null,"Terms and conditions not accepted","WARNING",JOptionPane.WARNING_MESSAGE );
				
				
			}
		});
		btnNewButton.setBounds(169, 371, 145, 48);
		contentPane.add(btnNewButton);
		
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		popupMenu_1.setBounds(227, 242, 200, 50);
		contentPane.add(popupMenu_1);
		
		JLabel lblNewLabel_5 = new JLabel("GCET AIRLINES...");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(29, 28, 414, 38);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Let us help you travel the world......");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel_6.setBounds(0, 449, 350, 13);
		contentPane.add(lblNewLabel_6);
		
	
		

	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

}
