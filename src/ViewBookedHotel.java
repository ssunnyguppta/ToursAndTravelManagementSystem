import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewBookedHotel extends JFrame implements ActionListener {
    JButton back;
    JLabel labelusername, labelhotel, labelpersons, labeldays, labelac, labelfood, labelid, labelnumber, labelphone, labeltotal;
    ViewBookedHotel(String username){
        setLayout(null);
        setBounds(400, 200, 1000, 600);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setBounds(60, 0, 400, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username: ");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        labelusername.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labelusername);

        JLabel lblhotel = new JLabel("Hotel Name: ");
        lblhotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblhotel.setBounds(30, 90, 150, 25);
        add(lblhotel);

        labelhotel = new JLabel();
        labelhotel.setBounds(220, 90, 150, 25);
        labelhotel.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labelhotel);

        JLabel lblpersons = new JLabel("Total Persons: ");
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpersons.setBounds(30, 130, 150, 25);
        add(lblpersons);

        labelpersons = new JLabel();
        labelpersons.setBounds(220, 130, 150, 25);
        labelpersons.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labelpersons);

        JLabel lbldays = new JLabel("Total Days: ");
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldays.setBounds(30, 170, 150, 25);
        add(lbldays);

        labeldays = new JLabel();
        labeldays.setBounds(220, 170, 150, 25);
        labeldays.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labeldays);

        JLabel lblac = new JLabel("AC/ NON-AC: ");
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblac.setBounds(30, 210, 150, 25);
        add(lblac);

        labelac = new JLabel();
        labelac.setBounds(220, 210, 150, 25);
        labelac.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labelac);

        JLabel lblfood = new JLabel("Food Included: ");
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblfood.setBounds(30, 250, 150, 25);
        add(lblfood);

        labelfood = new JLabel();
        labelfood.setBounds(220, 250, 150, 25);
        labelfood.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labelfood);

        JLabel lblid = new JLabel("Id: ");
        lblid.setBounds(30, 290, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(220, 290, 150, 25);
        labelid.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labelid);

        JLabel lblnumber = new JLabel("Number: ");
        lblnumber.setBounds(30, 330, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(220, 330, 150, 25);
        labelnumber.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone: ");
        lblphone.setBounds(30, 370, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(220, 370, 150, 25);
        labelphone.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price: ");
        lbltotal.setBounds(30, 410, 150, 25);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setBounds(220, 410, 150, 25);
        labeltotal.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labeltotal);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(130, 470, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 20, 500, 400);
        add(image);

        try{
            Conn c = new Conn();
            String query = "select * from bookhotel where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()){
                labelid.setText(rs.getString("id"));
                labelusername.setText(rs.getString("username"));
                labelnumber.setText(rs.getString("number"));
                labelhotel.setText(rs.getString("name"));
                labeltotal.setText(rs.getString("totalPrice"));
                labelphone.setText(rs.getString("phone"));
                labelpersons.setText(rs.getString("persons"));
                labelfood.setText(rs.getString("food"));
                labelac.setText(rs.getString("ac"));
                labeldays.setText(rs.getString("days"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new ViewBookedHotel("");
    }
}