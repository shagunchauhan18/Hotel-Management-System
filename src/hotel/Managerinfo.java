
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Managerinfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Managerinfo(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        //adding table columns
        JLabel l1=new JLabel("Name");
        l1.setBounds(40,10,100,20);
        add(l1);
        JLabel l2=new JLabel("Age");
        l2.setBounds(170,10,100,20);
        add(l2);
         JLabel l3=new JLabel("Gender");
        l3.setBounds(290,10,100,20);
        add(l3);
         JLabel l4=new JLabel("Job");
        l4.setBounds(410,10,100,20);
        add(l4);
        
         JLabel l5=new JLabel("Salary");
        l5.setBounds(540,10,100,20);
        add(l5);
         JLabel l6=new JLabel("Phone");
        l6.setBounds(670,10,100,20);
        add(l6);
         JLabel l7=new JLabel("Email");
        l7.setBounds(790,10,100,20);
        add(l7);
         JLabel l8=new JLabel("Adhar");
        l8.setBounds(910,10,100,20);
        add(l8);
        //now adding table
       
        table =new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        //accessing database to catch the data of rooms
        try{
            Conn conn=new Conn();
          ResultSet rs=  conn.s.executeQuery("select * from employee4 where job='Manager'");
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
        new Managerinfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       setVisible(false);
       new Reception();
    }
}
