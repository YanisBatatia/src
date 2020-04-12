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
@Table(name = "fournisseur")
@NamedQueries({
    @NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f"),
    @NamedQuery(name = "Fournisseur.findByNum", query = "SELECT f FROM Fournisseur f WHERE f.num = :num"),
    @NamedQuery(name = "Fournisseur.findBySociete", query = "SELECT f FROM Fournisseur f WHERE f.societe = :societe"),
    @NamedQuery(name = "Fournisseur.findByContact", query = "SELECT f FROM Fournisseur f WHERE f.contact = :contact"),
    @NamedQuery(name = "Fournisseur.findByAdresse", query = "SELECT f FROM Fournisseur f WHERE f.adresse = :adresse"),
    @NamedQuery(name = "Fournisseur.findByCodePostal", query = "SELECT f FROM Fournisseur f WHERE f.codePostal = :codePostal"),
    @NamedQuery(name = "Fournisseur.findByVille", query = "SELECT f FROM Fournisseur f WHERE f.ville = :ville"),
    @NamedQuery(name = "Fournisseur.findByTelephone", query = "SELECT f FROM Fournisseur f WHERE f.telephone = :telephone"),
    @NamedQuery(name = "Fournisseur.findByFax", query = "SELECT f FROM Fournisseur f WHERE f.fax = :fax")})
public class Fournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num")
    private Integer num;
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

    public Fournisseur() {
    }

    public Fournisseur(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (num != null ? num.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.num == null && other.num != null) || (this.num != null && !this.num.equals(other.num))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.ipst.vente.entities.Fournisseur[ num=" + num + " ]";
    }
    
}
