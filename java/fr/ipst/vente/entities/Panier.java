/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ipst.vente.entities;

import java.util.HashSet;

/**
 *
 * @author yanis.batatia
 */
public class Panier extends HashSet<LignePanier>{

    @Override
    public boolean add(LignePanier lignePanierToAdd) {
        for(LignePanier lignepanier : this){
            if (lignePanierToAdd.equals(lignepanier)) {
                lignepanier.setQuantite(lignepanier.getQuantite() + lignePanierToAdd.getQuantite());
                return false;
            }
        }
        return super.add(lignePanierToAdd); //To change body of generated methods, choose Tools | Templates.
    }
 
    
    
}
