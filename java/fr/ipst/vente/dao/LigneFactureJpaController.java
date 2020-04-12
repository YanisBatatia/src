/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ipst.vente.dao;

import fr.ipst.vente.dao.exceptions.NonexistentEntityException;
import fr.ipst.vente.entities.LigneFacture;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author yanis.batatia
 */
public class LigneFactureJpaController implements Serializable {

    public LigneFactureJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LigneFacture ligneFacture) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ligneFacture);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LigneFacture ligneFacture) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ligneFacture = em.merge(ligneFacture);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ligneFacture.getNumLigne();
                if (findLigneFacture(id) == null) {
                    throw new NonexistentEntityException("The ligneFacture with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LigneFacture ligneFacture;
            try {
                ligneFacture = em.getReference(LigneFacture.class, id);
                ligneFacture.getNumLigne();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ligneFacture with id " + id + " no longer exists.", enfe);
            }
            em.remove(ligneFacture);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LigneFacture> findLigneFactureEntities() {
        return findLigneFactureEntities(true, -1, -1);
    }

    public List<LigneFacture> findLigneFactureEntities(int maxResults, int firstResult) {
        return findLigneFactureEntities(false, maxResults, firstResult);
    }

    private List<LigneFacture> findLigneFactureEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LigneFacture.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public LigneFacture findLigneFacture(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LigneFacture.class, id);
        } finally {
            em.close();
        }
    }

    public int getLigneFactureCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LigneFacture> rt = cq.from(LigneFacture.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
