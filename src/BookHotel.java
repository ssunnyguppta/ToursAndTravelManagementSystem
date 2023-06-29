import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener {

    Choice chotel, cac, cfood;
    JLabel labelusername, labeltotal, labelid, labelnumber, labelphone;
    TextField tfpersons, tfdays;
    JButton checkprice, back, bookhotel;
    String username;

    BookHotel(String username){
        this.username = username;

        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username: ");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblusername.setBounds(40, 70, 100, 20 );
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelusername.setBounds(250, 70, 200, 20);
        labelusername.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labelusername);

        JLabel lblhotel = new JLabel("Select Hotel: ");
        lblhotel.setBounds(40, 110, 100, 20);
        lblhotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblhotel);

        chotel = new Choice();
        chotel.setBounds(250, 110, 200, 20);
        add(chotel);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next()){
                chotel.add(rs.getString("name"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        JLabel lbltotalpersons = new JLabel("Total Persons: ");
        lbltotalpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltotalpersons.setBounds(40, 150, 150, 20);
        add(lbltotalpersons);

        tfpersons = new TextField("1");
        tfpersons.setBounds(250, 150, 200, 20);
        add(tfpersons);

        JLabel lbldays = new JLabel("No. of Days: ");
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldays.setBounds(40, 190, 150, 20);
        add(lbldays);

        tfdays = new TextField("1");
        tfdays.setBounds(250, 190, 200, 20);
        add(tfdays);

        JLabel lblac = new JLabel("AC/ NON-AC");
        lblac.setBounds(40, 230, 150, 20);
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("NON-AC");
        cac.setBounds(250, 230, 200, 25);
        add(cac);

        JLabel lblfood = new JLabel("Food Included: ");
        lblfood.setBounds(40, 270, 150, 20);
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfood);

        cfood = new Choice();
        cfood.add("YES");
        cfood.add("NO");
        cfood.setBounds(250, 270, 200, 25);
        add(cfood);

        JLabel lblid = new JLabel("Id: ");
        lblid.setBounds(40, 310, 150, 20);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 310, 200, 25);
        labelid.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labelid);

        JLabel lblnumber = new JLabel("Number: ");
        lblnumber.setBounds(40, 350, 150, 20);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 200, 25);
        labelnumber.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone: ");
        lblphone.setBounds(40, 390, 150, 20);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 390, 200, 25);
        labelphone.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price: ");
        lbltotal.setBounds(40, 430, 150, 20);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setBounds(250, 430, 200, 25);
        labeltotal.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(labeltotal);

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
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookhotel = new JButton("Book Hotel");
        bookhotel.setBackground(Color.black);
        bookhotel.setForeground(Color.white);
        bookhotel.setBounds(200, 490, 120, 25);
        bookhotel.addActionListener(this);
        add(bookhotel);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(340, 490, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 600, 400);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == checkprice){
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"'");

                while (rs.next()){
                    int cost = Integer.parseInt(rs.getString("costperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));

                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();

                    if (persons * days > 0){
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labeltotal.setText("Rs "+total);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    }
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        else if(ae.getSource() == bookhotel){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values ('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labeltotal.getText()+"')");

                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new BookHotel("");
    }
}