/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ipst.vente.actions;

import fr.ipst.vente.dao.ArticleJpaController;
import fr.ipst.vente.dao.BDFactory;
import fr.ipst.vente.entities.Article;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author yanis.batatia
 */
public class Action1Catalogue {
    public List<Article> execute(){
        EntityManagerFactory emf = BDFactory.getInstance().getEMF();
        ArticleJpaController dao = new ArticleJpaController(emf);
        
        List<Article> articles = dao.findArticleEntities();
        
        return articles;
    }
}
