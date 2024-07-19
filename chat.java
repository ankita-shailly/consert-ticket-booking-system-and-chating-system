package managementsys;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.net.*;
import java.io.*;
public class chat extends JFrame implements ActionListener{
    JTable table;
    JButton g,se,back,print;
    JLabel name;
    JTextField tn;
    Choice c;
    chat(){
        setLayout(null);
        JLabel heading= new JLabel("START CHATTING WITH THE PEOPLE");
        heading.setForeground(Color.black);
        heading.setBounds(300,40,1000,30);
        heading.setFont(new Font("SERIF",Font.BOLD,30));
        add(heading);
        JLabel search=new JLabel("SEARCH BY CITY :");
        search.setBounds(40,90,150,30);
        add(search);
        c=new Choice();
        c.setBounds(200,90,150,30);
        add(c);
        name=new JLabel("NAME :");
        name.setBounds(800,100,150,30);
        add(name);
        tn=new JTextField();
        tn.setBounds(900,100,200,30);
        add(tn);
        g=new JButton("GO");
        g.setBounds(950,130,80,20);
        g.addActionListener(this);
        add(g);
        se=new JButton("search");
        se.setBounds(250,130,100,30);
        se.addActionListener(this);
        add(se);
        back=new JButton("BACK");
        back.setBounds(1030,20,80,20);
        back.addActionListener(this);
        add(back);
        try{
            adcon ad=new adcon();
            ResultSet rs= ad.s.executeQuery("select name,city from bookings");
            //table.setModel(DbUtils.resultSetToTableModel(rs));
            //LOOPING THE ROWS AND TAKING OUT THE COLOUM b_id AND ADDING IT TO CHOICE;
            while (rs.next()){
                c.add(rs.getString("city"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        table=new JTable();
        try{
            adcon ad=new adcon();
            ResultSet rs= ad.s.executeQuery("select name,city from bookings");
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
    }  public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==se) {
            String query="select name,city from bookings where city ='"+c.getSelectedItem()+"'";
            try{
                adcon ad=new adcon();
                ResultSet rs=ad.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==g) {
            new server();
            String s = tn.getText();
            new client(s);
        }else {
            setVisible(false);
        }

    }
    public static void main(String[] arg){
        new chat();
    }
}

