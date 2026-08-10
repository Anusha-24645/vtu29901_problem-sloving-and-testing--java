import java.time.LocalDate;
import java.util.Scanner;

public class DayOfWeek {
    
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return days[date.getDayOfWeek().getValue() - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DayOfWeek solution = new DayOfWeek();

        System.out.print("Enter day: ");
        int day = sc.nextInt();
        System.out.print("Enter month: ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        System.out.println(solution.dayOfTheWeek(day, month, year));
        sc.close();
    }
}