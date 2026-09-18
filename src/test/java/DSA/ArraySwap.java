package DSA;

import java.util.Arrays;

public class ArraySwap {


    public static void main(String[] args) {


        int []a1= {2,4,7,8};
        int []b2={6,9,1,3};

        int temp=0;

        if(a1.length==b2.length)
        {

            for(int i=0;i<a1.length-1;i++)
            {
                temp=a1[i];
                a1[i]=b2[i];
                b2[i]=temp;
            }

            System.out.println(Arrays.toString(a1));
            System.out.println(Arrays.toString(b2));

        }








    }



}
