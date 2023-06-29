import java.awt.*;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, checkPackages, bookPackages, viewPackages, viewHotels, destinations, bookHotels, viewBookedHotel, payment;
    JButton calculators, notepad, about, deletePersonalDetails;
    String username;
    Dashboard(String username){
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // => It's used to set the frame size equal to your screen size.
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 65, 300, 900);
        p2.setBackground(new Color(0, 0, 102));
        add(p2);

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 0, 300, 50);
        addPersonalDetails.setBackground(new Color(0, 0, 102));
        addPersonalDetails.setForeground(Color.white);
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addPersonalDetails.setMargin(new Insets(0, 0, 0, 60)); // => It's used to give padding to button content, otherwise whatever written on button will always come in middle.
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 50, 300, 50);
        updatePersonalDetails.setBackground(new Color(0, 0, 102));
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatePersonalDetails.setMargin(new Insets(0, 0, 0, 30));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0, 100, 300, 50);
        viewPersonalDetails.setBackground(new Color(0, 0, 102));
        viewPersonalDetails.setForeground(Color.white);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPersonalDetails.setMargin(new Insets(0, 0, 0, 130));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, 150, 300, 50);
        deletePersonalDetails.setBackground(new Color(0, 0, 102));
        deletePersonalDetails.setForeground(Color.white);
        deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deletePersonalDetails.setMargin(new Insets(0, 0, 0, 40));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkPackages = new JButton("Check Package");
        checkPackages.setBounds(0, 200, 300, 50);
        checkPackages.setBackground(new Color(0, 0, 102));
        checkPackages.setForeground(Color.white);
        checkPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkPackages.setMargin(new Insets(0, 0, 0, 110));
        checkPackages.addActionListener(this);
        p2.add(checkPackages);

        bookPackages = new JButton("Book Package");
        bookPackages.setBounds(0, 250, 300, 50);
        bookPackages.setBackground(new Color(0, 0, 102));
        bookPackages.setForeground(Color.white);
        bookPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookPackages.setMargin(new Insets(0, 0, 0, 120));
        bookPackages.addActionListener(this);
        p2.add(bookPackages);

        viewPackages = new JButton("View Package");
        viewPackages.setBounds(0, 300, 300, 50);
        viewPackages.setBackground(new Color(0, 0, 102));
        viewPackages.setForeground(Color.white);
        viewPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPackages.setMargin(new Insets(0, 0, 0, 120));
        viewPackages.addActionListener(this);
        p2.add(viewPackages);

        viewHotels = new JButton("View Hotel");
        viewHotels.setBounds(0, 350, 300, 50);
        viewHotels.setBackground(new Color(0, 0, 102));
        viewHotels.setForeground(Color.white);
        viewHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewHotels.setMargin(new Insets(0, 0, 0, 140));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotels = new JButton("Book Hotel");
        bookHotels.setBounds(0, 400, 300, 50);
        bookHotels.setBackground(new Color(0, 0, 102));
        bookHotels.setForeground(Color.white);
        bookHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookHotels.setMargin(new Insets(0, 0, 0, 140));
        bookHotels.addActionListener(this);
        p2.add(bookHotels);

        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(0, 450, 300, 50);
        viewBookedHotel.setBackground(new Color(0, 0, 102));
        viewBookedHotel.setForeground(Color.white);
        viewBookedHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewBookedHotel.setMargin(new Insets(0, 0, 0, 70));
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);

        destinations = new JButton("Destinations");
        destinations.setBounds(0, 500, 300, 50);
        destinations.setBackground(new Color(0, 0, 102));
        destinations.setForeground(Color.white);
        destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
        destinations.setMargin(new Insets(0, 0, 0, 130));
        destinations.addActionListener(this);
        p2.add(destinations);

        payment = new JButton("Payments");
        payment.setBounds(0, 550, 300, 50);
        payment.setBackground(new Color(0, 0, 102));
        payment.setForeground(Color.white);
        payment.setFont(new Font("Tahoma", Font.PLAIN, 20));
        payment.setMargin(new Insets(0, 0, 0, 150));
        payment.addActionListener(this);
        p2.add(payment);

        calculators = new JButton("Calculator");
        calculators.setBounds(0, 600, 300, 50);
        calculators.setBackground(new Color(0, 0, 102));
        calculators.setForeground(Color.white);
        calculators.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calculators.setMargin(new Insets(0, 0, 0, 150));
        calculators.addActionListener(this);
        p2.add(calculators);

        notepad = new JButton("Notepad");
        notepad.setBounds(0, 650, 300, 50);
        notepad.setBackground(new Color(0, 0, 102));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        notepad.setMargin(new Insets(0, 0, 0, 155));
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0, 700, 300, 50);
        about.setBackground(new Color(0, 0, 102));
        about.setForeground(Color.white);
        about.setFont(new Font("Tahoma", Font.PLAIN, 20));
        about.setMargin(new Insets(0, 0, 0, 175));
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);

        JLabel text = new JLabel("Travel & Tourism Management System");
        text.setBounds(400, 70, 1200, 70);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway", Font.PLAIN, 55));
        image.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == addPersonalDetails){
            new AddCustomer(username);
        } else if (ae.getSource() == viewPersonalDetails) {
            new ViewCustomer(username);
        } else if (ae.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username);
        } else if (ae.getSource() == checkPackages) {
            new CheckPackage();
        } else if (ae.getSource() == bookPackages){
            new BookPackage(username);
        } else if (ae.getSource() == viewPackages){
            new ViewPackage(username);
        } else if (ae.getSource() == viewHotels){
            new CheckHotels();
        } else if (ae.getSource() == destinations){
            new Destinations();
        } else if (ae.getSource() == bookHotels){
            new BookHotel(username);
        }else if (ae.getSource() == viewBookedHotel){
            new ViewBookedHotel(username);
        }else if (ae.getSource() == payment){
            new Payment();
        }else if (ae.getSource() == calculators){
            // way to get system's CALCULATOR in function.
            try{
                Runtime.getRuntime().exec("calc.exe");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == about){
            new About();
        } else if (ae.getSource() == deletePersonalDetails){
            new DeleteDetails(username);
        }
    }

    public static void main(String[] args) {
        new Dashboard("");
    }
}