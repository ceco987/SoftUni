import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
public static final String pu = "university";
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);
        var EntityManager = emf.createEntityManager();

    }
}
