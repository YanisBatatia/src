/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ipst.vente.controleurs;

import fr.ipst.vente.actions.Action1Catalogue;
import fr.ipst.vente.actions.Action2Detail;
import fr.ipst.vente.actions.Action3AjoutPanier;
import fr.ipst.vente.actions.Action4GetPanier;
import fr.ipst.vente.actions.Action5ChangerQty;
import fr.ipst.vente.actions.Action6SuprPanier;
import fr.ipst.vente.actions.Action7ViderPanier;
import fr.ipst.vente.entities.Article;
import fr.ipst.vente.entities.Panier;
import fr.ipst.vente.vues.VueCatalogue;
import fr.ipst.vente.vues.VueDetails;
import fr.ipst.vente.vues.VuePanier;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yanis.batatia
 */
@WebServlet(name = "ControleurVente", urlPatterns = {"/controleur"})
public class ControleurVente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            HttpSession session = request.getSession();
            String choix = request.getParameter("action");
            switch(choix){
                case "1":{
                    Action1Catalogue action1 = new Action1Catalogue();
                    List<Article> articles = action1.execute();
                    VueCatalogue vue = new VueCatalogue();
                    vue.afficher(out, articles);

                }
                break;
                case "2":{
                    Action2Detail action2 = new Action2Detail();
                    Article article = action2.execute(request.getParameter("id"));
                    VueDetails vue = new VueDetails();
                    vue.afficher(out, article);
                }
                break;
                case "3":{ 
                    String ref = request.getParameter("ref");
                    int qty = Integer.parseInt(request.getParameter("qty"));
                    Action3AjoutPanier action3 = new Action3AjoutPanier();
                    Panier panier = action3.execute(ref, qty, session); 
                    VuePanier vue = new VuePanier();
                    vue.afficher(out, panier);
                }
                break;
                case "4":{
                    Action4GetPanier action4 = new Action4GetPanier();
                    Panier panier = action4.execute(session);
                    VuePanier vue = new VuePanier();
                    vue.afficher(out, panier);
                } 
                break;
                case "5":{ 
                    String ref = request.getParameter("ref");
                    int qty = Integer.parseInt(request.getParameter("qty"));
                    Action5ChangerQty action5 = new Action5ChangerQty();
                    Panier panier = action5.execute(qty,ref,session); 
                    VuePanier vue = new VuePanier();
                    vue.afficher(out, panier);
                } 
                break;
                case "6":{ 
                    String ref = request.getParameter("ref");
                    Action6SuprPanier action6 = new Action6SuprPanier();
                    Panier panier = action6.execute(ref,session); 
                    VuePanier vue = new VuePanier();
                    vue.afficher(out, panier);
                }
                break;
                case "7":{ 
                Action7ViderPanier action7 = new Action7ViderPanier();
                Panier panier = action7.execute(session); 
                VuePanier vue = new VuePanier();
                vue.afficher(out, panier);
            }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
