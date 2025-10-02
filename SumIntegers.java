import java.util.ArrayList;
import java.util.Scanner;

public class SumIntegers
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Enter integers separated by space:");
        String[] inputs = sc.nextLine().split(" ");
        for (String s : inputs) {
            Integer num = Integer.parseInt(s);
            numbers.add(num);
        }
        int sum = 0;
        for (Integer n : numbers) {
            sum += n;
        }
        System.out.println("Sum of integers: " + sum);
        sc.close();
    }
}
