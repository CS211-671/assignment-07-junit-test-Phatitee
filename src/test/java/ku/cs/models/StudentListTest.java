package ku.cs.models;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StudentListTest {

    private StudentList studentList;

    @BeforeEach
     void setUp() {
        studentList = new StudentList();
    }

    @Test
    void testAddNewStudentWithTwoParameters() {
        studentList.addNewStudent("123", "John Doe");
        Student student = studentList.findStudentById("123");
        assertNotNull(student, "Student should not be null");
        assertEquals("John Doe", student.getName(), "Student name should be 'John Doe'");
        assertEquals(0.0, student.getScore(), 0.01, "Default score should be 0.0");
    }

    @Test
    void testAddNewStudentWithThreeParameters() {
        studentList.addNewStudent("123", "John Doe", 85.0);
        Student student = studentList.findStudentById("123");
        assertNotNull(student, "Student should not be null");
        assertEquals("John Doe", student.getName(), "Student name should be 'John Doe'");
        assertEquals(85.0, student.getScore(), 0.01, "Student score should be 85.0");
    }

    @Test
    void testAddDuplicateStudent() {
        studentList.addNewStudent("123", "John Doe");
        studentList.addNewStudent("123", "Jane Doe");
        Student student = studentList.findStudentById("123");
        assertNotNull(student, "Student should not be null");
        assertEquals("John Doe", student.getName(), "Student name should remain 'John Doe'");
    }

    @Test
     void testGiveScoreToId() {
        studentList.addNewStudent("123", "John Doe");
        studentList.giveScoreToId("123", 90.0);
        Student student = studentList.findStudentById("123");
        assertNotNull(student, "Student should not be null");
        assertEquals(90.0, student.getScore(), 0.01, "Student score should be 90.0");
    }

    @Test
     void testViewGradeOfId() {
        studentList.addNewStudent("123", "John Doe", 85.0);
        String grade = studentList.viewGradeOfId("123");
        assertNotNull(grade, "Grade should not be null");
        assertEquals("A", grade, "Grade should be 'B'");
    }

    @Test
     void testFindStudentById() {
        studentList.addNewStudent("123", "John Doe");
        Student student = studentList.findStudentById("123");
        assertNotNull(student, "Student should not be null");
        assertEquals("John Doe", student.getName(), "Student name should be 'John Doe'");
    }

    @Test
     void testGetStudents() {
        studentList.addNewStudent("123", "John Doe");
        studentList.addNewStudent("456", "Jane Doe");
        assertEquals(2, studentList.getStudents().size(), "Student list size should be 2");
    }
}
