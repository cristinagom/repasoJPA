import entity.City;
import entity.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Country espana = em.find(Country.class,"ESP");
        City cabral = new City("Cabral", espana, "Galicia", 700);
        em.persist(cabral);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
