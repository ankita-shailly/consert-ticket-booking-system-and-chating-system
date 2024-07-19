package managementsys;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
public class delete extends JFrame implements ActionListener{
    JLabel bid,n,n1,email,email1,city,c1,date,d1;
    Choice c;
    JTable table;
    JButton se,delete,back;
    delete(){
        setLayout(null);
        bid=new JLabel("SEARCH BY BOOKING ID :");
        bid.setBounds(40,90,150,20);
        add(bid);
        c=new Choice();
        c.setBounds(200,90,150,30);
        add(c);
        se=new JButton("search");
        se.setBounds(250,130,100,30);
        se.addActionListener(this);
        add(se);
        try{
            adcon ad=new adcon();
            String query="select * from bookings";
            ResultSet rs= ad.s.executeQuery(query);
            while (rs.next()){
                c.add(rs.getString("b_id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        n=new JLabel("NAME :");
        n.setBounds(80,200,150,40);
        add(n);
        n1=new JLabel();
        n1.setBounds(200,200,150,40);
        add(n1);
        date=new JLabel("DATE :");
        date.setBounds(80,250,150,40);
        add(date);
        d1=new JLabel();
        d1.setBounds(200,250,150,40);
        add(d1);
        city=new JLabel("CITY :");
        city.setBounds(80,300,150,40);
        add(city);
        c1=new JLabel();
        c1.setBounds(200,300,150,40);
        add(c1);
        try{
            adcon ad=new adcon();
            String query="select * from bookings where b_id ='"+c.getSelectedItem()+"'";
            ResultSet rs= ad.s.executeQuery(query);
            while (rs.next()){
                n1.setText(rs.getString("name"));
                d1.setText(rs.getString("date"));
                c1.setText(rs.getString("city"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        c.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try{
                    adcon ad=new adcon();
                    String query="select * from bookings where b_id ='"+c.getSelectedItem()+"'";
                    ResultSet rs= ad.s.executeQuery(query);
                    while (rs.next()){
                        n1.setText(rs.getString("name"));
                        d1.setText(rs.getString("date"));
                        c1.setText(rs.getString("city"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
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
        jsp.setBounds(500,100,600,400);
        add(jsp);
        delete=new JButton("DELETE");
        delete.setBounds(100,400,80,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        back=new JButton("BACK");
        back.setBounds(1030,20,80,20);
        back.addActionListener(this);
        add(back);
        setSize(1170,650);
        setLocation(80,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                adcon ad=new adcon();
                String query="delete from bookings where b_id= '"+c.getSelectedItem()+"'";
                ad.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"deleted sucessfully");
                //setVisible(false);
                new delete();
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (ae.getSource()==back) {
                new adhome();
        }else if (ae.getSource()==se) {
            String query="select * from bookings where b_id ='"+c.getSelectedItem()+"'";
            try{
                adcon ad=new adcon();
                ResultSet rs=ad.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new adhome();
        }
    }
    public static void main(String[] arg){
        new delete();
    }
}
