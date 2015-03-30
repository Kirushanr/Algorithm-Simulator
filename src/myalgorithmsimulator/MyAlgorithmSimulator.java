/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myalgorithmsimulator;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author Kirushan Rasendran
 */
public class MyAlgorithmSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
         try 
        {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName()); 
                    break;
                }
            }  
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }

       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartScreen().setVisible(true);
            }
        });
    }
    }

