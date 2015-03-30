/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myalgorithmsimulator;

import javax.swing.JTextField;

/**
 *
 * @author Kirushan Rasendran
 */
public class Validation {

    public Validation() {
    }
    
    public boolean valid(String a,String b,String c,String d,String e)
    {
       boolean  ar=isDigit(a);
       boolean  br=isDigit(b);
       boolean  cr=isDigit(c);
       boolean  dr=isDigit(d);
       boolean  er=isDigit(e);
       if(ar && br && cr  && dr && er)
       {
           return true;
       }
       else
       {
            return false;
       }
       
    }
    public boolean isDigit(String a)
    {
        boolean digitresult=false;
        int stringlength=a.length();
        for(int i=0;i<stringlength;i++)
        {
            digitresult=Character.isLetter(a.charAt(i));
        }
        return digitresult;
    }
    
}
