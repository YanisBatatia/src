/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ipst.vente.vues;

import fr.ipst.vente.entities.Article;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author yanis.batatia
 */
public class VueDetails {
    public void afficher(PrintWriter out ,Article article){
        out.println("<html>");
        
        out.println("<head>");
            out.println("<Title>Vente Directe");
            out.println("</Title>");
        out.println("</head>");
        
        out.println("<body>");
        
out.println("<H1>CATALOGUE</H1>");
        out.println("<TABLE border='0'>");
            out.println("<TR>");
                out.println("<TD> Référence</TD>");
                out.println("<TD>"  + article.getReference() + "</TD>");
            out.println("</TR>");
            out.println("<TR>");
                out.println("<TD> Nom</TD>");
                out.println("<TD>"  + article.getNom() + "</TD>");
            out.println("</TR>");
            out.println("<TR>");
                out.println("<TD> Catégorie</TD>");
                out.println("<TD>"  + article.getCategorie() + "</TD>");
            out.println("</TR>");
            out.println("<TR>");
                out.println("<TD> Prix</TD>");
                out.println("<TD>"  + article.getPrix() + "</TD>");
            out.println("</TR>");
            out.println("<TR>");
                out.println("<TD> TVA</TD>");
                out.println("<TD>"  + article.getTva() + "</TD>");
            out.println("</TR><BR>");
            
            out.println("<TR>");
                out.println("<FORM action='controleur'>");
                out.println("<TD> Quantité </TD>");
                out.println("<TD> ");
                out.println("<INPUT TYPE ='HIDDEN' NAME='action' value='3'>");
                out.println("<INPUT TYPE ='HIDDEN' NAME='ref' value='"+article.getReference()+"'>");
                out.println("<INPUT TYPE ='TEXT' NAME='qty' value='1'><BR>");
                out.println("<INPUT TYPE ='SUBMIT' value='ajouter'>");
                out.println("</TD> ");
                
                out.println("</FORM>");
            out.println("</TR>");
        
        out.println("</TABLE >");

        
        out.println("</body>");
        
        out.println("</html>");
    }
}
