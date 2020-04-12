/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ipst.vente.dao;

import fr.ipst.vente.dao.exceptions.NonexistentEntityException;
import fr.ipst.vente.dao.exceptions.PreexistingEntityException;
import fr.ipst.vente.entities.Traite;
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
public class TraiteJpaController implements Serializable {

    public TraiteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Traite traite) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(traite);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTraite(traite.getNumFacture()) != null) {
                throw new PreexistingEntityException("Traite " + traite + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Traite traite) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            traite = em.merge(traite);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = traite.getNumFacture();
                if (findTraite(id) == null) {
                    throw new NonexistentEntityException("The traite with id " + id + " no longer exists.");
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
            Traite traite;
            try {
                traite = em.getReference(Traite.class, id);
                traite.getNumFacture();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The traite with id " + id + " no longer exists.", enfe);
            }
            em.remove(traite);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Traite> findTraiteEntities() {
        return findTraiteEntities(true, -1, -1);
    }

    public List<Traite> findTraiteEntities(int maxResults, int firstResult) {
        return findTraiteEntities(false, maxResults, firstResult);
    }

    private List<Traite> findTraiteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Traite.class));
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

    public Traite findTraite(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Traite.class, id);
        } finally {
            em.close();
        }
    }

    public int getTraiteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Traite> rt = cq.from(Traite.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
