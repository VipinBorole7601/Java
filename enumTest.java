public class enumTest {

  
  public enum signal{
      
    green, yellow, red;

  }


     public static void main(String[] args) {
         
         signal s = signal.red;
         
         switch(s){
             case green:
                 System.out.println("Go");
                 break;
             case yellow:
                 System.out.println("Ready");
                 break;
             case red:
                 System.out.println("Stop");
                 break;
         }
     }

  
}
