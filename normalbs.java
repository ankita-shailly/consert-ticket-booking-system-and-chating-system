package managementsys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
public class normalbs extends JFrame implements ActionListener {
    JLabel sv,n,t,id,no;
    JTextField tn,tc;
    JComboBox cs;
    JTextArea a;
    JButton b,b1;
    String formno;
    normalbs(String first){
        setLayout(null);
        JLabel h=new JLabel("NORAML SEATS");
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
        String seats[]={"NORMAL"};
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
        t.setBounds(150,300,1000,30);
        t.setFont(new Font("SERIF",Font.BOLD,30));
        add(t);
        tc=new JTextField();
        tc.setBounds(150,340,150,50);
        add(tc);
        id=new JLabel("YOUR BOOKING ID IS :");
        id.setForeground(Color.black);
        id.setBounds(150,400,1000,30);
        id.setFont(new Font("SERIF",Font.PLAIN,20));
        add(id);
        no=new JLabel(formno);
        no.setForeground(Color.black);
        no.setBounds(370,400,1000,30);
        no.setFont(new Font("SERIF",Font.PLAIN,20));
        add(no);
        b1=new JButton("PAY NOW");
        b1.setBounds(400,450,100,40);
        b1.addActionListener(this);
        add(b1);
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
        int total=no*1500;
        tc.setText(String.valueOf(total));
        if(ae.getSource()==b1) {
            try {
                String seat=(String) cs.getSelectedItem();
                String no_of_seats=tn.getText();
                String cost=tc.getText();
                String b_id=formno;
                adcon ad=new adcon();
                String query="insert into normals values('"+seat+"','"+no_of_seats+"','"+cost+"','"+b_id+"')";
                ad.s.executeUpdate(query);
                pay f=new pay(formno);
                f.tc.setText(tc.getText());
                f.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] arg){
        new normalbs("");
    }
}
