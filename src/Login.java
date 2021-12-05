


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class Login {

	public static void main(String[] args) 
	{
		JFrame f= new JFrame();
		f.setSize(700,500);
		f.setResizable(false);
	               
        
        JPanel p1 = new JPanel();
        p1.setBounds(0, 50, 780, 70);
        p1.setBackground(new Color(25, 102, 80));
        f.getContentPane().add(p1,BorderLayout.NORTH);

        JPanel p = new JPanel();
        p.setLayout(null);
        f.add(p);
        
        JLabel l = new JLabel("LOGIN");
        l.setForeground(Color.WHITE);
        l.setBounds(275,10,300,40);
        l.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        p1.add(l);
       
        p.setBackground(Color.WHITE);
        
        ImageIcon img = new ImageIcon(new ImageIcon("/Users/Beena VS/eclipse-workspace/PROJECT/src/DBM/personicon1.png").getImage().getScaledInstance(140, 140, java.awt.Image.SCALE_SMOOTH));         
        JLabel piclabel= new JLabel(img);
        piclabel.setBounds(280,10,150,150);
        p.add(piclabel);
        
		
        JLabel l1= new JLabel("USER ID :");
        l1.setBounds(160,160,300,40);
        l1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        p.add(l1);
        
        
		final JTextField t1= new JTextField();
		t1.setBounds(280,160,250,40);
		p.add(t1);
		
		JLabel l2= new JLabel("PASSWORD :");
		l2.setBounds(120,210,250,40);
		l2.setFont(new Font("Times New Roman",Font.PLAIN,20));
		p.add(l2);
		
		final JPasswordField t2= new JPasswordField();
		t2.setBounds(280,210,250,40);
		p.add(t2);
		
        
		final JButton b1= new JButton("SUBMIT");
		b1.setBounds(300,300,100,40);
		b1.setBackground(new Color(25, 102, 80));
		b1.setForeground(Color.WHITE);
		b1.setOpaque(true);
		p.add(b1);
		
		
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b1.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
					{
						String u=t1.getText();
						String p=t2.getText();
						
						try
						{
							Connection connection=(Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/PROJECT","postgres","vishaal1");
							PreparedStatement st= connection.prepareStatement("select name,password from student where name=? and password=?");
							st.setString(1,u);
							st.setString(2,p);
							ResultSet rs= st.executeQuery();
							
							if(rs.next())
							{
								HOME p1= new HOME();
								dispose();
								p1.setVisible(true);
								
								
							}
							else
							{
								JOptionPane.showMessageDialog(b1,"Invaid Credentials");
							}
			
						}
						catch(SQLException sqlException)
						{
							sqlException.printStackTrace();
						}
					}

					private void dispose() {
						// TODO Auto-generated method stub
						
					}
					
				});
		
	

	}

}



