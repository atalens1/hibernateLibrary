package com.iticbcn.hibernate.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="Authors",uniqueConstraints = {@UniqueConstraint(columnNames = "nomAutor")})
public class Autor implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idAutor;
    @Column
    private String nomAutor;
    @Column
    private String nacionalitat;

    @OneToMany(mappedBy="Autor",cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
    private Set<LLibres> llibres;

    public Autor() {}

    public Autor(String nomAutor, String nacionalitat) {
        this.nomAutor = nomAutor;
        this.nacionalitat = nacionalitat;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNomAutor() {
        return nomAutor;
    }

    public void setNomAutor(String nomAutor) {
        this.nomAutor = nomAutor;
    }

    public String getNacionalitat() {
        return nacionalitat;
    }

    public void setNacionalitat(String nacionalitat) {
        this.nacionalitat = nacionalitat;
    }

    public Set<LLibres> getLLibres() {
        return llibres;
    }

    public void setLLibres(Set<LLibres> llibres) {
        this.llibres = llibres;
    }

    

    

    
}

