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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author yanis.batatia
 */
@Entity
@Table(name = "facture")
@NamedQueries({
    @NamedQuery(name = "Facture.findAll", query = "SELECT f FROM Facture f"),
    @NamedQuery(name = "Facture.findByNumFacture", query = "SELECT f FROM Facture f WHERE f.numFacture = :numFacture"),
    @NamedQuery(name = "Facture.findByDate", query = "SELECT f FROM Facture f WHERE f.date = :date"),
    @NamedQuery(name = "Facture.findByClient", query = "SELECT f FROM Facture f WHERE f.client = :client"),
    @NamedQuery(name = "Facture.findByMontantHT", query = "SELECT f FROM Facture f WHERE f.montantHT = :montantHT"),
    @NamedQuery(name = "Facture.findByMontantTVA", query = "SELECT f FROM Facture f WHERE f.montantTVA = :montantTVA"),
    @NamedQuery(name = "Facture.findByMontantTTC", query = "SELECT f FROM Facture f WHERE f.montantTTC = :montantTTC"),
    @NamedQuery(name = "Facture.findByDateReglement", query = "SELECT f FROM Facture f WHERE f.dateReglement = :dateReglement"),
    @NamedQuery(name = "Facture.findByMontantReglement", query = "SELECT f FROM Facture f WHERE f.montantReglement = :montantReglement"),
    @NamedQuery(name = "Facture.findByTraiteEmise", query = "SELECT f FROM Facture f WHERE f.traiteEmise = :traiteEmise")})
public class Facture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_facture")
    private Integer numFacture;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "client")
    private Integer client;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant_HT")
    private Double montantHT;
    @Column(name = "montant_TVA")
    private Double montantTVA;
    @Column(name = "montant_TTC")
    private Double montantTTC;
    @Column(name = "date_reglement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReglement;
    @Column(name = "montant_reglement")
    private Double montantReglement;
    @Column(name = "traite_emise")
    private Boolean traiteEmise;

    public Facture() {
    }

    public Facture(Integer numFacture) {
        this.numFacture = numFacture;
    }

    public Integer getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(Integer numFacture) {
        this.numFacture = numFacture;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public Double getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(Double montantHT) {
        this.montantHT = montantHT;
    }

    public Double getMontantTVA() {
        return montantTVA;
    }

    public void setMontantTVA(Double montantTVA) {
        this.montantTVA = montantTVA;
    }

    public Double getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(Double montantTTC) {
        this.montantTTC = montantTTC;
    }

    public Date getDateReglement() {
        return dateReglement;
    }

    public void setDateReglement(Date dateReglement) {
        this.dateReglement = dateReglement;
    }

    public Double getMontantReglement() {
        return montantReglement;
    }

    public void setMontantReglement(Double montantReglement) {
        this.montantReglement = montantReglement;
    }

    public Boolean getTraiteEmise() {
        return traiteEmise;
    }

    public void setTraiteEmise(Boolean traiteEmise) {
        this.traiteEmise = traiteEmise;
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
        if (!(object instanceof Facture)) {
            return false;
        }
        Facture other = (Facture) object;
        if ((this.numFacture == null && other.numFacture != null) || (this.numFacture != null && !this.numFacture.equals(other.numFacture))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.ipst.vente.entities.Facture[ numFacture=" + numFacture + " ]";
    }
    
}
