package managementsys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class adhome extends JFrame implements ActionListener{
    JButton b,b1,b2,b3;
    adhome(){
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/img_2.png"));
        Image i1= i.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel image=new JLabel(i2);
        image.setBounds(0,0,1170,650);
        add(image);
        JLabel heading= new JLabel("CONCERT SETTING MANAGEMENT SYSTEM");
        heading.setBounds(350,100,800,40);
        heading.setFont(new Font("SERIF",Font.BOLD,36));
        image.add(heading);
        //ADDING BUTTONS;
        b=new JButton("booking");
        b.setBounds(600,200,300,40);
        b.setFont(new Font("MONOSPACE",Font.BOLD,30));
        b.addActionListener(this);
        image.add(b);
        b1=new JButton("VIEW");
        b1.setBounds(600,300,300,40);
        b1.setFont(new Font("MONOSPACE",Font.BOLD,30));
        b1.addActionListener(this);
        image.add(b1);
        b2=new JButton("BACK");
        b2.setBounds(600,500,300,40);
        b2.setFont(new Font("MONOSPACE",Font.BOLD,30));
        b2.addActionListener(this);
        image.add(b2);
        b3=new JButton("DELETE");
        b3.setBounds(600,400,300,40);
        b3.setFont(new Font("MONOSPACE",Font.BOLD,30));
        b3.addActionListener(this);
        image.add(b3);

        setSize(1170,650);
        setLocation(80,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b){
            setVisible(false);
           new loginbs();
        }else if(e.getSource()==b1){
            setVisible(false);
            new viewad();
        } else if (e.getSource()==b2) {
            setVisible(false);
            new login();
        } else if (e.getSource()==b3) {
            setVisible(false);
            new delete();
        }
    }
    public static void main(String[] arg){
        new adhome();
    }
}
