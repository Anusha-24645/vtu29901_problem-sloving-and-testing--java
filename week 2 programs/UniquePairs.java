import java.util.*;

public class UniquePairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();          // number of pairs
        sc.nextLine();                 // consume the remaining newline

        Set<String> set = new HashSet<>();

        for (int i = 0; i < t; i++) {
            String pair = sc.nextLine();   // read the whole line "name1 name2"
            set.add(pair);                 // HashSet automatically keeps only unique pairs
            System.out.println(set.size());
        }

        sc.close();
    }
}