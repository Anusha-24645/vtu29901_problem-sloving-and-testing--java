public class ShuffleArray {

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];         // xi
            result[2 * i + 1] = nums[n + i]; // yi
        }
        return result;
    }

    public static void main(String[] args) {
        ShuffleArray obj = new ShuffleArray();

        // Example 1
        int[] nums1 = {2, 5, 1, 3, 4, 7};
        int[] result1 = obj.shuffle(nums1, 3);
        System.out.print("Example 1 Output: ");
        printArray(result1);

        // Example 2
        int[] nums2 = {1, 2, 3, 4, 4, 3, 2, 1};
        int[] result2 = obj.shuffle(nums2, 4);
        System.out.print("Example 2 Output: ");
        printArray(result2);

        // Example 3
        int[] nums3 = {1, 1, 2, 2};
        int[] result3 = obj.shuffle(nums3, 2);
        System.out.print("Example 3 Output: ");
        printArray(result3);
    }

    // Helper method to print array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}