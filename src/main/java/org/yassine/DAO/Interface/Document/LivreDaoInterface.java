package org.yassine.DAO.Interface.Document;

import org.yassine.model.Livre;

import java.util.List;

public interface LivreDaoInterface {

    void createLivre(Livre livre);

    void updateLivre(Integer id ,Livre livre);

    void deleteLivre(Integer livreId);

    Livre displayLivre(Integer livreId);

    List<Livre> displayAllLivres();

    List<Livre> searchLivre(String titre);

}
