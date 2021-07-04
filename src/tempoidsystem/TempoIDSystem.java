/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempoidsystem;

/**
 *
 * @author E-rinGZ
 */
public class TempoIDSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
       StringBuffer buff = new StringBuffer("CDM-2100010");
       System.out.println("before = " +buff);
       buff.delete(0, 4);
       System.out.println("after = " +buff);
       String a = buff.toString();
       int b = Integer.parseInt(a);
       int c = b + 1;
       System.out.println(c);
       String d = String.valueOf(c);
       String e = "CDM-"+d;
       System.out.println(e);
       
       
       /* 
       int alength = a.length();
       System.out.println("a length: " +alength);
       int b = Integer.parseInt(a);
       int c = b + 1;
       String d = String.valueOf(c);
       int dlength = d.length();
       int e = alength - dlength;
       //System.out.println("the remaining is "+e);
       String f;
       for(int i = 0; i<e; i++){
           f = "0";
          
       }
       System.out.println(f);
       String g = f+d;
       System.out.println("CDM-"+g);*/
       
    }

}
