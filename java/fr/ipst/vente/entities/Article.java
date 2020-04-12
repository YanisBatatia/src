/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ipst.vente.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author yanis.batatia
 */
@Entity
@Table(name = "article")
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findByReference", query = "SELECT a FROM Article a WHERE a.reference = :reference"),
    @NamedQuery(name = "Article.findByCategorie", query = "SELECT a FROM Article a WHERE a.categorie = :categorie"),
    @NamedQuery(name = "Article.findByNom", query = "SELECT a FROM Article a WHERE a.nom = :nom"),
    @NamedQuery(name = "Article.findByFournisseur", query = "SELECT a FROM Article a WHERE a.fournisseur = :fournisseur"),
    @NamedQuery(name = "Article.findByPrix", query = "SELECT a FROM Article a WHERE a.prix = :prix"),
    @NamedQuery(name = "Article.findByTva", query = "SELECT a FROM Article a WHERE a.tva = :tva"),
    @NamedQuery(name = "Article.findByStock", query = "SELECT a FROM Article a WHERE a.stock = :stock"),
    @NamedQuery(name = "Article.findBySeuilCritique", query = "SELECT a FROM Article a WHERE a.seuilCritique = :seuilCritique")})
public class Article implements Serializable, Comparable<Article> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "reference")
    private String reference;
    @Size(max = 15)
    @Column(name = "categorie")
    private String categorie;
    @Size(max = 100)
    @Column(name = "nom")
    private String nom;
    @Column(name = "fournisseur")
    private Integer fournisseur;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prix")
    private Double prix;
    @Column(name = "tva")
    private Double tva;
    @Column(name = "stock")
    private Short stock;
    @Column(name = "seuil_critique")
    private Short seuilCritique;

    public Article() {
    }

    public Article(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Integer fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Double getTva() {
        return tva;
    }

    public void setTva(Double tva) {
        this.tva = tva;
    }

    public Short getStock() {
        return stock;
    }

    public void setStock(Short stock) {
        this.stock = stock;
    }

    public Short getSeuilCritique() {
        return seuilCritique;
    }

    public void setSeuilCritique(Short seuilCritique) {
        this.seuilCritique = seuilCritique;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reference != null ? reference.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.reference == null && other.reference != null) || (this.reference != null && !this.reference.equals(other.reference))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.ipst.vente.entities.Article[ reference=" + reference + " ]";
    }

    @Override
    public int compareTo(Article o) {
        return this.reference.compareTo(o.getReference());
    }
    
}
