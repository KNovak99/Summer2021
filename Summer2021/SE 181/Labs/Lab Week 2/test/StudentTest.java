import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest {

    public static final String NAME = "Boris Valerstein";
    Student student;

    @BeforeEach
    void setUp() {
        student = new Student(NAME);
    }

    @Test
    void student_has_name() {
        Student student = new Student(NAME);
        assertEquals(NAME, student.getName());
    }

    @Test
    void student_is_not_enrolled_in_any_courses_initially() {
        Student student = new Student(NAME);
        assertTrue(student.getCourses().isEmpty());
    }
}
