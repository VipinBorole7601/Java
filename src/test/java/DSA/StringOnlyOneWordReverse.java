package DSA;

public class StringOnlyOneWordReverse {


    public static void main(String[] args) {


        String a = "I love my india";

        String n[] = a.split(" ");

        String rev="";

        for(String c:n) {
            System.out.print(" ");

            if(c.equalsIgnoreCase("india"))
            {
                for(int i=c.length()-1;i>=0;i--)
                {

                    rev = rev+c.charAt(i);

                }
                System.out.print(rev);

            } else {
                System.out.print(c);
            }


        }



    }



}
