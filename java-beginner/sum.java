import java.util.Scanner;

public class sum {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Two Numbers (Press Enter after Each Entry)");
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println("The sum of " + a + " and " + b + " is " + (a+b));
    }
}
