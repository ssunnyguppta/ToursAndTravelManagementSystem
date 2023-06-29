import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener {

    Paytm(){
        setLayout(null);
        setBounds(500, 200, 800, 600);

        //we have to add a Text Area in which we will load the full website, we have 2 options
        // 1) JTextArea => but in this adding scroll is very difficult
        // 2) JEditor Pane
        // JEditorPane pane = new JEditorPane();
        // text area were always editable, but we don't want to edit over here as we were loadint the whole website, therefore..
        // pane.setEditable(false);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);

//        try{
//            // if we want to bring any website to our page
//            pane.setPage("https://www.tutorialspoint.com");
//        }
//        catch (Exception e){
//            pane.setContentType("text/html");
//            pane.setText("<html> Could not load, Error 404</html>");
//        }

        //to add a scroll bar.
//        JScrollPane sp = new JScrollPane(pane);
//        getContentPane().add(sp);

        JButton back = new JButton("Back");
        back.setBounds(610, 20, 80, 40);
        back.addActionListener(this);
        add(back);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Payment();
    }
    public static void main(String[] args) {
        new Paytm();
    }
}