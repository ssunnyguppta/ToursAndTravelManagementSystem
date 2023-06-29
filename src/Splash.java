import javax.swing.*;
import java.awt.*;

// ONLY ONE CLASS CAN BE EXTENDED IN JAVA
// MULTIPLE INHERITANCE IS POSSIBLE BY ONLY EXTENDING 1 CLASS AND IMPLEMENTING OTHER IMPLEMENTS.

public class Splash extends JFrame implements Runnable{ // -> extends Jframe to make the frame (comes with javax.swing classs)

    Thread thread;
    // Constructor --> name same as Class name
    Splash(){
        // setsize and setLocation funcs has been commented coz it's has been HARDCORED.
//        setSize(1200, 600);   // -> used to define FRAME SIZE of the project.
//        setLocation(200, 100);    // -> to bring the frame in mid from the lept top corner

        // to call the image from the file -> create a object and then define in it.
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/splash.jpg"));
        // to add this Image class ==> AWT is needed to be imported.
        // then making the object of the same to fit the image on the frame
        // and then we cannot directly add that on frame.
        // we have to create a i3 class of ImageIcon to add that image.
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        // creating i3 ImageIcon Class to add image.
        ImageIcon i3 = new ImageIcon(i2);
        // to fit the image on frame JLabel is used by adding the image's object
        JLabel image = new JLabel(i3);
        // and then add function to finally add the image on the frame.
        add(image);
        setVisible(true);  // -> so that frame is visible to us
        thread = new Thread(this);
        thread.start();
    }

    public void run(){
        try {
            Thread.sleep(3000);
            new Login();
            setVisible(false);
        }catch (Exception e){}
    }



    public static void main(String[] args) {
        Splash frame = new Splash(); // -> making object of Splash for making the frame moivng while opening
        int x = 1;
        for (int i=1; i<=150; i++) {
            frame.setLocation(160 + i / 2, 90 + i / 2);
            frame.setSize(1050 + x + i, 480 + i);
            // try & catch block
            // thread.sleep for making it a bit late by adding the miliseconds value inside tht.
            try {
                Thread.sleep(05);
            } catch (Exception e) {
            }
        }

        new Login();
    }
}