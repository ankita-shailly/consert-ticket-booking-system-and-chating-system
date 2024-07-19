package managementsys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class vipSearch extends JFrame implements ActionListener {
    JTable table;
    JButton h,se,back,print;

    Choice c;
    vipSearch(){
        setLayout(null);
        JLabel heading= new JLabel("VIP TICKET BOOKING DETAILS");
        heading.setForeground(Color.black);
        heading.setBounds(300,40,1000,30);
        heading.setFont(new Font("SERIF",Font.BOLD,30));
        add(heading);
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
        print=new JButton("print");
        print.setBounds(100,130,100,30);
        print.addActionListener(this);
        add(print);
        back=new JButton("BACK");
        back.setBounds(1030,20,80,20);
        back.addActionListener(this);
        add(back);
        h=new JButton("HOME PAGE");
        h.setBounds(1030,60,120,20);
        h.addActionListener(this);
        add(h);
        try{
            adcon ad=new adcon();
            ResultSet rs= ad.s.executeQuery("select * from vips");
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
            ResultSet rs= ad.s.executeQuery("select * from vips");
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
        if (ae.getSource()==se) {
            String query="select * from vips where b_id ='"+c.getSelectedItem()+"'";
            try{
                adcon ad=new adcon();
                ResultSet rs=ad.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==back) {
            setVisible(false);
            new viewad();
        } else if (ae.getSource()==print) {
            try {
                table.print();
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new adhome();
        }
    }
    public static void main(String[] arg){
        new vipSearch();
    }
}

