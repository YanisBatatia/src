/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ipst.vente.actions;

import fr.ipst.vente.dao.ArticleJpaController;
import fr.ipst.vente.dao.BDFactory;
import fr.ipst.vente.entities.Article;
import fr.ipst.vente.entities.LignePanier;
import fr.ipst.vente.entities.Panier;
import java.util.Iterator;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yanis.batatia
 */
public class Action3AjoutPanier {

    public Panier execute(String ref, int qty, HttpSession session) {

        EntityManagerFactory emf = BDFactory.getInstance().getEMF();
        ArticleJpaController dao = new ArticleJpaController(emf);
        Panier panier = (Panier) session.getAttribute("Panier");

        if (panier == null) {
            panier = new Panier();
            session.setAttribute("Panier", panier);
        } 
            
        
        Article article = dao.findArticle(ref);

        LignePanier newLinePanier = new LignePanier(article, qty);

        panier.add(newLinePanier);
        return panier;
    }
}