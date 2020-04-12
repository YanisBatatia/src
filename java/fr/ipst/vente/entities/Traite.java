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

/**
 *
 * @author yanis.batatia
 */
@Entity
@Table(name = "traite")
@NamedQueries({
    @NamedQuery(name = "Traite.findAll", query = "SELECT t FROM Traite t"),
    @NamedQuery(name = "Traite.findByNumFacture", query = "SELECT t FROM Traite t WHERE t.numFacture = :numFacture")})
public class Traite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_facture")
    private Integer numFacture;

    public Traite() {
    }

    public Traite(Integer numFacture) {
        this.numFacture = numFacture;
    }

    public Integer getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(Integer numFacture) {
        this.numFacture = numFacture;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numFacture != null ? numFacture.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Traite)) {
            return false;
        }
        Traite other = (Traite) object;
        if ((this.numFacture == null && other.numFacture != null) || (this.numFacture != null && !this.numFacture.equals(other.numFacture))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.ipst.vente.entities.Traite[ numFacture=" + numFacture + " ]";
    }
    
}
