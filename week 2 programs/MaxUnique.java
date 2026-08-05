import java.util.*;

public class MaxUnique {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // total numbers
        int m = sc.nextInt(); // size of subarray

        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> freq = new HashMap<>();

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            // Add current number to the window
            deque.addLast(num);
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            // Remove the element that is going out of the window
            if (deque.size() > m) {
                int removed = deque.removeFirst();
                freq.put(removed, freq.get(removed) - 1);
                if (freq.get(removed) == 0) {
                    freq.remove(removed);
                }
            }

            // Update maximum unique count when window size is exactly m
            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, freq.size());
            }
        }

        System.out.println(maxUnique);
        sc.close();
    }
}