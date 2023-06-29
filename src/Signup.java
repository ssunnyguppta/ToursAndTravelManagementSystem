
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener { // ActionListener is used for buttons, like what to do when button is pressed.

    JButton create, back; //=> It's done so that we can access the buttons outside the Signup Constructor.
    JTextField tfusername, tfname, tfpassword, tfanswer; //=> Same done for this too, to get an access outside the constructor globally.
    Choice security; //=> to get an access.

    Signup(){
        setBounds(350, 200, 900, 360); // -> it's the combination of both setLocation and setSize.
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);

        JLabel lblusername = new JLabel("Username: ");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblusername.setBounds(50, 20, 125, 25);
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(190, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        JLabel lblname = new JLabel("Name: ");
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblname.setBounds(50, 60, 125, 25);
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(190, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lblpassword = new JLabel("Password: ");
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblpassword.setBounds(50, 100, 125, 25);
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(190, 100, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        JLabel lblsecurity = new JLabel("Security Question: ");
        lblsecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblsecurity.setBounds(50, 140, 125, 25);
        p1.add(lblsecurity);

        // Now to get a drop down box
        security = new Choice();
        security.add("Your nickname");
        security.add("Your Primary School Name");
        security.add("Your Lucky Number");
        security.add("Your fav childhood super hero");
        security.setBounds(190, 140, 180, 25);
        p1.add(security);

        JLabel lblanswer = new JLabel("Answer: ");
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblanswer.setBounds(50, 180, 125, 25);
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(190, 180, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        create = new JButton("Create");
        create.setBackground(Color.white);
        create.setForeground(new Color(133, 193, 233));
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBounds(80, 250, 100, 30);
        create.addActionListener(this); // on click.
        p1.add(create);

        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBounds(250, 250, 100, 30);
        back.addActionListener(this); // on click.
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);

        // this is the last statement, ALWAYS REMEMBER.
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        // It's written to remove the error from the ActionListener , as it was abstract method so we overrided this.
        if (ae.getSource() == create){
            String username = tfusername.getText(); //=> getText() to get the value that has been entered over there.
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem(); //=> getSelectedItem to get the selected itemm from the text field.
            String answer = tfanswer.getText();

            //=> to add the values, code written down below is useful. '"+ value +"'
            String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
            // to execute the query.
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query); //=> to update in the database.

                JOptionPane.showMessageDialog(null, "Account Created Successfully");

                setVisible(false);
                new Login();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {

        new Signup();
    }
}