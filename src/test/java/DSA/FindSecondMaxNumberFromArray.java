package DSA;

public class FindSecondMaxNumberFromArray {

    /**
     *   one way to solve this problem
     *
     *
     */

    public static void main(String[] args) {

        int a[] = {10,23,1,5,7,90};
        int max =0;
        int secondMax=0;
        for(int i=0;i<=a.length-1;i++)
        {
            if(max<a[i])
            {
                max=a[i];
            }
        }
        for(int i = 0; i <= a.length - 1; i++) {
            if(a[i] != max && secondMax < a[i]) {
                secondMax = a[i];
            }
        }
        System.out.println(max);
        System.out.println(secondMax);






    }
}