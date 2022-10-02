package tn.esprit.projectclass.controllers.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.services.Etudiant.IntServiceC;

@RestController
@RequestMapping(value = "/student")
public class EtudiantController {

    @Autowired
    private IntServiceC etudiantservice;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Etudiant save(@RequestBody Etudiant etudiant) throws Exception {
        Etudiant studentResponse = (Etudiant) etudiantservice.save(etudiant);
        return studentResponse;
    }

 /*   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudent(@PathVariable int id) {
        Student studentResponse = (Student) studentService.getStudent(id);
        return studentResponse;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "student has been deleted successfully";
    }*/

}
