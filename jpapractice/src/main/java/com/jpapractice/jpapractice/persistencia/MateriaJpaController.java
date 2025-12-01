package com.jpapractice.jpapractice.persistencia;

import java.io.Serializable;
import java.util.List;

import com.jpapractice.jpapractice.logica.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class MateriaJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public MateriaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // ========================
    //       CREATE
    // ========================
    public void create(Materia materia) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(materia);
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    // ========================
    //         EDIT
    // ========================
    public void edit(Materia materia) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(materia);
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    // ========================
    //        DELETE
    // ========================
    public void destroy(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Materia materia = em.find(Materia.class, id);
            if (materia != null) {
                em.remove(materia);
            }
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    // ========================
    //       FIND BY ID
    // ========================
    public Materia findMateria(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Materia.class, id);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    // ========================
    //     FIND ALL
    // ========================
    public List<Materia> findMateriaEntities() {
        return findMateriaEntities(true, -1, -1);
    }

    public List<Materia> findMateriaEntities(int maxResults, int firstResult) {
        return findMateriaEntities(false, maxResults, firstResult);
    }

    @SuppressWarnings("unchecked")
    private List<Materia> findMateriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Materia> cq = em.getCriteriaBuilder().createQuery(Materia.class);
            Root<Materia> root = cq.from(Materia.class);
            cq.select(root);

            Query query = em.createQuery(cq);

            if (!all) {
                query.setMaxResults(maxResults);
                query.setFirstResult(firstResult);
            }

            return query.getResultList();

        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    // ========================
    //     COUNT
    // ========================
    public int getMateriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<Materia> root = cq.from(Materia.class);
            cq.select(em.getCriteriaBuilder().count(root));
            return em.createQuery(cq).getSingleResult().intValue();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
}

