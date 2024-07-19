package managementsys;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.net.Socket;
import java.util.*;
import java.text.*;
import java.sql.*;
import java.net.*;
import java.io.*;
public class client extends JFrame implements ActionListener{
    static DataOutputStream dout;
   static JPanel p1,a1,p2;
    JButton b1,send;
    JLabel status,name1,output;
    JTextField t;
    static Box vertical=Box.createVerticalBox();
   static JFrame f=new JFrame();
   String s;
   client(String s){
        setLayout(null);
        getContentPane().setBackground(Color.PINK);
        p1=new JPanel();
        p1.setBounds(0,0,400,70);
        p1.setBackground(new Color(7,94,84));
        add(p1);
        b1=new JButton("back");
        b1.setBounds(0,10,80,20);
        b1.addActionListener(this);
        p1.add(b1);
        this.s=s;
        name1=new JLabel(s);
        name1.setBounds(0,10,80,18);
        name1.setForeground(Color.WHITE);
        name1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        p1.add(name1);
        status=new JLabel("Active NOw");
        status.setForeground(Color.white);
        status.setBounds(0,35,100,18);
        status.setFont(new Font("SERIF",Font.PLAIN,14));
        p1.add(status);
        a1=new JPanel();
        a1.setBounds(0,75,380,440);
        add(a1);
        t=new JTextField();
        t.setBounds(5,515,280,40);
        t.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
        add(t);
        send=new JButton("SEND");
        send.setBackground(new Color(7,94,84));
        send.setForeground(Color.WHITE);
        send.setBounds(290,515,90,40);
        send.addActionListener(this);
        add(send);
        setSize(400,600);
        setLocation(600,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==send){
            try{
            String out=t.getText();
            p2=formatLabel(out);
            a1.setLayout(new BorderLayout());
            JPanel right=new JPanel(new BorderLayout());
            right.add(p2,BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));
            a1.add(vertical,BorderLayout.PAGE_START);
            dout.writeUTF(out);
            t.setText("");
            repaint();
            invalidate();
            validate();}catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==b1) {
            setVisible(false);
        }
    }
    public static JPanel formatLabel(String out){
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel output=new JLabel(out);
        output.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        output.setBackground(new Color(37,211,102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(10,10,10,40));
        panel.add(output);
        Calendar cal= Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        JLabel time=new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);
        return panel;
    }
    public static void main(String[] arg){
        new client("");
        try{
            Socket s=new Socket("127.0.0.1",6001);
            DataInputStream din=new DataInputStream(s.getInputStream());
            //to send data
            dout=new DataOutputStream(s.getOutputStream());
            while (true){
                a1.setLayout(new BorderLayout());
                String msg= din.readUTF();
                JPanel panel=formatLabel(msg);
                JPanel left=new JPanel(new BorderLayout());
                left.add(panel,BorderLayout.LINE_START);
                vertical.add(left);
                vertical.add(Box.createVerticalStrut(10));
                a1.add(vertical,BorderLayout.PAGE_START);
                f.validate();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
