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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author yanis.batatia
 */
@Entity
@Table(name = "ligne_facture")
@NamedQueries({
    @NamedQuery(name = "LigneFacture.findAll", query = "SELECT l FROM LigneFacture l"),
    @NamedQuery(name = "LigneFacture.findByNumLigne", query = "SELECT l FROM LigneFacture l WHERE l.numLigne = :numLigne"),
    @NamedQuery(name = "LigneFacture.findByNumFacture", query = "SELECT l FROM LigneFacture l WHERE l.numFacture = :numFacture"),
    @NamedQuery(name = "LigneFacture.findByRefArticle", query = "SELECT l FROM LigneFacture l WHERE l.refArticle = :refArticle"),
    @NamedQuery(name = "LigneFacture.findByQuantite", query = "SELECT l FROM LigneFacture l WHERE l.quantite = :quantite")})
public class LigneFacture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_ligne")
    private Integer numLigne;
    @Column(name = "num_facture")
    private Integer numFacture;
    @Size(max = 50)
    @Column(name = "ref_article")
    private String refArticle;
    @Column(name = "quantite")
    private Short quantite;

    public LigneFacture() {
    }

    public LigneFacture(Integer numLigne) {
        this.numLigne = numLigne;
    }

    public Integer getNumLigne() {
        return numLigne;
    }

    public void setNumLigne(Integer numLigne) {
        this.numLigne = numLigne;
    }

    public Integer getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(Integer numFacture) {
        this.numFacture = numFacture;
    }

    public String getRefArticle() {
        return refArticle;
    }

    public void setRefArticle(String refArticle) {
        this.refArticle = refArticle;
    }

    public Short getQuantite() {
        return quantite;
    }

    public void setQuantite(Short quantite) {
        this.quantite = quantite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numLigne != null ? numLigne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LigneFacture)) {
            return false;
        }
        LigneFacture other = (LigneFacture) object;
        if ((this.numLigne == null && other.numLigne != null) || (this.numLigne != null && !this.numLigne.equals(other.numLigne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.ipst.vente.entities.LigneFacture[ numLigne=" + numLigne + " ]";
    }
    
}
