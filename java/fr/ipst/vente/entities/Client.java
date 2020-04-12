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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author yanis.batatia
 */
@Entity
@Table(name = "client")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByNumClient", query = "SELECT c FROM Client c WHERE c.numClient = :numClient"),
    @NamedQuery(name = "Client.findBySociete", query = "SELECT c FROM Client c WHERE c.societe = :societe"),
    @NamedQuery(name = "Client.findByContact", query = "SELECT c FROM Client c WHERE c.contact = :contact"),
    @NamedQuery(name = "Client.findByAdresse", query = "SELECT c FROM Client c WHERE c.adresse = :adresse"),
    @NamedQuery(name = "Client.findByCodePostal", query = "SELECT c FROM Client c WHERE c.codePostal = :codePostal"),
    @NamedQuery(name = "Client.findByVille", query = "SELECT c FROM Client c WHERE c.ville = :ville"),
    @NamedQuery(name = "Client.findByTelephone", query = "SELECT c FROM Client c WHERE c.telephone = :telephone"),
    @NamedQuery(name = "Client.findByFax", query = "SELECT c FROM Client c WHERE c.fax = :fax"),
    @NamedQuery(name = "Client.findByConfirmation", query = "SELECT c FROM Client c WHERE c.confirmation = :confirmation"),
    @NamedQuery(name = "Client.findByPaiement", query = "SELECT c FROM Client c WHERE c.paiement = :paiement"),
    @NamedQuery(name = "Client.findByEncoursMaximal", query = "SELECT c FROM Client c WHERE c.encoursMaximal = :encoursMaximal")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_client")
    private Integer numClient;
    @Size(max = 60)
    @Column(name = "societe")
    private String societe;
    @Size(max = 30)
    @Column(name = "contact")
    private String contact;
    @Size(max = 40)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 5)
    @Column(name = "code_postal")
    private String codePostal;
    @Size(max = 30)
    @Column(name = "ville")
    private String ville;
    @Size(max = 15)
    @Column(name = "telephone")
    private String telephone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "fax")
    private String fax;
    @Column(name = "confirmation")
    private Boolean confirmation;
    @Size(max = 18)
    @Column(name = "paiement")
    private String paiement;
    @Lob
    @Size(max = 16777215)
    @Column(name = "Informations")
    private String informations;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "encours_maximal")
    private Double encoursMaximal;

    public Client() {
    }

    public Client(Integer numClient) {
        this.numClient = numClient;
    }

    public Integer getNumClient() {
        return numClient;
    }

    public void setNumClient(Integer numClient) {
        this.numClient = numClient;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }

    public String getPaiement() {
        return paiement;
    }

    public void setPaiement(String paiement) {
        this.paiement = paiement;
    }

    public String getInformations() {
        return informations;
    }

    public void setInformations(String informations) {
        this.informations = informations;
    }

    public Double getEncoursMaximal() {
        return encoursMaximal;
    }

    public void setEncoursMaximal(Double encoursMaximal) {
        this.encoursMaximal = encoursMaximal;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.numClient == null && other.numClient != null) || (this.numClient != null && !this.numClient.equals(other.numClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.ipst.vente.entities.Client[ numClient=" + numClient + " ]";
    }
    
}
