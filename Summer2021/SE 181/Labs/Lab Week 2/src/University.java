import java.util.HashMap;
import java.util.Map;

public class University {
    private Map<String, Student> students;

    University() {
        students = new HashMap<>();
    }

    public Map<String, Student> getStudents() {
        return students;
    }

    public void addStudent(String quickId, String name) {
        students.put(quickId, new Student(name));
    }

    public void enrollStudent(String quickId, String CourseName) {
        students.get(quickId).enroll(CourseName);
    }

    public void unenroll(String quickId, String courseName) {
        students.get(quickId).unenroll(courseName);
    }
}
