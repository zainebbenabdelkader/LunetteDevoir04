package  com.zaineb.entities; 


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class Lunette implements Serializable {
	
	@Id
	@Column(name = "code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLunette;
	
	@Column(name = "nom")
	private String nomLunette;
	private double prix;

	public Lunette() {
		super();
	}

	public Lunette(String nomLunette, double prix) {
		super();
		this.nomLunette = nomLunette;
		this.prix = prix;
	}

	public Long getIdLunette() {
		return idLunette;
	}

	public void setIdLunette(Long idLunette) {
		this.idLunette = idLunette;
	}

	public String getNomLunette() {
		return nomLunette;
	}

	public void setNomLunette(String nomLunette) {
		this.nomLunette = nomLunette;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Lunette [idLunette=" + idLunette + ", nomLunette=" + nomLunette + ", prix=" + prix + "]";
	}
}
