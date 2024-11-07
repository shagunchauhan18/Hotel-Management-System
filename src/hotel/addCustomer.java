
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.Date;


public class addCustomer extends JFrame implements ActionListener{
    JComboBox opt;
    TextField num1,name1,count,dep;
    JRadioButton rmale,rfemale;
    Choice croom;
    JLabel checkin;
    JButton add ,back;
    addCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //adding new customer label
        JLabel text=new JLabel("New Customer Form");
        text.setBounds(100,20,300,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);
        //adding id label
         JLabel id=new JLabel("ID");
        id.setBounds(35,80,100,20);
        id.setFont(new Font("Raleway",Font.PLAIN,15));
        add(id);
        //adding combobox
        String option[]={"Adhar Card","Passport","Driving License","Voter-id Card","Ration Card"};
        opt=new JComboBox(option);
        opt.setBounds(200,80,150,25);
        add(opt);
        //adding number
         JLabel num=new JLabel("Number");
        num.setBounds(35,120,100,20);
        num.setFont(new Font("Raleway",Font.PLAIN,15));
        add(num);
        //adding num field
        num1=new TextField();
        num1.setBounds(200,120,150,25);
        add(num1);
         //adding name
         JLabel name=new JLabel("Name");
        name.setBounds(35,160,100,20);
        name.setFont(new Font("Raleway",Font.PLAIN,15));
        add(name);
        //adding num field
        name1=new TextField();
        name1.setBounds(200,160,150,25);
        add(name1);
        //adding gender label
         JLabel gender=new JLabel("Gender");
        gender.setBounds(35,200,100,20);
        gender.setFont(new Font("Raleway",Font.PLAIN,15));
        add(gender);
        //adding radiobutton for male female
        rmale=new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,200,60,25);
        add(rmale);
        rfemale=new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270,200,100,25);
        add(rfemale);
        //adding country label
         JLabel country=new JLabel("Country");
        country.setBounds(35,240,100,20);
        country.setFont(new Font("Raleway",Font.PLAIN,15));
        add(country);
        //adding num field
        count=new TextField();
        count.setBounds(200,240,150,25);
        add(count);
        //adding allocAted room label
         JLabel room=new JLabel("Room Number");
        room.setBounds(35,280,150,20);
        room.setFont(new Font("Raleway",Font.PLAIN,15));
        add(room);
        //adding choice class
        croom =new Choice();
        //to hit the query in my sql use try and catch
        try{
            Conn conn=new Conn();
            String query="Select * from rooms1";
           ResultSet rs= conn.s.executeQuery(query);
           //taking all the data from room table using loop
           while(rs.next()){
              croom.add(rs.getString("roomno"));
               
           }
            
        }catch(Exception e){
            
            e.printStackTrace();
        }
        croom.setBounds(200,280,150,25);
        add(croom);
        //adding checkin time
        JLabel check=new JLabel("Checkin Time");
        check.setBounds(35,320,150,20);
        check.setFont(new Font("Raleway",Font.PLAIN,15));
        add(check);
        
       
        Date date = new Date();
        
         checkin=new JLabel(""+date);
        checkin.setBounds(200,320,150,25);
        checkin.setFont(new Font("Raleway",Font.PLAIN,15));
        add(checkin);
         JLabel deposit=new JLabel("Deposit");
        deposit.setBounds(35,360,100,20);
        deposit.setFont(new Font("Raleway",Font.PLAIN,15));
        add(deposit);
        //adding num field
        dep=new TextField();
        dep.setBounds(200,360,150,25);
        add(dep);
        //adding buttons
        add=new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,410,120,30);
        add(add);
        add.addActionListener(this);
         back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,410,120,30);
        add(back);
        back.addActionListener(this);
        //adding image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
                
        
        
        
        
        setBounds(350,200,800,550);
        setVisible(true);
        
    }
    public static void main(String args[]){
        new addCustomer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String opt2=(String)opt.getSelectedItem();
            String num2=num1.getText();
            String name2=name1.getText();
            String gender2=null;
            if(rmale.isSelected()){
                gender2="Male";
            }else{
                gender2="Female";
            }
            String count2=count.getText();
            String room1=croom.getSelectedItem();
            String time=checkin.getText();
            String depo=dep.getText();
            try{
                Conn conn=new Conn();
                String query="insert into customer values('"+opt2+"','"+num2+"','"+name2+"','"+gender2+"','"+count2+"','"+room1+"','"+time+"','"+depo+"')";
                //here we are changinging the availability if the room is occupied by customer
                String query1="Update rooms1 set availability = 'Occupied' where roomno='"+room1+"'";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
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
