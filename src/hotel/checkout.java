
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;


public class checkout extends JFrame implements ActionListener {
    Choice ccustomer;
    JLabel lblroomno,lblcheckin,lblcheckout;
    JButton CheckOut,Back;
    checkout() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
        
         JLabel lblid=new JLabel("Customer Id");
        lblid.setBounds(30,80,100,30);
        add(lblid);
        
         ccustomer=new Choice();
        ccustomer.setBounds(150,80,150,25);
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
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(310,80,20,20);
        add(image);
        
        JLabel lblroom=new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);
        
         lblroomno=new JLabel();
        lblroomno.setBounds(150,130,100,30);
        add(lblroomno);
        
        JLabel lblcheck=new JLabel("Checkin time");
        lblcheck.setBounds(30,180,100,30);
        add(lblcheck);
        
         lblcheckin=new JLabel();
        lblcheckin.setBounds(150,180,100,30);
        add(lblcheckin);
        
        JLabel lblchec=new JLabel("Checkout time");
        lblchec.setBounds(30,230,100,30);
        add(lblchec);
        
        Date date=new Date();
         lblcheckout=new JLabel(""+date);
        lblcheckout.setBounds(150,230,150,30);
        add(lblcheckout);
        
        CheckOut=new JButton("CheckOut");
        CheckOut.setForeground(Color.WHITE);
        CheckOut.setBackground(Color.BLACK);
        CheckOut.setBounds(30,280,120,30);
        add(CheckOut);
        CheckOut.addActionListener(this);
        
        Back=new JButton("Back");
        Back.setForeground(Color.WHITE);
        Back.setBackground(Color.BLACK);
        Back.setBounds(170,280,120,30);
        add(Back);
        Back.addActionListener(this);
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image2=new JLabel(i6);
        image2.setBounds(350,50,400,250);
        add(image2);
        
        
        
        setBounds(300,200,800,400);
        setVisible(true);
        
        
        
    }
    public static void main(String args[]){
        new checkout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==CheckOut){
            String query="delete from customer where number='"+ccustomer+"' ";
            String query1="update rooms1 set availability='Available' where roomno='"+lblroomno.getText()+"' ";
            try{
                Conn conn=new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "CHECKOUT DONE");
                setVisible(false);
                new Reception();
                
            }catch(Exception ae){
                ae.printStackTrace();
            }
            
        }else if(e.getSource()==Back){
            setVisible(false);
            new Reception();
        }
        
    }
}
