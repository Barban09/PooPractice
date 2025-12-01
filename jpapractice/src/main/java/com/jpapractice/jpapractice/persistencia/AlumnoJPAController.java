package com.jpapractice.jpapractice.persistencia;

import com.jpapractice.jpapractice.logica.Alumno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.io.Serializable;
import java.util.List;

public class AlumnoJPAController implements Serializable {

    private EntityManagerFactory emf = null;

    public AlumnoJPAController() {
        // Carga la unidad de persistencia definida en persistence.xml
        emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // =======================================================
    //                     CREATE
    // =======================================================
    public void create(Alumno alumno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    // =======================================================
    //                      EDIT
    // =======================================================
    public void edit(Alumno alumno) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(alumno);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error al editar Alumno: " + ex.getMessage());
        } finally {
            if (em != null) em.close();
        }
    }

    // =======================================================
    //                     DESTROY
    // =======================================================
    public void destroy(int id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Alumno alumno = em.find(Alumno.class, id);
            if (alumno == null) {
                throw new Exception("El alumno con id " + id + " no existe.");
            }

            em.remove(alumno);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    // =======================================================
    //               FIND (Lista completa)
    // =======================================================
    public List<Alumno> findAlumnoEntities() {
        return findAlumnoEntities(true, -1, -1);
    }

    public List<Alumno> findAlumnoEntities(int maxResults, int firstResult) {
        return findAlumnoEntities(false, maxResults, firstResult);
    }

    private List<Alumno> findAlumnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alumno.class));
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

    // =======================================================
    //               FIND (Uno en específico)
    // =======================================================
    public Alumno findAlumno(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alumno.class, id);
        } finally {
            em.close();
        }
    }

    // =======================================================
    //           OBTENER CANTIDAD TOTAL DE ALUMNOS
    // =======================================================
    public int getAlumnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alumno> rt = cq.from(Alumno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
