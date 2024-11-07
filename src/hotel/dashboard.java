/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class dashboard extends JFrame implements ActionListener{
    dashboard(){
        setBounds(0,0,1550,1000);
        setLayout(null);
       //adding image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        //adding text
        JLabel text=new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,46));
        text.setForeground(Color.WHITE);
        image.add(text);
        //adding menubar
        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1550,30);
        mb.setBackground(Color.orange);
        image.add(mb);
        //adding menubar option for hotelmanagement
        JMenu hotel=new JMenu("Hotel Management");
        hotel.setForeground(Color.WHITE);
        hotel.setFont(new Font("Tahoma",Font.BOLD,15));
        mb.add(hotel);
        // adding menuitems to hotelmanagement
        JMenuItem reception=new JMenuItem("Reception");
        reception.addActionListener(this);
        hotel.add(reception);
        
        
        
         //adding menubar option for admin
        JMenu admin=new JMenu("Admin");
        admin.setForeground(Color.cyan);
        admin.setFont(new Font("Tahoma",Font.BOLD,15));
        mb.add(admin);
        //adding menuitems to admin
        JMenuItem addemployee=new JMenuItem("Add Employee");
         addemployee.addActionListener(this);
        admin.add(addemployee);
        //adding more options
        JMenuItem addroom=new JMenuItem("Add Rooms");
         addroom.addActionListener(this);
        admin.add(addroom);
        JMenuItem addriver=new JMenuItem("Add Driver");
        addriver.addActionListener(this);
        admin.add(addriver);
        
        
        
        
        
         setVisible(true);
        
    }
    public static void main(String args[]){
        new dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getActionCommand().equals("Add Employee")){
         new AddEmployee();
     }else if(e.getActionCommand().equals("Add Rooms")){
         new addrooms();
     }else if(e.getActionCommand().equals("Add Driver")){
         new Adddriver();
     }else if(e.getActionCommand().equals("Reception")){
         new Reception();
     }
     
    }
    
}
