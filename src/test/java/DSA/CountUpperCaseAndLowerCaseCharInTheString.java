package DSA;

public class CountUpperCaseAndLowerCaseCharInTheString {


    public static void main(String[] args) {


        String a = "My name is Vipin WELOCOME";
        
        int n=0;
        int x=0;
        int upperCasecount = 0;
        int lowerCasecount = 0;
        
        for(int i=0;i<=a.length()-1;i++)
        {
            if(Character.isUpperCase(a.charAt(i))){
                upperCasecount = n+1;
                n++;
              }
        }

        for(int i=0;i<=a.length()-1;i++)
        {
            if(Character.isLowerCase(a.charAt(i))){
                lowerCasecount = x+1;
                x++;
            }
        }

        System.out.println("Upper case count: " + upperCasecount);
        System.out.println("Lower case count: " + lowerCasecount);

    }

}
