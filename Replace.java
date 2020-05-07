package lectuer;

import java.util.*;


public class Replace {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        String leet;
        
        
             leet =line.replace("A","4")
            		   .replace("E","3")
             	       .replace("G","6")
             	       .replace("I","1")
             	       .replace("O","0")
             	       .replace("S","5")
             	       .replace("Z","2");
            
        
        System.out.println(leet);
    }
}