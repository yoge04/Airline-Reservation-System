package airline;
import java.io.*;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JCalendar;

@SuppressWarnings("unused")
public class LOGIN extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private static final String dup = null;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN frame = new LOGIN();
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
	public LOGIN() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\HD-wallpaper-aeroplane-military-aircraft.jpg"));
		setTitle("GCET AIRLINES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 692);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" Log-in Page");
		lblNewLabel_1.setBackground(new Color(0, 64, 64));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_1.setBounds(232, 67, 211, 54);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  String us= user.getText();
				char[] ps= pass.getPassword();
				String p=new String(ps);
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","Yoge@123");
					Statement stm=con.createStatement();
					ResultSet rs=stm.executeQuery("select * from login where username='"+us+"' and password='"+p+"'");
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Login Succesfull");
						book boo=new book();
						boo.setVisible(true);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invaliod Username or Password ");
					}
					con.close();
				}

				catch(Exception ex) {
					System.out.print(ex);
				}
				String dup=us;
			
				
				
			}
			
		});
		btnNewButton.setBounds(144, 294, 85, 21);
		contentPane.add(btnNewButton);
		
		user = new JTextField();
		user.setBounds(134, 217, 114, 21);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(134, 265, 114, 19);
		contentPane.add(pass);
		
		JLabel lblNewLabel_2 = new JLabel("username:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(44, 217, 80, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("password:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(57, 264, 67, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Haven't Register Yet?...");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_3.setForeground(new Color(153, 0, 0));
		lblNewLabel_3.setBounds(27, 482, 250, 21);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("REGISTER NOW!");
		btnNewButton_1.setForeground(new Color(0, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register reg=new register();
				reg.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(44, 513, 143, 54);
		contentPane.add(btnNewButton_1);
		
		JLabel backimage = new JLabel("");
		backimage.setBackground(new Color(30, 144, 255));
		backimage.setHorizontalAlignment(SwingConstants.TRAILING);
		backimage.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		backimage.setForeground(new Color(0, 0, 255));
		backimage.setIcon(new ImageIcon("src\\generic-airplane-blue-sky-medium.jpg"));
		backimage.setBounds(-13, -21, 769, 699);
		contentPane.add(backimage);
	}
	

}
