package org.yassine.DAO.Interface.Document;

import org.yassine.model.Magazine;

import java.util.List;

public interface MagazineDaoInterface {

    void createMagazine(Magazine magazine);

    void updateMagazine(Integer id,Magazine magazine);

    void deleteMagazine(Integer magazineId);

    Magazine displayMagazine(Integer magazineId);

    List<Magazine> displayAllMagazines();

    List<Magazine> searchMagazine(String titre);

}



