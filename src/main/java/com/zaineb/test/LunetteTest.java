package com.zaineb.test; 
import com.zaineb.dao.LunetteDao; 
import com.zaineb.entities.Lunette; 

public class LunetteTest { 
    public static void main(String[] args) { 
        // créer un objet lunette 
        Lunette l = new Lunette(); 
        l.setNom("Gucci"); 
        l.setPrix("150"); 

        // ajouter l'objet lunette à la BD 
        LunetteDao lunetteDao = new LunetteDao(); 
        lunetteDao.ajouter(l);    

        System.out.println("Appel de la méthode listerTous"); 
        for (Lunette lu : lunetteDao.listerTous()) 
            System.out.println(lu.getCode() + " " + lu.getNom()); 

        System.out.println("Appel de la méthode listerParNom"); 
        for (Lunette lu : lunetteDao.listerParNom("gucci")) 
            System.out.println(lu.getCode() + " " + lu.getNom()); 

        // Modifier l'objet lunette 
        l.setNom("Updated Name"); 
        l.setPrix("200"); 
        lunetteDao.modifier(l); 
        System.out.println("Lunette modifiée"); 

        // Supprimer l'objet lunette 
        lunetteDao.supprimer(l); 
        System.out.println("Lunette supprimée"); 
    } 
}
