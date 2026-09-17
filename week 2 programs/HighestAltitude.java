public class HighestAltitude {

    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int maxAltitude = 0;

        for (int g : gain) {
            currentAltitude += g;
            if (currentAltitude > maxAltitude) {
                maxAltitude = currentAltitude;
            }
        }
        return maxAltitude;
    }

    public static void main(String[] args) {
        HighestAltitude obj = new HighestAltitude();

        // Example 1
        int[] gain1 = {-5, 1, 5, 0, -7};
        System.out.println("Example 1 Output: " + obj.largestAltitude(gain1));

        // Example 2
        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println("Example 2 Output: " + obj.largestAltitude(gain2));
    }
}