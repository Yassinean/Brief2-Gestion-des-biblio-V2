package org.yassine.service.Interface.Utilisateur;


import org.yassine.model.Etudiant;

import java.util.*;

public interface EtudiantService {

    Etudiant getEtudiantById(Integer id);

    List<Etudiant> getEtudiantByName(String name);

    List<Etudiant> getAllEtudiants();

    void createEtudiant(Etudiant etudiant);

    void updateEtudiant(Integer id , Etudiant etudiant);

    void deleteEtudiant(Integer id);
}
