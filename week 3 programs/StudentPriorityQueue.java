import java.util.*;

class Student {
    int id;
    String name;
    double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    int getID() { return id; }
    String getName() { return name; }
    double getCGPA() { return cgpa; }
}

class Priorities {
    List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>((s1, s2) -> {
            if (s1.cgpa != s2.cgpa)
                return Double.compare(s2.cgpa, s1.cgpa);
            if (!s1.name.equals(s2.name))
                return s1.name.compareTo(s2.name);
            return Integer.compare(s1.id, s2.id);
        });

        for (String e : events) {
            if (e.startsWith("ENTER")) {
                String[] p = e.split(" ");
                pq.add(new Student(Integer.parseInt(p[3]), p[1], Double.parseDouble(p[2])));
            } else if (!pq.isEmpty()) {
                pq.poll();
            }
        }

        List<Student> result = new ArrayList<>();
        while (!pq.isEmpty()) result.add(pq.poll());
        return result;
    }
}

public class StudentPriorityQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> events = new ArrayList<>();
        for (int i = 0; i < n; i++) events.add(sc.nextLine());

        List<Student> students = new Priorities().getStudents(events);
        if (students.isEmpty()) System.out.println("EMPTY");
        else for (Student s : students) System.out.println(s.getName());
        sc.close();
    }
}