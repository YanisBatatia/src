/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ipst.vente.actions;


import fr.ipst.vente.entities.LignePanier;
import fr.ipst.vente.entities.Panier;
import java.util.Iterator;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yanis.batatia
 */
public class Action5ChangerQty {
    public Panier execute(int qty, String ref,HttpSession session){
                
        
        Panier panier = (Panier) session.getAttribute("Panier");

        for (Iterator<LignePanier> iterator = panier.iterator(); iterator.hasNext();) {
            LignePanier next = iterator.next();
            if (next.getArticle().getReference().equals(ref)) {
                next.setQuantite(qty);
            } 
        }
        return panier;
    }
}
