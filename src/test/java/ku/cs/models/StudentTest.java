package ku.cs.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void testAddScore() {
        Student s = new Student("610450111", "Chaimongkhon Nakkaew");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());
    }
    @Test
    void testCalculateGrade(){
        Student s = new Student("610450111", "Chaimongkhon Nakkaew");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    void testChangeName(){
        Student s = new Student("610450111", "StudentTest");
        s.changeName("pat");
        assertEquals("pat", s.getName());
    }
    @Test
    void  testIsId(){
        Student s = new Student("610450111", "pat");
        assertFalse(s.isId("6610450111"));



    }
}