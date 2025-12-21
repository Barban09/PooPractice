package persistencia;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import logica.Duenio;

public class DuenioJPAController implements Serializable {

    private EntityManagerFactory emf = null;

    public DuenioJPAController() {
        emf = Persistence.createEntityManagerFactory("PeluqueriaCaninaPU");
    }

    public DuenioJPAController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // -------------------------------
    //            CREATE
    // -------------------------------
    public void create(Duenio duenio) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            em.persist(duenio);

            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // -------------------------------
    //             EDIT
    // -------------------------------
    public void edit(Duenio duenio) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            em.merge(duenio);

            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error al modificar el dueño: " + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // -------------------------------
    //           DESTROY
    // -------------------------------
    public void destroy(int id) throws Exception {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Duenio duenio;
            try {
                duenio = em.getReference(Duenio.class, id);
                duenio.getId_duenio();  // fuerza carga
            } catch (Exception e) {
                throw new Exception("El dueño con id " + id + " no existe.");
            }

            em.remove(duenio);
            em.getTransaction().commit();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // -------------------------------
    //          FIND BY ID
    // -------------------------------
    public Duenio findDuenio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Duenio.class, id);
        } finally {
            em.close();
        }
    }

    // -------------------------------
    //           FIND ALL
    // -------------------------------
    public List<Duenio> findDuenioEntities() {
        return findDuenioEntities(true, -1, -1);
    }

    public List<Duenio> findDuenioEntities(int maxResults, int firstResult) {
        return findDuenioEntities(false, maxResults, firstResult);
    }

    private List<Duenio> findDuenioEntities(boolean all, int maxResults, int firstResult) {

        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Duenio> cq = em.getCriteriaBuilder().createQuery(Duenio.class);
            cq.select(cq.from(Duenio.class));
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

    // -------------------------------
    //             COUNT
    // -------------------------------
    public int getDuenioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<Duenio> rt = cq.from(Duenio.class);
            cq.select(em.getCriteriaBuilder().count(rt));

            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();

        } finally {
            em.close();
        }
    }
}
