package DSA;

public class ReverseAString {

    public static void main(String[] args) {

        String a = "vipin is my name";
        String b="";

        for(int i=a.length()-1;i>=0;i--)
        {

            b=b + a.charAt(i);
        }

        System.out.println(b);

    }

}
