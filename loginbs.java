package managementsys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.util.Random;
public class loginbs extends JFrame implements ActionListener{
    JLabel n,date,seat,city,p,em,id,no;
    JTextField tn,tp,tem;
    JButton vip,normal,back;
    JComboBox c,d;
    Random ran=new Random();
    long first4=(ran.nextLong()%9000L)+1000;
    String first=""+Math.abs(first4);
    loginbs(){
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/img_4.png"));
        Image i1= i.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel image=new JLabel(i2);
        image.setBounds(80,50,1170,650);
        add(image);
        JLabel heading= new JLabel("ENTER THE DETAILS");
        heading.setForeground(Color.black);
        heading.setBounds(270,40,1000,50);
        heading.setFont(new Font("SERIF",Font.BOLD,60));
        image.add(heading);
        n=new JLabel("NAME :");
        n.setForeground(Color.black);
        n.setBounds(80,150,1000,30);
        n.setFont(new Font("SERIF",Font.PLAIN,20));
        image.add(n);
        tn=new JTextField();
        tn.setBounds(200,150,200,30);
        image.add(tn);
        p=new JLabel("PHONE_NO. :");
        p.setForeground(Color.black);
        p.setBounds(80,200,1000,30);
        p.setFont(new Font("SERIF",Font.PLAIN,20));
        image.add(p);
        tp=new JTextField();
        tp.setBounds(200,200,200,30);
        image.add(tp);
        em=new JLabel("EMAIL :");
        em.setForeground(Color.black);
        em.setBounds(80,250,1000,30);
        em.setFont(new Font("SERIF",Font.PLAIN,20));
        image.add(em);
        tem=new JTextField();
        tem.setBounds(200,250,200,30);
        image.add(tem);
        city=new JLabel("CITY :");
        city.setForeground(Color.black);
        city.setBounds(80,350,1000,30);
        city.setFont(new Font("SERIF",Font.PLAIN,20));
        image.add(city);
        String cities[]={"Singapore","Japan","Australia"};
        c=new JComboBox(cities);
        c.setBounds(200,350,200,30);
        image.add(c);
        date=new JLabel("DATE :");
        date.setForeground(Color.black);
        date.setBounds(80,300,1000,30);
        date.setFont(new Font("SERIF",Font.PLAIN,20));
        image.add(date);
        String dates[]={"7/jan/2024","14/jan/2024","21/jan/2024"};
        d=new JComboBox(dates);
        d.setBounds(200,300,200,30);
        image.add(d);
        seat=new JLabel("SEAT :");
        seat.setForeground(Color.black);
        seat.setBounds(80,400,1000,30);
        seat.setFont(new Font("SERIF",Font.PLAIN,20));
        image.add(seat);
        vip=new JButton("VIP");
        vip.setBounds(200,400,100,30);
        vip.addActionListener(this);
        image.add(vip);
        normal=new JButton("NORMAL");
        normal.setBounds(200,450,100,30);
        normal.addActionListener(this);
        image.add(normal);
        id=new JLabel("YOUR BOOKING ID IS :" +first);
        id.setForeground(Color.black);
        id.setBounds(80,500,800,30);
        id.setFont(new Font("SERIF",Font.PLAIN,20));
        image.add(id);
        back=new JButton("BACK");
        back.setBounds(1030,20,80,20);
        back.addActionListener(this);
        image.add(back);

        setSize(1170,650);
        setLocation(80,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == vip){
           String name= tn.getText();
            String phone_no=tp.getText();
            String email=tem.getText();
            String date=(String) d.getSelectedItem();
            String city=(String) c.getSelectedItem();
            String b_id=first;
            try{
                adcon ad=new adcon();
                String query="insert into bookings values('"+name+"','"+phone_no+"','"+email+"','"+date+"','"+city+"','"+b_id+"')";
                ad.s.executeUpdate(query);
               setVisible(false);
               new vipbs(first);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == normal) {
            String name= tn.getText();
            String phone_no=tp.getText();
            String email=tem.getText();
            String date=(String) d.getSelectedItem();
            String city=(String) c.getSelectedItem();
            String b_id=first;
            try{
                adcon ad=new adcon();
                String query="insert into bookings values('"+name+"','"+phone_no+"','"+email+"','"+date+"','"+city+"','"+b_id+"')";
                ad.s.executeUpdate(query);
                setVisible(false);
                new normalbs(first);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new login();
        }
    }
    public static void main(String[] arg){
    new loginbs();
    }
}
