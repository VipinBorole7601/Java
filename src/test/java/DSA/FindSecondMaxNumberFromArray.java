package DSA;

public class FindSecondMaxNumberFromArray {

    /**
     *   one way to solve this problem
     *
     *
     */

    public static void main(String[] args) {
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
        int secondMax = number[number.length - 2];
        System.out.println("Second Max: " + secondMax);
    }
}