package managementsys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class viewad extends JFrame implements ActionListener {
    JTable table;
    JButton n,v,p,se,back,print;
    Choice c;
    viewad(){
        setLayout(null);
        JLabel heading= new JLabel("OTHER DETAILS :");
        heading.setForeground(Color.black);
        heading.setBounds(80,40,200,30);
        heading.setFont(new Font("SERIF",Font.BOLD,20));
        add(heading);
        n=new JButton("NORMAL SEATS");
        n.setBounds(300,40,100,30);
        n.addActionListener(this);
        add(n);
        v=new JButton("VIP SEATS");
        v.setBounds(450,40,100,30);
        v.addActionListener(this);
        add(v);
        p=new JButton("PAYMENT");
        p.setBounds(600,40,100,30);
        p.addActionListener(this);
        add(p);
        JLabel search=new JLabel("SEARCH BY BOOKING ID :");
        search.setBounds(40,90,150,30);
        add(search);
        c=new Choice();
        c.setBounds(200,90,150,30);
        add(c);
        se=new JButton("search");
        se.setBounds(250,130,100,30);
        se.addActionListener(this);
        add(se);
        back=new JButton("BACK");
        back.setBounds(1040,20,80,20);
        back.addActionListener(this);
        add(back);
        print=new JButton("print");
        print.setBounds(100,130,100,30);
        print.addActionListener(this);
        add(print);
        try{
            adcon ad=new adcon();
            ResultSet rs= ad.s.executeQuery("select * from bookings");
            //table.setModel(DbUtils.resultSetToTableModel(rs));
            //LOOPING THE ROWS AND TAKING OUT THE COLOUM b_id AND ADDING IT TO CHOICE;
            while (rs.next()){
                c.add(rs.getString("b_id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        table=new JTable();
        try{
            adcon ad=new adcon();
            ResultSet rs= ad.s.executeQuery("select * from bookings");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            //LOOPING THE ROWS AND TAKING OUT THE COLOUM b_id AND ADDING IT TO CHOICE;

        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,200,1150,400);
        add(jsp);
        setSize(1170,650);
        setLocation(80,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==n){
                setVisible(false);
                new normalSearch();
        } else if (ae.getSource()==v) {
            setVisible(false);
            new vipSearch();
        } else if (ae.getSource()==p) {
            setVisible(false);
            new paymentDetails();
        } else if (ae.getSource()==se) {
            String query="select * from bookings where b_id ='"+c.getSelectedItem()+"'";
            try{
                adcon ad=new adcon();
                ResultSet rs=ad.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==print) {
            try {
                table.print();
            }catch (Exception e){

            }
        } else {
            setVisible(false);
            new adhome();
        }
    }
    public static void main(String[] arg){
        new viewad();
    }
}

