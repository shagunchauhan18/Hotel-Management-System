/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class addrooms extends JFrame implements ActionListener {
    JButton addroom,cancel;
     JTextField roomno1,pr;
      JComboBox av,av1,av2;   
    addrooms(){
        setLayout(null);
        //adding frame color
        getContentPane().setBackground(Color.WHITE);
        //adding heading
        JLabel heading=new JLabel("ADD ROOMS");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);
        //adding room number label
          JLabel roomno=new JLabel("Room Number");
        roomno.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,16));
        roomno.setBounds(60,80,120,30);
        add(roomno);
        //adding textfield of roomno
        roomno1=new JTextField();
        roomno1.setBounds(200,80,150,30);
        add(roomno1);
        //adding available label
          JLabel avail=new JLabel("Available");
        avail.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,16));
        avail.setBounds(60,130,120,30);
        add(avail);
        //ADDING DROPDOWN LIST
        String str[]={"Available","Occupied"};
         av=new JComboBox(str);
        av.setBounds(200,130,150,30);
        av.setBackground(Color.WHITE);
        add(av);
        //adding cleaningstatus label
          JLabel status=new JLabel("Cleaning Status");
        status.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,16));
        status.setBounds(60,180,120,30);
        add(status);
        //ADDING DROPDOWN LIST
        String str1[]={"Cleaned","Dirty"};
         av1=new JComboBox(str1);
        av1.setBounds(200,180,150,30);
        av1.setBackground(Color.WHITE);
        add(av1);
         //adding price label
          JLabel price=new JLabel("Price");
        price.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,16));
        price.setBounds(60,230,120,30);
        add(price);
        //adding textfield of roomno
         pr=new JTextField();
        pr.setBounds(200,230,150,30);
        add(pr);
         //adding bedtype label
          JLabel bed=new JLabel("Bed Type");
        bed.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,16));
        bed.setBounds(60,280,120,30);
        add(bed);
        //ADDING DROPDOWN LIST
        String str2[]={"Single Bed","Double Bed"};
         av2=new JComboBox(str2);
        av2.setBounds(200,280,150,30);
        av2.setBackground(Color.WHITE);
        add(av2);
        //adding buttons
         addroom=new JButton("Add Rooms");
        addroom.setForeground(Color.WHITE);
        addroom.setBackground(Color.BLACK);
        addroom.setBounds(60,350,130,30);
        add(addroom);
        addroom.addActionListener(this);
         cancel=new JButton("Cancel");
         cancel.setForeground(Color.WHITE);
         cancel.setBackground(Color.BLACK);
         cancel.setBounds(220,350,130,30);
        add( cancel);
        cancel.addActionListener(this);
        //adding image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
        
        
        
        
        setBounds(330,200,940,470);
        setVisible(true);
        
        
    }
    public static void main(String []args){
        new addrooms();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addroom){
            String roomnoo=roomno1.getText();
            String availableroom= (String) av.getSelectedItem();
            String clean=(String) av1.getSelectedItem();
            String bedroom=(String) av2.getSelectedItem();
            String price1=pr.getText();
            try{
                Conn conn=new Conn();
                String str1="Insert into rooms1 values('"+roomnoo+"','"+availableroom+"','"+clean+"','"+price1+"','"+bedroom+"')";
                conn.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null, "New Room Added Successfully");
                setVisible(false); 
                
            }catch(Exception ae){
                ae.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
        
    }
    
}
