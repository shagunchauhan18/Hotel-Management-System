/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener  {
      JTextField username,password;
      JButton login ,cancel;
    Login(){
        //adding frame background as white
        getContentPane().setBackground(Color.WHITE);
         //adding username 
         setLayout(null);
        JLabel user=new JLabel("Username");
       user.setBounds(40,20,100,30);
        add(user);
        //ADDING USERNAME WALA DABBA
        username=new JTextField();
        username.setBounds(150,20,150,30);
        add(username);
        //adding password
         JLabel pass=new JLabel("Password");
       pass.setBounds(40,70,100,30);
        add(pass);
        //ADDING password WALA DABBA
         password=new JTextField();
         password.setBounds(150,70,150,30);
        add(password);
        //adding login button
         login=new JButton("LOGIN");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        //adding cancel button
          cancel=new JButton("CANCEL");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        //adding image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);
        
        
        
        
        
        setBounds(500,200,600,300);
       
        
         
        
        
        setVisible(true); 
        
    }
   
    public static void main(String args[]){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //checking if login button is selected or cancel button is selected
        if(ae.getSource()==login){
            //taking the text entered by user in the page so we can match with the text in the databse
            String user=username.getText();
            String pass=password.getText();
            //nowchecking in database whether hit or miss
            try{
                Conn c=new Conn();
                String query="select * from login where username='"+user+"'and password='"+pass+"'";
               ResultSet rs= c.s.executeQuery(query);
               //checking ig the data matches
                if(rs.next()){
                    setVisible(false);
                    new dashboard();
                    
                }else{
                    JOptionPane.showMessageDialog(null,"INVALID USERNAME OR PASSWORD");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==cancel){
            setVisible(false);
        }
    
    }
        
    
}
