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
public class VueCatalogue {
    public void afficher(PrintWriter out ,List<Article> articles){
        out.println("<html>");
        
        out.println("<head>");
            out.println("<Title>Vente Directe");
            out.println("</Title>");
        out.println("</head>");
        
        out.println("<body>");
        
           out.println("<div id='baniere'>");
              out.println("<h1>Vente Directe");
              out.println("</h1>");
           out.println("</div>");

           out.println("<div id='Menu'>");
              out.println("<a href='controleur?action=1'>Catalogue</a>");
              out.println("</h1>");
           out.println("</div>");
           
           out.println("<table border=1>");
           for (Article article : articles) {
              out.println("<tr>");
              out.println("<td><a href='controleur?action=2&id="+article.getReference()+"'>"+ article.getReference()+ "</a></td>");
              out.println("<td>"+ article.getNom()+ "</td>");
              out.println("<td>"+ article.getCategorie()+ "</td>");
              out.println("<td>"+ article.getPrix()+ " €</td>");
              out.println("</tr>");

        }
           out.println("</table>");

        
        out.println("</body>");
        
        out.println("</html>");
    }
}
