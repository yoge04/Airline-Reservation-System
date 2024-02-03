package airline;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.Window.Type;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import java.awt.TextArea;
import java.awt.Scrollbar;
import javax.swing.JDesktopPane;
import javax.naming.directory.SearchResult;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;

import com.mysql.cj.xdevapi.Statement;
import com.toedter.calendar.JCalendar;
import javax.swing.JTable;
import javax.swing.JScrollPane;

@SuppressWarnings("unused")

public class book extends JFrame  {
	public String user;

	public void username(String us)
	{
		 user=us;
	}
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton economy;
	private JRadioButton bui;
	private JRadioButton firstc;
	private JTextField date;
	private Object tblData;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					book frame = new book();
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
	@SuppressWarnings("rawtypes")
	public book() {
		setTitle("GCET AIRWAYS");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\HD-wallpaper-aeroplane-military-aircraft.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 110, 535, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setForeground(new Color(176, 224, 230));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> source = new JComboBox<String>();
		source.setBackground(new Color(255, 255, 255));
		source.setToolTipText("source");
		source.setBounds(43, 95, 124, 29);
		contentPane.add(source);
		source.addItem("Source");
		source.addItem("Hyderabad");
		source.addItem("Delhi");
		source.addItem("Mumbai");
		
		@SuppressWarnings("unchecked")
		JComboBox<String> destination = new JComboBox();
		destination.setBackground(new Color(255, 255, 255));
		destination.setToolTipText("Destination");
		destination.setBounds(251, 95, 124, 29);
		contentPane.add(destination);
		destination.addItem("Destination");
		destination.addItem("Hyderabad");
		destination.addItem("Delhi");
		destination.addItem("Mumbai");
		
		JLabel lblNewLabel = new JLabel("BOOK TICKETS..");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(124, 10, 189, 56);
		contentPane.add(lblNewLabel);
		
		@SuppressWarnings("unchecked")
		JComboBox<Integer> passengers = new JComboBox();
		passengers.setBounds(55, 167, 40, 29);
		contentPane.add(passengers);
		passengers.addItem(1);
		passengers.addItem(2);
		passengers.addItem(3);
		passengers.addItem(4);
		
		JLabel lblNewLabel_1 = new JLabel("Number of passengers:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_1.setBounds(45, 147, 135, 23);
		contentPane.add(lblNewLabel_1);
		
		 economy = new JRadioButton("Economy");
		 economy.setBackground(new Color(176, 224, 230));
		economy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(economy.isSelected())
				{
					bui.setSelected(false);
					firstc.setSelected(false);
				}
				
			}
		});
		economy.setBounds(43, 230, 89, 21);
		contentPane.add(economy);
		
		 bui = new JRadioButton("Buisness");
		 bui.setBackground(new Color(176, 224, 230));
		 bui.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(bui.isSelected())
				{
					economy.setSelected(false);
					firstc.setSelected(false);
				}
		 	}
		 });
		bui.setBounds(131, 230, 89, 21);
		contentPane.add(bui);
		
		 firstc = new JRadioButton("First");
		 firstc.setBackground(new Color(176, 224, 230));
		 firstc.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(firstc.isSelected())
				{
					bui.setSelected(false);
					economy.setSelected(false);
				}
		 	}
		 });
		firstc.setBounds(222, 230, 103, 21);
		contentPane.add(firstc);
		
		JLabel lblNewLabel_2 = new JLabel("Choose class:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblNewLabel_2.setBounds(43, 206, 173, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Date:");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(251, 148, 33, 17);
		contentPane.add(lblNewLabel_4);
		
		date = new JTextField();
		date.setToolTipText("dd/mm/yyyy");
		date.setBounds(251, 167, 130, 29);
		contentPane.add(date);
		date.setColumns(10);
		
		JButton bookbtn = new JButton("BOOK TICKETS!");
		bookbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sou = source.getSelectedItem().toString();
				System.out.println(sou);
				String dest = destination.getSelectedItem().toString();
				System.out.println(dest);
				int  passe = passengers.getSelectedIndex();
				passe++;
				System.out.println(passe);
				String Date = date.getText();
				System.out.println(Date);
				String classs=getclass();
				System.out.println(classs);
				int price=getprice(sou,dest,passe,classs);
				if(price!=0) {
			int result=	JOptionPane.showConfirmDialog(null, "Price is: "+price+"  Do you wanna continue?","Confirmation",JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_OPTION)
				{
					//booking sucess
					try {
						
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","Yoge@123");
						String sql="insert into bookings values('abc','"+sou+"','"+dest+"','"+Date+"','"+passe+"')";
						PreparedStatement stm=con.prepareStatement(sql);
						stm.execute();
						JOptionPane.showMessageDialog(null, "Booking Succesful"); 
						con.close();
					}

					catch(Exception ex) {
						System.out.print(ex);
						JOptionPane.showMessageDialog(null,"Error Occured during booking process Try Again!,","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					book bo=new book();
					bo.setVisible(true);
				}
				}
				else JOptionPane.showMessageDialog(null,"Please Enter Appriopriate Values!","Error",JOptionPane.ERROR_MESSAGE);
			}
		});
		bookbtn.setForeground(new Color(255, 255, 255));
		bookbtn.setBackground(new Color(83, 83, 83));
		bookbtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		bookbtn.setBounds(149, 268, 157, 50);
		contentPane.add(bookbtn);
		
		JLabel lblNewLabel_3 = new JLabel("(dd/mm/yyyy)");
		lblNewLabel_3.setBounds(382, 183, 77, 13);
		contentPane.add(lblNewLabel_3);
		

}
	String getclass()
	{
		if (economy.isSelected()){
			return "economy";
		}
		if (bui.isSelected()){
			return "bui";
		}
		if (firstc.isSelected()){
			return "firstc";
		}
		else
		return null;
	}
	int getprice(String s,String d,int pass,String classs)
	{
		int p=0,c =0;
		if(classs=="economy")
			c=0;
		if(classs=="bui")
			c=2100;
		if(classs=="firstc")
			c=4500;
		
		if(s=="Hyderabad"&&d=="Delhi") 
			p=6000;
		if(s=="Hyderabad"&&d=="Mumbai") 
			p=3500;
		if(d=="Hyderabad"&&s=="Delhi") 
			p=6000;
		if(d=="Hyderabad"&&s=="Mumbai") 
			p=3500;
		if(s=="Mumbai"&&d=="Delhi") 
			p=5000;
		if(d=="Mumbai"&&s=="Delhi") 
			p=5000;

		p=p+c;
		p=p*pass;
		
		return p;
	}
}

