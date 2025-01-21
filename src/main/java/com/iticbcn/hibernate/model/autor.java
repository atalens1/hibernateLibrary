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
public class autor implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idAutor;
    @Column
    private String nomAutor;
    @Column
    private String nacionalitat;

    @OneToMany(mappedBy="autor",cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
    private Set<llibres> llibres;

    public autor() {}

    public autor(String nomAutor, String nacionalitat) {
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

    public Set<llibres> getLlibres() {
        return llibres;
    }

    public void setLlibres(Set<llibres> llibres) {
        this.llibres = llibres;
    }

    

    

    
}

