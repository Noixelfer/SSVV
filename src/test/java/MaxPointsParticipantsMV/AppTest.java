package MaxPointsParticipantsMV;

import Domain.Student;
import Repository.StudentRepo;
import Service.ServiceStudent;
import Validator.StudentValidator;
import org.junit.Assert;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * Unit test for simple App.
 */
public class AppTest
{
    private static String studentsPath = "src\\studenti.xml";
    private static String temePath = "src\\teme.xml";
    /**
     * Rigorous Test :-)
     */

    @Test
    public void addStudentSuccessfully()
    {
        StudentRepo rep = new StudentRepo(new StudentValidator(), studentsPath);
        Student paul = new Student("10", "Paul", 936, "paul.pop@yahoo.com", "Profesor X");
        float size = rep.size();
        rep.save(paul);
        assert(rep.size() == size+ 1);
    }

    @Test
    public void addStudentWithInvalidEmail() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), studentsPath);
            ServiceStudent srv = new ServiceStudent(rep);
            Student std = new Student("78", "Sergiu", 936, "e-mail", "Prof X");
            srv.add(std);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }    }

    @Test
    public void addStudentWithNullEmail() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), studentsPath);
            ServiceStudent srv = new ServiceStudent(rep);
            Student std = new Student("78", "Sergiu", 936, null, "Prof X");
            srv.add(std);
            Assert.assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }       }

    @Test
    public void addStudentWithInvalidGroup() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), studentsPath);
            ServiceStudent srv = new ServiceStudent(rep);
            Student std = new Student("78", "Sergiu", 189, "jojo@ghdd.com", "Prof X");
            srv.add(std);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }      }

    @Test
    public void addStudentWithNullName() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), studentsPath);
            ServiceStudent srv = new ServiceStudent(rep);
            Student std = new Student("78", null, 933, "jojo@ghdd.com", "Prof X");
            srv.add(std);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }        }

    @Test
    public void addStudentWithNullProfessor() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), studentsPath);
            ServiceStudent srv = new ServiceStudent(rep);
            Student std = new Student("78", "Sergiu", 933, "jojo@ghdd.com", null);
            srv.add(std);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void addStudentWithInvalidProfessor() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), studentsPath);
            ServiceStudent srv = new ServiceStudent(rep);
            Student std = new Student("78", "Sergiu", 935, "jojo@ghdd.com", "Prof 66X");
            srv.add(std);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void addStudentWithInvalidID() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), studentsPath);
            ServiceStudent srv = new ServiceStudent(rep);
            Student std = new Student("7j8", "Sergiu", 934, "jojo@ghdd.com", "Prof X");
            srv.add(std);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
