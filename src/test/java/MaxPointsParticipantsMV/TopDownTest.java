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
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TopDownTest {

    private static String studentsPath = "src\\studenti.xml";
    private static String temePath = "src\\teme.xml";
    @Test
    public void studentAssignment(){
        try{
            test_addStudent();
            addValidAssignment();
        }catch (Error e){
            assertTrue(false);
        }
    }

    @Test
    public void studentAssignmentGrade(){
        try{
            test_addStudent();
            addValidAssignment();
            addValidGrade();
        }catch (Error e){
            assertTrue(false);
        }
    }



    @Test
    public void test_addStudent() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), studentsPath);
            ServiceStudent srv = new ServiceStudent(rep);

            Student std = new Student("87", "Mihai", 936, "mihai97@yahoo.ro", "Prof X");
            srv.add(std);
            assertTrue(true);
        } catch (Error e) {
            assertTrue(false);
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
            ui.addAssignment(1, "Do black box testing", 3, 4);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }


    @Test
    public void addValidGrade() {
        try {
            StudentRepo rep=new StudentRepo(new StudentValidator(),studentsPath);
            TemeRepo repo=new TemeRepo(new TemeValidator(),temePath);
            NoteRepo r=new NoteRepo(new NotaValidator());
            ServiceStudent srv=new ServiceStudent(rep);
            ServiceTeme serv=new ServiceTeme(repo);
            ServiceNote sv=new ServiceNote(r);
            UI.UI ui = new UI.UI(srv, serv, sv);

            ui.addAssignment(1, "Paul ii mic", 3, 5);
            srv.add(new Student("1", "Mihai", 936, "mihai_ii_inalt@paulIiScund.com", "Andreea Vescan"));
            ui.addGrade("2", 1, 10.0f, 4, "un metru si un snitel ii paul (sorry boo)");
            assertTrue(true);

        } catch (Error e) {
            assertTrue(false);
        }
    }
}