package tn.esprit.projectclass.services.Etudiant;

import tn.esprit.projectclass.Generic.ImplementationGeneric;
import tn.esprit.projectclass.Generic.InterfaceGeneric;
import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Option;
public interface InterfaceE extends InterfaceGeneric<Etudiant> {
    Etudiant addAndAssignEtudiant(Etudiant e, Option o, Departement d) throws Exception;

}
