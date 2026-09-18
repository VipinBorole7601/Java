package DSA;

import java.util.Arrays;

public class ArraySwap {


    public static void main(String[] args) {

  int[] a1 = {4,6,7,3};
  int[] a2 = {1,8,9,5};

  int temp=0;

if(a1.length==a2.length) {
    for (int i = 0; i <= a1.length - 1; i++) {

        temp = a1[i];
        a1[i] = a2[i];
        a2[i] = temp;

    }
}
  System.out.println(" a2 is swaped into a1 :- "+java.util.Arrays.toString(a1));
  System.out.println(" a1 is swaped into a2 :- "+java.util.Arrays.toString(a2));


    }



}
