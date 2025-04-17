package src.main;

import src.main.Model.Personne;
import src.main.Repository.PersonneRepository;

import javax.persistence.EntityManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        PersonneRepository personneRepository = new PersonneRepository();
        Personne personne = Personne
                .builder()
                .nom("DIOP")
                .prenom("Moussa")
                .age(18)
                .build();
        personneRepository.add(personne);
        personneRepository.getAll().forEach(p -> System.out.println(p));


    }
}
