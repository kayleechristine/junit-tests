import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void testCreateStudent(){
        Student randoStudent = new Student(1, "randoStudent");
        Student blankStudent = null;
        assertNull(blankStudent);
        assertNotNull(randoStudent);
    }

    @Test
    public void testStudentFields(){
        Student randoStudent = new Student(1, "randoStudent");
        assertSame("randoStudent", randoStudent.getName());
        assertSame(0, randoStudent.getGrades().size());
    }

    @Test
    public void testAddGrade(){
        Student randoStudent = new Student(1, "randoStudent");
        randoStudent.addGrade(100);
        assertSame(100, randoStudent.getGrades().get(0));
        randoStudent.addGrade(80);
        assertSame(80, randoStudent.getGrades().get(1));
    }

    @Test
    public void testAverageGrade(){
        Student randoStudent = new Student(1, "randoStudent");
        randoStudent.addGrade(100);
        randoStudent.addGrade(80);
        assertEquals(90, randoStudent.getGradeAverage(), 0);
    }

}