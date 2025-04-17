package src.main.Repository;

import src.main.JPAUtil;
import src.main.Model.Personne;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonneRepository {
    private EntityManager db;
    public PersonneRepository() {
        db = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager(); ;
    }

    public List<Personne> getAll() throws SQLException {
        List<Personne> list = new ArrayList<>();
        db.getTransaction().begin();
        List<Personne> resultat = db.createQuery("FROM Personne",Personne.class).getResultList();
        db.getTransaction().commit();
        for (Personne p : resultat) {
            Personne personne = new Personne();
            personne.setId(p.getId());
            personne.setAge(p.getAge());
            personne.setNom(p.getNom());
            personne.setPrenom(p.getPrenom());

            list.add(personne);
        }

        return  list;
    }
    public void add(Personne personne) throws SQLException {
        db.getTransaction().begin();
        db.persist(personne);
        db.getTransaction().commit();
    }
    public void update(Personne personne) throws SQLException {
        db.getTransaction().begin();
        Personne personneORM = getById(personne.getId());
        personneORM.setNom(personne.getNom());
        personneORM.setPrenom(personne.getPrenom());
        personneORM.setAge(personne.getAge());
        db.getTransaction().commit();
    }


    public void delete(int id) throws SQLException {

        db.getTransaction().begin();
        Personne personne = this.getById(id);
        db.remove(personne);
        db.getTransaction().commit();

    }

    public Personne getById(int id) {

           Personne personne =  db.find(Personne.class,id);

        return personne;
    }

    public List<Personne> getSearch(String data) throws SQLException {
        List<Personne> list = new ArrayList<>();
        db.getTransaction().begin();
        List<Personne> resultat = db.createQuery("FROM Personne p where p.nom LIKE '%"+data+"%'",Personne.class).getResultList();
        db.getTransaction().commit();
        for (Personne p : resultat) {
            Personne personne = new Personne();
            personne.setId(p.getId());
            personne.setAge(p.getAge());
            personne.setNom(p.getNom());
            personne.setPrenom(p.getPrenom());

            list.add(personne);
        }
        return  list;
    }

}
