//1st frame
package managementsys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class sms extends JFrame implements ActionListener{
    sms(){
        //CREATING THE FRAME/BACKGROUND ;
        getContentPaneweccx().setBackground(Color.PINK);
        
        setLayout(null);
           //DEFAULT VISIBLITY IS FALSE;

        //ADDING IMAGE ON THE BACKGROUND;
       ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/img_1.png"));
        Image i1= i.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel image=new JLabel(i2);
        image.setBounds(10,10,1170,650);
        add(image);
        //ADDING TEXT ON THE BACKGROUND
        JLabel title=new JLabel("WELCOME TO TAYLOR SWIFT ERAS TOUR");
        title.setBounds(80,30,1000,50);
        title.setFont(new Font("SERIF",Font.PLAIN,50));
        title.setForeground(Color.BLACK);
        image.add(title);

        JLabel title1=new JLabel("ONLINE BOOKING,CHATTING AND A MANAGEMENT SYSTEM");
        title1.setBounds(80,250,1000,50);
        title1.setFont(new Font("SERIF",Font.PLAIN,35));
        title1.setForeground(Color.BLACK);
        image.add(title1);

        //ADDING BUTTON ON THE FRAME;
        JButton b=new JButton("Click Here For Details");
        b.setBounds(200,400,400,100);
        b.setBackground(Color.PINK);
        b.setFont(new Font("SERIF",Font.BOLD,30));
        b.addActionListener(this);
       //add(b);
        image.add(b);
        setSize(1170,650);
        setLocation(80,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new login();
    }
    public static void main(String[] args) {
       new sms();
    }
}