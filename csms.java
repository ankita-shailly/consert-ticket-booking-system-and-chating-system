package managementsys;
import javax.swing.*;
import java.awt.*;
public class csms extends JFrame {
    private JPanel csmsmain;
    private JButton button1;
    private JButton clickHereForMoreButton;

    csms(){
            setContentPane(csmsmain);
            setSize(1170,650);
            setLocation(80,50);
            setVisible(true);
            clickHereForMoreButton.setBounds(80,40,100,200);

        }
        public static void main(String[] args) {
            new managementsys.csms();
        }

}

