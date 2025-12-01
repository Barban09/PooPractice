package com.jpapractice.jpapractice.persistencia;

import com.jpapractice.jpapractice.logica.Carrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class CarreraJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    // Constructor
    public CarreraJpaController() {
        this.emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
    }

    public CarreraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // CREATE
    public void create(Carrera carrera) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(carrera);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // EDIT
    public void edit(Carrera carrera) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            carrera = em.merge(carrera);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error editando la carrera con id: " + carrera.getId(), ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // DELETE
    public void destroy(int id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Carrera carrera;

            carrera = em.getReference(Carrera.class, id);
            carrera.getId(); // fuerza carga

            em.remove(carrera);
            em.getTransaction().commit();

        } catch (Exception ex) {
            throw new Exception("Error borrando la carrera con id: " + id, ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // FIND ALL
    public List<Carrera> findCarreraEntities() {
        return findCarreraEntities(true, -1, -1);
    }

    // FIND with pagination
    public List<Carrera> findCarreraEntities(int maxResults, int firstResult) {
        return findCarreraEntities(false, maxResults, firstResult);
    }

    private List<Carrera> findCarreraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Carrera> cq = em.getCriteriaBuilder().createQuery(Carrera.class);
            Root<Carrera> root = cq.from(Carrera.class);
            cq.select(root);
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

    // FIND BY ID
    public Carrera findCarrera(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Carrera.class, id);
        } finally {
            em.close();
        }
    }

    // COUNT
    public int getCarreraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<Carrera> rt = cq.from(Carrera.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
