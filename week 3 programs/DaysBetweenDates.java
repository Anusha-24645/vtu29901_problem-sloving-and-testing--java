import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DaysBetweenDates {

    public int daysBetweenDates(String date1, String date2) {
        LocalDate d1 = LocalDate.parse(date1);
        LocalDate d2 = LocalDate.parse(date2);
        return (int) Math.abs(ChronoUnit.DAYS.between(d1, d2));
    }

    // Optional main method for testing in VS Code
    public static void main(String[] args) {
        DaysBetweenDates solution = new DaysBetweenDates();

        // Example 1
        System.out.println(solution.daysBetweenDates("2019-06-29", "2019-06-30")); // 1

        // Example 2
        System.out.println(solution.daysBetweenDates("2020-01-15", "2019-12-31")); // 15
    }
}