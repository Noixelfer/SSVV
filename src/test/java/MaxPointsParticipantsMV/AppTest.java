package MaxPointsParticipantsMV;

import Domain.Student;
import Repository.NoteRepo;
import Repository.StudentRepo;
import Repository.TemeRepo;
import Service.ServiceNote;
import Service.ServiceStudent;
import Service.ServiceTeme;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemeValidator;
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
    @Test
    public void addValidAssignment() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), studentsPath);
            TemeRepo repo = new TemeRepo(new TemeValidator(), temePath);
            NoteRepo r = new NoteRepo(new NotaValidator());
            ServiceStudent srv = new ServiceStudent(rep);
            ServiceTeme serv = new ServiceTeme(repo);
            ServiceNote sv = new ServiceNote(r);
            UI.UI ui = new UI.UI(srv, serv, sv);
            ui.addAssignment(1, "Do black box testing", 2, 3);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void addInvalidAssignment() {
        try {
            StudentRepo rep=new StudentRepo(new StudentValidator(), studentsPath);
            TemeRepo repo=new TemeRepo(new TemeValidator(),temePath);
            NoteRepo r=new NoteRepo(new NotaValidator());
            ServiceStudent srv=new ServiceStudent(rep);
            ServiceTeme serv=new ServiceTeme(repo);
            ServiceNote sv=new ServiceNote(r);
            UI.UI ui=new UI.UI(srv,serv,sv);
            ui.addAssignment(1, "WhiteBox", 3, 1);
            assertTrue(false);
        } catch (Error e) {
            assertTrue(true);
        }
    }

    @Test
    public void addInvalidAssignmentNoDesc() {
        try {
            StudentRepo rep=new StudentRepo(new StudentValidator(), studentsPath);
            TemeRepo repo=new TemeRepo(new TemeValidator(),temePath);
            NoteRepo r=new NoteRepo(new NotaValidator());
            ServiceStudent srv=new ServiceStudent(rep);
            ServiceTeme serv=new ServiceTeme(repo);
            ServiceNote sv=new ServiceNote(r);
            UI.UI ui=new UI.UI(srv,serv,sv);
            ui.addAssignment(1, "", 3, 4);
            assertTrue(false);
        } catch (Error e) {
            assertTrue(true);
        }
    }

    @Test
    public void addInvalidAssignmentWrongNr() {
        try {
            StudentRepo rep=new StudentRepo(new StudentValidator(), studentsPath);
            TemeRepo repo=new TemeRepo(new TemeValidator(),temePath);
            NoteRepo r=new NoteRepo(new NotaValidator());
            ServiceStudent srv=new ServiceStudent(rep);
            ServiceTeme serv=new ServiceTeme(repo);
            ServiceNote sv=new ServiceNote(r);
            UI.UI ui=new UI.UI(srv,serv,sv);
            ui.addAssignment(-1, "WhiteBox", 3, 1);
            assertTrue(false);
        } catch (Error e) {
            assertTrue(true);
        }
    }

    @Test
    public void addInvalidAssignmentWrongSapt() {
        try {
            StudentRepo rep=new StudentRepo(new StudentValidator(), studentsPath);
            TemeRepo repo=new TemeRepo(new TemeValidator(),temePath);
            NoteRepo r=new NoteRepo(new NotaValidator());
            ServiceStudent srv=new ServiceStudent(rep);
            ServiceTeme serv=new ServiceTeme(repo);
            ServiceNote sv=new ServiceNote(r);
            UI.UI ui=new UI.UI(srv,serv,sv);
            ui.addAssignment(1, "WhiteBox", -1, 1);
            assertTrue(false);
        } catch (Error e) {
            assertTrue(true);
        }
    }
    @Test
    public void addInvalidAssignmentWrongDue() {
        try {
            StudentRepo rep=new StudentRepo(new StudentValidator(), studentsPath);
            TemeRepo repo=new TemeRepo(new TemeValidator(),temePath);
            NoteRepo r=new NoteRepo(new NotaValidator());
            ServiceStudent srv=new ServiceStudent(rep);
            ServiceTeme serv=new ServiceTeme(repo);
            ServiceNote sv=new ServiceNote(r);
            UI.UI ui=new UI.UI(srv,serv,sv);
            ui.addAssignment(1, "WhiteBox", 3, -1);
            assertTrue(false);
        } catch (Error e) {
            assertTrue(true);
        }
    }
}
