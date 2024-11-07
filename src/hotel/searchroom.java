
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class searchroom extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    JComboBox bedt;
    JCheckBox available;
    
    searchroom(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
       JLabel text=new JLabel("Search for Room");
       text.setFont(new Font("Tahoma",Font.PLAIN,20));
       text.setBounds(400,30,200,30);
       add(text);
       //adding bed type
       JLabel bedtype=new JLabel("Bed Type");
       bedtype.setBounds(50,100,100,20);
       add(bedtype);
       //adding combobox;
        
       bedt=new JComboBox(new String[]{"Single Bed","Double Bed"});
       bedt.setBounds(150,100,150,25);
       bedt.setBackground(Color.WHITE);
       add(bedt);
       //adding checkBox
       available =new JCheckBox("Only Display Available");
       available.setBounds(650,100,150,25);
       available.setBackground(Color.WHITE);
       add(available);
       
        //adding table columns
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(50,160,100,20);
        add(l1);
        JLabel l2=new JLabel("Availability");
        l2.setBounds(270,160,100,20);
        add(l2);
         JLabel l3=new JLabel("Status");
        l3.setBounds(450,160,100,20);
        add(l3);
         JLabel l4=new JLabel("Price");
        l4.setBounds(670,160,100,20);
        add(l4);
         JLabel l5=new JLabel("Bed Type");
        l5.setBounds(870,160,100,20);
        add(l5);
        //now adding table
       
        table =new JTable();
        table.setBounds(0,200,1000,300);
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
        //adding submit button
          submit=new JButton("Submit");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setBounds(300,520,120,30);
        add(submit);
        submit.addActionListener(this);
        
        
        //adding back button
        back=new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(500,520,120,30);
        add(back);
        back.addActionListener(this);
        
        
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    public static void main(String args[]){
        new searchroom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            
            try{
                String query="select * from rooms1 where bed_type='"+bedt.getSelectedItem()+"'";
                String query1="select* from rooms1 where availability ='Available'AND bed_type='"+bedt.getSelectedItem()+"' ";
                Conn conn=new Conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs=conn.s.executeQuery(query1);
                }else{
                    rs=conn.s.executeQuery(query);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception ae){
                ae.printStackTrace();
            }
        }
        else{
            setVisible(false);
        
       new Reception();
        }
    }
}
