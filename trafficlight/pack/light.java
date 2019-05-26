package pack;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;
public class light extends JFrame implements ActionListener{
JRadioButton r1=new JRadioButton("Red");
JRadioButton r2=new JRadioButton("Orange");
JRadioButton r3=new JRadioButton("Green");
JLabel l = new JLabel(); 
ButtonGroup btg = new ButtonGroup();
{
	btg.add(r1);
	btg.add(r2);
	btg.add(r3);
	
	r1.addActionListener(this);
	r2.addActionListener(this);
	r3.addActionListener(this);
}

light()
{
	super("Traffic Light");
	Container cont=getContentPane();
	cont.setLayout(new FlowLayout());
	//cont.setLayout(new GridLayout(3,1));
	cont.add(r1);
	cont.add(r2);
	cont.add(r3);
	cont.add(l);
}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==r1)
	{
		l.setForeground(Color.RED);
		l.setText("STOP");
	}
	else if(e.getSource()==r2)
	{
		l.setForeground(Color.ORANGE);
		l.setText("READY");
	}
	else if(e.getSource()==r3)
	{
		l.setForeground(Color.GREEN);
		l.setText("GO");
	}
	
}
public static void main(String args[])
{
	light l=new light();
	l.setSize(300,300);
	l.setVisible(true);
	l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
