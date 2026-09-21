class Arithmetic {
    int add(int a, int b) {
        return a + b;
    }
}

public class Adder extends Arithmetic {

    public static void main(String[] args) {
        // Create a new Adder object
        Adder a = new Adder();

        // Print the name of the superclass
        System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());

        // Print the results of three add calls
        System.out.print(a.add(10, 32) + " " + a.add(10, 3) + " " + a.add(10, 10) + "\n");
    }
}