package DSA;

public class CountUpperCaseAndLowerCaseCharInTheString {


    public static void main(String[] args) {

    //way 1
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


        // way 2


        String b = "My name is vipin Borole";
        char [] r = b.toCharArray();
        int upperCase=0;
        int lowerCase=0;

        for(int i=0;i<=b.length()-1;i++)
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
