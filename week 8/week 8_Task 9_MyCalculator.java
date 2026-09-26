import java.util.Scanner;

public class MyCalculator {

    public long power(int n, int p) throws Exception {

        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        }

        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        }

        long result = 1;

        for (int i = 0; i < p; i++) {
            result = result * n;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MyCalculator calculator = new MyCalculator();

        while (sc.hasNextInt()) {

            int n = sc.nextInt();
            int p = sc.nextInt();

            try {
                System.out.println(calculator.power(n, p));
            } 
            catch (Exception e) {
                System.out.println("java.lang.Exception: " + e.getMessage());
            }
        }

        sc.close();
    }
}