import java.util.*;

public class LargestNumber {
    
    public String largestNumber(int[] nums) {
        // Convert integers to strings
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // Custom sort: compare a+b vs b+a
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is "0", return "0"
        if (strs[0].equals("0")) {
            return "0";
        }

        // Build the result
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LargestNumber solution = new LargestNumber();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Largest Number: " + solution.largestNumber(nums));
        sc.close();
    }
}