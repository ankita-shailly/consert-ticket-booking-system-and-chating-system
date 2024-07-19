package managementsys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class loginad extends JFrame implements ActionListener{
    JTextField n,p;
    loginad(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel un=new JLabel("USERNAME :");
        un.setBounds(80,40,100,30);
        add(un);
         n=new JTextField();
        n.setBounds(170,40,250,30);
        add(n);
        JLabel pw=new JLabel("PASSWORD :");
        pw.setBounds(80,80,100,30);
        add(pw);
         p=new JTextField();
        p.setBounds(170,80,250,30);
        add(p);
        JButton l=new JButton("Login");
        l.setBounds(250,150,100,40);
        l.addActionListener(this);
        add(l);
        JButton back=new JButton("Back");
        back.setBounds(80,200,80,20);
        back.addActionListener(this);
        add(back);
        setSize(600,300);
        setLocation(400,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        try{
            String s=e.getActionCommand();
            if(s.equals("Back")){
                new login();
            }else{
           String username = n.getText();
           String password = p.getText();
           //creating the object of adcon for the execution of mysql query;
            adcon ac=new adcon();
           //creating the mysql query;
           String query="select * from login where username = '"+username+"' and password = '"+password+"'";
           //executing the mysql query
           //ac.s.executeQuery(query) it will return some value which is needed to store somewhere ie ResultSet;
            ResultSet rs= ac.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new adhome();
            }
            else {
                JOptionPane.showMessageDialog(null, "INVALID USERNAME OR PASSWORD PLEASE TYR AGAIN");
                setVisible(false);
                new loginad();
            }
            }
        }
        catch (Exception ae){
            ae.printStackTrace();
        }
    }
    public static void main(String[] arg){
        new loginad();
    }
}
