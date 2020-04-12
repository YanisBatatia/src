/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ipst.vente.entities;

import java.util.Objects;

/**
 *
 * @author yanis.batatia
 */
public class LignePanier {

    public LignePanier(String ref) {
        this.article = new Article(ref); 
        this.quantite = 0;
    }

    
    
    public LignePanier(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
    }

    private Article article;

    /**
     * Get the value of article
     *
     * @return the value of article
     */
    public Article getArticle() {
        return article;
    }

    /**
     * Set the value of article
     *
     * @param article new value of article
     */
    public void setArticle(Article article) {
        this.article = article;
    }

    
    private int quantite;

    /**
     * Get the value of quantite
     *
     * @return the value of quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Set the value of quantite
     *
     * @param quantite new value of quantite
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LignePanier other = (LignePanier) obj;
        if (!Objects.equals(this.article, other.article)) {
            return false;
        }
        return true;
    }

    
    
}
