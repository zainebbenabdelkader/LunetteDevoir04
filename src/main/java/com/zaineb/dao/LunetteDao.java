package com.zaineb.dao; 
 
import java.util.List; 
import javax.persistence.EntityManager; 
import javax.persistence.EntityTransaction; 
import com.zaineb.entities.Lunette; 
import com.zaineb.util.JPAutil; 
//classe contenant les méthodes génériques ajouter, supprimer, 
//consulter par clé primaire (Id) 
public class LunetteDao { 
    private EntityManager entityManager = JPAutil.getEntityManager("LunetteDevoir04"); 

    // méthode ajouter d'une entité à la bd 
    public void ajouter(Lunette l) { 
        EntityTransaction tx = entityManager.getTransaction(); 
        tx.begin(); 
        entityManager.persist(l); 
        tx.commit(); 
    } 

    // méthode modifier d'une entité à partir de la bd 
    public void modifier(Lunette l) { 
        EntityTransaction tx = entityManager.getTransaction(); 
        tx.begin(); 
        entityManager.merge(l); 
        tx.commit(); 
    } 

    // méthode Supprimer d'une entité à partir de la bd 
    public void supprimer(Lunette l) {  
        EntityTransaction tx = entityManager.getTransaction(); 
        tx.begin(); 
        l = entityManager.merge(l); // important 
        entityManager.remove(l); 
        tx.commit();   
    } 

    // méthode Consulter d'une entité à partir de la bd 
    public Lunette consulter(Lunette l, Object id) { 
        return entityManager.find(l.getClass(), id); 
    } 

    // méthode pour lister tous les objets à partir de la bd 
    public List<Lunette> listerTous() { 
        List<Lunette> lunettes = 
            entityManager.createQuery("select l from Lunette l").getResultList(); 
        return lunettes; 
    }  

    // méthode pour lister toutes les lunettes dont le nom contient un  
    // texte donné en paramètre (pnom) 
    public List<Lunette> listerParNom(String nom) { 
        List<Lunette> lunettes = entityManager.createQuery("select l from Lunette l where l.nom like :pnom") 
            .setParameter("pnom", "%" + nom + "%").getResultList(); 
        return lunettes;  
    }  
}
