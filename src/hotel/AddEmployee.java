/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{
    JTextField nm,ag,sl,ph,el,adhar;
    JRadioButton male,female;
    JComboBox job1;
    JButton sub;
    AddEmployee(){
        setLayout(null);
        //making frame color white
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        //adding thr labels
        JLabel name=new JLabel("NAME");
        name.setBounds(60,30,120,30);
        name.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,17));
         add(name);
         //adding namewala dabba
          nm=new JTextField();
         nm.setBounds(200,30,150,30);
         add(nm);
         //adding the label age
         JLabel age=new JLabel("AGE");
         age.setBounds(60,80,120,30);
         age.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,17));
         add(age);
         //dding age wala dabba
          ag=new JTextField();
         ag.setBounds(200,80,150,30);
         add(ag);
         //adding label gender also it is a radiobutton
         JLabel gend=new JLabel("GENDER");
         gend.setBounds(60,130,120,30);
          gend.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,17));
         add(gend);
         //adding male radiobutton
          male=new JRadioButton("Male");
         male.setBounds(200,130,70,30);
         male.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,14));
         male.setBackground(Color.WHITE);
         add(male);
         //adding female radiobutton
          female=new JRadioButton("Female");
         female.setBounds(280,130,70,30);
         female.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,14));
         female.setBackground(Color.WHITE);
         add(female);
         //selecting only one of 2 buttons
         ButtonGroup bg=new ButtonGroup();
         bg.add(male);
         bg.add(female);
         //adding a drop down list
         JLabel job=new JLabel("JOB");
         job.setBounds(60,180,120,30);
         job.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,17));
         add(job);
         //drop down we can make from jcombobox
         String str[]={"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waitress","Manager","Accountant"};
          job1=new JComboBox(str);
         job1.setBounds(200,180,150,30);
         job1.setBackground(Color.WHITE);
         add(job1); 
          //adding thr salarylabels
        JLabel sal=new JLabel("SALARY");
        sal.setBounds(60,230,120,30);
        sal.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,17));
         add(sal);
         //adding salarywala dabba
          sl=new JTextField();
         sl.setBounds(200,230,150,30);
         add(sl);
          //adding thr phonelabels
        JLabel phone=new JLabel("PHONE");
        phone.setBounds(60,280,120,30);
        phone.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,17));
         add(phone);
         //adding phonewala dabba
          ph=new JTextField();
         ph.setBounds(200,280,150,30);
         add(ph);
          //adding thr emaillabels
        JLabel em=new JLabel("EMAIL");
        em.setBounds(60,330,120,30);
        em.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,17));
         add(em);
         //adding emailwala dabba
          el=new JTextField();
         el.setBounds(200,330,150,30);
         add(el);
          //adding thr adharlabels
        JLabel aadhar=new JLabel("AADHAR");
        aadhar.setBounds(60,380,120,30);
        aadhar.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,17));
         add(aadhar);
         //adding aadharwala dabba
          adhar=new JTextField();
         adhar.setBounds(200,380,150,30);
         add(adhar);
         //adding submit button
          sub=new JButton("SUBMIT");
         sub.setBounds(200,430,150,30);
         sub.setBackground(Color.BLACK);
         sub.setForeground(Color.white);
         sub.addActionListener(this);
         add(sub);
         //adding image
         ImageIcon ig=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
         Image ig1= ig.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
         ImageIcon ig2=new ImageIcon(ig1);
         JLabel image=new JLabel(ig2);
         image.setBounds(380,60,450,370);
         add(image);
         
        setVisible(true);
        
        
    }
    public static void main(String args[]){
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name=nm.getText();
        String age=ag.getText();
        String sal=sl.getText();
        String phone=ph.getText();
        String email=el.getText();
        String aadhar1=adhar.getText();
        String gender;
        //checking if male is selcted or female is selected
        if(male.isSelected()){
            gender="Male";
        }else{
            gender="Female";
        }
        String job2=(String)job1.getSelectedItem();
        try{
            Conn conn=new Conn();
            String query="insert into employee4 values('"+name+"','"+age+"','"+gender+"','"+job2+"','"+sal+"','"+phone+"','"+email+"','"+aadhar1+"')";
            // as u are updating value so use exceute update
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee Added Successfully");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
