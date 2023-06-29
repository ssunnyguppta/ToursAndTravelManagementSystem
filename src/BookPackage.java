import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {
    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel text, lblusername, labelusername, lblselpack, lblpersons, lblid, labelid, lblnumber, labelnumber, lblphone, labelphone, lbltotalprice, labeltotalprice;
    JButton checkprice, bookpackage, back;

    BookPackage(String username){
        this.username = username;

        setBounds(350, 200, 1100, 500);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        text = new JLabel("Book Package");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        lblusername = new JLabel("Username: ");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblusername.setBounds(40, 70, 100, 20);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelusername.setBounds(250, 70, 200, 20);
        labelusername.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labelusername);

        lblselpack = new JLabel("Select Package: ");
        lblselpack.setBounds(40, 110, 150, 20);
        lblselpack.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblselpack);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250, 110, 200, 20);
        add(cpackage);

        lblpersons = new JLabel("Total Persons: ");
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpersons.setBounds(40, 150, 150, 20);
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfpersons.setBounds(250, 150, 200, 25);
        tfpersons.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(tfpersons);

        lblid = new JLabel("Id: ");
        lblid.setBounds(40, 190, 150, 20);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 190, 200, 25);
        labelid.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labelid);

        lblnumber = new JLabel("Number: ");
        lblnumber.setBounds(40, 230, 150, 20);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 230, 200, 25);
        labelnumber.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labelnumber);

        lblphone = new JLabel("Phone: ");
        lblphone.setBounds(40, 270, 150, 20);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 270, 200, 25);
        labelphone.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labelphone);

        lbltotalprice = new JLabel("Total Price: ");
        lbltotalprice.setBounds(40, 310, 150, 20);
        lbltotalprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotalprice);

        labeltotalprice = new JLabel();
        labeltotalprice.setBounds(250, 310, 200, 25);
        labeltotalprice.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labeltotalprice);

        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";

            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.black);
        checkprice.setForeground(Color.white);
        checkprice.setBounds(60, 380, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.black);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(200, 380, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(340, 380, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 500, 300);
        add(image);

        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == checkprice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("Gold Package")){
                cost += 12000;
            }
            else if(pack.equals("Silver Package")){
                cost += 25000;
            }
            else{
                cost += 32000;
            }

            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labeltotalprice.setText("Rs "+ cost);
        }
        else if(ae.getSource() == bookpackage){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values ('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labeltotalprice.getText()+"')");

                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookPackage("ssunnyguppta");

    }
}