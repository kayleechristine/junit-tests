import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CohortTest {

    Cohort emptyCohort;
    Cohort cohortWithOne;
    Cohort cohortWithMany;

    @Before
    public void setup() {
        emptyCohort = new Cohort();
        cohortWithOne = new Cohort();
        cohortWithMany = new Cohort();

        Student averageJoe = new Student(1, "Joe Schmoe");
        averageJoe.addGrade(75);

        Student overAchiever = new Student(2, "Mary Sue");
        overAchiever.addGrade(100);
        overAchiever.addGrade(100);
        overAchiever.addGrade(100);

        cohortWithOne.addStudent(averageJoe);
        cohortWithMany.addStudent(averageJoe);
        cohortWithMany.addStudent(overAchiever);
    }

    @Test
    public void testAddStudent() {
        cohortWithMany.addStudent(new Student(3, "Joshua Mullins"));
        assertEquals("Joshua Mullins", cohortWithMany.getStudents().get(2).getName());
        cohortWithMany.addStudent(new Student(4, "Kaylee Morris"));
        assertEquals(4, cohortWithMany.getStudents().size());
    }

    @Test
    public void testStudents() {
        assertEquals(0, emptyCohort.getStudents().size());
        assertEquals(1, cohortWithOne.getStudents().size());
        assertEquals(1, cohortWithMany.getStudents().get(0).getId());
        assertEquals(2, cohortWithMany.getStudents().get(1).getId());
    }

    @Test
    public void testGradeAverages() {
        assertEquals(Double.NaN, emptyCohort.getCohortAverage(), 0);
        assertEquals(75.0, cohortWithOne.getCohortAverage(), 0);
        assertEquals(87.5, cohortWithMany.getCohortAverage(), 0);
    }

}