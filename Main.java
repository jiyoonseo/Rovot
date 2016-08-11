import java.*;

public class Main { 
   public static void main(String[] args) { 
      // System.out.println("Hello, World :D"); //test string...

      //calling Rovot class
      Rovot g1 = new Rovot(1, 2, 'N');       
      g1.sendMessage("LMLMLMLMM"); 
      g1.printRovot(); // check what fin coor is for g1 


      Rovot g2 = new Rovot(3, 3, 'E');
      g2.sendMessage("MMRMMRMRRM");  
      g2.printRovot(); // check what fin coor is for g2
   }


}
