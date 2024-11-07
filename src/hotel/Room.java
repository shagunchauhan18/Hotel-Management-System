
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Room(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);
        //adding table columns
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(10,10,100,20);
        add(l1);
        JLabel l2=new JLabel("Availability");
        l2.setBounds(120,10,100,20);
        add(l2);
         JLabel l3=new JLabel("Status");
        l3.setBounds(230,10,100,20);
        add(l3);
         JLabel l4=new JLabel("Price");
        l4.setBounds(330,10,100,20);
        add(l4);
         JLabel l5=new JLabel("Bed Type");
        l5.setBounds(410,10,100,20);
        add(l5);
        //now adding table
       
        table =new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        //accessing database to catch the data of rooms
        try{
            Conn conn=new Conn();
          ResultSet rs=  conn.s.executeQuery("select * from rooms1");
          ResultSetMetaData rsmd=rs.getMetaData();
          table.setModel(DbUtils.resultSetToTableModel(rs));
         
          
            
        }catch(Exception ae){
            ae.printStackTrace();
        }
        //adding back button
        back=new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(200,500,120,30);
        add(back);
        back.addActionListener(this);
        
        
        
        setBounds(300,200,1050,600);
        setVisible(true);
    }
    public static void main(String args[]){
        new Room();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       setVisible(false);
       new Reception();
    }
}
