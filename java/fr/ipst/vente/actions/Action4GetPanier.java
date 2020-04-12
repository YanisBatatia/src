/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ipst.vente.actions;

import fr.ipst.vente.entities.Panier;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yanis.batatia
 */
public class Action4GetPanier {
    public Panier execute(HttpSession session){
        Panier panier = (Panier) session.getAttribute("Panier");
        return panier;
    }
}
