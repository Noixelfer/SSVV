package g936;

import g936.Repository.NoteRepo;
import g936.Repository.StudentRepo;
import g936.Repository.TemeRepo;
import g936.Service.ServiceNote;
import g936.Service.ServiceStudent;
import g936.Service.ServiceTeme;
import g936.UI.UI;
import g936.Validator.NotaValidator;
import g936.Validator.StudentValidator;
import g936.Validator.TemeValidator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        StudentRepo rep=new StudentRepo(new StudentValidator(),"C:\\Temp\\studenti.xml");
        TemeRepo repo=new TemeRepo(new TemeValidator(),"C:\\Temp\\teme.xml");
        NoteRepo r=new NoteRepo(new NotaValidator());
        ServiceStudent srv=new ServiceStudent(rep);
        ServiceTeme serv=new ServiceTeme(repo);
        ServiceNote sv=new ServiceNote(r);
        UI ui=new UI(srv,serv,sv);
        ui.show();

    }
}
