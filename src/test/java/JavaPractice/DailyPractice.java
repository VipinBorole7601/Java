package JavaPractice;


import java.util.HashMap;
import java.util.Map;

public class DailyPractice {
    public static void main(String[] args) {

   String a = "My name is vipin Borole";
   char [] r = a.toCharArray();
   int upperCase=0;
   int lowerCase=0;

   for(int i=0;i<=a.length()-1;i++)
   {
       if(Character.isUpperCase(r[i]))
       {
           upperCase++;
       }
       else if(Character.isLowerCase(r[i])) {
           lowerCase++;
       }



   }

        System.out.println("uppercase:- "+upperCase);
        System.out.println("lowercase:- "+lowerCase);





    }
}