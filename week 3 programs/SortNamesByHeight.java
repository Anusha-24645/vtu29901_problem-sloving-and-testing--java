import java.util.*;

public class SortNamesByHeight {
    
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        
        // Create array of indices
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices by height in descending order
        Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);

        // Build result
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = names[indices[i]];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SortNamesByHeight solution = new SortNamesByHeight();

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] names = new String[n];
        int[] heights = new int[n];

        System.out.println("Enter names:");
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        System.out.println("Enter heights:");
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        String[] result = solution.sortPeople(names, heights);
        System.out.println(Arrays.toString(result));
        sc.close();
    }
}