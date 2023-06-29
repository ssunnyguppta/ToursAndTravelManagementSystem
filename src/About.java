import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {
    JButton back;
    About(){
        setBounds(600, 200, 500, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel l1 = new JLabel("About");
        l1.setBounds(210, 15, 100, 40);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1);

        String s = "About Project      \n" +
                "\n" +
                "The objective of the Travel and Tourism Management System\n" +
                "   project is to develop a system that automates the processes \n" +
                "   and activities of a travel and the purpose is to design a\n" +
                "   system using which one can perform all operations related to\n" +
                "   traveling.\n" +
                "\n" +
                "   This application will help in accessing the information related\n" +
                "   to the travel to the particular destination with great ease.\n" +
                "   The users can track the information related to their tours with\n" +
                "   great ease through this application. The travel agency information\n" +
                "   can also be obtained through this application.\n" +
                "\n" +
                "   Advantages of Project:\n" +
                "   Gives accurate information.\n" +
                "   Simplifies the manual work.\n" +
                "   It minimizes the documentation related work.\n" +
                "   Provides up to date information.\n" +
                "   Friendly Environment by providing warning messages.\n" +
                "   Travelers details can be provided.\n" +
                "   Booking confirmation notification.\n";

        TextArea area = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 450, 300);
        add(area);

        back = new JButton("Back");
        back.setBounds(200, 420, 80, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){
        setVisible(false);
        new Dashboard("");
    }

    public static void main(String[] args) {

        new About();

    }
}