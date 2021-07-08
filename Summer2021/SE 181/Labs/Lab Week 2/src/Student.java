import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<String> courses;

    public Student(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void enroll(String courseName) {
        courses.add(courseName);
    }

    public void unenroll(String courseName) {
        courses.remove(courseName);
    }
}
