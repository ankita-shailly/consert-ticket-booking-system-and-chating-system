package managementsys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class login extends JFrame implements ActionListener  {
    login(){
        getContentPane().setBackground(Color.pink);
        setLayout(null);
        JLabel title=new JLabel("Select the options");
        add(title);
        title.setBounds(70,60,1000,50);
        title.setFont(new Font("SERIF",Font.BOLD,40));
        JLabel title1=new JLabel(": You Are Here AS!");
        add(title1);
        title1.setBounds(100,150,1000,30);
        title1.setFont(new Font("SERIF",Font.BOLD,40));
        JButton b1=new JButton("ONLINE CONCERT TICKET BOOKING");
        b1.setBounds(200,300,400,70);
        b1.addActionListener(this);
        add(b1);
        JButton b2=new JButton("ADMINISTRATION");
        b2.setBounds(200,400,400,70);
        b2.addActionListener(this);
        add(b2);

        setSize(1170,650);
        setSize(1170,650);
        setLocation(80,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        String s=e.getActionCommand();
        if(s.equals("ONLINE CONCERT TICKET BOOKING")){
            new loginbs();
        } else if (s.equals("ADMINISTRATION")) {
            new loginad();
        }
    }

    public static void main(String[] arg){
        new login();
    }
}
