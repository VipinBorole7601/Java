package DSA;

public class PalindromeNumber {


    public static void main(String[] args) {

        int n=0; int temp;
        int sum=0;

        int a = 75657;

        temp=a;

        while(a>0)
        {
            n=a%10;
            sum=(sum*10)+n;
            a=a/10;
        }

        if(temp==sum)
        {
            System.out.println("Palindrome");
        }
        else
        {
            System.out.println("Not Palindrome");
        }




    }

}
