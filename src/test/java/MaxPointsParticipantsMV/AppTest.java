package MaxPointsParticipantsMV;

import Domain.Student;
import Repository.StudentRepo;
import Validator.StudentValidator;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void addStudentSuccessfully()
    {
        StudentRepo rep = new StudentRepo(new StudentValidator(), "src\\\\studenti.xml");
        Student paul = new Student("10", "Paul", 936, "paul.pop@yahoo.com", "Profesor X");
        float size = rep.size();
        rep.save(paul);
        assert(rep.size() == size+ 1);
    }
}
