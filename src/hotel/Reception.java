/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Reception extends JFrame implements ActionListener{
    JButton ncustom,room,depart,allemployee,manager,custominfo,update,updateroo;
    Reception(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //adding buttons
         ncustom=new JButton("New Customer Form");
        ncustom.setBounds(10,30,200,30);
        ncustom.setBackground(Color.BLACK);
        ncustom.setForeground(Color.WHITE);
        add(ncustom);
        ncustom.addActionListener(this);
         room=new JButton("Rooms");
        room.setBounds(10,70,200,30);
        room.setBackground(Color.BLACK);
        room.setForeground(Color.WHITE);
        add(room);
        room.addActionListener(this);
         depart=new JButton("Department");
        depart.setBounds(10,110,200,30);
        depart.setBackground(Color.BLACK);
        depart.setForeground(Color.WHITE);
        add(depart);
        depart.addActionListener(this);
        allemployee=new JButton("All Employees");
        allemployee.setBounds(10,150,200,30);
        allemployee.setBackground(Color.BLACK);
        allemployee.setForeground(Color.WHITE);
        add(allemployee);
        allemployee.addActionListener(this);
         custominfo=new JButton("Customer Info");
        custominfo.setBounds(10,190,200,30);
        custominfo.setBackground(Color.BLACK);
        custominfo.setForeground(Color.WHITE);
        add(custominfo);
        custominfo.addActionListener(this);
        manager=new JButton("Manager Info");
        manager.setBounds(10,230,200,30);
        manager.setBackground(Color.BLACK);
        manager.setForeground(Color.WHITE);
        add(manager);
        manager.addActionListener(this);
         JButton check=new JButton("CheckOut");
        check.setBounds(10,270,200,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        add(check);
         update=new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);
         update.addActionListener(this);
         updateroo=new JButton("Update Room Status");
        updateroo.setBounds(10,350,200,30);
        updateroo.setBackground(Color.BLACK);
        updateroo.setForeground(Color.WHITE);
        add(updateroo);
        updateroo.addActionListener(this);
       JButton pickup=new JButton("PickUp Service");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        add(pickup);
         JButton search=new JButton("Search Room");
        search.setBounds(10,430,200,30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        add(search);
         JButton logout=new JButton("LogOut");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        add(logout);
        //adding image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        
        
        
        
        
        
        
        setBounds(350,200,800,570);
        setVisible(true);
        
    }
    public static void main(String args[]){
        new Reception();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
  if(e.getSource()==ncustom){
      setVisible(false);
      new addCustomer();
  }else if(e.getSource()==room){
      setVisible(false);
      new Room();
  }else if(e.getSource()==depart){
      setVisible(false);
      new department();
  }else if(e.getSource()==allemployee){
      setVisible(false);
      new employeeinfo();
      
  }else if(e.getSource()==manager){
      setVisible(false);
      new Managerinfo();
  }else if(e.getSource()==custominfo){
      setVisible(false);
      new Customerinfo();
  }else if(e.getSource()==update){
        setVisible(false);
        new Updatecheck();
    }else if(e.getSource()==updateroo){
        setVisible(false);
        new Updateroom();
    }
    }
    
}
