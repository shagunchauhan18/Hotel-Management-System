
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    department(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
       
        //adding table columns
        JLabel l1=new JLabel("Department");
        l1.setBounds(180,10,100,20);
        add(l1);
        JLabel l2=new JLabel("Budget");
        l2.setBounds(420,10,100,20);
        add(l2);
         JLabel l3=new JLabel("Status");
      
        //now adding table
       
        table =new JTable();
        table.setBounds(0,50,700,350);
        add(table);
        //accessing database to catch the data of rooms
        try{
            Conn conn=new Conn();
          ResultSet rs=  conn.s.executeQuery("select * from department");
          ResultSetMetaData rsmd=rs.getMetaData();
          table.setModel(DbUtils.resultSetToTableModel(rs));
         
          
            
        }catch(Exception ae){
            ae.printStackTrace();
        }
        //adding back button
        back=new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(280,400,120,30);
        add(back);
        back.addActionListener(this);
        
        
        
        setBounds(400,200,700,480);
        setVisible(true);
    }
    public static void main(String args[]){
        new department();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       setVisible(false);
       new Reception();
    }
}
