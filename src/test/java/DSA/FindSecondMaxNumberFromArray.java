package DSA;

public class FindSecondMaxNumberFromArray {

    /**
     *   one way to solve this problem
     *
     *
     */

    public static void main(String[] args) {
        //way 1

        int a[] = {10,3,1,5,7,90};
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



        //way 2

        int[] number = {2,38, 44,22, 4, 6, 2, 7, 1};
        int temp=0;

        for(int i = 0; i < number.length; i++) {
            for(int j = i + 1; j < number.length; j++) {
                if(number[i] > number[j]) {
                    temp = number[i];
                    number[i] = number[j];
                    number[j] = temp;
                }
            }
        }
        int secondMax2 = number[number.length - 2];
        System.out.println("Second Max: " + secondMax2);





    }
}