import java.util.*;

class UndergroundSystem {

    // Stores the current check-in information of a customer
    // Key = customer id, Value = [stationName, checkInTime]
    private Map<Integer, Pair> checkInMap;

    // Stores the total travel time and number of trips between two stations
    // Key = "startStation->endStation", Value = [totalTime, tripCount]
    private Map<String, double[]> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair checkInInfo = checkInMap.get(id);
        String startStation = checkInInfo.station;
        int checkInTime = checkInInfo.time;

        int travelTime = t - checkInTime;
        String route = startStation + "->" + stationName;

        // Update total time and count for this route
        travelMap.putIfAbsent(route, new double[2]);
        travelMap.get(route)[0] += travelTime;   // total time
        travelMap.get(route)[1] += 1;            // number of trips

        // Remove the customer from check-in map
        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        double[] data = travelMap.get(route);
        return data[0] / data[1];   // totalTime / tripCount
    }

    // Helper class to store station name and time
    private static class Pair {
        String station;
        int time;

        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}

// ==================== Test Code ====================
public class Main {
    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();

        // Example 1
        System.out.println("===== Example 1 =====");
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);

        System.out.printf("%.5f%n", undergroundSystem.getAverageTime("Paradise", "Cambridge")); // 14.00000
        System.out.printf("%.5f%n", undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // 11.00000

        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.printf("%.5f%n", undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // 11.00000

        undergroundSystem.checkOut(10, "Waterloo", 38);
        System.out.printf("%.5f%n", undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // 12.00000

        System.out.println();

        // Example 2
        System.out.println("===== Example 2 =====");
        UndergroundSystem us2 = new UndergroundSystem();
        us2.checkIn(10, "Leyton", 3);
        us2.checkOut(10, "Paradise", 8);
        System.out.printf("%.5f%n", us2.getAverageTime("Leyton", "Paradise")); // 5.00000

        us2.checkIn(5, "Leyton", 10);
        us2.checkOut(5, "Paradise", 16);
        System.out.printf("%.5f%n", us2.getAverageTime("Leyton", "Paradise")); // 5.50000

        us2.checkIn(2, "Leyton", 21);
        us2.checkOut(2, "Paradise", 30);
        System.out.printf("%.5f%n", us2.getAverageTime("Leyton", "Paradise")); // 6.66667
    }
}