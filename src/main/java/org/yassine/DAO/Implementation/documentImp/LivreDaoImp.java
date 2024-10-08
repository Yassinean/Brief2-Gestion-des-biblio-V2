package org.yassine.DAO.Implementation.documentImp;

import org.yassine.config.DbConfig;
import org.yassine.model.Abstract.DroitAccess;
import org.yassine.model.Livre;
import org.yassine.DAO.Interface.Document.LivreDaoInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivreDaoImp implements LivreDaoInterface {

    private Connection connection;

    public LivreDaoImp() {
        try {
            this.connection = DbConfig.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createLivre(Livre livre) {

        String sql = "INSERT INTO livre (titre, auteur, datePublication, nombredepage, isbn , acces) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, livre.getTitre());
            statement.setString(2, livre.getAuteur());
            statement.setDate(3, Date.valueOf(livre.getDatePublication()));
            statement.setInt(4, livre.getNombreDePages());
            statement.setString(5, livre.getIsbn());
            statement.setString(6, livre.getDroitAcces().name());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateLivre(Integer id ,Livre livre) {

        String sql = "UPDATE livre SET titre = ?, auteur = ?, datePublication = ?, nombredepage = ?, isbn = ? , acces = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, livre.getTitre());
            statement.setString(2, livre.getAuteur());
            statement.setDate(3, Date.valueOf(livre.getDatePublication()));
            statement.setInt(4, livre.getNombreDePages());
            statement.setString(5, livre.getIsbn());
            statement.setString(6, livre.getDroitAcces().name());
            statement.setInt(7, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteLivre(Integer livreId) {
        String sql = "DELETE FROM livre WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setObject(1, livreId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    @Override
    public Livre displayLivre(Integer livreId) {
        String sql = "SELECT * FROM livre WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, livreId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                DroitAccess droitAcces = DroitAccess.valueOf(resultSet.getString("acces"));
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Titre: " + resultSet.getString("titre"));
                System.out.println("Auteur: " + resultSet.getString("auteur"));
                System.out.println("Date de publication: " + resultSet.getString("datePublication"));
                System.out.println("Nombre de pages: " + resultSet.getInt("nombredepage"));
                System.out.println("ISBN: " + resultSet.getString("isbn"));
                System.out.println("Accessibilite pour : " + resultSet.getString("acces"));
                return new Livre(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getDate("datePublication").toLocalDate(),
                        resultSet.getInt("nombredepage"),
                        droitAcces,
                        resultSet.getString("isbn")
                );
            }else System.out.println("Nous n'avons pas ce document en base de donne");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Livre> displayAllLivres() {
        List<Livre> livres = new ArrayList<>();
        String sql = "SELECT * FROM livre";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                DroitAccess droitAcces = DroitAccess.valueOf(resultSet.getString("acces"));
                Livre livre = new Livre(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getDate("datePublication").toLocalDate(),
                        resultSet.getInt("nombredepage"),
                        droitAcces,
                        resultSet.getString("isbn")
                );
                livres.add(livre);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return livres;

    }

    @Override
    public List<Livre> searchLivre(String titre) {
        List<Livre> livres = new ArrayList<>();
        String sql = "SELECT * FROM livre WHERE titre LIKE ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            String searchPattern = "%" + titre + "%";
            statement.setString(1, searchPattern);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DroitAccess droitAcces = DroitAccess.valueOf(resultSet.getString("acces"));
                Livre livre = new Livre(
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getDate("datePublication").toLocalDate(),
                        resultSet.getInt("nombreDePage"),
                        droitAcces,
                        resultSet.getString("isbn")
                );
                livres.add(livre);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return livres;
    }

}