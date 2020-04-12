/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ipst.vente.vues;

import fr.ipst.vente.entities.Article;
import fr.ipst.vente.entities.LignePanier;
import fr.ipst.vente.entities.Panier;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author yanis.batatia
 */
public class VuePanier {

    public void afficher(PrintWriter out, Panier panier) {
        out.println("<html>");

        out.println("<head>");
        out.println("<Title>Vente Directe");
        out.println("</Title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<div id='baniere'>");
        out.println("<h1>Panier</h1>");
        out.println("</div>");

        out.println("<div id='Menu'>");
        out.println("<a href='/Td52-Vente-catalogue'>Retour</a>");
        out.println("</h1>");
        out.println("</div> </br>");

        out.println("<table border=1>");
        out.println("<tr>");
        out.println("<th>Nom</th>");
        out.println("<th>Categorie</th>");
        out.println("<th>Quantité</th>");
        out.println("</tr>");

        for (LignePanier lignePanier : panier) {
            out.println("<tr>");
            out.println("<td>" + lignePanier.getArticle().getNom() + "</td>");
            out.println("<td>" + lignePanier.getArticle().getCategorie() + "</td>");
            out.println("<FORM action='controleur'>");
                out.println("<TD> ");
                    out.println("<INPUT TYPE ='HIDDEN' NAME='action' value='5'>");
                    out.println("<INPUT TYPE ='HIDDEN' NAME='ref' value='" + lignePanier.getArticle().getReference() + "'>");
                    out.println("<INPUT TYPE ='TEXT' NAME='qty' value='" + lignePanier.getQuantite() + "' min='1'>");
                    out.println("<INPUT TYPE ='SUBMIT' value='Changer Quantité'>");
                out.println("</TD> ");
            out.println("</FORM>");
            out.println("<td><a href='controleur?action=6&ref=" + lignePanier.getArticle().getReference() + "'>Supprimer</a></td>");
            out.println("</tr>");
        }
        out.println("</table><br><br>");

        out.println("<FORM action='controleur'>");
        out.println("<INPUT TYPE ='HIDDEN' NAME='action' value='7'>");
        out.println("<INPUT TYPE ='SUBMIT' value='Vider le panier'>");
        out.println("</TD> ");

        out.println("</FORM>");
        out.println("</body>");
        out.println("</html>");
    }
}
