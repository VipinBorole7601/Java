package JavaPractice;


import java.util.Scanner;

class TestC {



    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a weekday: ");
        String weekday = scanner.nextLine();

        switch (weekday)
        {
            case "Monday":
                System.out.println("today is Monday");
                break;
            case "Tuesday":
                System.out.println("today is Tuesday");
                break;
            case "Wednesday":
                System.out.println("today is Wednesday");
                break;
            default:
                System.out.println("today is Other day");
                break;

        }





    }
}
