package com.zaineb.entities; 
 
import java.io.Serializable; 
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id; 
 
@Entity 
public class Lunette implements Serializable { 
 
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    // pour autoincrement  
    private int code; 
    private String nom; 
    private String prix; 
    
    public int getCode() { 
        return code; 
    } 
    
    public void setCode(int code) { 
        this.code = code; 
    } 
    
    public String getNom() { 
        return nom; 
    } 
    
    public void setNom(String nom) { 
        this.nom = nom; 
    } 
    
    public String getPrix() { 
        return prix; 
    } 
    
    public void setPrix(String prix) { 
        this.prix = prix; 
    } 
}
