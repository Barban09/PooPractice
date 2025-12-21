package persistencia;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import logica.Mascota;

public class MascotaJPAController implements Serializable {

    private EntityManagerFactory emf = null;

    public MascotaJPAController() {
        emf = Persistence.createEntityManagerFactory("PeluqueriaCaninaPU");
    }

    public MascotaJPAController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // -------------------------------
    //        CREATE
    // -------------------------------
    public void create(Mascota mascota) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            em.persist(mascota);

            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // -------------------------------
    //        EDIT
    // -------------------------------
    public void edit(Mascota mascota) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            em.merge(mascota);

            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error al modificar la mascota: " + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // -------------------------------
    //        DESTROY
    // -------------------------------
    public void destroy(int id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Mascota mascota;
            try {
                mascota = em.getReference(Mascota.class, id);
                mascota.getNum_cliente(); // fuerza carga
            } catch (Exception e) {
                throw new Exception("La mascota con id " + id + " no existe.");
            }

            em.remove(mascota);
            em.getTransaction().commit();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // -------------------------------
    //       FIND BY ID
    // -------------------------------
    public Mascota findMascota(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mascota.class, id);
        } finally {
            em.close();
        }
    }

    // -------------------------------
    //        FIND ALL
    // -------------------------------
    public List<Mascota> findMascotaEntities() {
        return findMascotaEntities(true, -1, -1);
    }

    public List<Mascota> findMascotaEntities(int maxResults, int firstResult) {
        return findMascotaEntities(false, maxResults, firstResult);
    }

    private List<Mascota> findMascotaEntities(boolean all, int maxResults, int firstResult) {

        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Mascota> cq = em.getCriteriaBuilder().createQuery(Mascota.class);
            cq.select(cq.from(Mascota.class));
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
    //        COUNT
    // -------------------------------
    public int getMascotaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<Mascota> rt = cq.from(Mascota.class);
            cq.select(em.getCriteriaBuilder().count(rt));

            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();

        } finally {
            em.close();
        }
    }
}
