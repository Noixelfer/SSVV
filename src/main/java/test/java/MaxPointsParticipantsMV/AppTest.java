package test.java.MaxPointsParticipantsMV;

import static org.junit.Assert.assertTrue;

import Domain.Student;
import Repository.StudentRepo;
import Repository.TemeRepo;
import Validator.StudentValidator;
import Validator.TemeValidator;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void addStudentSuccessfully()
    {
        StudentRepo rep = new StudentRepo(new StudentValidator(), "E:\\AndroidProjects\\SSVV\\LabAssiAsseProjectV04\\src\\studenti.xml");
        Student paul = new Student("10", "Paul", 936, "paul.pop@yahoo.com", "Profesor X");
        float size = rep.size();
        rep.save(paul);
        assert(rep.size() == size+ 1);
    }
}
