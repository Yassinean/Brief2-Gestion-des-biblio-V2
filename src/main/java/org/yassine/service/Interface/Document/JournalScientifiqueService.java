package org.yassine.service.Interface.Document;



import org.yassine.metier.JournalScientifique;

import java.util.List;

public interface JournalScientifiqueService {
    JournalScientifique getJournalScientifiqueById(Integer id);
    List<JournalScientifique> getAllJournalScientifiques();
    void createJournalScientifique(JournalScientifique document);
    void updateJournalScientifique(Integer id , JournalScientifique document);
    void deleteJournalScientifique(Integer id);
}
