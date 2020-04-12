/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ipst.vente.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author yanis.batatia
 */
@Entity
@Table(name = "encours")
@NamedQueries({
    @NamedQuery(name = "Encours.findAll", query = "SELECT e FROM Encours e"),
    @NamedQuery(name = "Encours.findByNumClient", query = "SELECT e FROM Encours e WHERE e.numClient = :numClient"),
    @NamedQuery(name = "Encours.findByEncours", query = "SELECT e FROM Encours e WHERE e.encours = :encours"),
    @NamedQuery(name = "Encours.findByDerniereCommande", query = "SELECT e FROM Encours e WHERE e.derniereCommande = :derniereCommande")})
public class Encours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_client")
    private Integer numClient;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "encours")
    private Double encours;
    @Column(name = "derniere_commande")
    @Temporal(TemporalType.TIMESTAMP)
    private Date derniereCommande;

    public Encours() {
    }

    public Encours(Integer numClient) {
        this.numClient = numClient;
    }

    public Integer getNumClient() {
        return numClient;
    }

    public void setNumClient(Integer numClient) {
        this.numClient = numClient;
    }

    public Double getEncours() {
        return encours;
    }

    public void setEncours(Double encours) {
        this.encours = encours;
    }

    public Date getDerniereCommande() {
        return derniereCommande;
    }

    public void setDerniereCommande(Date derniereCommande) {
        this.derniereCommande = derniereCommande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numClient != null ? numClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encours)) {
            return false;
        }
        Encours other = (Encours) object;
        if ((this.numClient == null && other.numClient != null) || (this.numClient != null && !this.numClient.equals(other.numClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.ipst.vente.entities.Encours[ numClient=" + numClient + " ]";
    }
    
}
