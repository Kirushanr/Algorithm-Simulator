/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myalgorithmsimulator;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

/**
 *
 * @author Kirushan Rasendran
 */
public class Sorting extends javax.swing.JFrame {

    public Sorting() {
    }

    /**
     * Creates new form Sorting
     */
    public Sorting(int[] array) {
        inputarray = new int[array.length];
        inputarray = array.clone();
        initComponents();
        addButtonToFrame();
    }
    int[] inputarray;
    JButton[] button;
    int max = 5;
    JFrame starting;
    Thread Animation;
    public Thread SortingStart;
    int sliderspeed = 10;

    /*
     * addButtonToFrame() Methods adds button to interface after the user clicks 
     * respective sorting button(selection || Bubble sort
     * 
    */
    void addButtonToFrame() {
        starting = null;
        button = new JButton[max];
        for (int i = 0; i < max; i++) {
            System.out.println(inputarray[i]);
            button[i] = new JButton();
            button[i].setName("ButtonVal" + i);
            button[i].setText("" + inputarray[i]);
            button[i].setEnabled(true);
            button[i].setVisible(true);
            button[i].setLayout(new BorderLayout());



        }
        layout(button);



    
    }
    
    
    /*
     * void layout(JButton[]buttons)
    *       Group layout used to insert buttons in a row seqentially and 
    * with gaps between button are automatically Generated 
    * Reference http://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
    */
     
    void layout(JButton[] buttons) {

        GroupLayout gp = new GroupLayout(getContentPane()); 
        getContentPane().setLayout(gp);


        gp.setAutoCreateGaps(true);
        gp.setAutoCreateContainerGaps(true);

        GroupLayout.Group H = gp.createSequentialGroup();
        GroupLayout.Group V = gp.createParallelGroup();


        for (int i = 0; i < buttons.length; i++) {
            H.addComponent(buttons[i]);
            V.addComponent(buttons[i]);
        }
        gp.setHorizontalGroup(H);
        gp.setVerticalGroup(V);

        pack();
    }
    /*
     * Invoking the selctionsort runnable 
    */
    public void SelectionSortCall() {
        SortingStart = new Thread(new Selectionsort());
    }
     /*
     * Invoking the Bubble sort runnable 
    */
    
    public void BubbleSortcall() {
        SortingStart = new Thread(new BubbleSorting());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(675, 416));
        setResizable(false);
        getContentPane().setLayout(null);

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(80, 260, 75, 31);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 228, 675, 20);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(350, 260, 80, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       /*
        * If the thread is not alive start the thread else resume the thread
        */        
        if (!SortingStart.isAlive()) 
        {
            SortingStart.start();
        } else {
            SortingStart.resume();
            SortingStart.resume();

        }
    }//GEN-LAST:event_jButton1ActionPerformed

       
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         /*
         Back Button
         */
        
        this.dispose();
        new StartScreen().setVisible(true);
    
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void init() {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    public void setParentFrame(JFrame aThis) {
        this.starting = aThis;
    }

    public JFrame getParentFrame() {
        return starting;
    }

    class Selectionsort implements Runnable {

        @Override
        public void run() {
//            sliderspeed=jSlider1.getValue();
            //System.out.println(sliderspeed);
             jButton1.setEnabled(false);
            for (int i = 0; i < max; i++) 
            {
                try {
                    int minPosition = i;
                    int j;

                    for (j = i + 1; j < max; j++) {
                        System.out.println("Compare" + inputarray[j] + " with" + inputarray[minPosition]);
                        button[j].setBackground(Color.yellow);
                        button[minPosition].setBackground(Color.red);
                        Thread.sleep(1000);

                        if (inputarray[j] < inputarray[minPosition]) {
                            button[minPosition].setBackground(Color.white);
                            minPosition = j;
                        }
                        button[j].setBackground(Color.white);
                    }
                    if (i != minPosition) {
                        button[i].setBackground(Color.yellow);
                        button[minPosition].setBackground(Color.red);

                        int temp = inputarray[i];
                        inputarray[i] = inputarray[minPosition];
                        inputarray[minPosition] = temp;
                        SortingStart = new Thread(new Animation(button[i], button[minPosition]));
                        SortingStart.start();
                        SortingStart.join();
                        JButton tempButton = button[i];
                        button[i] = button[minPosition];
                        button[minPosition] = tempButton;
                        button[i].setBackground(Color.green);
                        button[minPosition].setBackground(Color.WHITE);
                    }
                    else 
                    {
                        button[i].setBackground(Color.green);
                    }


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
               
             
            
        }
    }

    public void Colorchange(final int v1, final int v2, Color c) {
        button[v1].setBackground(c);
        button[v2].setBackground(c);
    }

    class BubbleSorting implements Runnable 
    {

        public void run() {
              jButton1.setEnabled(false);
            for (int i = 0; i < max - 1; i++) 
            {
                try {

                    for (int j = 0; j < max - i - 1; j++) {
                        button[j].setBackground(Color.yellow);
                        button[j + 1].setBackground(Color.yellow);
                        Thread.sleep(1000);
                        if (inputarray[j] > inputarray[j + 1]) {
                            int temp = inputarray[j];
                            inputarray[j] = inputarray[j + 1];
                            inputarray[j + 1] = temp;

                            SortingStart = new Thread(new Animation(button[j], button[j + 1]));
                            SortingStart.start();
                            SortingStart.join();

                            JButton temps = button[j];
                            button[j] = button[j + 1];
                            button[j + 1] = temps;

                        }
                        Colorchange(j, j + 1, Color.white);
                    }
                    for (int j = 5 - i - 1; j < 5; j++) {
                        button[j].setBackground(Color.green);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                for (int j = 0; j < 5; j++) {
                    button[j].setBackground(Color.green);
                }
                  
            }
            
           
               
           
        }
      
    }
}