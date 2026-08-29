package DSA;

public class CreateDiemandStarPattern {

    public static void main(String[] args) {


        for(int i=0;i<=5;i++)
        {

            for(int j=4;j>=i;j--) {
                System.out.print(" ");
            }

            for(int k=1;k<=i;k++)
            {
                System.out.print("*");
            }

            for(int l=2;l<=i;l++)
            {
                System.out.print("*");
            }


            System.out.println();
        }


        for(int m=1;m<=5;m++)
        {

            for(int n=1;n<=m;n++) {
                System.out.print(" ");
            }

            for(int o=4;o>=m;o--)
            {
                System.out.print("*");
            }

            for(int p=3;p>=m;p--)
            {
                System.out.print("*");
            }


            System.out.println();
    }

}
}
