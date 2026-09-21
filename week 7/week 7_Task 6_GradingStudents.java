import java.util.*;

public class GradingStudents {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> result = new ArrayList<>();

        for (int grade : grades) {
            if (grade < 38) {
                // No rounding for failing grades
                result.add(grade);
            } else {
                int nextMultiple = ((grade / 5) + 1) * 5;
                if (nextMultiple - grade < 3) {
                    result.add(nextMultiple);  // Round up
                } else {
                    result.add(grade);         // Keep original
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();                 // Number of students
        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            grades.add(sc.nextInt());
        }

        List<Integer> rounded = gradingStudents(grades);

        for (int grade : rounded) {
            System.out.println(grade);
        }

        sc.close();
    }
}