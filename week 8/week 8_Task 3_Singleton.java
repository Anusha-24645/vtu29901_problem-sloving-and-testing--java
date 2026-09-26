public class Singleton {

    // Private static instance
    private static Singleton singleInstance = null;

    // Public String variable
    public String str;

    // Private constructor
    private Singleton() {
    }

    // Static method to return the single instance
    public static Singleton getSingleInstance() {

        if (singleInstance == null) {
            singleInstance = new Singleton();
        }

        return singleInstance;
    }

    // Main method for running in VS Code
    public static void main(String[] args) {

        String input = "hello world";

        Singleton instance = Singleton.getSingleInstance();

        instance.str = input;

        System.out.println(
            "Hello I am a singleton! Let me say " 
            + instance.str + " to you"
        );
    }
}