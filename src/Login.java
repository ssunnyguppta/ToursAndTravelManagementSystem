import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, forgetpass;
    JTextField tfusername, tfpassword;

    // constructor name same as class Name
    Login(){
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null); // --> used this as i have to set the panel according to me, without defining this we can't use the setBounds function
        // now to divide panel in two parts we have to use JPanel

        getContentPane().setBackground(Color.white); // -> IT CAN BE USED TO pick up the whole panel.

        JPanel p1 = new JPanel();
        // .setBackground = background Colour changed.
        // .setForeground = text colour changed.
        // Color class is used to add the color which is there in awt package.
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400); //-> IT TAKES 4 ARGS = first 2 location, and next 2 size
        add(p1);
        p1.setLayout(null); // -> It's used for setting the bounds of the image on p1, we can't set the BOUNDS without making the LAYOUT NULL.

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // -> THIS IS MAINLY USED TO ADD TEXT ON THE PANEL
        image.setBounds(100, 120, 200, 200);
        p1.add(image);  // -> p1. is used for adding the image on the panel and not on the whole screen.



        // now will work on RHS

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        JLabel lblusername = new JLabel("Username: ");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 18)); // -> It's used to set the font type, size and way.
        p2.add(lblusername);

        // Now box for textfield
        tfusername = new JTextField(); // -> JTextField is used for adding box for text input
        tfusername.setBounds(60, 60, 300, 30);
        // x = 60, coz already took by username
        // y = 60, coz height + padding of username
        tfusername.setBorder(BorderFactory.createEmptyBorder()); //-> to remove border from TextField
        p2.add(tfusername);


        JLabel lblpassword = new JLabel("Password: ");
        lblpassword.setBounds(60, 110, 100, 25);
        lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 18)); // -> It's used to set the font type, size and way.
        p2.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder()); //-> to remove border from TextField
        p2.add(tfpassword);

        // To Add BUTTONS , use JButton Class.
        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.white);
        // for setting the border = javax.swing.border.*; needs to be imported.
        login.setBorder(new LineBorder(new Color(133, 193, 233))); // -> either we can remove or can set the same color as the of the button.
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.white);
        signup.setBorder(BorderFactory.createEmptyBorder()); // by this way we can also make it invisible.
        signup.addActionListener(this);
        p2.add(signup);

        forgetpass = new JButton("Forget Passoword");
        forgetpass.setBounds(145, 250, 130, 30);
        forgetpass.setBackground(new Color(133, 193, 233));
        forgetpass.setForeground(Color.white);
        forgetpass.setBorder(new LineBorder(new Color(133, 193, 233)));
        forgetpass.addActionListener(this);
        p2.add(forgetpass);



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == login){
            try{
                String username = tfusername.getText();
                String password = tfpassword.getText();

                String query = "select * from account where username = '"+username+"' AND password = '"+password+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Loading(username);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new Signup();
        }
        else if(ae.getSource() == forgetpass){
            setVisible(false);
            new ForgotPassword();
        }
    }


    public static void main(String[] args) {

        new Login();
    }
}

