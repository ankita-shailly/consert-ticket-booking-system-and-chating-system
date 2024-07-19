package managementsys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
public class vipbs extends JFrame implements ActionListener{
    JLabel sv,n,t,id,no;
    JTextField tn,tc;
    JComboBox cs;
    JTextArea a;
    JButton b,b1,b2;
    String formno;
    vipbs(String first){
        setLayout(null);
        JLabel h=new JLabel("VIP SEATS");
        add(h);
        h.setBounds(400,30,1000,60);
        h.setFont(new Font("SERIF",Font.PLAIN,60));
        h.setForeground(Color.black);
        this.formno=first;
        sv=new JLabel("SEAT :");
        sv.setForeground(Color.black);
        sv.setBounds(150,150,1000,30);
        sv.setFont(new Font("SERIF",Font.PLAIN,20));
        add(sv);
        String seats[]={"VIP"};
        cs=new JComboBox(seats);
        cs.setBounds(250,150,200,30);
        add(cs);
        n=new JLabel("TOTAL SEATS :");
        n.setForeground(Color.black);
        n.setBounds(150,200,1000,30);
        n.setFont(new Font("SERIF",Font.PLAIN,20));
        add(n);
        tn=new JTextField();
        tn.setBounds(300,200,200,30);
        add(tn);
        b=new JButton("ADD");
        b.setBounds(400,250,60,30);
        b.addActionListener(this);
        add(b);
        t=new JLabel("TOTAL COST:");
        t.setBounds(150,280,1000,30);
        t.setFont(new Font("SERIF",Font.BOLD,30));
        add(t);
        tc=new JTextField();
        tc.setBounds(150,320,150,50);
        add(tc);
        id=new JLabel("YOUR BOOKING ID IS :");
        id.setForeground(Color.black);
        id.setBounds(150,380,1000,30);
        id.setFont(new Font("SERIF",Font.PLAIN,20));
        add(id);
        no=new JLabel(formno);
        no.setForeground(Color.black);
        no.setBounds(370,380,1000,30);
        no.setFont(new Font("SERIF",Font.PLAIN,20));
        add(no);
        b1=new JButton("PAY NOW");
        b1.setBounds(400,430,100,40);
        b1.addActionListener(this);
        add(b1);
        JLabel l=new JLabel("WANT TO MAKE FRIENDS BEFORE THE CONCERT");
        l.setBounds(150,490,1000,20);
        l.setFont(new Font("SERIF",Font.PLAIN,18));
        add(l);
        JCheckBox c=new JCheckBox("yes,I WANT TO START CHATTING",true);
        c.setBounds(150,520,400,20);
        c.setFont(new Font("SERIF",Font.PLAIN,18));
        add(c);
        b2=new JButton("START CHAT");
        b2.setBounds(180,550,150,30);
        b2.addActionListener(this);
        add(b2);
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/img_5.png"));
        Image i1= i.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel image=new JLabel(i2);
        image.setBounds(600,100,800,500);
        add(image);
        setSize(1170,650);
        setLocation(80,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        int no = Integer.parseInt(tn.getText());
        int total=no*3500;
        tc.setText(String.valueOf(total));
        if(ae.getSource()==b1) {
            try {
                String seat=(String) cs.getSelectedItem();
                String no_of_seats=tn.getText();
                String cost=tc.getText();
                String b_id=formno;
                adcon ad=new adcon();
                String query="insert into vips values('"+seat+"','"+no_of_seats+"','"+cost+"','"+b_id+"')";
                ad.s.executeUpdate(query);
                pay f=new pay(formno);
                f.tc.setText(tc.getText());
                f.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource()==b2) {
            new chat();
        }
    }
    public static void main(String[] arg){
       new vipbs("");
    }
}
