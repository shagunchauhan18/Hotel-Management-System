
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Updateroom extends JFrame implements ActionListener {
    JTextField tfroom,tfavailable,tfstatus;
    Choice ccustomer;
    JButton check,update,back;
    Updateroom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,25));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);
        
        JLabel id=new JLabel("Customer Id");
        id.setBounds(30,80,100,20);
        add(id);
        
        ccustomer=new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select* from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number")); 
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        JLabel room=new JLabel("Room No");
        room.setBounds(30,130,100,20);
        add(room);
        
        tfroom=new JTextField();
        tfroom.setBounds(200,130,150,25);
        add(tfroom);
        
         JLabel name=new JLabel("Availability");
        name.setBounds(30,180,100,20);
        add(name);
        
        tfavailable=new JTextField();
        tfavailable.setBounds(200,180,150,25);
        add(tfavailable);
        
         JLabel checkin=new JLabel("Cleaning Status");
        checkin.setBounds(30,230,100,20);
        add(checkin);
        
        tfstatus=new JTextField();
        tfstatus.setBounds(200,230,150,25);
        add(tfstatus);
        
        
        //adding buittons
        check =new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,300,100,30);
        add(check);
        check.addActionListener(this);
        
         back =new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,300,100,30);
        add(back);
        back.addActionListener(this);
        
         update =new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,300,100,30);
        add(update);
        update.addActionListener(this);
        
        //adding image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);          
        
        setBounds(300,200,980,500);
        setVisible(true);
        
    }
    public static void main(String args[]){
        new Updateroom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==check){
            String id=ccustomer.getSelectedItem();
            String query="select * from customer where number='"+id+"'";
            try{
                Conn conn=new Conn();
                ResultSet rs=conn.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                    
                       
                     
                     
                }
                ResultSet rs2=conn.s.executeQuery("select * from rooms1 where roomno ='"+tfroom.getText()+"' ");
                while(rs2.next()){
                   tfavailable.setText(rs2.getString("availability"));
                   tfstatus.setText(rs2.getString("clean_status"));
                   
                    
                    
                }
            }catch(Exception ae){
                ae.printStackTrace();
            }
        }else if(e.getSource()==update){
            String number=ccustomer.getSelectedItem();
            String room=tfroom.getText();
            String available=tfavailable.getText();
          
            String status=tfstatus.getText();
            try{
                Conn conn=new Conn();
                conn.s.executeUpdate("update rooms1 set availability='"+available+"', clean_status='"+status+"' where roomno='"+room+"' ");
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                setVisible(false);
                new Reception();
            }catch(Exception ae){
                ae.printStackTrace();
            }
            
        }else if(e.getSource()==back){
             setVisible(false);
                new Reception();
        }
        
    }
}
