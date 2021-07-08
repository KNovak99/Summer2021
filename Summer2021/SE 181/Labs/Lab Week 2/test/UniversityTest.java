import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniversityTest {

    public static final String NAME = "Boris Valerstein";
    public static final String QUICK_ID = "bv49";
    private static final String COURSE_NAME = "CS100";
    University university;

    @BeforeEach
    void setUp() {
        university = new University();
    }

    @Test
    void university_has_no_students_initially() {
        assertTrue(university.getStudents().isEmpty());
    }

    @Test
    void add_student_to_university() {
        university.addStudent(QUICK_ID, NAME);
        assertEquals(NAME, university.getStudents().get(QUICK_ID).getName());
    }

    @Test
    void add_two_students_to_university() {
        university.addStudent(QUICK_ID, NAME);
        university.addStudent(QUICK_ID + "1", NAME + "1");
        assertEquals(NAME + "1", university.getStudents().get(QUICK_ID + "1").getName());
    }

    @Test
    void enroll_student_in_course() {
        university.addStudent(QUICK_ID, NAME);
        university.enrollStudent(QUICK_ID, COURSE_NAME);
        Student actual = university.getStudents().get(QUICK_ID);
        assertEquals(COURSE_NAME, actual.getCourses().get(0));
    }

    @Test
    void enroll_student_in_two_courses() {
        university.addStudent(QUICK_ID, NAME);
        university.enrollStudent(QUICK_ID, COURSE_NAME);
        university.enrollStudent(QUICK_ID, COURSE_NAME + "1");
        Student actual = university.getStudents().get(QUICK_ID);
        assertEquals(COURSE_NAME, actual.getCourses().get(0));
        assertEquals(COURSE_NAME + "1", actual.getCourses().get(1));
    }

    @Test
    void unenroll_student_in_course() {
        university.addStudent(QUICK_ID, NAME);
        university.enrollStudent(QUICK_ID, COURSE_NAME);
        university.unenroll(QUICK_ID, COURSE_NAME);
        Student actual = university.getStudents().get(QUICK_ID);
        assertTrue(actual.getCourses().isEmpty());
    }

}
