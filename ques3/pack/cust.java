package pack;
import javax.swing.*;

//import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.DriverManager;
import java.awt.BorderLayout;
import java.awt.Container;
//import java.sql.SQLException;
import java.awt.GridLayout;
import java.sql.*;
public class cust extends JFrame{
JLabel c=new JLabel("customer details");
JLabel jlbc1 = new JLabel("Enter custno");
JLabel jlbc2 = new JLabel("Enter custname");
JLabel jlbc3 = new JLabel("Enter state");
JLabel jlbc4 = new JLabel("Enter credit_limit");
JLabel jlbc5 = new JLabel("Enter repno");
JTextField txtc1 = new JTextField(11);
JTextField txtc2 = new JTextField(20);
JTextField txtc3 = new JTextField(20);
JTextField txtc4 = new JTextField(11);
JTextField txtc5 = new JTextField(11);

JLabel r=new JLabel("representative details");
JLabel jlbr1 = new JLabel("Enter repsentative no");
JLabel jlbr2 = new JLabel("Enter representative name");
JLabel jlbr3 = new JLabel("Enter representative state");
JLabel jlbr4 = new JLabel("Enter representative comission");
JLabel jlbr5 = new JLabel("Enter representative rate");
JTextField txtr1 = new JTextField(11);
JTextField txtr2 = new JTextField(20);
JTextField txtr3 = new JTextField(20);
JTextField txtr4 = new JTextField(11);
JTextField txtr5 = new JTextField(11);

JButton insertbtn2 = new JButton("insert");
JButton btn=new JButton("Representative whose credit_limit is > 15000");
//JScrollPane pane=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
public cust(String title)
{
	super(title);
	Container cont=getContentPane();
	//setLayout(new FlowLayout());
	cont.setLayout(new GridLayout(0,1));
	
	cont.add(r);
	cont.add(jlbr1);cont.add(txtr1);
	cont.add(jlbr2);cont.add(txtr2);
	cont.add(jlbr3);cont.add(txtr3);
	cont.add(jlbr4);cont.add(txtr4);
	cont.add(jlbr5);cont.add(txtr5);
	
	cont.add(c);
	cont.add(jlbc1);cont.add(txtc1);
	cont.add(jlbc2);cont.add(txtc2);
	cont.add(jlbc3);cont.add(txtc3);
	cont.add(jlbc4);cont.add(txtc4);
	cont.add(jlbc5);cont.add(txtc5);
	
	cont.add(insertbtn2);
	cont.add(btn);
	//cont.add(pane);
	insertbtn2.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent evt)
	{
		Statement stmt;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","qwerty");
			stmt = conn.createStatement();
			String query1 = "insert into customer(custno,custname,state,credit_limit,repno) values("+Integer.parseInt(txtc1.getText())+", '"+txtc2.getText()+"'"+", '"+txtc3.getText()+"'"+","+Integer.parseInt(txtc4.getText())+","+Integer.parseInt(txtc5.getText())+");";
			stmt.executeUpdate(query1);
			String query2 = "insert into representative(repno,repname,state,comission,rate) values("+Integer.parseInt(txtr1.getText())+", '"+txtr2.getText()+"'"+", '"+txtr3.getText()+"'"+","+Integer.parseInt(txtr4.getText())+","+Integer.parseInt(txtr5.getText())+");";
			stmt.executeUpdate(query2);
			ResultSet rs1= stmt.executeQuery("select * from representative");
			while(rs1.next())
			{
				System.out.println("representative no is "+rs1.getInt(1));
				System.out.println("representative name is "+rs1.getString(2));
				System.out.println("representative state is "+rs1.getString(3));
				System.out.println("representative comission is "+rs1.getInt(4));
				System.out.println("representative rate is "+rs1.getInt(5));
			}
					
		}
		catch(Exception e)
		{
			System.out.println("Exception occurred is"+ e);
		}
	}
});
	

	
	btn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt)
		{
			Statement stmt;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","qwerty");
				stmt = conn.createStatement();
				String query3 = "select representative.repno,repname,representative.state,comission,rate from customer,representative where customer.repno=representative.repno and credit_limit>=15000;";
				ResultSet rs3=stmt.executeQuery(query3);
				//Container con=getContentPane();
				//con.setLayout(new GridLayout(0,1)));
				//con.setVisible(true);
				while(rs3.next())
				{
					System.out.println(rs3.getInt(1));
					System.out.println(rs3.getString(2));
					System.out.println(rs3.getString(3));
					System.out.println(rs3.getInt(4));
					System.out.println(rs3.getInt(5));
					JLabel j1 = new JLabel("repsentative no");
					JLabel j2 = new JLabel("representative name");
					JLabel j3 = new JLabel("representative state");
					JLabel j4 = new JLabel("representative comission");
					JLabel j5 = new JLabel("representative rate");
					JTextField t1 = new JTextField(11);
					JTextField t2 = new JTextField(20);
					JTextField t3 = new JTextField(20);
					JTextField t4 = new JTextField(11);
					JTextField t5 = new JTextField(11);
					t1.setText(String.valueOf(rs3.getInt(1)));
					t2.setText(rs3.getString(2));
					t3.setText(rs3.getString(3));
					t4.setText(String.valueOf(rs3.getInt(4)));
					t5.setText(String.valueOf(rs3.getInt(5)));

					cont.add(j1);cont.add(t1);
					cont.add(j2);cont.add(t2);
					cont.add(j3);cont.add(t3);
					cont.add(j4);cont.add(t4);
					cont.add(j5);cont.add(t5);
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception occurred is"+ e);
			}
			
		}
		
		}
		);
}
	public static void main(String args[])
	{
		cust c = new cust("Customer Rppresentative");
		c.setSize(450,1000);
		c.setVisible(true);
	}
}