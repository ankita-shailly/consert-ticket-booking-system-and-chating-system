package managementsys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class pay extends JFrame implements ActionListener{
    JLabel ac,c,id,no;
    JButton p;
    JTextField tac,tc;
    String formno;
    pay(String formno){
        setLayout(null);
        id=new JLabel("YOUR BOOKING ID IS :");
        id.setForeground(Color.black);
        id.setBounds(50,50,800,30);
        id.setFont(new Font("SERIF",Font.PLAIN,20));
        add(id);
        this.formno=formno;
        no=new JLabel(formno);
        no.setForeground(Color.black);
        no.setBounds(260,50,1000,30);
        no.setFont(new Font("SERIF",Font.PLAIN,20));
        add(no);
        ac=new JLabel("ACCOUNT NO. :");
        ac.setForeground(Color.black);
        ac.setBounds(50,100,600,30);
        ac.setFont(new Font("SERIF",Font.PLAIN,15));
        add(ac);
        tac=new JTextField();
        tac.setBounds(170,100,200,30);
        add(tac);
        c=new JLabel("AMOUNT :");
        c.setForeground(Color.black);
        c.setBounds(50,150,600,30);
        c.setFont(new Font("SERIF",Font.PLAIN,15));
        add(c);
        tc=new JTextField();
        tc.setBounds(170,150,200,30);
        add(tc);
        p=new JButton("PAY");
        p.setBounds(150,220,60,30);
        p.addActionListener(this);
        add(p);

        setSize(400,500);
        setLocation(500,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== p){
            try {
                String b_id = formno;
                String account_no = tac.getText();
                String amount = tc.getText();
                adcon ad = new adcon();
                String query = "insert into payment values('"+b_id+"','"+account_no+"','"+amount+"')";
                ad.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "PAYMENT DONE SUCCESFULLY");
                setVisible(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] arg){
        new pay("");
    }
}
