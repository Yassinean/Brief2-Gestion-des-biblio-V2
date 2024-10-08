package org.yassine.service.Implementation;
import org.yassine.model.Abstract.Utilisateur;
import org.yassine.model.JournalScientifique;
import org.yassine.model.Livre;
import org.yassine.model.Magazine;
import org.yassine.model.TheseUniversitaire;
import org.yassine.DAO.Implementation.ReservableImp;
import org.yassine.service.Interface.ReservableService;

public class ReservableServiceImp implements ReservableService {

    private ReservableImp reservableImp;

    public ReservableServiceImp() {
        this.reservableImp = new ReservableImp();
    }

    @Override
    public void reserveLivre(Livre livre, Utilisateur utilisateur) {
        reservableImp.reserveLivre(livre, utilisateur);
    }

    @Override
    public void reserveMagazine(Magazine magazine, Utilisateur utilisateur) {
        reservableImp.reserveMagazine(magazine, utilisateur);
    }

    @Override
    public void reserveThese(TheseUniversitaire theseUniversitaire, Utilisateur utilisateur) {
        reservableImp.reserveThese(theseUniversitaire, utilisateur);
    }

    @Override
    public void reserveJournal(JournalScientifique journalScientifique, Utilisateur utilisateur) {
        reservableImp.reserveJournal(journalScientifique, utilisateur);
    }

    @Override
    public void annuleReserveLivre(Livre livre, Utilisateur utilisateur) {
        reservableImp.annuleReserveLivre(livre, utilisateur);
    }

    @Override
    public void annuleReserveMagazine(Magazine magazine, Utilisateur utilisateur) {
        reservableImp.annuleReserveMagazine(magazine, utilisateur);
    }

    @Override
    public void annuleReserveThese(TheseUniversitaire theseUniversitaire, Utilisateur utilisateur) {
        reservableImp.annuleReserveThese(theseUniversitaire, utilisateur);
    }

    @Override
    public void annuleReserveJournal(JournalScientifique journalScientifique, Utilisateur utilisateur) {
        reservableImp.annuleReserveJournal(journalScientifique, utilisateur);
    }
}