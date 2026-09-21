class ParkingSystem {
    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (big > 0) {
                big--;
                return true;
            }
        } else if (carType == 2) {
            if (medium > 0) {
                medium--;
                return true;
            }
        } else if (carType == 3) {
            if (small > 0) {
                small--;
                return true;
            }
        }
        return false;
    }

    // Optional: main method to test the example
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        
        System.out.println(parkingSystem.addCar(1)); // true
        System.out.println(parkingSystem.addCar(2)); // true
        System.out.println(parkingSystem.addCar(3)); // false
        System.out.println(parkingSystem.addCar(1)); // false
    }
}