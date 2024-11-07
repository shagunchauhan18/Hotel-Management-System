/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



    public class Adddriver extends JFrame implements ActionListener {
    JButton addroom,cancel;
     JTextField name1,car,car1,age1,loc;
      JComboBox av,gen1;   
    Adddriver(){
        setLayout(null);
        //adding frame color
        getContentPane().setBackground(Color.WHITE);
        //adding heading
        JLabel heading=new JLabel("ADD DRIVERS");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,10,200,20);
        add(heading);
        //adding room number label
          JLabel name=new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,16));
        name.setBounds(60,70,120,30);
        add(name);
        //adding textfield of roomno
        name1=new JTextField();
        name1.setBounds(200,70,150,30);
        add(name1);
        //adding available label
          JLabel age=new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,16));
        age.setBounds(60,110,120,30);
        add(age);
        //ADDING DROPDOWN LIST
        age1=new JTextField();
        age1.setBounds(200,110,150,30);
        add(age1);
        //adding cleaningstatus label
          JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,16));
        gender.setBounds(60,150,120,30);
        add(gender);
        //ADDING DROPDOWN LIST
        String str1[]={"Male","Female"};
         gen1=new JComboBox(str1);
        gen1.setBounds(200,150,150,30);
        gen1.setBackground(Color.WHITE);
        add(gen1);
         //adding price label
          JLabel carc=new JLabel("Car Company");
        carc.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,16));
        carc.setBounds(60,190,120,30);
        add(carc);
        //adding textfield of roomno
         car=new JTextField();
        car.setBounds(200,190,150,30);
        add(car);
         //adding bedtype label
          JLabel carm=new JLabel("Car Model");
        carm.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,16));
        carm.setBounds(60,230,120,30);
        add(carm);
        //ADDING DROPDOWN LIST
         car1=new JTextField();
        car1.setBounds(200,230,150,30);
        add(car1);
        JLabel avail=new JLabel("Available");
        avail.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,16));
        avail.setBounds(60,270,120,30);
        add(avail);
               //adding buttons
               String str2[]={"Available","Occupied"};
                av=new JComboBox(str2);
               av.setBounds(200,270,150,30);
               av.setBackground(Color.WHITE);
               add(av);
               JLabel location=new JLabel("Location");
        location.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,16));
        location.setBounds(60,310,120,30);
        add(location);
         loc=new JTextField();
        loc.setBounds(200,310,150,30);
        add(loc);
        
               
         addroom=new JButton("Add Driver");
        addroom.setForeground(Color.WHITE);
        addroom.setBackground(Color.BLACK);
        addroom.setBounds(60,370,130,30);
        add(addroom);
        addroom.addActionListener(this);
         cancel=new JButton("Cancel");
         cancel.setForeground(Color.WHITE);
         cancel.setBackground(Color.BLACK);
         cancel.setBounds(220,370,130,30);
        add( cancel);
        cancel.addActionListener(this);
        //adding image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2= i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);
        
        
        
        
        setBounds(300,200,980,470);
        setVisible(true);
        
        
    }
    public static void main(String []args){
        new Adddriver();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addroom){
            String name2=name1.getText();
             String car2=car1.getText();
              String car3=car.getText();
               String loc1=loc.getText();
            String gen2= (String) gen1.getSelectedItem();
            String av1=(String) av.getSelectedItem();
          
            String age2=age1.getText();
            try{
                Conn conn=new Conn();
                String str1="Insert into driver values('"+name2+"','"+age2+"','"+gen2+"','"+car3+"','"+car2+"','"+av1+"', '"+loc1+"')";
                conn.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
                setVisible(false); 
                
            }catch(Exception ae){
                ae.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
        
    }

    
}
