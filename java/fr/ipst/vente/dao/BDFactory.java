/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package  fr.ipst.vente.dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

/**
 *
 * @author Hadj
 */
public class BDFactory {

    
    private static BDFactory factory = null;

    public static BDFactory getInstance() {
        if (factory == null) {
            factory = new BDFactory();
        }
        return factory;

    }

    private BDFactory() {
    }

    public EntityManagerFactory getEMF() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Td52-Vente-cataloguePU");
        return emf;
    }

    public UserTransaction getUserTransaction() {
        UserTransaction utx = null;
        try {
            InitialContext ic = new InitialContext();
            utx = (UserTransaction) ic.lookup("java:comp/UserTransaction");
        } catch (NamingException ex) {
            Logger.getLogger(BDFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return utx;
    }
}
