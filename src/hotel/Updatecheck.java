
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Updatecheck extends JFrame implements ActionListener {
    JTextField tfroom,tfname,tfcheck,tfpaid,tfpending;
    Choice ccustomer;
    JButton check,update,back;
    Updatecheck(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(90,20,200,30);
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
        room.setBounds(30,120,100,20);
        add(room);
        
        tfroom=new JTextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);
        
         JLabel name=new JLabel("Name");
        name.setBounds(30,160,100,20);
        add(name);
        
        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
         JLabel checkin=new JLabel("Checkin Time");
        checkin.setBounds(30,200,100,20);
        add(checkin);
        
        tfcheck=new JTextField();
        tfcheck.setBounds(200,200,150,25);
        add(tfcheck);
        
         JLabel apaid=new JLabel("Amount Paid");
        apaid.setBounds(30,240,100,20);
        add(apaid);
        
        tfpaid=new JTextField();
        tfpaid.setBounds(200,240,150,25);
        add(tfpaid);
        
         JLabel pending=new JLabel("Pending Amount");
        pending.setBounds(30,280,100,20);
        add(pending);
        
        tfpending=new JTextField();
        tfpending.setBounds(200,280,150,25);
        add(tfpending);
        
        //adding buittons
        check =new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,340,100,30);
        add(check);
        check.addActionListener(this);
        
         back =new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,340,100,30);
        add(back);
        back.addActionListener(this);
        
         update =new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,340,100,30);
        add(update);
        update.addActionListener(this);
        
        //adding image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);          
        
        setBounds(300,200,980,500);
        setVisible(true);
        
    }
    public static void main(String args[]){
        new Updatecheck();
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
                     tfname.setText(rs.getString("name"));
                      tfcheck.setText(rs.getString("checkintime"));
                       tfpaid.setText(rs.getString("deposit"));
                       
                     
                     
                }
                ResultSet rs2=conn.s.executeQuery("select * from rooms1 where roomno ='"+tfroom.getText()+"' ");
                while(rs2.next()){
                    String price=rs2.getString("price");
                    int amountpaid=Integer.parseInt(price)-Integer.parseInt(tfpaid.getText());
                    tfpending.setText(""+amountpaid);
                    
                    
                }
            }catch(Exception ae){
                ae.printStackTrace();
            }
        }else if(e.getSource()==update){
             String number=ccustomer.getSelectedItem();
            String room=tfroom.getText();
            String checkin=tfcheck.getText();
            String deposit=tfpaid.getText();
            String name=tfname.getText();
            try{
                Conn conn=new Conn();
                conn.s.executeUpdate("update customer set room='"+room+"' ,name='"+name+"' ,checkintime='"+checkin+"', deposit='"+deposit+"' where number='"+number+"' ");
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
