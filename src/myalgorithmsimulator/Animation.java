/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myalgorithmsimulator;

import javax.swing.JButton;

/**
 *
 * @author Kirushan Rasendran
 */
public class Animation implements Runnable {

    //Initializing variables 
    private JButton jb1;
    private JButton jb2;
    private int Movejb1;
    private int Movejb2;
    private int space;
    private int speeds;

    public Animation(JButton jb, JButton jb2) {
        this.jb1 = jb;
        this.jb2 = jb2;

    }

    public void run() {

        try {
            int jb1X = jb1.getX();   //Get Starting X,Y cordinate of Button1 duringswap 
            int jb1Y = jb1.getY();
            int jb2X = jb2.getX();  //Get Starting X,Y cordinate of Button2 duringswap 
            int jb2Y = jb2.getY();
//            System.out.println("jB1x"+jb1X);
//            System.out.println("jB1y"+jb1Y);
//            System.out.println("jB2x"+jb2X);
//            System.out.println("jB2y"+jb2Y);
//            System.out.println("jb1Height"+jb1.getHeight());
//            System.out.println("jb2Height"+jb2.getHeight());
            jb1.setLocation(jb1X, jb1Y + jb1.getHeight());
            jb2.setLocation(jb2X, jb2Y + 2 * jb2.getHeight());
            //Sorting g = new Sorting();

            Thread.sleep(100);

            if (jb1X > jb2X) {    //If the X Coordinate of button[i] > button[minPosition]
                Movejb1 = -1;
                Movejb2 = 1;
                space = jb1X - jb2X;
            } else {
                Movejb1 = 1;
                Movejb2 = -1;                //If the X Coordinate of button[i]X < button[minPosition]X
                space = jb2X - jb1X;      //Calculate the Space(Gap between two Buttons)
            }
            for (int z = 1; z <= space; z++)
            {
                jb1.setLocation(jb1X + z * Movejb1, jb1Y + jb1.getHeight()); //Swapping the buttons 
                jb2.setLocation(jb2X + z * Movejb2, jb2Y + 2 * jb2.getHeight());


                Thread.sleep(100);


            }
            jb1.setLocation(jb1.getX(), jb1Y);
            jb2.setLocation(jb2.getX(), jb2Y);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
