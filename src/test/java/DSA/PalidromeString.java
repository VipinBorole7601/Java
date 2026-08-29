package DSA;

public class PalidromeString {


    public static void main(String[] args) {

         String name = "madam";
         String s = "";

         for(int i=name.length()-1;i>=0;i--) {
             s= s + name.charAt(i);
         }

         if(name.equals(s)) {
             System.out.println(name + " is a palindrome");
         } else {
             System.out.println(name + " is not a palindrome");
         }






    }



}
