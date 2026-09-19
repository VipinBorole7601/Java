package DSA;

public class FindNumberIsOddOrEven {

    public static void main(String[] args) {

       int a[] = {2,3,6,6,2,2,1,1,6,7};

       int odd=0;
       int even=0;

       for(int i=0;i<=a.length-1;i++)
       {
           if(a[i]%2==1)
           {
               odd++;

           } else if (a[i]%2==0) {
               even++;
           }
       }

        System.out.println("total odd are "+odd);
        System.out.print("total even are "+even);

    }


}
