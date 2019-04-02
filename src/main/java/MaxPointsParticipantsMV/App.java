package MaxPointsParticipantsMV;

import Repository.NoteRepo;
import Repository.StudentRepo;
import Repository.TemeRepo;
import Service.ServiceNote;
import Service.ServiceStudent;
import Service.ServiceTeme;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemeValidator;
import UI.UI;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        StudentRepo rep = new StudentRepo(new StudentValidator(), "E:\\AndroidProjects\\SSVV\\LabAssiAsseProjectV04\\src\\studenti.xml");
        TemeRepo repo = new TemeRepo(new TemeValidator(), "E:\\AndroidProjects\\SSVV\\LabAssiAsseProjectV04\\src\\teme.xml");
        NoteRepo r = new NoteRepo(new NotaValidator());
        ServiceStudent srv = new ServiceStudent(rep);
        ServiceTeme serv = new ServiceTeme(repo);
        ServiceNote sv = new ServiceNote(r);
        UI ui = new UI(srv, serv, sv);
        ui.show();

    }
}
