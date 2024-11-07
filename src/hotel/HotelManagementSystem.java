/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class HotelManagementSystem extends JFrame implements ActionListener{
    HotelManagementSystem(){
        setSize(1366,565);
        setLocation(90,90);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image=new JLabel(i1);
        add(image);
        //adding text
        JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,430,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.CENTER_BASELINE,50));
        
        image.add(text);
        //adding button
        JButton next =new JButton("NEXT");
        next.setBounds(1150,450,150,50);
        next.setFont(new Font("serif",Font.ROMAN_BASELINE,30));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        next.setBackground(Color.darkGray);
        image.add(next);
        setVisible(true);
       while(true){
          text.setVisible(false);
        try{
            Thread.sleep(500);
        }catch(Exception e){
            e.printStackTrace();
        }
          text.setVisible(true);
         try{
            Thread.sleep(500);
        }catch(Exception e){
            e.printStackTrace();
        }
      
            
        }
            
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

   
    public static void main(String[] args) {
        // TODO code application logic here
        new HotelManagementSystem();
        
    }
    
}
