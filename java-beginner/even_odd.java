// Gets number and checks if it is even or odd
import java.util.Scanner;
public class even_odd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = scanner.nextInt();
        if (num % 2 == 0) {
            System.out.println(num + " is Even");
        }
        else {
            System.out.println(num + " is Odd");
        }
        scanner.close();
    }
}
