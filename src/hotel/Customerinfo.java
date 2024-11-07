
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Customerinfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Customerinfo(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        //adding table columns
        JLabel l1=new JLabel("Document Type");
        l1.setBounds(10,10,100,20);
        add(l1);
        JLabel l2=new JLabel("Number");
        l2.setBounds(160,10,100,20);
        add(l2);
         JLabel l3=new JLabel("Name");
        l3.setBounds(290,10,100,20);
        add(l3);
         JLabel l4=new JLabel("Gender");
        l4.setBounds(410,10,100,20);
        add(l4);
        
         JLabel l5=new JLabel("Country");
        l5.setBounds(540,10,100,20);
        add(l5);
         JLabel l6=new JLabel("Room Number");
        l6.setBounds(640,10,100,20);
        add(l6);
         JLabel l7=new JLabel("Checkin");
        l7.setBounds(760,10,100,20);
        add(l7);
         JLabel l8=new JLabel("Deposit");
        l8.setBounds(900,10,100,20);
        add(l8);
        //now adding table
       
        table =new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        //accessing database to catch the data of rooms
        try{
            Conn conn=new Conn();
          ResultSet rs=  conn.s.executeQuery("select * from customer");
          ResultSetMetaData rsmd=rs.getMetaData();
          table.setModel(DbUtils.resultSetToTableModel(rs));
         
          
            
        }catch(Exception ae){
            ae.printStackTrace();
        }
        //adding back button
        back=new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(420,500,120,30);
        add(back);
        back.addActionListener(this);
        
        
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    public static void main(String args[]){
        new Customerinfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       setVisible(false);
       new Reception();
    }
}
