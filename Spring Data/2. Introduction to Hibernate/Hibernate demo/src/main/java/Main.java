import entities.Student;
import org.hibernate.FlushMode;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Student student = new Student ("Hristo Georgiev");
        session.beginTransaction();
        session.save(student);

        session.getTransaction().commit();

        session.beginTransaction();
        session.setHibernateFlushMode(FlushMode.MANUAL);
        Student result = session.get(Student.class,1, LockMode.READ);
        session.getTransaction().commit();
        System.out.printf("Student with ID: %d -> %s",result.getId(),result.getName());

        // List all students using HQL
        session.beginTransaction();
        session.createQuery("FROM Student ", Student.class)
                .setFirstResult(5)
                .setMaxResults(10)
                .stream()
                .forEach(System.out::println);

        session.getTransaction().commit();
        session.close();
    }
}
