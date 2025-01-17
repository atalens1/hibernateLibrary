package com.iticbcn.hibernate.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Books")
public class llibres implements Serializable{
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private int idLlibre;
   @Column
   private String Title;
   @Column
   private int NumEdicio;
   @ManyToOne(cascade=CascadeType.PERSIST)
   @JoinColumn(name="idAutor",foreignKey = @ForeignKey(name="FK_LIB_AUT"),nullable = false)
      private autor autor;

    public llibres() {}

    public llibres(String title, int numEdicio, com.iticbcn.hibernate.model.autor autor) {
        Title = title;
        NumEdicio = numEdicio;
        this.autor = autor;
    }

    public int getIdLlibre() {
        return idLlibre;
    }

    public void setIdLlibre(int idLlibre) {
        this.idLlibre = idLlibre;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getNumEdicio() {
        return NumEdicio;
    }

    public void setNumEdicio(int numEdicio) {
        NumEdicio = numEdicio;
    }

    public autor getAutor() {
        return autor;
    }

    public void setAutor(autor autor) {
        this.autor = autor;
    }

}
