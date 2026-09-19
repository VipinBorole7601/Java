package DSA;

public class StringWordsReverseNotSentence {


    public static void main(String[] args) {

        String name ="vipin borole";
        String [] aname = name.split(" ");

        for(String n:aname)
        {
            for(int j=n.length()-1;j>=0;j--)
            {

                System.out.print(n.charAt(j));

            }
            System.out.print(" ");

        }





       }



    }




